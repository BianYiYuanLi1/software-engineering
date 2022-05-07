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
                    <li class="active">图书销售系统</li>
                </ol>
                <br/><br/>
                <table class="table table-bordered table-striped text-center bg-info">
                    <thead >
                    <form action="${pageContext.request.contextPath}/Addbookservlet" method="post">
                    
                    <table class="table table-bordered table-striped text-center bg-info">
                  		<font size="7" style="color:red;align="center";">上传失败，请输入正确的图书信息重新上传</font>
                    <tr>
		                  <td style="height:50px;width:650px;font-size:30px;">书名</td>
		                  <td><input placeholder="请输入书名"  style="height:50px;width:300px;font-size:30px;"  type="text" name="bookName" value="" /></td>
		                  </tr>
		                  <tr>
		                 <td style="height:50px;width:650px;font-size:30px;">作者</td>
			               <td><input placeholder="请输入作者"  style="height:50px;width:300px;font-size:30px;"  type="text" name="bookWriter" value="" /></td>
			               </tr>
			               <tr>
			               <td style="height:50px;width:650px;font-size:30px;">价格</td>
			                   <td><input placeholder="请输入价格"  style="height:50px;width:300px;font-size:30px;" type="text" name="bookPrice" value="" /></td>
			                </tr>
			                <tr>   
			                <td style="height:50px;width:650px;font-size:30px;">库存</td>
			                   <td><input placeholder="请输入库存"  style="height:50px;width:300px;font-size:30px;" type="text" name="bookNum" value="" /></td>
			                  </tr>
			                  <tr>
			                  <td style="height:50px;width:300px;font-size:30px;">操作</td>
			                   <td ><input  style="height:50px;width:300px;font-size:30px;color:black;" type="submit" value="点击上传" /></td>
              				</tr>
          			</table>
      			</form>
                    </thead>
                    <tbody>
                  </table>
        </div>
    </div>
</section>
</body>
</html>