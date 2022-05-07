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
                    <li class="active">销售统计 - 销售量</li>
                </ol>
                
                
                <!-- 排行榜选择 -->
                <br/>
                <tr>
                      <td colspan="4">
                          <table>
                              <tr>
                                  <div class = "table-fun" class="input-group line left" >
                                 		<a href = "${pageContext.request.contextPath}/BookRankListServlet" > <input type = "button" value ="总排行榜 "></a>
                                 		<a href = "${pageContext.request.contextPath}/DayServlet" ><input type = "button" value ="本日排行榜 "></a>
                                 		<a href = "${pageContext.request.contextPath}/WeekServlet" ><input type = "button" value ="近7天排行榜"></a>
                                 		<a href = "${pageContext.request.contextPath}/MonthServlet" ><input type = "button" value ="近30天排行榜"> </a>
                                 </div>
                              </tr>
                          </table>
                      </td>
                  </tr> 
                <br/>
               <!-- 选择结束 -->
                <!-- 图书排行榜开始 -->
                <table class="table table-bordered table-striped text-center bg-info">
                
                    <thead >
                    <tr class="info">
                        <th class="text-center">排名</th>
                        <th class="text-center">图书编号</th>
                        <th class="text-center">图书名称</th>
                        <th class="text-center">销售量（本）</th>
                    </tr>
                    </thead>
                    <tbody>
		                    <c:set var="index" value="${index}"></c:set>
		                    <c:forEach  items="${bookranklist}" var="book">
		                    <tr align="center" class="d">
			                    <td>${index=index+1}</td>
			                    <td>${book.id}</td>
			                  	<td>${book.bookname}</td>
			                  	<td>${book.number}</td>                                
		              		</tr>
		                    </c:forEach>
                    </tbody>
                </table>
                <!-- 分页 -->
                 <div class = "page"  align="center" style= "color:white;">
            	<form action = ""  method = "get">
            	共<span style= "color:red;">${totalCount}</span>条记录
            		<a style= "color:white;" href = "BookRankListServlet?pageCur1=1">首页</a>
            		<c:url var = "url_pre"  value = "BookRankListServlet">
            			<c:param name = "pageCur" value = "${pageCur1-1}"></c:param>            		
            		</c:url>
            		<c:url var = "url_next"  value = "BookRankListServlet">
            			<c:param name = "pageCur" value = "${pageCur1+1}"></c:param>            		
            		</c:url>
            		<c:if test="${pageCur1!=1}">
            			<a style= "color:white;" href = "${url_pre}">上一页</a>
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
                 <!-- 图书排行榜结束 -->
                </div>
            </div>
            <!--右侧内容结束-->
        </div>
    </div>
</section>

</body>
</html>