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
                    <li class="active">订单管理 - 添加订单</li>
                </ol>        
                <!--  添加信息开始 -->
                <div class="col-xs-10">
                <div  class="canvas">
                	<div style="width: 500px;height:400px;">
                        <h3 class="text-primary" align="center">添加订单</h3>
                        	<div class="col-xs-10">
                           <tr>
                                    <tr>
                                        <td colspan="2">
                                            <form action="${pageContext.request.contextPath }/OrderAddServlet" method="post">
                                                <table width="100%" aligh="center" >
                                                    <tr>
                                                        <td width="2%" >&nbsp;</td>
                                                        <td width="20%" >图书编号：</td>
                                                        <td width="30%" ><input class="text" type="text" name="bookid" value="" /></td>
                                                    </tr>
                                                    <tr>
                                                        <td>&nbsp;</td>
                                                        <td></td>
                                                        <td ></td><br/>
                                                    </tr>
                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td width="15%">图书数量：</td>
                                                        <td width="25%"><input class="text" type="text" name="number" value="" /></td><br/>
                                                    </tr>
                                                    <tr>
                                                        <td>&nbsp;</td>
                                                        <td></td>
                                                        <td ></td><br/>
                                                    </tr>
                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td width="20%">客户编号：</td>
                                                        <td width="20%"><input class="text" type="text" name="userid" value="" /></td>                                 
                                                    </tr>
                                                    <tr>
                                                        <td>&nbsp;</td>
                                                        <td></td>
                                                        <td ></td><br/>
                                                    </tr>
                                                    <tr>
                                                        <td>&nbsp;</td>
                                                        <td>&nbsp;</td>
                                                        <td colspan="3" width="20%"><input class="btn btn-primary" type="submit" value="提交" /></td>
                                                    </tr>
                                                </table>
                                            </form>
                                        </td>
                                    </tr>
                        		</tr>
                        </div>
                      </div>  
                    </div> 
                 </div>
                <!--  添加信息结束 -->   
                </div>
            </div>
            <!--右侧内容结束-->
    
</section>
</body>
</html>