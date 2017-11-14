package model.user;

import model.Connection.Database;
import model.user.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

public class UserList {

    private List<User> users = new ArrayList<User>();
    private Statement command;
    private ResultSet resultSet;
    private User user;

    public UserList(ServletContext servletContext) throws Exception {
        command = Database.getDbConnection(servletContext).createStatement();
        resultSet = command.executeQuery("select * from users;");
        while(resultSet.next()){
            user = new User(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
            users.add(user);
        }
    }

    public User getMatchedUser(String username, String password) throws SQLException {
        resultSet = command.executeQuery("select userId, userName FROM users WHERE username = '"+ username +"' and password = '"+ password+"'");
        if(!resultSet.next()) {
            return null;
        }
      
        else return new User(resultSet.getInt(1), resultSet.getString(2), null);
    }

    public User getOtherUser(long userId) throws SQLException {
        resultSet = command.executeQuery("select userId, userName FROM users WHERE userId != '"+ userId +"'");
        if(!resultSet.next()) {
            return null;
        }else return new User(resultSet.getInt(1), resultSet.getString(2), null);
    }
    
    public boolean registration(String username, String password) throws Exception {
        boolean userExists = false;
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getUsername().equalsIgnoreCase(username)) {
            	userExists = true;
                break;
            }
        }

        boolean registered = false;
        
        if(!userExists) {
        	 command.execute("INSERT INTO users (username, password) VALUES ('" + username + "', '" + password + "')");
        	 registered = true;
        }

        return registered;
    }

    public int getUsersCount() throws SQLException {
        resultSet = command.executeQuery("select count(userId) FROM users");
        if(!resultSet.next()) {
            return -1;
        }else return resultSet.getInt(1);
    }
    
    public List<User> getUsers(){
        return users;
    }
}
