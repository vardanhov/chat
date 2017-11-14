package com.chat.app;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.message.Message;
import model.user.User;

/**
 * Servlet implementation class MessagesServlet
 */
@WebServlet("/messages")
public class MessagesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessagesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String conversation = "";
		for(Message message : getMessages()) {
			conversation += message.getUserFrom().getUsername() + ": "  + message.getMessage() + "<br><br>";
		}
		response.setContentType("text/plain");  
	    response.setCharacterEncoding("UTF-8"); 
	    response.getWriter().write(conversation);       
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User userFrom = (User) request.getSession().getAttribute("user");
		User userTo= (User) request.getSession().getAttribute("otherUser");
		if (userTo != null) {
			String message = request.getParameter("message");
			getMessages().add(new Message(userFrom, userTo, message));
		}
	}
	
	private List<Message> getMessages() {
		return (List<Message>) getServletContext().getAttribute("messages");
	}
}
