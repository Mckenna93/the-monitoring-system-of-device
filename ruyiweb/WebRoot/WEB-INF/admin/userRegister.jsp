
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
    <h1>注册</h1>
</div>
<div class="col-md-4">
    <form action="${pageContext.request.contextPath}/admin_register" method="post">
    <table style="margin-top:25px">
    <tr height="40px"><td>用&nbsp;户&nbsp;名:<input type="text" name="user.userName"/></td></tr>
    <tr height="40px"><td>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:<input type="password" name="user.password"/></td></tr>
    <tr height="40px"><td>确认密码:<input type="password" name="confirmedPwd"/></td></tr>
    <tr height="40px"><td><input type="radio" name="user.rank" value="2" checked="checked"/>普通用户</td></tr>
    <tr height="40px"><td><input type="radio" name="user.rank" value="1"/>管理员</td></tr>
    <tr height="40px"><td align="center"><input type="submit" value="注册"/></td></tr>
    </table>
    </form>
</div>
</div>
</div>
</body>
</html>



