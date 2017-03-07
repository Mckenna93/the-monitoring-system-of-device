
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
                <h4>历史故障报警</h4>
            </div>
            <div class="col-md-4">
    <form action="${pageContext.request.contextPath}/warn_historyWarnList" method="post">
    <table style="margin-top:25px">
    <tr height="40px"><td>
    	叉车编号:
    	<c:if test="${not empty session.deviceList}">
        <select class="form-control" id="textSelect" name="deviceId">
        <c:forEach items="${session.deviceList}" var="onlineDevice">
        <option value="${onlineDevice.id}">${onlineDevice.id}</option></c:forEach>
        </select>
      </c:if>
    </td></tr>
    <tr height="40px"><td>起始时间
    <!-- 获取当前系统时间 -->        
    <% String date=new java.text.SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()); %>
    <input class="form-control" id="startTime" name="startTime" type="date" value=<%=date %>></td></tr>
    <tr height="40px"><td>结束时间
    <input class="form-control" id="endTime" name="endTime" type="date" value=<%=date %>></td></tr>
    <tr height="40px"><td><input type="submit" value="查询"/></td></tr>
    </table>
    </form>
    <br>
</div>
            <div class="panel-body">
               <table class="table">  
               <thead>                                      
              <tr>
                 <td></td>
                     <td><strong>起始时间</strong></td>
                     <td><strong>${session.startTime}</strong></td>
                     <td><strong>结束时间</strong></td>
                     <td><strong>${session.endTime}</strong></td>
              </tr>

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

               

		<c:if test="${not empty session.historyWarning}">
            <c:forEach items="${session.historyWarning}" var="entry" varStatus="varSt">
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