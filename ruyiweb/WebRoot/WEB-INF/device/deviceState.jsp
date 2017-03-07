
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
                <h4>叉车状态信息</h4>

            </div>
            <div class="panel-body">
            <c:if test="${not empty session.device}">
                <tr id="${session.device.id}" >
                  <td colspan="10">
                  <div class="table-responsive">
                        <table class="table table-bordered table-striped">
                        <tr>叉车基本信息</tr>
                        <tr>
                        <td>叉车ID</td>
                        <td>
                        ${session.device.id}
                        </td>
                        <td>采集时间</td>
                        <td> ${session.device.time}</td>
                        <td>运行时间</td>
                        <td>
                        ${session.device.runningTime}
                        </td>

                        </tr>

                        </table>
                        </div>
                        <div class="table-responsive">
                        <table class="table table-bordered table-striped">
                        <tr>提升控制器信息</tr>
                        <tr>
                        <td>提升电机电流</td>
                        <td>${session.device.liftMotorCurrent}A</td>
                        <td>提升电机温度</td>
                        <td>${session.device.liftMotorTemperature}°C</td>
                        <td>提升开关正极</td>
                        <td>
                        <c:choose>
                        <c:when test="${session.device.upBtnSwitch==1 }">正常</c:when>
                        <c:otherwise><font color="red"> 不正常</font></c:otherwise>                    
                        </c:choose></td>
                        
                        <td>下降开关正极</td>
                        <td>
                        <c:choose>
                        <c:when test="${session.device.downBtnSwitch==1 }">正常</c:when>
                        <c:otherwise><font color="red"> 不正常</font></c:otherwise>                    
                        </c:choose></td>
                        
                        </tr>
                        <tr>
                          
                        <td>提升控制器线圈进线端</td>
                        <td>
                        <c:choose>
                        <c:when test="${session.device.upBtnContactorCoilUpper==1 }"><font color="red"> 不正常</font></c:when>
                        <c:otherwise>正常</c:otherwise>                    
                        </c:choose></td>
                        
                        <td>提升接触器线圈接地端</td>
                        <td>
                        <c:choose>
                        <c:when test="${session.device.upBtnContactorCoilDown==1 }"><font color="red"> 不正常</font></c:when>
                        <c:otherwise>正常</c:otherwise>                    
                        </c:choose></td>
                        
                       <td>提升触点进线端</td>
                        <td>
                        <c:choose>
                        <c:when test="${session.device.upBtnContactUpper==1 }">正常</c:when>
                        <c:otherwise><font color="red"> 不正常</font></c:otherwise>                    
                        </c:choose></td>
                       
                        
                        <td>提升触点出线端</td>
                        <td>
                        <c:choose>
                        <c:when test="${session.device.upBtnContactDown==1 }"><font color="red"> 不正常</font></c:when>
                        <c:otherwise> 正常 </c:otherwise>                    
                        </c:choose></td>
                        
                        </tr>
                        <tr>
                        
                        <td>下降电磁阀进线端</td>
                        <td>
                        <c:choose>
                        <c:when test="${session.device.downBtnsolenoidvalveUpper==1 }"><font color="red"> 不正常</font></c:when>
                        <c:otherwise> 正常 </c:otherwise>                    
                        </c:choose></td>
                                        
                        <td>下降电磁阀接地端</td>
                        <td>
                        <c:choose>
                        <c:when test="${session.device.downBtnsolenoidvalveDown==1 }"><font color="red"> 不正常</font></c:when>
                        <c:otherwise> 正常 </c:otherwise>                    
                        </c:choose></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        </tr>
                        </table>
                        </div>

                        <div class="table-responsive">
                        <table class="table table-bordered table-striped">
                        <tr>喇叭、主控制器、制动器信息</tr>
                        <tr>
                        <td>主接触器线圈进线端</td>
                        <td>
                        <c:choose>
                        <c:when test="${session.device.masterContactorCoilUpper==1 }">正常</c:when>
                        <c:otherwise><font color="red"> 不正常</font></c:otherwise>                    
                        </c:choose></td>
                        
                        <td>主接触器线圈接地端</td>
                        <td>
                        <c:choose>
                        <c:when test="${session.device.masterContactorCoilDown==1 }"><font color="red"> 不正常</font></c:when>
                        <c:otherwise> 正常 </c:otherwise>                    
                        </c:choose></td>
                        
                        <td>主接触器触点进线端</td>
                        <td>
                        <c:choose>
                        <c:when test="${session.device.masterContactUpper==1 }">正常</c:when>
                        <c:otherwise><font color="red"> 不正常</font></c:otherwise>                    
                        </c:choose></td>
                       
                        <td>主接触器触点出线端</td>
                        <td>
                        <c:choose>
                        <c:when test="${session.device.masterContactDown==1 }">正常</c:when>
                        <c:otherwise><font color="red"> 不正常</font></c:otherwise>                    
                        </c:choose></td>
                        
                        </tr>
                        <tr>
                        
                        <td>喇叭正极</td>
                        <td>
                        <c:choose>
                        <c:when test="${session.device.hornSwitch==1 }">正常</c:when>
                        <c:otherwise><font color="red"> 不正常</font></c:otherwise>                    
                        </c:choose></td>
                        
                        <td>喇叭负极</td>
                        <td>
                        <c:choose>
                        <c:when test="${session.device.hornGround==1 }"><font color="red"> 不正常</font></c:when>
                        <c:otherwise> 正常 </c:otherwise>                    
                        </c:choose></td>
                        
                        <td>喇叭开关</td>
                        <td>
                        <c:choose>
                        <c:when test="${session.device.horn==1 }"><font color="red"> 不正常</font></c:when>
                        <c:otherwise> 正常 </c:otherwise>                    
                        </c:choose></td>
                        
                          <td></td>
                        <td></td>
                        </tr>
                         <tr>
                         
                          <td>制动器线圈正极</td>
                        <td>
                        <c:choose>
                        <c:when test="${session.device.arresterUpper==1 }">正常</c:when>
                        <c:otherwise><font color="red"> 不正常</font></c:otherwise>                    
                        </c:choose></td>               

                        
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        </tr>
                        </table>
                        </div>
                  </td>
                </tr>
                </c:if>
</div>
</div>
</div>
</div>
</body>
</html>





