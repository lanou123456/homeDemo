<%--
  Created by IntelliJ IDEA.
  User: java-201707211014
  Date: 2018/1/2
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="login" method="post">
    用户名：<h1><span id="username"></span></h1>
    密码：<h1><span id="password"></span></h1>


  </form>
  </body>
  <script src="js/jquery-3.2.1.min.js">

    $.getJSON("http://localhost:8080/login",function (data,status) {

        if (status=="success"){
            $('#usernma').text(data["username"]);
            $('#password').text(data["password"]);

        }

    })

  </script>


</html>
