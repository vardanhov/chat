package com.chat.app;

import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.Connection.Database;
import model.message.Message;

@WebListener
public class MyContextListener implements ServletContextListener {
	
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
		try {
			Statement createDbCommand = Database.getConnection(servletContextEvent.getServletContext()).createStatement();
			createDbCommand.execute("CREATE DATABASE IF NOT EXISTS chat_db");
			Statement createTableCommand = Database.getDbConnection(servletContextEvent.getServletContext()).createStatement();
			createTableCommand.execute("CREATE TABLE IF NOT EXISTS users (userId INT(64) NOT NULL AUTO_INCREMENT UNIQUE, username TEXT NOT NULL, password TEXT NOT NULL);");
			servletContextEvent.getServletContext().setAttribute("messages", new ArrayList<Message>());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        
    }
}
