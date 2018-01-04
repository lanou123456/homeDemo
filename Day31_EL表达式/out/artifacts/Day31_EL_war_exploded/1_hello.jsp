<%--
  Created by IntelliJ IDEA.
  User: java-201707211014
  Date: 2018/1/4
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--
        使用EL可以获得JSP四大域中的域属性，
        与昨天学的PageContext的全域查找一个意思
        EL表达式的格式：
        ${ }
    --%>
${name}
${10+10}
${10-10}
${100 mod 10}
${50 eq 50 }
${50 ne 50}
${40 lt 30}
${20 gt 30}
${20 lt 30}
${20 gt 30}
${empty "1"}
${ not true }
${ !true }
${true or false}

</body>
</html>
