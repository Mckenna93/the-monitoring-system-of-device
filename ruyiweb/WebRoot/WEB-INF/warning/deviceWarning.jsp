
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
                <h4>叉车故障信息</h4>
            </div>
            <div class="panel-body">
            <c:if test="${not empty session.deviceWarn}">
                <tr id="${session.deviceWarn.deviceid}" >
                  <td colspan="10">
                  <div class="table-responsive">
                        <table class="table table-bordered table-striped">
                        <tr>叉车基本信息</tr>
                        <tr>
                        <td>叉车ID</td>
                        <td>
                        ${session.deviceWarn.deviceid}
                        </td>
                        <td>故障次数</td>
                        <td>
                        ${session.warnNum}
                        </td>
                        

                        </tr>
                        <tr>
                        <td>起始时间</td>
                        <td>${session.startTime}</td>
                        <td>结束时间</td>
                        <td>
                        ${session.endTime}
                        </td>
                        </tr>

                        <tr>
                        <td>故障代码</td>
                        <td><font color="red">${session.deviceWarn.errorType.id}</font></td>
                        <td>故障名称</td>
                        <td>
                        <font color="red">${session.deviceWarn.errorType.error}</font>
                        </td>
                        </tr>

                        </table>

                        </div>
                        <div class="table-responsive">
                        <table class="table table-bordered table-striped">
                        <tr>故障处理方法</tr>

                        <tr>
                        <td>故障处理方法</td>
                        <td><font color="red">${session.deviceWarn.errorType.repair}</font></td>

                        </tr>
                        </table>

                        </div>
                </td>
                </tr>
                </c:if>
				<div id="container"></div>
				

</div>
</div>
</div>
</div>
</body>
<script type="text/javascript">
				Highcharts.setOptions({
				  global: {
				    useUTC: false
				  }
				});
				$(function () {
				    $('#container').highcharts({
				        chart: {
				            type: 'scatter',
				            zoomType: 'x'
				        },
				        title: {
				            text: '故障报警图'
				        },
				        subtitle: {
				            text: '故障时间：${session.startTime}  至 ${session.endTime}'
				        },
				         scrollbar: {
				
				               enabled: true
				
				          },
				        xAxis: {
				            title: {
				                enabled: true,
				                text: '时间'
				            },
				            type:'datetime',
				             tickPixelInterval: 150,
				             labels: {
				                       enable: true,
				                       //step: 4,
				                       formatter: function () {
				                           return Highcharts.dateFormat('%Y-%m-%d %H:%M', this.value);
				                           }
				                       },
				            showLastLabel: true
				        },
				        yAxis: {
				            title: {
				                text: '报警值'
				            }
				        },
				        legend: {
				            layout: 'vertical',
				            align: 'left',
				            verticalAlign: 'top',
				            x: 100,
				            y: 70,
				            floating: true,
				            backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF',
				            borderWidth: 1
				        },
				        credits:{
				     enabled:false // 禁用版权信息
				},
				       tooltip: {
				            formatter: function() {
				                    return '<b>'+ this.series.name +'</b><br/>'+
				                    Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) +'<br/>  报警值: '+ this.y;
				            }
				        },
				        series: [{
				            name: '故障中',
				            color: '#ff0000',
				            data: <%=session.getAttribute("warnDetail")%>
				        }]
				    });
				});
				
				
				</script>
</html>