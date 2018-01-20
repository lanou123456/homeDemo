<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: java-201707211014
  Date: 2018/1/20
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<s:form action="login" method="POST">
   用户名： <input type="text" name="uname">
    密码：<input type="text" name="password">
    <s:submit/>
</s:form>



</body>
</html>
