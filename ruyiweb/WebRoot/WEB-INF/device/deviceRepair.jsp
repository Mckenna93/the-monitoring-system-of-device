
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/common/header.jsp"/>
   
<body >
<jsp:include page="/WEB-INF/common/guide.jsp"/>

<div class="container">
<div class="col-xs-12 col-sm-10 col-md-offset-1 col-lg-10" >
    <div class="panel panel-default">
            <div class="panel-heading">
                <h4>维修保养记录查询</h4>


            </div>
            <div class="col-md-10">
           
     <form method="post" class="form-horizontal"  action="${pageContext.request.contextPath}/repair_findByDeviceId">
             <fieldset>
              <legend>叉车编号</legend>
             <div class="form-group">
             
             <label class="col-sm-2 control-label" for="deviceid">叉车编号</label>
             <div class="col-sm-4">
             <c:if test="${not empty deviceList}">
		       <select class="form-control" id="textSelect" name="id" >
		      <c:forEach items="${session.deviceList}" var="onlineDevice">
		      <option value="${onlineDevice.id}">${onlineDevice.id}</option></c:forEach>
		      </select>
		      </c:if> 
		      </div>
             </div>
		      <div class=" form-group  required">
            <div class="col-md-offset-1">
		     <input class="btn btn-default" id="submit" name="key" type="submit" value="查询"> 
    		</div>
             </div>
             </fieldset>
     </form>
      <form method="post" class="form-horizontal"  action="${pageContext.request.contextPath}/repair_addRepair">
              <legend>维修信息添加</legend>
             <fieldset>
                          <div class="form-group  required">
             <label class=" col-sm-2 control-label" for="end">维修时间</label>
             <div class="col-sm-4">
             <!-- 获取当前系统时间 -->
             <% String date=new java.text.SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()); %>
             <input class="form-control" id="repairtime" name="repairTime" type="date" value=<%=date %>>
             </div>
             <label class="col-sm-2 control-label" for="deviceid">叉车编号</label>
             <div class="col-sm-4">
             <c:if test="${not empty deviceList}">
		       <select class="form-control" id="textSelect" name="id" >
		      <c:forEach items="${session.deviceList}" var="onlineDevice">
		      <option value="${onlineDevice.id}">${onlineDevice.id}</option></c:forEach>
		      </select>
		      </c:if> 
		      </div>                          
              </div>            
              <div class="form-group  required">
              <label class="col-sm-2 control-label" for="end">对应故障</label>
<div class="col-sm-4">
	<select class="form-control" id="textSelect" name="errortypeId">
		<c:if test="${not empty errorList}">
			<c:forEach items="${session.errorList}" var="errorType">
				<option  value="${errorType.id}" >(${errorType.id})   ${errorType.error}</option>
			</c:forEach>
		</c:if>
	</select>
</div>

              <label class="control-label col-sm-2" for="repairtype">维护策略</label>
              <div class="col-sm-4">
              <select class="form-control" id="repairtype" name="repairType">


             <option selected value="更换">更换</option>
              <option value="保养">保养</option>
              <option  value="检修">检修</option>
              <option  value="其他">其他</option>
              </select>
              </div>
                         
              </div>


                         <div class="form-group  required">
                         <label class="control-label col-sm-2" for="end">备注</label>
             <div class="col-sm-4">
             <input  class="form-control " name="remark" type="text">
 </div>  
             <label class="control-label col-sm-2 required" >维修人员 </label>
             <div class="col-sm-4">
            <input class="form-control" id="repairman" name="repairMan" type="text" >
         </div>
          <div class=" form-group  required">
            <div class="col-md-offset-1">
           <input class=" btn btn-default" id="submit" name="key" type="submit" value="保存">
            </div>
            </div>
              </div>

</fieldset>
            </form>

</div>
      <div class="panel-body">
      <table class="table">  
               <thead>
                <tr>
                  <th>编号</th>
                  <th>叉车ID</th>
                  <th>维修时间</th>
                  <th>对应故障</th>
                  <th>维修策略</th>
                  <th>备注</th>
                  <th>维护人员</th>
                </tr>
                </thead>
                <tbody>
		<c:if test="${not empty session.repairList }">
		<c:forEach items="${session.repairList }" var="repair" varStatus="varSt">
                <tr>
                  <td>${varSt.count}</td>
                  <td>${repair.id}</td>
                  <td>${repair.repairTime}</td>
                  <td>(${repair.errorType.id})  ${repair.errorType.error}</td>
                  <td>${repair.repairType}</td>
                  <td>${repair.remark}</td>
                  <td>${repair.repairMan}</td>
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



