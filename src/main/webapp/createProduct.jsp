<%--
  Created by IntelliJ IDEA.
  User: johntoan98gmail.com
  Date: 30/06/2022
  Time: 09:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

</head>
<body class="container">
<h1>Create Product</h1>
<form action="/product" method="post">
    <input placeholder="id" name="id">
    <input placeholder="name" name="name">
    <input placeholder="price" name="price">
    <input placeholder="img" name="img">
    <button type="submit" class="btn btn-success">Create</button>
</form>
</body>
</html>
