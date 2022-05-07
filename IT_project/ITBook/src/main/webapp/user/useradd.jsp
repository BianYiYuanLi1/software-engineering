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
						<li class="active">用户管理</li>
					</ol>
					<p>
						<!-- 添加栏目开始 -->
						<tr>
							<td width="2%">&nbsp;</td>
							<td width="96%">
								<table width="100%">
									<tr>
										<td colspan="2">
											<form action="${pageContext.request.contextPath}/Adduser"
												method="post">
												<table align="center" style="border-collapse:separate; border-spacing:0px 10px">
													<!-- 放置用户属性的各输入框 -->
													<tr>
														<div class="text" align="center">
															
															<td width="4%">&nbsp;</td>
															<td style="color: white; font-weight: 400">用户名称:</td>

															<td width="60%"><input class="form-control"
																type="text" name="uname" placeholder="USERID" /></td>
															<td width="2%">&nbsp;</td>
														</div>
													</tr>

													<tr>
														<div class="text" align="center">
															
															<td width="4%">&nbsp;</td>
															<td style="color: white; font-weight: 400">用户密码:</td>

															<td width="60%"><input class="form-control"
																type="text" name="upwd" placeholder="PASSWORD" /></td>
															<td width="2%">&nbsp;</td>
														</div>
													</tr>
													<tr>
														<div class="text" align="center">
															
															<td width="4%">&nbsp;</td>
															<td style="color: white; font-weight: 400">联系方式:</td>

															<td width="60%"><input class="form-control"
																type="text" name="utel" placeholder="TELEPHONE" /></td>
															<td width="2%">&nbsp;</td>
														</div>

													<tr>
														<div class="text" align="center">
															
															<td width="4%">&nbsp;</td>
															<td style="color: white; font-weight: 400">用户地址:</td>

															<td width="60%"><input class="form-control"
																type="text" name="uaddr" placeholder="ADDRESS" /></td>
															<td width="2%">&nbsp;</td>
														</div>
													</tr>
													<tr>
														<div class="text" align="center">	
														    <td width="4%">&nbsp;</td>
															<td style="color: white; font-weight: 400">用户等级:</td>
															<td width="60%"><input class="form-control"
																type="text" name="ugrade" placeholder="GRADE" /></td>
															<td width="2%">&nbsp;</td>
														</div>
													</tr>
													<tr>
														<td colspan="3" align="right">
														
														<input class="btn btn-primary" type="submit" value="提交" /> 
														<a href="${pageContext.request.contextPath}/Jmppage"> 
														<input style="margin-left: 40px;" class="btn btn-primary"
																type="button" value="返回" /></a></td>

													</tr>
													<tr>
													     <div class="text" align="center">
															<td width="4%">&nbsp;</td>
														    <span style="color: red; font-weight: 400"><c:if
															test="${flag==true}">数据错误，请重新输入！</c:if></span>
													     </div><!-- 如果接受到数据格式错误信息则输出错误提示 -->
													</tr>
												</table>
											</form>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<!-- 添加栏目结束 -->
					</p>
				</div>
				<!--右侧内容结束-->
			</div>
		</div>
	</section>

	<script src="1.18ZF07/js/jquery-1.11.3.js"></script>
	<script src="1.18ZF07/js/bootstrap.js"></script>

</body>
</html>