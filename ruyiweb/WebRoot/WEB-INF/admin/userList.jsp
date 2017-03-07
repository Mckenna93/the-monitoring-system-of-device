
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/common/header.jsp"/>
   
<body >
<jsp:include page="/WEB-INF/common/guide.jsp"/>

<div class="container">
<div class="col-xs-12 col-sm-10 col-md-offset-1 col-lg-10">
    <div class="panel panel-default">
            <div class="panel-heading">
                <h4>账户管理</h4>
            </div>
            <div class="panel-body">
               <table class="table">  
               <thead>
                <tr>
                  <th>编号</th>
                  <th>用户名称</th>
                  <th>用户等级</th>
                  <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:if test="${not empty session.userList }">
                	<c:forEach items="${session.userList }" var="user" varStatus="varSt">
                		<tr>
                			<td>${varSt.count}</td>
                			<td>${user.userName}</td>
                			<td><c:choose>
                			<c:when test="${user.rank==1}">管理员</c:when>
                			<c:otherwise>普通用户</c:otherwise>
                			</c:choose></td>
                			<td>
                			<button   type="submit" class="btn btn-danger"  onclick ="deleteUser(${user.id})">删除</button>
                			</td>
                		</tr>
                	</c:forEach>
                
                </c:if>             
                </tbody>
                </table>
            </div>
    </div>
 </div>
</div>
</body>
</html>



