<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
    <title>错误页面</title>
</head>
<body>
出现异常【<%=request.getAttribute("errorMsg")%>】
</body>
</html>