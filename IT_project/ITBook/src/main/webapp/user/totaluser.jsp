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

					<div class="input-group line left"></div>
					<form method="post"
						action="${pageContext.request.contextPath}/Finduser">
						<table align="center">
							<tr>
								<td width="10" align="center" colspan="4">
							<tr>
								<td width="50%"><input type="text" class="form-control"
									placeholder="输入用户编号搜索" name="uid"
									aria-describedby="basic-addon2">
								<td colspan="3"><input class="btn btn-primary"
									type="submit" value="搜索" /></td>
								<div class="text" align="center">
									<td width="4%">&nbsp;</td> <span
										style="color: red; font-weight: 400"><c:if
											test="${flag==true}">数据有误，请重新输入！</c:if></span>
								</div>
							</tr><!-- 放置搜索框和搜索按钮,如果输入框内的数据形式不是整数输出错误提示 -->
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
										<!-- 输出每页的内容，包括用的各个属性 -->
										<table
											class="table table-bordered table-striped text-center bg-info">
											<tr>
												<th class="text-center">序号</th>
												<th class="text-center">用户编号</th>
												<th class="text-center">用户名</th>
												<th class="text-center">密码</th>
												<th class="text-center">联系方式</th>
												<th class="text-center">地址</th>
												<th class="text-center">用户等级</th>
												<th class="text-center">操作</th>
											</tr>
											<c:forEach items="${userlist}" var="user">
												<tr align="center" class="d">
													<td>${userlist.indexOf(user)+1+(currentpage-1)*pnum}</td>
													<td>${user.id}</td>
													<td>${user.uname}</td>
													<td>${user.password}</td>
													<td>${user.utel}</td>
													<td>${user.uaddress}</td>
													<td>${user.ugrade}</td>
													<td>
														<div class="table-fun">
															<a
																href="${pageContext.request.contextPath}/UpdateTouser?id=${user.id}">
																<input class="btn btn-primary btn-sm" type="submit"
																value="编辑">
															</a> <a
																href="${pageContext.request.contextPath}/Deleteuser?id=${user.id}">
																<input class="btn btn-primary btn-sm" type="submit"
																value="注销">
															</a>
														</div><!-- 在每一行放置编辑和注销按钮，点击后可以链接到相应的servlet-->
													</td>
												</tr>
											</c:forEach>
										</table>

										<div class="page" align="center">
											<form action="" method="get">
												<!-- 首页对应页数value为1 -->
												<c:url var="url_org" value="Jmppage">
													<c:param name="topage" value="1"></c:param>
												</c:url>
												<!-- 末页对应页数value为totalpage-->
												<c:url var="url_end" value="Jmppage">
													<c:param name="topage" value="${totalpage}"></c:param>
												</c:url>
												<!-- 上一页对应页数为当前页数减1-->
												<c:url var="url_pre" value="Jmppage">
													<c:param name="topage" value="${currentpage-1}"></c:param>
												</c:url>
												<!-- 下一页对应页数为当前页数加1-->
												<c:url var="url_next" value="Jmppage">
													<c:param name="topage" value="${currentpage+1}"></c:param>
												</c:url>



												<a href="${url_org}"><input type="button" value="首页"></input></a>

												<c:if test="${currentpage!=1}"><!-- 如果当前页数不为1，则可以跳转到上一页-->
													<a href="${url_pre}"><input type="button" value="上一页"></a>
												</c:if>

												<c:if test="${currentpage!=totalpage && totalpage!=0}"><!-- 如果当前页数不是总页数也不为0，则可以跳转到下一页-->
													<a href="${url_next}"><input type="button" value="下一页"></a>
												</c:if>
												<a href="${url_end}"><input type="button" value="末页"></input></a>
												<span style="color: white; font-weight: 600">第${currentpage}页</span>
												<span style="color: white; font-weight: 600">共${totalpage}页</span>
												<input type="text" class="page-input" name="topage">
												<span style="color: gray; font-weight: 600"> <input
													type="submit" class="page-btn" value="跳转"></input></span>
											</form>
										</div>

									</td>
								</tr>
							</table>
						</td>
						<td width="2%">&nbsp;</td>
					</tr>
					<!-- 产品列表结束 -->

					<!--右侧内容结束-->
				</div>
			</div>
	</section>

	
</body>
</html>