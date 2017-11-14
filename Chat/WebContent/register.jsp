<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Login page</title>
  <link href="css/StyleRegist.css" rel="stylesheet" type="text/css">
  
</head>
<body>
<div id=wall>

</div>
<div id="logWrapper">

  <div id="log_in_div">
    <b>REGISTRATION</b>
  </div>

  <div id="logForm">
    <form action="registration.jsp" method="post">
      <div class="textField">
      
      <input type="text" name="username" placeholder="Username"><br>
      </div>
      
      <div class="textField">
      
      <input type="password" name="password" placeholder="Password"><br>
      </div>
      
      <div id="sendButton"><input type="submit" value="Registration">
      </div>
      
    </form>
    
     <div id="already-a-member">Already a member?<a href="login.jsp">Login</a>
     </div>
    
      <% if("1".equals(request.getParameter("state"))) { %>
      	<div>User already exists</div>
      	 <%} else if("2".equals(request.getParameter("state"))) {%>
      	 <div>The application can have only 2 users</div>
      <%}else if("2".equals(request.getParameter("state"))) {%>
      	 <div>Fill fields</div>
      <%}%>
    
  </div>

  <% if(request.getParameter("session") != null){
      session.invalidate();
  }%>

</div>



</body>
</html>