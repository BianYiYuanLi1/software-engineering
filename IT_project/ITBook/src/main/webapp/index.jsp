<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script src="${pageContext.request.contextPath}/myFold/js/html5shiv.min.js"></script>
    <script src="${pageContext.request.contextPath}/myFold/js/respond.min.js"></script>

</head>
<body>
<header>
    <div class="container-fluid navbar-fixed-top bg-primary">
        <ul class="nav navbar-nav  left">
            <li class="text-white h4">
                &nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-leaf"></span>&nbsp;&nbsp;<b>图书销售管理系统</b>
            </li>
        </ul>
        <ul class="nav navbar-nav nav-pills right ">
            <li class="bg-warning ">
                <a href="#"><span class="glyphicon glyphicon-tasks"></span><span class="badge">1</span></a>
            </li>
            <li class="bg-success">
                <a href="#"><span class="glyphicon glyphicon-envelope"></span><span class="badge">2</span></a>
            </li>
            <li class="bg-danger">
                <a href="#"><span class="glyphicon glyphicon-bell"></span></a>
            </li>
            <li class="bg-info dropdown">
                <a class="dropdown-toggle" href="#" data-toggle="dropdown">
                    <span class="glyphicon glyphicon-user"></span>&nbsp;<span>系统管理员</span><span class="caret"></span>
                </a>
                <ul class="dropdown-menu dropdown-menu-right">
                    <li class="text-center"><a href="${pageContext.request.contextPath}/index.jsp"><span class="text-primary">账号设置</span></a></li>
                    <li class="text-center"><a href="${pageContext.request.contextPath}/index.jsp"><span class="text-primary">消息设置</span></a></li>
                    <li class="text-center"><a href="${pageContext.request.contextPath}/index.jsp"><span class="text-primary">帮助中心</span></a></li>
                    <li class="divider"><a href="${pageContext.request.contextPath}/index.jsp"></a></li>
                    <li class="text-center"><a href="login.html"><span class="text-primary">退出</span></a></li>
                </ul>
            </li>
        </ul>
    </div>
</header>

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


                    <div class="panel panel-default menu-first">
                        <a data-toggle="collapse" data-parent="#accordion" href="index.jsp#collapseOne" aria-expanded="false"
                           aria-controls="collapseOne">
                            <i class="icon-user-md icon-large"></i> 销售统计</a>
                        </a>
                        <div id="collapseOne" class="panel-collapse collapse " >
                            <ul class="nav nav-list menu-second">
                                <li><a href="${pageContext.request.contextPath}/SalesServlet"><i class="icon-user"></i> 销售额</a></li>
                                <li><a href="${pageContext.request.contextPath}/BookRankListServlet"><i class="icon-edit"></i> 销售量</a></li>
                                <li><a href="${pageContext.request.contextPath}/ChartServlet"><i class="icon-trash"></i>统计图</a></li>
                            </ul>
                        </div>
                    </div>


                    <div class="panel panel-default menu-first">
                        <a class="collapsed" data-toggle="collapse"
                           data-parent="#accordion" href="index.jsp#collapseTwo"
                           aria-expanded="false" aria-controls="collapseTwo"> <i
                                class="icon-book icon-large"></i> 用户管理
                        </a> </a>
                        <div id="collapseTwo" class="panel-collapse collapse">
                            <ul class="nav nav-list menu-second">
                                <li><a
                                        href="${pageContext.request.contextPath}/user/useradd.jsp"><i
                                        class="icon-user"></i>添加用户</a></li>
                                <li><a href="${pageContext.request.contextPath}/Jmppage"><i
                                        class="icon-edit"></i>管理用户</a></li>

                            </ul>
                        </div>
                    </div>

                    <div class="panel panel-default menu-first">
                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="index.jsp#collapseThree"
                           aria-expanded="false" aria-controls="collapseThree">
                            <i class="icon-book icon-large"></i> 订单管理</a>
                        </a>
                        <div id="collapseThree" class="panel-collapse collapse">
                            <ul class="nav nav-list menu-second">
                                <li><a href="${pageContext.request.contextPath}/OrderListServlet"><i class="icon-user"></i> 订单列表</a></li>
                                <li><a href="${pageContext.request.contextPath}/order/order_add.jsp"><i class="icon-edit"></i> 添加订单</a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="panel panel-default menu-first">
                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="index.jsp#collapseFour"
                           aria-expanded="false" aria-controls="collapseFour">
                            <i class="icon-book icon-large"></i> 图书管理</a>
                        </a>
                        <div id="collapseFour" class="panel-collapse collapse">
                            <ul class="nav nav-list menu-second">
                                <li><a href="${pageContext.request.contextPath}/booklistservlet"><i class="icon-user"></i>图书列表</a></li>
                                <li><a href="${pageContext.request.contextPath}/book/book_add.jsp"><i class="icon-edit"></i>上新图书</a></li>
                            </ul>
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
                    <li class="active"><span class="glyphicon glyphicon-home"></span>&nbsp;后台首页</li>
                </ol>
                <h1 class="text-center text-white">图书销售管理系统</h1>
                <!----------------------------------------------------------    ------------------------------------------->
            </div>
            <!--右侧内容结束-->
        </div>
    </div>
</section>

<script src="${pageContext.request.contextPath}/myFold/js/jquery-1.11.3.js"></script>
<script src="${pageContext.request.contextPath}/myFold/js/bootstrap.js"></script>

<style>
    .copyrights{text-indent:-9999px;height:0;line-height:0;font-size:0;overflow:hidden;}
</style>

</body>
</html>