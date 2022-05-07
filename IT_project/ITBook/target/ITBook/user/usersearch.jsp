<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
					<br />
					<ol class="breadcrumb">
						<li><a href="${pageContext.request.contextPath}/index.jsp"><span
								class="glyphicon glyphicon-home"></span>&nbsp;后台首页</a></li>
						<li class="active">用户管理 - 表格</li>
					</ol>
					<!--搜索框和搜索按钮-->
					 <div class="input-group line left"></div>
					<form method="post" action="${pageContext.request.contextPath}/Finduser">
         					    <table align="center">
                                    <tr >
                                        <td width="10" align="center" colspan="4">
                                   <tr>
                                    <td width="50%"><input type="text" class="form-control" placeholder="输入用户编号搜索"  name ="uid" aria-describedby="basic-addon2">
                                    <td colspan="3"><input class="btn btn-primary" type="submit" value="搜索" /></td>
                                   </tr>
                                    </tr>
                                </table>
                                </form>
					<!-- 产品列表开始 -->
					<tr>
						<td width="2%">&nbsp;</td>
						<td width="96%">
							<table width="100%">
								<tr>
									<td colspan="2">
										<table class="table table-bordered table-striped text-center bg-info">
											<tr>
                                                        <th class="text-center">用户编号</th>
                                                        <th class="text-center">用户名</th>
                                                        <th class="text-center">密码</th>
                                                        <th class="text-center">联系电话</th>
                                                        <th class="text-center">地址</th>
                                                        <th class="text-center">用户等级</th>
                                                        <th class="text-center">操作</th>
											</tr>
											<c:forEach items="${userlist}" var="user">
												<tr align="center" class="d">
												<c:if test="${user.id!=0}"><!--如果查询到了用户信息则输出完整的用户信息，否则只输出表头，结果为空-->
													<td>${user.id}</td>
													<td>${user.uname}</td>
													<td>${user.password}</td>
													<td>${user.utel}</td>
													<td>${user.uaddress}</td>
													<td>${user.ugrade}</td>
													<td>
														<div class="table-fun">
														<a href="${pageContext.request.contextPath}/UpdateTouser?id=${user.id}">
														<input class="btn btn-primary btn-sm" type="submit" value="编辑"></a>  
														<a href="${pageContext.request.contextPath}/Deleteuser?id=${user.id}">
														<input class="btn btn-primary btn-sm" type="submit" value="注销"></a>  
														</div>
													</td>
												</c:if>
												</tr>
											</c:forEach>
										</table>
									</td>
								</tr>
							</table>
						</td>
						<td width="2%">&nbsp;</td>
					</tr>
					<!-- 产品列表结束 -->
					</tbody>
					</table>

				</div>
				<!--右侧内容结束-->
			</div>
		</div>
	</section>
</body>
</html>