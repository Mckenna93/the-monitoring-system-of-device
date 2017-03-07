
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
                <h4>历史状态查询</h4>
            </div>
            <div class="col-md-4">
    <form action="${pageContext.request.contextPath}/device_historyStateList" method="post">
    <table style="margin-top:25px">
    <tr height="40px"><td>
    	叉车编号:
    	<c:if test="${not empty session.deviceList}">
        <select class="form-control" id="textSelect" name="id">
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
                        <td><strong>叉车编号</strong></td>
                        <td>
                        <c:if test="${not empty session.historyState }">
                         ${session.historyState.id }
                        </c:if></td>   
                        <td><strong>起始时间</strong></td>
                        <td>${session.startTime} </td>
                        <td><strong>结束时间</strong></td>
                        <td>${session.endTime}</td>

                   </tr>
              </table>
              <table class="table"> 
                  <tr>
	                  <th>名称</th>
	                  <th>动作次数</th>
	                  <th>名称</th>
	                  <th>动作次数</th>
                  </tr>
                  
                  <tr>
                        <td><strong>喇叭开关</strong> </td><td>
                        <c:if test="${not empty session.historyState }">
                         ${session.historyState.hornCount }
                        </c:if></td>
                        <td><strong>提升开关</strong></td><td>
                        <c:if test="${not empty session.historyState }">
                        ${session.historyState.upBtnCount }
                        </c:if></td>  
                  </tr>
                  <tr>
                        <td><strong>提升接触器 </strong></td><td>
                        <c:if test="${not empty session.historyState }">
                         ${session.historyState.upBtnContactorCount }
                        </c:if></td>
                        <td><strong>下降开关</strong></td><td>
                        <c:if test="${not empty session.historyState }">
                         ${session.historyState.downBtnCount }
                        </c:if></td>                     
                   </tr>
                   <tr>
                        <td><strong>主接触器 </strong></td><td>
                        <c:if test="${not empty session.historyState }">
                        ${session.historyState.masterContactorCount }
                        </c:if></td>
                        <td><strong>制动器线圈控制端</strong></td><td>
                        <c:if test="${not empty session.historyState }">
                         ${session.historyState.arresterCount }
                        </c:if></td>
                       
                   </tr>
                  
                </thead>
                <tbody>
               
            
                </tbody>
                </table>
                <div id="mychart"></div>
            </div>      
    </div>
 </div>
</div>
</body>
</html>





