<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <script src="${ pageContext.request.contextPath }/js/common/head.js"></script>
    
	<script src="${ pageContext.request.contextPath }/js/lib/bootstrap.min.js"></script>
    
    <link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/css/search.css">
	<link href="${ pageContext.request.contextPath }/css/main.css" rel="stylesheet">
	<link href="${ pageContext.request.contextPath }/css/login.css"rel="stylesheet">
	<link href="${ pageContext.request.contextPath }/css/admin_header.css" rel="stylesheet">
	<link href="${ pageContext.request.contextPath }/css/signin.css" rel="stylesheet">
	
	<link href="${ pageContext.request.contextPath }/css/self_bt.css" rel="stylesheet">
    
  </head>
  
  <body>
    	<div class="logo fl">
			<a href="/ezmooc">
				<img src="/ezmooc/images/logo2.png">
			</a>
		</div>
		<div class="nav fl navbar-header">
			<a href="/ezmooc/list">课程</a>
			<a href="/ezmooc/list">实战</a>
			<a href="/ezmooc/list">教师</a>
			<a href="/ezmooc/list">问答</a>
			<a href="/ezmooc/list">关于我们</a>
		</div>
		
		<div 
			style="margin-left: 20%; font-size: 16px; line-height: 24px; width: 100%; 
			height: 48px; display: inline-block; position: relative;
			 background-color: transparent; font-family: Roboto, sans-serif; 
			 transition: height 200ms cubic-bezier(0.23, 1, 0.32, 1) 0ms; 
			 max-width: 200px; mui-prepared: ;">
			<div id="headSearchStr"
				style="position: absolute; opacity: 1; 
				color: #fff; transition: all 450ms cubic-bezier(0.23, 1, 0.32, 1) 0ms;
				 bottom: 12px; color: #fff">
				搜索
			</div>
			<input id="headKeyWord" value=""  
				style="-webkit-tap-highlight-color: #fff; padding: 0;
				position: relative; width: 100%; height: 100%; border: none; outline: none;
				 background-color: rgba(0, 0, 0, 0); color: #fff; font: inherit; mui-prepared: ;"
				type="text">
			<div>
				<hr
					style="border: none; border-bottom: solid 1px; 
					border-color: #fff; bottom: 8px; box-sizing: content-box; 
					margin: 0; position: absolute; width: 100%; mui-prepared: ;">
				<hr
					style="border-style: none none solid; border-bottom-width: 2px;
					 border-color: #fff; bottom: 8px; box-sizing: content-box; 
					 margin: 0px; position: absolute; width: 100%; transform: scaleX(1); 
					 transition: all 450ms cubic-bezier(0.23, 1, 0.32, 1) 0ms;">
			</div>
		</div>
		 
		<a href="javascript:void(0)"
			style="width: 48px; height: 48px; display: inline-block;
			 position: relative; margin-bottom: -17px;" 
			 onclick="headSearch()">
			<svg
				style="display:inline-block;fill:#fff;
								height:24px;width:24px;user-select:none;
								transition:all 450ms cubic-bezier(0.23, 1, 0.32, 1) 0ms;
								position:absolute;top:24px;left:12px;mui-prepared:;"
				viewBox="0 0 24 24">
			<path
				d="M15.5 14h-.79l-.28-.27C15.41 12.59 16 11.11 16 9.5 16 5.91 13.09 3 9.5 3S3 5.91 3 9.5 5.91 16 9.5 16c1.61 0 3.09-.59 4.23-1.57l.27.28v.79l5 4.99L20.49 19l-4.99-5zm-6 0C7.01 14 5 11.99 5 9.5S7.01 5 9.5 5 14 7.01 14 9.5 11.99 14 9.5 14z"></path>
			</svg>
		</a>
		
		<div  style="float: right"> 
			<!-- EL表达式两边不要写空格，不然判断会失效 -->
			<!-- 注释不能写在jstl中。。。 -->
			<c:choose>
				<c:when test="${empty sessionScope.loginUser}">
				<div class="nav fl navbar-header">
					<a href="javascript:void(0);" data-toggle="modal" data-target="#loginModal">登录</a>
					<a href="javascript:void(0);" data-toggle="modal" data-target="#registModal">注册</a>
					</div>
				</c:when>
				<c:when test="${not empty sessionScope.loginUser}">
					<div class="dropdown" style="margin-right: 30px; margin-top: 15px">
					
					<span style="color:#fff;font-size: large;padding-right: 10px;">${ loginUser.userName }</span>
					  <a href=""
							style="font-size: 16px;"
							class="dropdown-toggle" data-toggle="dropdown">
							 <img src="${ loginUser.userIcon }" class="img-circle"  width="32" height="32">
						</a>
					  
					  <ul class="dropdown-menu"
					  style="right: 0; left: auto; margin-right: 20px; margin-top: 15px;">
					  	<li>
					  		<a href="/ezmooc/user/${ loginUser.userId }">${ loginUser.userName }</a>
					  	</li>
					  	
					  	<!-- TODO: 登出 改成ajax提交，则可以在响应时refresh当前页面 -->
					    <li><a id="logout" href="javascript:void(0);" style="color: #333; padding: 3px 20px;">登出</a></li>
					  </ul>
					</div>
     			</c:when>
			</c:choose>
		</div>
		<jsp:include page="/WEB-INF/pages/user/loginDialog.jsp"></jsp:include>
    	<jsp:include page="/WEB-INF/pages/user/registDialog.jsp"></jsp:include>
		
  </body>
</html>
