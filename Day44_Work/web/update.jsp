<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: java-201707211014
  Date: 2018/1/20
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
<s:form action="update1" method="POST">
<table border="1">
    <tr>
        <th>用工编码</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>部门</th>
        <th>入岗时间</th>
        <th>家庭住址</th>
        <th>电话号</th>
    </tr>

    <tr>
        <td><input readonly="readonly" value="<s:property value="%{#user.id}"/>" name="id"></td>
        <td><input value="<s:property value="%{#user.uname}"/>" name="user.uname"></td>
        <td><input value="<s:property value="%{#user.age}"/>" name="user.age"></td>
        <td><input value="<s:property value="%{#user.department}"/>" name="user.department"></td>
        <td><input value="<s:property value="%{#user.time}"/>" name="user.time"></td>
        <td><input value="<s:property value="%{#user.address}"/>" name="user.address"></td>
        <td><input value="<s:property value="%{#user.phone}"/>" name="user.phone"></td>
    </tr>
</table>
<s:submit value="提交更改"/>
</s:form>









</body>
</html>
