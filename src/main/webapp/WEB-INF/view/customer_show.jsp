<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/11 0011
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>客户信息展示</title>
</head>
<body>

<form >
    <input type="hidden" name="id" value="${customer.id}" readonly="readonly">
    客户名称：<input type="text" name="name" value="${customer.name}" readonly="readonly">
    联系人：<input type="text" name="contact" value="${customer.contact}" readonly="readonly">
    电话号码：<input type="text" name="telephone" value="${customer.telephone}" readonly="readonly">
    邮箱：<input type="text" name="email" value="${customer.email}" readonly="readonly">
</form>

</body>
</html>
