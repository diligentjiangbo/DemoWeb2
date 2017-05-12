<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/11 0011
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="BASE" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>客户编辑</title>
</head>
<body>

<h1>客户信息</h1>

<form action="${BASE}/customer_edit" method="POST">
    <input type="hidden" name="id" value="${customer.id}">
    客户名称：<input type="text" name="name" value="${customer.name}">
    联系人：<input type="text" name="contact" value="${customer.contact}">
    电话号码：<input type="text" name="telephone" value="${customer.telephone}">
    邮箱：<input type="text" name="email" value="${customer.email}">
    <input type="submit" value="提交">
</form>

</body>
</html>
