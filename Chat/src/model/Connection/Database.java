package model.Connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.NamingException;
import javax.servlet.ServletContext;

public class Database {

    private static Connection connection;

    public static Connection getConnection(ServletContext servletContext) throws SQLException, NamingException {
    	Properties configs = getConfigs(servletContext);
    	String url = configs.getProperty("url");
    	String username = configs.getProperty("username");
    	String password = configs.getProperty("password");
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        connection = DriverManager.getConnection(url, username, password);
        return connection;
    }
    
    public static Connection getDbConnection(ServletContext servletContext) throws SQLException, NamingException {
    	Properties configs = getConfigs(servletContext);
    	String url = configs.getProperty("url");
    	String username = configs.getProperty("username");
    	String password = configs.getProperty("password");
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        connection = DriverManager.getConnection(url + "/chat_db", username, password);
        return connection;
    }
    
    private static Properties getConfigs(ServletContext servletContext) {
    	Properties prop = new Properties();
    	InputStream input = null;

    	try {

    		input = servletContext.getResourceAsStream("/WEB-INF/config.properties");
    		prop.load(input);
    		
    	} catch (IOException ex) {
    		ex.printStackTrace();
    	} finally {
    		if (input != null) {
    			try {
    				input.close();
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
    		}
    	}
    	return prop;
    }
}
