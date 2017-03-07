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
    <h1>修改密码</h1>
</div>
<div class="col-md-4">
    <form action="${pageContext.request.contextPath}/user_changePassword" method="post">
    <table style="margin-top:25px">
    <tr height="40px"><td>原始密码:<input type="password" name="oldPwd"/></td></tr>
    <tr height="40px"><td>新&nbsp;&nbsp;密&nbsp;&nbsp;码:<input type="password" name="newPwd"/></td></tr>
    <tr height="40px"><td>确认密码:<input type="password" name="confirmedPwd"/></td></tr>
    <tr height="40px"><td align="center"><input type="submit" value="修改"/></td></tr>
    </table>
    </form>
</div>
</div>
</div>
</body>
</html>



