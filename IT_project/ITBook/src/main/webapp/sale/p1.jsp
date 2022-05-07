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
    <!--[if lt IE 9]>
    <script src="js/html5shiv.min.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
    <style>

    </style>
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
                    <li class="active">销售统计 - 销售额</li>
                </ol>
                <br/><br/>
                <!-- 搜索栏 -->
                <div class="input-group line left"></div>
              <form method="post" action="${pageContext.request.contextPath}/SalesServlet">
  					<table align="center">
	                    <tr >
	                        <td width="10" align="center"  colspan="4">
	                     <tr>
	                      <td width="50%"><input type="text" class="form-control" placeholder="输入日期"  name ="date" aria-describedby="basic-addon2">
	                     <td colspan="3"><input class="btn btn-primary" type="submit" value="搜索" /></td>
	                    </tr>
	                    </tr>
               		 </table>
                </form>
                <br/><br/>
                <!-- 搜索栏结束 -->
                <!-- 销售额统计表开始 -->
                <table class="table table-bordered table-striped text-center bg-info">
                    <thead >
                    <tr class="info">
                        <th class="text-center">日期</th>
                        <th class="text-center">销售额（元）</th>
                    </tr>
                    </thead>
                    <tbody>
                     <c:forEach  items="${list}" var="sale">
                          <tr align="center" class="d">
                        	<td>${sale.date}</td>
                       		 <td>${sale.income}</td>                                
                    		</tr>
                      </c:forEach>
                    </tbody>
                </table>
                 <div class = "page" align="center" style= "color:white;">
            	<form action = ""  method = "get">
            	共<span style= "color:red;">${totalCount}</span>条记录
            		<a style= "color:white;"  href = "SalesServlet?pageCur1=1">首页</a>
            		<c:url var = "url_pre"  value = "SalesServlet">
            			<c:param name = "pageCur" value = "${pageCur1-1}"></c:param>            		
            		</c:url>
            		<c:url var = "url_next"  value = "SalesServlet">
            			<c:param name = "pageCur" value = "${pageCur1+1}"></c:param>            		
            		</c:url>
            		<c:if test="${pageCur1!=1}">
            			<a style= "color:white;"href = "${url_pre}">上一页</a>
            		</c:if>
            		<c:if test="${pageCur1!=totalPage && totalPage!=0}">
            			<a style= "color:white;" href = "${url_next}">下一页</a>
            		</c:if>
            		第<span style = "color:red;font-weight:600"> ${pageCur1}</span>页
            		共<span style = "color:red;font-weight:600"> ${totalPage}</span>页
            		<input style= "color:black;" type = "text"  name ="pageCur" class = "page-input" size = "1">
            		<input style= "color:black;" type = "submit" class = "page-btn" value = "跳转">
            	</form>
            </div>
           </div>
                <!--  销售统计表结束 -->
            <!--右侧内容结束-->
        </div>
    </div>
</section>
</body>
</html>