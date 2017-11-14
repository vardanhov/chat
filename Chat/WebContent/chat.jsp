<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Login page</title>
<link href="css/StyleChat.css" rel="stylesheet" type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
  $(document).ready(function() {
	  (function worker() {
		  $.ajax({
		    url: 'messages', 
		    success: function(data) {
		      $("#chatbox").html(data);
		    },
		    complete: function() {
		      // Schedule the next request when the current one's complete
		      setTimeout(worker, 1000);
		    }
		  });
		})();
	    $("#submitmsg").click(function() {
	        var newMessage = $("#usermsg").val();
	        var conversation = $("#chatbox").html();
	        
	        var newConversation = conversation + newMessage + "<br>";
	        $("#chatbox").html("" + newConversation + "");
	        $("#usermsg").val("");
	        $.ajax({
	            type: 'POST',
	            url: "messages",
	            data: {message : newMessage},
	            dataType: "text"
	      });
	        $.get("messages", function(responseText) {   // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
                $("#chatbox").html(responseText);           // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
            });
	    });
	});
  
  </script>
</head>
<body>
	<div id=wall></div>
	<div id="wrapper">
    <div id="menu">
       
        <p class="logout"><a id="exit" href="index.jsp">EXIT</a></p>
        <div style="clear:both"></div>
    </div>
     
 	<div id="chatbox"></div>
    
        <input name="usermsg" type="text" id="usermsg" size="63" />
        <input name="msg" type="submit"  id="submitmsg" value="Send" />
	</div>
</body>
</html>