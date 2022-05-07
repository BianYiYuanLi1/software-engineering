<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="author" content="order by dede58.com"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="${pageContext.request.contextPath}/myFold/img/logo.png"/>
    <title>图书销售管理系统</title>
    <link href="${pageContext.request.contextPath}/myFold/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/myFold/css/mmss.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/myFold/css/font-awesome.min.css"/>
    <script src="${pageContext.request.contextPath}/myFlod/echarts.min.js"></script> 
    <script src="${pageContext.request.contextPath}/myFold/js/html5shiv.min.js"></script>
    <script src="${pageContext.request.contextPath}/myFold/js/respond.min.js"></script>
    <script src="${pageContext.request.contextPath}/myFold/js/Chart.js"></script>
    <script src="https://cdn.staticfile.org/echarts/4.3.0/echarts.min.js"></script>
</head>
<body>

<section>
    <div class="container-fluid">
        <div class="row ">
            <!--左侧导航开始-->
            <div class="col-xs-2 bg-blue">
                <br/>
                <div class="panel-group sidebar-menu" id="accordion" aria-multiselectable="true">
                    <div class="panel panel-default menu-first ">
                        <a data-toggle="collapse" data-parent="#accordion" href="index.jsp" aria-expanded="false">
                            <i class="icon-home icon-large"></i> 主页
                        </a>
                    </div>

                    
                </div>
            </div>
            <!--左侧导航结束-->
            <!----------------------------------------------------------------------------------------------------->
            <!--右侧内容开始-->
            <div class="col-xs-10">
                <br/>
                <ol class="breadcrumb">
                    <li><a href="${pageContext.request.contextPath}/index.jsp"><span class="glyphicon glyphicon-home"></span>&nbsp;后台首页</a></li>
                    <li class="active">销售统计 - 统计图</li>
                </ol>        
                 <!-- 销售额统计图开始 --> 
                <div class="chart">
                    <div class="canvas" >
                        <h3 class="text-primary">销售额</h3>
	               			<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
		                    <div id="main1" style="width: 450px;height:400px;"></div>
							    <script type="text/javascript">
							        var myChart1 = echarts.init(document.getElementById('main1'));
							 
							        var option1 = {
							            title: {},
							            tooltip: {},
							            legend: {
							                data:['销售额']
							            },
							            xAxis: {
							            	type:'category',
							            	axisLabel:{
							            		interval:'auto',
							            		rotate:50
							            	},
							                data: ["${date7}","${date6}","${date5}","${date4}","${date3}","${date2}","${date1}"]
							            },
							            yAxis: {},
							            color: ['#4682B4'],
							            series: [{
							                name: '销售额',
							                type: 'line',
							                data: [${income7}, ${income6},${income5},${income4},${income3},${income2},${income1}]
							            }]
							        };
							        myChart1.setOption(option1);
							    </script>
	                 </div>
                	<!-- 销售额统计图结束 -->
                  <!-- 销售量统计图开始 --> 
                  <div class="col-xs-50">
                    <div  class="canvas">
                        <h3 class="text-primary">销售量</h3>
                         <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
		                   <div id="main2" style="width: 450px;height:400px;"></div>
							    <script type="text/javascript">
							        var myChart2 = echarts.init(document.getElementById('main2'));
							 
							        var option2 = {
							            title: {},
							            tooltip: {},
							            legend: {
							                data:['销售量']
							            },
							            xAxis: {
							            	type:'category',
							            	axisLabel:{
							            		interval:'auto',
							            		rotate:50
							            	},
							                data: ["${date7}","${date6}","${date5}","${date4}","${date3}","${date2}","${date1}"]
							            },
							            yAxis: {},
							            color: ['#4682B4'],
							            series: [{
							                name: '销售量',
							                type: 'line',
							                data: [${num7}, ${num6},${num5},${num4},${num3},${num2},${num1}]
							            }]
							        };
							        myChart2.setOption(option2);
							    </script>
						</div>
                   </div>
                </div>
                <!-- 销售量统计图结束 --> 
            </div>
            <!--右侧内容结束-->
        </div>
    </div>
</section>
</body>
</html>