
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/common/header.jsp"/>
   
<body >
<jsp:include page="/WEB-INF/common/guide.jsp"/>

<div class="container">
<div class="col-xs-12 col-sm-10 col-md-offset-1 col-lg-10 ">
    <div class="panel panel-default">
        <div class="panel-heading">
                <h4>故障统计  </h4>
                <h4 class="text-right">
                <% String date = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()); %>
                <%= date %></h4>  
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
           <ul id="myTab" class="nav nav-tabs">
                       <li >
                          <a href="${pageContext.request.contextPath}/warn_warningCount"  > 单辆叉车统计</a>
                       </li>
                       <li class="active">
                       <a href="${pageContext.request.contextPath}/warn_warningCount1" >按出厂日期统计</a>
                       </li>
                       <li>
                       <a href="${pageContext.request.contextPath}/warn_warningCount2" >所有故障分布统计</a>
                       </li>
                      
                    </ul>

            </div>
            </div>
            <div class="panel-body">
          <div id="myTabContent" class="tab-content">
   <div class="tab-pane fade" id="singlepanel">

    <form method="post" class="form" action="${pageContext.request.contextPath}/warn_countByDevice">

        <div class="row">
             <div class="col-lg-4">
             <div class="form-group  required">

             <label class="control-label" for="deviceid">叉车编号</label>
            <c:if test="${not empty session.deviceList}">
		        <select class="form-control" id="textSelect" name="deviceId">
		        <c:forEach items="${session.deviceList}" var="onlineDevice">
		        <option value="${onlineDevice.id}">${onlineDevice.id}</option></c:forEach>
		        </select>
		      </c:if>
             </div>
             <div class="form-group  required">
              <label class="control-label" for="trucktype">故障车型</label>
              <select class="form-control" id="trucktype" name="trucktype"><option selected value="1">CBD20R-II</option><option value="2">其他</option></select>
              </div>
             </div>
        </div>

        <label class="control-label" >故障类型</label>
        <div>
        <label><input type="checkbox" id="singleall">全选</label>
        <label><input type="checkbox" id="singleuncheck">不选</label>
        <label><input type="checkbox" id="singleothercheck">反选</label>

        </div>
<div id="single">
               <table class="table ">  
  <tbody>
  	
  	<c:if test="${not empty session.errorTypeList}">
  		<tr>
  			<c:forEach items="${session.errorTypeList}" var="errorType" varStatus="varSt">
  				<th>
  					<label><input type="checkbox" value="${errorType.id}" name="s_option">(${errorType.id})${errorType.error}</label>
  				</th>
  				<c:if test="${varSt.count%7==0}"></tr><tr></c:if>
  			</c:forEach>
  		</tr>
  	 </c:if>       
    </tbody>
            </table>
</div>
        <div class="col-lg-4">
            <div class="row">
           <input class="btn btn-default" id="submit" name="submit" type="submit" value="查询">
            </div>
          </div>
            </form>
<div id="singlechart"></div>
<c:if test="${not empty session.warningList1 }">
<script >
Highcharts.setOptions({
    lang: {
        printChart: '打印图表',
        downloadJPEG: '下载 JPEG 文件',
        downloadPDF: '下载 PDF   文件',
        downloadPNG: '下载 PNG  文件',
        downloadSVG: '下载 SVG  文件',
        downloadCSV: '下载 CSV  文件',
        downloadXLS: '下载 XLS   文件'
    },
    navigation: {
        menuItemStyle: {
            padding: '6px 14px'
        }
    },
    global: {
    useUTC: false
  },
  exporting: {
            buttons: {
                contextButton: {
                    menuItems: [
                                Highcharts.getOptions().exporting.buttons.contextButton.menuItems[0],
                                Highcharts.getOptions().exporting.buttons.contextButton.menuItems[7]
                            ]
                }
            }
        }
});
  $(function () {
    $('#singlechart').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        exporting: {
        filename: '编号${session.deviceId}叉车故障统计 '

    },
        title: {
            text: '单辆叉车故障统计'
        },
        subtitle:{
            text:'叉车编号：${session.deviceId}'
        },
        tooltip: {
            pointFormat: '{series.name}:{point.y} <br>百分比： {point.percentage:.1f}% '
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: false
                },
                showInLegend: true
            }
        },
        credits:{
     enabled:false // 禁用版权信息
},
        series: [{
            type: 'pie',
            name: '次数',
            data:<%=session.getAttribute("warningList1")%>  /* ${session.warningList}  */
        }]
    });
});
</script>
</c:if>
</div>

   <div class="tab-pane fade in active" id="datepanel">
    <form method="post" class="form" action="${pageContext.request.contextPath}/warn_countByDate">

        <div class="row">
             <div class="col-lg-4">
             <div class="form-group  required">
  <label class="control-label" for="begin">起始时间</label>
             <input class="form-control" id="deviceid" name="startTime" type="date" value=<%=date %>>
             </div>
             <div class="form-group  required">
  <label class="control-label" for="end">结束时间</label>
             <input class="form-control" id="deviceid" name="endTime" type="date" value=<%=date %>>
              </div>
              <div class="form-group  required">
              <label class="control-label" for="trucktype">故障车型</label>
              <select class="form-control" id="trucktype" name="trucktype"><option selected value="1">CBD20R-II</option><option value="2">其他</option></select>

              </div>
             </div>
        </div>


                       <label class="control-label" >故障类型</label>
        <div >
        <label><input type="checkbox" id="dateall">全选</label>
        <label><input type="checkbox" id="dateuncheck">不选</label>
        <label><input type="checkbox" id="dateothercheck">反选</label>

        </div>
          <div id="date">
                         <table class="table ">  
	<tbody>
  	
  	<c:if test="${not empty session.errorTypeList}">
  		<tr>
  			<c:forEach items="${session.errorTypeList}" var="errorType" varStatus="varSt">
  				<th>
  					<label><input type="checkbox" value="${errorType.id}" name="s_option">(${errorType.id})${errorType.error}</label>
  				</th>
  				<c:if test="${varSt.count%7==0}"></tr><tr></c:if>
  			</c:forEach>
  		</tr>
  	 </c:if>       
    </tbody>
            </table>
        </div>
<div class="col-lg-4">
            <div class="row">

            <input class="btn btn-default" id="submit" name="submit" type="submit" value="查询">
            </div>
            </div>
            </form>
<div id="datechart"></div>
<c:if test="${not empty warningList2}">
<script >
Highcharts.setOptions({
    lang: {
        printChart: '打印图表',
        downloadJPEG: '下载 JPEG 文件',
        downloadPDF: '下载 PDF   文件',
        downloadPNG: '下载 PNG  文件',
        downloadSVG: '下载 SVG  文件',
        downloadCSV: '下载 CSV  文件',
        downloadXLS: '下载 XLS   文件'
    },
    navigation: {
        menuItemStyle: {
            padding: '6px 14px'
        }
    },
    global: {
    useUTC: false
  },
  exporting: {
            buttons: {
                contextButton: {
                    menuItems: [
                                Highcharts.getOptions().exporting.buttons.contextButton.menuItems[0],
                                Highcharts.getOptions().exporting.buttons.contextButton.menuItems[7]
                            ]
                }
            }
        }
});
  $(function () {
    $('#datechart').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: '按出厂日期故障统计'
        },
        subtitle:{
          text:'${session.startTime}至${session.endTime}'
        }, 
        exporting: {
        filename: '出厂日期为${session.startTime}至${session.endTime}叉车故障统计 '
    },
        tooltip: {
            pointFormat: '{series.name}:{point.y} <br>百分比： {point.percentage:.1f}% '
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: false
                },
                showInLegend: true
            }
        },
        credits:{
     enabled:false // 禁用版权信息
},
        series: [{
            type: 'pie',
            name: '次数',
            data:<%=session.getAttribute("warningList2")%>
        }]
    });
});  
</script>
</c:if>
</div>



   <div class="tab-pane fade" id="allpanel">
<form method="POST" class="form" action="/allcount">

        <div class="row">
             <div class="col-lg-4">

             <div class="form-group  required">
         <label class="control-label" for="trucktype">故障车型</label>
              <select class="form-control" id="trucktype" name="trucktype"><option selected value="1">CBD20R-II</option><option value="2">其他</option></select>

              </div>
             </div>
        </div>


                       <label class="control-label" >故障类型</label>
        <div >
        <label><input type="checkbox" id="allall">全选</label>
        <label><input type="checkbox" id="alluncheck">不选</label>
        <label><input type="checkbox" id="allothercheck">反选</label>

        </div>
          <div id="all">
                         <table class="table ">  
	<tbody>
  	
  	<c:if test="${not empty session.errorTypeList}">
  		<tr>
  			<c:forEach items="${session.errorTypeList}" var="errorType" varStatus="varSt">
  				<th>
  					<label><input type="checkbox" value="${errorType.id}" name="s_option">(${errorType.id})${errorType.error}</label>
  				</th>
  				<c:if test="${varSt.count%7==0}"></tr><tr></c:if>
  			</c:forEach>
  		</tr>
  	 </c:if>       
    </tbody>
            </table>
        </div>
<div class="col-lg-4">
            <div class="row">

           <input class="btn btn-default" id="submit" name="submit" type="submit" value="查询">

            </div>
            </div>
            </form>
<div id="allchart"></div>
<c:if test="${not empty warningList3 }"></c:if>
<script >
Highcharts.setOptions({
    lang: {
        printChart: '打印图表',
        downloadJPEG: '下载 JPEG 文件',
        downloadPDF: '下载 PDF   文件',
        downloadPNG: '下载 PNG  文件',
        downloadSVG: '下载 SVG  文件',
        downloadCSV: '下载 CSV  文件',
        downloadXLS: '下载 XLS   文件'
    },
    navigation: {
        menuItemStyle: {
            padding: '6px 14px'
        }
    },
    global: {
    useUTC: false
  },
  exporting: {
            buttons: {
                contextButton: {
                    menuItems: [
                                Highcharts.getOptions().exporting.buttons.contextButton.menuItems[0],
                                Highcharts.getOptions().exporting.buttons.contextButton.menuItems[7]
                            ]
                }
            }
        }
});
  $(function () {
    $('#allchart').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: '所有故障统计'
        },
exporting: {
        filename: '所有故障统计'
    },
        tooltip: {
            pointFormat: '{series.name}:{point.y} <br>百分比： {point.percentage:.1f}%  '
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: false
                },
                showInLegend: true
            }
        },
        credits:{
     enabled:false // 禁用版权信息
},
        series: [{
            type: 'pie',
            name: '次数',
            data:<%=session.getAttribute("warningList3")%>
        }]
    });
});   
</script>
   </div>
</div>
                
            </div>
    </div>
 </div>

 </div>

</body>
</html>
<!-- 全选，全不选，反选的逻辑 -->
<script>
window.onload=function(){
    var singleCheckAll=document.getElementById('singleall');
    var singleUnCheck=document.getElementById('singleuncheck');
    var singleOtherCheck=document.getElementById('singleothercheck');
    var singlediv=document.getElementById('single');
    var singleCheckBox=singlediv.getElementsByTagName('input');

    var dateCheckAll=document.getElementById('dateall');
    var dateUnCheck=document.getElementById('dateuncheck');
    var dateOtherCheck=document.getElementById('dateothercheck');
    var datediv=document.getElementById('date');
    var dateCheckBox=datediv.getElementsByTagName('input');  

    var allCheckAll=document.getElementById('allall');
    var allUnCheck=document.getElementById('alluncheck');
    var allOtherCheck=document.getElementById('allothercheck');
    var alldiv=document.getElementById('all');
    var allCheckBox=alldiv.getElementsByTagName('input');  

    singleCheckAll.onclick=function(){
            for(i=0;i<singleCheckBox.length;i++){
                    singleCheckBox[i].checked=true;
                };
                singleUnCheck.checked=false;
                singleOtherCheck.checked=false;
        };
    singleUnCheck.onclick=function(){
            for(i=0;i<singleCheckBox.length;i++){
                    singleCheckBox[i].checked=false;
                };
            singleCheckAll.checked=false;
            singleOtherCheck.checked=false;

        };
    singleOtherCheck.onclick=function(){
            for(i=0;i<singleCheckBox.length;i++){
                    if(singleCheckBox[i].checked==true){
                            singleCheckBox[i].checked=false;
                        }
                    else{
                        singleCheckBox[i].checked=true
                        }
                      
                };
                  singleCheckAll.checked=false;
                  singleUnCheck.checked=false;
        };
    dateCheckAll.onclick=function(){
            for(i=0;i<dateCheckBox.length;i++){
                    dateCheckBox[i].checked=true;
                };
                dateUnCheck.checked=false;
                dateOtherCheck.checked=false;
        };
    dateUnCheck.onclick=function(){
            for(i=0;i<dateCheckBox.length;i++){
                    dateCheckBox[i].checked=false;
                };
            dateCheckAll.checked=false;
            dateOtherCheck.checked=false;
        };
    dateOtherCheck.onclick=function(){
            for(i=0;i<dateCheckBox.length;i++){
                    if(dateCheckBox[i].checked==true){
                            dateCheckBox[i].checked=false;
                        }
                    else{
                        dateCheckBox[i].checked=true
                        } 
                };
                  dateCheckAll.checked=false;
                  dateUnCheck.checked=false;
        };
    allCheckAll.onclick=function(){
            for(i=0;i<allCheckBox.length;i++){
                    allCheckBox[i].checked=true;
                };
                allUnCheck.checked=false;
                allOtherCheck.checked=false;
        };
    allUnCheck.onclick=function(){
            for(i=0;i<allCheckBox.length;i++){
                    allCheckBox[i].checked=false;
                };
            allCheckAll.checked=false;
            allOtherCheck.checked=false;
        };
    allOtherCheck.onclick=function(){
            for(i=0;i<allCheckBox.length;i++){
                    if(allCheckBox[i].checked==true){
                            allCheckBox[i].checked=false;
                        }
                    else{
                        allCheckBox[i].checked=true
                        } 
                };
                  allCheckAll.checked=false;
                  allUnCheck.checked=false;
        };
};
</script>





