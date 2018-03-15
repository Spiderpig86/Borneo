<%--
  Created by IntelliJ IDEA.
  User: slim1
  Date: 3/14/2018
  Time: 1:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- Allows
us to use Java tags in our JSP -->

<c:set var="contextRoot" value="${pageContext.request.contextPath}" /> <!--
Store the path in a variable called contextRoot -->

<html>
<head>
    <title>Borneo - Best place to buy stuff</title>
</head>
<body>
    <h2>${contextRoot} says - ${greeting}</h2>
</body>
</html>
