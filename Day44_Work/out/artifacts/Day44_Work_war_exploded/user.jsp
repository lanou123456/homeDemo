<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: java-201707211014
  Date: 2018/1/20
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息</title>
</head>
<body>
<table border="1">
    <tr>
        <th>姓名</th>
        <th>年龄</th>
        <th>部门</th>
        <th>入职时间</th>
        <th>家庭住址</th>
        <th>电话号</th>
        <th>修改</th>
    </tr>

<s:iterator value="#users" var="user">
    <tr>
        <td> <s:property value="%{#user.uname}"/></td>
        <td> <s:property value="%{#user.age}"/></td>
        <td> <s:property value="%{#user.department}"/></td>
        <td> <s:property value="%{#user.time}"/></td>
        <td> <s:property value="%{#user.address}"/></td>
        <td> <s:property value="%{#user.phone}"/></td>
        <td><s:a href="update?id=%{#user.id}">修改</s:a> </td>
    </tr>
</s:iterator>
</table>





</body>
</html>
