<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: java-201707211014
  Date: 2018/1/20
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <s:url value="user.action" var="user"/>
  <s:a action="%{#user}">查询所有的员工信息</s:a>



  </body>
</html>
