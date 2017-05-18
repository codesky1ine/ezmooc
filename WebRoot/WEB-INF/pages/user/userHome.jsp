<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>个人主页 - ${ requestScope.user.userName }</title>
	
	<link href="${ pageContext.request.contextPath }/css/index.css" rel="stylesheet">
	<script src="${ pageContext.request.contextPath }/js/lib/jquery-2.0.0.min.js"></script>
	<script src="${ pageContext.request.contextPath }/js/user/home.js" type="text/javascript"></script>
	
</head>
<body>
	<div>
		
		<div id="indextop" class="header ">
			<jsp:include page="/WEB-INF/pages/common/header.jsp" flush="true"/>
		</div>
		
		<div class="main" style="margin-top: 0;">
			<div class="settings">
				<div class="container settings-container">
					<div class="aside hide-when-not-large" style="top: 4.5em">
						<h2>用户主页</h2>
						<div class="aside-title true" style="font-size: 18px;">
							<a href="#top"	style="color: #428bca">个人资料</a>
						</div>
						<div class="aside-title" style="font-size: 18px;">
							<a href="#follow " style="color: #428bca">关注课程</a>
						</div>
						
					</div>
					<%--
					TODO:
						头像上传：
							user form中一个自定义样式的button，
							user form下一个隐藏的文件上传form，其中有个input file，
							button的click触发file的click，
							
							file form可以在图片选择后直接submit，
							也可以在user form提交之后提交file form 
					--%>
					<div class="profile-settings" >
						<h3>个人资料</h3>
						<form id="user-form" enctype="multipart/form-data" >
							<div class="settings-cell">
								<label class="col-xs-2 control-label" style="font-size: 15px;text-align: center;">
										个人头像
								</label>
								<img class="user-avatar"
									src="${ requestScope.user.userIcon }">
								<div class="upload action">
									仅支持 jpg、png 格式大小 5M 以内图片。<input type="file" class="upload-input">
									<div>
										<input type="file" class="inline upload-file-button" name="iconFile">
									</div>
								</div>
							</div>
							<div class="settings-cell">
								<label class="col-xs-2 control-label">用户名</label>
								<input type="text"
									placeholder="填写你的姓名" name="userName" value="${ requestScope.user.userName }"
									class="action settings-input username-input">
								
							</div>
							<div class="settings-cell">
								<label class="col-xs-2 control-label">职业</label>
								<input type="text" value="${ requestScope.user.profession }"
									placeholder="填写你的职业" name="profession"
									class="action settings-input job-title-input">
								
							</div>
							<div class="settings-cell">
								<label class="col-xs-2 control-label">地址</label>
								<input type="text" value="${ requestScope.user.address }"
									placeholder="填写你的地址" name="address"
									class="action settings-input company-input">
								
							</div>
							<div class="settings-cell" >	
								<div style="float: right">
									<input type="reset" class="btn btn-default" value="重置">	
									<input type="submit" class="btn btn-primary" value="提交">
								</div>
							</div>	
						</form>
					</div>
					<a name="follow"></a>	
					<div style="height: 60px"></div>
					<div class="account-settings" >
						<h3>关注课程</h3>
						<div class="video-list" id="video-item" style="display: block; min-height: 0px">
							<c:forEach items="${ requestScope.courses }" var="course">
								<a class="item" 
								style="box-shadow: 0px 0px 2px 0px rgba(0, 0, 0, 0.23), 
								0 0px 0px 0 rgba(0, 0, 0, 0);" 
								target="_blank" href="/ezmooc/play/${ course.courseId }">
									<div class="left"
										style="background-image: url(${ course.courseImage }); height: 120px; width: 65px; background-size: cover">
									</div>
									<div class="right" style="width: 150px">
										<div class="title">
											${ course.courseName }
										</div>
										<div class="date">
											${ course.courseInfo }
										</div>
									</div>
								 </a>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>