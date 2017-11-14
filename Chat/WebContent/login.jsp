<%@ page import="model.user.UserList" %>
<%@ page import="model.user.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<%


String username = request.getParameter("username");
String password = request.getParameter("password");

UserList userList = new UserList(request.getServletContext());

User user = userList.getMatchedUser(username, password);

if(user != null){
    session.setAttribute("user", user);
    User otherUser = userList.getOtherUser(user.getUserId());
    session.setAttribute("otherUser",otherUser);
    
    response.sendRedirect("chat.jsp");
}else {
	response.sendRedirect("index.jsp?state=1");
}

%>

</body>
</html>
