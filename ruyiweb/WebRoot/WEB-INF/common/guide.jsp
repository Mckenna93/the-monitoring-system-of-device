<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<header   style="background-image: url(${pageContext.request.contextPath}/image/bg.jpg)">
        <div class="container-fluid">

            <div class="col-md-4">
              <img src="${pageContext.request.contextPath}/image/logo.png" alt="ruyi" width="70px">
            </div>
                <div class="col-md-offset-10">
              <h3> 400 880 9355</h3> 
                </div>         

        </div>
    </header>


<div> 

    <nav class="navbar navbar-inverse">

      <div class="col-md-offset-1">

        <div  class="collapse navbar-collapse"  >

          <ul class="nav navbar-nav ">
    <li><a id="onlinestate"  class="navbar-brand" href="${pageContext.request.contextPath}/device_getOnlineDevice" >在线设备</a> </li>
    <li><a id="todaywarn" class="navbar-brand" href="${pageContext.request.contextPath}/warn_todayWarn" >当日故障报警</a> </li>
    <li> <a id="historywarn" class="navbar-brand" href="${pageContext.request.contextPath}/warn_historyWarn" >历史故障查询</a></li>
    <li> <a id="historystate" class="navbar-brand" href="${pageContext.request.contextPath}/device_historyState" >历史状态查询</a></li>
    <li><a id="repair" class="navbar-brand" href="${pageContext.request.contextPath}/repair_info" >维修保养记录</a>  </li>
    <li><a id="warncount" class="navbar-brand" href="${pageContext.request.contextPath}/warn_warningCount" >故障统计</a> </li>
    <li ><a id="changepassword" class="navbar-brand" href="${pageContext.request.contextPath}/user_changePwd" >修改密码</a> </li>
    <c:if test="${not empty session.user && session.user.rank==1}">
    <li ><a id="usermanager" class="navbar-brand " href="${pageContext.request.contextPath}/admin_userList">账号管理</a> </li>
    <li ><a id="register" class="navbar-brand" href="${pageContext.request.contextPath}/admin_addUser" >用户注册</a> </li>
    </c:if>
    <li><a class="navbar-brand" href="${pageContext.request.contextPath}/user_logout" >退出系统</a> </li>

          </ul>

         <ul class="nav navbar-nav navbar-right"> <li>
         <a><c:if test="${not empty session.user}">
      	   用户：${session.user.userName}
      	   <c:choose>
         <c:when test="${session.user.rank==1}">管理员</c:when>
         <c:otherwise>普通用户</c:otherwise></c:choose>
         </c:if></a></li></ul>
        </div>
      </div>
    </nav>
</div>





