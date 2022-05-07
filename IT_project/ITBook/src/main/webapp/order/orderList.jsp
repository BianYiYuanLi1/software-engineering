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
                        <a data-toggle="collapse" data-parent="#accordion" href="${pageContext.request.contextPath}/index.jsp" aria-expanded="false">
                            <i class="icon-home icon-large"></i> 主页
                        </a>
                    </div>

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
                    <li class="active">订单管理 - 订单列表</li>
                </ol>
                
              
                <!-- 订单列表开始 -->
                
                <table class="table table-bordered table-striped text-center bg-info">
                    <thead >
                    <tr class="info">
                        <td>选中</td>
                        <td>图书编号</td>
                        <td>订单创建时间</td>
                        <td>图书编号</td>
                        <td>图书数量</td>
                        <td>图书金额</td>
                        <td>客户编号</td>                                                      
                        <td>图书状态</td>
                    </tr>
                    </thead>
                    <tbody>
                     <c:forEach var = "order" items="${list}">
                          <tr align="center" class="d">
                              <td><input type="checkbox" value="" /></td>
                              <td>${order.order_id}</td>
                              <td>${order.create_time}</td>
                              <td>${order.book_id}</td>
                              <td>${order.numbers}</td>
                              <td>${order.prices}</td>
                              <td>${order.user_id}</td>
                              <td>已完成</td>
                          </tr>
                          </c:forEach>
                    </tbody>
                </table>
                
                <!-- 分页 -->
                 <div class = "page" align="center" style= "color:white;">
            	<form action = ""  method = "get">
            	共<span style= "color:red;">${totalCount}</span>条记录
            		<a style= "color:white;"  href = "OrderListServlet?pageCur1=1">首页</a>
            		<c:url var = "url_pre"  value = "OrderListServlet">
            			<c:param name = "pageCur" value = "${pageCur1-1}"></c:param>            		
            		</c:url>
            		<c:url var = "url_next"  value = "OrderListServlet">
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
                <!--  订单列表结束 -->
            <!--右侧内容结束-->
        </div>
    
</section>
</body>
</html>