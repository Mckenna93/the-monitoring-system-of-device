
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/common/header.jsp"/>
   
<body >
<jsp:include page="/WEB-INF/common/guide.jsp"/>

<div class="container">
<div class="col-xs-12 col-sm-10 col-md-offset-1 col-lg-10" >
<div class="page-header">
    <h1>登录</h1>
</div>
<div class="col-md-4">
    <form action="${pageContext.request.contextPath}/user_login" method="post">
    <table style="margin-top:25px">
    <tr height="40px"><td>用户名:<input type="text" name="user.userName"/></td></tr>
    <tr height="40px"><td> 密     码：<input type="password" name="user.password"/></td></tr>
    <tr height="40px"><td align="center"><input type="submit" value="登录"/></td></tr>
    </table>
    </form>
</div>
</div>
</div>
</body>
</html>



