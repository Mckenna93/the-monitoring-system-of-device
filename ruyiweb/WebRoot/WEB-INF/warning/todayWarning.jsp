
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
            <div class="row"> 
                <h4 class="col-md-6">当日故障报警</h4>
                <h4 class="col-md-5 text-right">
                <% String date = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()); %>
                <%= date %></h4> 
            </div>
          </div>
          <div class="panel-body">
               <table class="table">  
               <thead>
                <tr>               
                  <th>编号</th>
                  <th>叉车ID</th>
                  <th>故障名称</th>
                  <th>故障码</th>
                  <th>报警次数</th>
                  <th>详情</th>
                </tr>
                </thead>
                <tbody>
         <c:if test="${not empty session.todayWarning}">
            <c:forEach items="${session.todayWarning}" var="entry" varStatus="varSt">
            	<tr>
                  <td>${varSt.count}</td>
                  <td>${entry.key.deviceid}</td>
                  <td>${entry.key.errorType.error}</td>
                  <td>${entry.key.errorType.id}</td>
                  <td>${entry.value}</td>
                  <td>
                  <a   class="btn btn-danger tryitbn" target="_blank" 
                  href="${pageContext.request.contextPath}/warn_deviceWarning?deviceId=${entry.key.deviceid}&startTime=${session.startTime}&endTime=${session.endTime}&errorNum=${entry.key.errorType.id}">详情</a>
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

