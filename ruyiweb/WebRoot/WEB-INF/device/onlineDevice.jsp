
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
                <h4 class="col-md-6">叉车状态信息</h4>
                <h5 class="col-md-2 text-right">叉车编号</h5>
                <div class="col-md-3">
<!-- 可查询的叉车通过下拉列表选择 -->
      <c:if test="${not empty session.deviceList}">
       <select class="form-control" id="textSelect">
      <c:forEach items="${session.deviceList}" var="onlineDevice">
      <option value="${onlineDevice.id}">${onlineDevice.id}</option></c:forEach>
      </select>
      </c:if>
    </div>
    <a class="btn btn-success tryitbn " onclick="javascript:window.open('${pageContext.request.contextPath}/device_findById?id='+textSelect.value);" >
                      查询
                    </a>

            </div>
            </div>
            <div class="panel-body">
               <table class="table ">  
               <thead >
                <tr>
                  <!-- <th></th>
                  <th>审核状态</th>
                  <th>标题</th> -->
                  <th style="width:10%">编号</th>
                  <th style="width:25%">叉车ID</th>
                  <th style="width:25%">采集时间</th>
                  <th style="width:25%">运行时间</th>
                  <th style="width:15%">详情</th>
                </tr>
                </thead>
                <tbody>
 <c:if test="${not empty session.deviceList}">
<c:forEach items="${session.deviceList}" var="onlineDevice" varStatus="varSt">
                <tr>

                  <td style="width:10%">${varSt.count}</td>
                  <td style="width:25%">${onlineDevice.id}</td>
                  <td style="width:25%">${onlineDevice.time}</td>
                  <td style="width:25%">${onlineDevice.runningTime}</td>
                  <td style="width:15%">
                    <a   class="btn btn-danger tryitbn" target="_blank" href="${pageContext.request.contextPath}/device_findById?id=${onlineDevice.id}" >
                      详情
                    </a>
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




