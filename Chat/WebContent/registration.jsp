<%@ page import="model.user.UserList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>

<%
String username = request.getParameter("username");
String password = request.getParameter("password");

if(username == null || username.isEmpty()
	|| password == null || password.isEmpty()) {
	response.sendRedirect("register.jsp?state=3");
	return;
}

	UserList userList = new UserList(request.getServletContext());
	
	if (userList.getUsersCount() < 2) {
		if(userList.registration(username, password)) {
			response.sendRedirect("login.jsp");
		}else{
		    response.sendRedirect("register.jsp?state=1");
		}
	} else {
		response.sendRedirect("register.jsp?state=2");
	}
%>
</body>
</html>
