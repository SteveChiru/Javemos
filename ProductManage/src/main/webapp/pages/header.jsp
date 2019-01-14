<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js" ></script>
    <title>商品管理系统</title>
</head>
<body>

    <br />

    <h1>商品管理系统</h1>

    <br />

    <a href="${pageContext.request.contextPath}/pages/addCategory.jsp">添加分类</a>
    &nbsp;&nbsp;
    <a href="${pageContext.request.contextPath}/CategoryServlet?op=find">查询分类</a>
    &nbsp;&nbsp;
    <a href="${pageContext.request.contextPath}/pages/addProduct.jsp">添加商品</a>
    &nbsp;&nbsp;
    <a href="${pageContext.request.contextPath}/pages/listProduct.jsp">查询商品</a>

    <br />
    <hr />