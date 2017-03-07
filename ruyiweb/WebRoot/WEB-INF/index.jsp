<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/common/header.jsp"/>  

<body >
<jsp:include page="/WEB-INF/common/guide.jsp"/>

<div class="container">
<div class="col-xs-12 col-sm-10 col-md-offset-1 col-lg-10" >
<h1>您好, 
	<c:if test="${not empty session.user}">${session.user.userName}</c:if>
</h1>
    <h1>欢迎来到如意叉车监控系统!</h1>
</div>
</div>
</body>
</html>



