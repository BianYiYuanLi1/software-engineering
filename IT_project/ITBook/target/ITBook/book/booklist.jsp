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
            <!--左侧导航结束-->
            <!----------------------------------------------------------------------------------------------------->
            <!--右侧内容开始-->
            <div class="col-xs-10">
                <br/>
                <ol class="breadcrumb">
                    <li><a href="${pageContext.request.contextPath}/index.jsp"><span class="glyphicon glyphicon-home"></span>&nbsp;后台首页</a></li>
                    <li class="active">图书销售管理系统</li>
                </ol>
           <form method="post" action="${pageContext.request.contextPath}/FindByNameServlet">
           <input placeholder="输入书名搜索" class="text" style="width:100px;" type="text" name="name" value="" />
           <input class="btn btn-primary btn-sm" type="submit" value="搜索" /></td>
           <input  placeholder="输入作者搜索" class="text" style="width:100px;" type="text" name="writer" value="" />
           <input class="btn btn-primary btn-sm" type="submit" value="搜索" /></td>
             </form>
                <table class="table table-bordered table-striped text-center bg-info">
                    <thead >
                    <tr class="info">
                        <th class="text-center">图书编号</th>
                        <th class="text-center">书名</th>
                        <th class="text-center">作者</th>
                        <th class="text-center">价格</th>
                        <th class="text-center">库存</th>
                        <th class="text-center">操作</th>
                    </tr>
                    </thead>
                    <c:forEach var="book" items="${booklist}">
									<tr align="center">
										<td>${book.bookId}</td>
										<td>${book.bookName}</td>
										<td>${book.bookWriter}</td>
										<td>${book.bookPrice}</td>
										<td>${book.bookNum}</td>
										<td>
										<div class="table-fun">
										<a href="${pageContext.request.contextPath}/ToEditBook?bookId=${book.bookId}" class="btn btn-primary btn-sm" >编辑</a>
										<a href="${pageContext.request.contextPath}/DeleteSevlet?bookId=${book.bookId}" class="btn btn-primary btn-sm" >删除</a>
										</div>
										</td>
									</tr>
									</c:forEach>
									</table>
            <!--右侧内容结束-->
        </div>
    </div>
    <div align="center">
    <form action="" method="get">
        <span style="color:white;"> 共${totalCount}种书        </span>
       <a style="color:white;" href="${pageContext.request.contextPath}/booklistservlet">首页          </a>
       <c:url var = "url_pre" value="booklistservlet"><c:param name="pageCur" value="${pageCur1-1}"></c:param> </c:url> 
       <c:url var="url_next" value="booklistservlet"><c:param name="pageCur" value="${pageCur1+1}"></c:param></c:url>                    
<!--判断首页与末页，若为首页则没有上一页，若为末页没有下一页，注意若总页数为0则没有下一页，因此在末页的判断中有两个条件-->
        <c:if test="${pageCur1!=1}">
        <a style="color:white;" href="${url_pre}">上一页          </a>
        </c:if >
        <c:if test="${pageCur1!=totalPage&&pageCur1!=0}">
        <a style="color:white;" href="${url_next}">下一页</a>
        </c:if>
       	<span style="color:white;"> 第${pageCur1}页</span>
<!--         跳转页面输入框 及提交按钮-->
       <input type="text" name ="pageCur" class="page-input" size="2"></input >
       <input class="btn btn-primary btn-sm"  type="submit" value="跳转" />
        共<span>${totalPage}</span>页
        </form></div>
</section>
</body>
</html>