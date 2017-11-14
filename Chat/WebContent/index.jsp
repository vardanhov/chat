<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Login page</title>
  <link href="css/Stylelogin.css" rel="stylesheet" type="text/css">
  
</head>
<body>
<div id=wall>

</div>
<div id="logWrapper">

  <div id="log_in_div">
    <b>CHAT APPLICATION</b>
  </div>

  <div id="logForm">
    <form action="login.jsp" method="get">
      <div class="textField">
      
      <input type="text" name="username" placeholder="Username"><br>
      </div>
      
      <div class="textField">
      
      <input type="password" name="password" placeholder="Password"><br>
      </div>
      
      <div id="sendButton"><input type="submit" value="Login">
      </div>
      
    </form>
    
    <div id="not-a-member">Not a member?<a href="register.jsp">Register</a>
     </div>
     
       <% if("1".equals(request.getParameter("state"))) { %>
      	<div>User name or password is not correct</div>
      <%}%>
  </div>

  <% if(request.getParameter("session") != null){
      session.invalidate();
  }%>

</div>



</body>
</html>