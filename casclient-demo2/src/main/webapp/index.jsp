<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>plusmall-cast-client1</title>
</head>
<body>

    欢迎来到普拉斯商城-CAS单点登录测试-客户端2
    <%=request.getRemoteUser()%>

    <a href="http://cloudserver:9691/logout?service=http://www.baidu.com">退出登录</a>
</body>
</html>
