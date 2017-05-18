<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ page import="com.aszy.ezmooc.po.Course"%>
<%@ page import="com.aszy.ezmooc.po.CourseCatg"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>
		EasyMOOC - 课程列表
	</title>
	
	<script src="${ pageContext.request.contextPath }/js/lib/jquery-2.0.0.min.js"></script>
	<script src="${ pageContext.request.contextPath }/js/course/list.js"></script>
	
<script type="text/javascript">
			
	$(function(){
		$("#asskfsbkjfnasjkdfnasklf").val();
		var data = ${ requestScope.listActionData };
		var courseCatgList = data.courseCatgList;
		var courseCatgId = data.courseCatgId;
		var page = data.page;
		var pageCount = data.pageCount;
		//var sort = data.sort;
		
		$("#courseCatgHtml").html( 
			genCourseCatgHtml(courseCatgList, courseCatgId, null) );
			
		$("#pageHtml").html( 
			getPageHtml(page, pageCount, courseCatgId, null) );
	})
	
</script>
	
</head>

<body id="List_courseId">

	<div id="indextop" class="header ">
		<jsp:include page="/WEB-INF/pages/common/header.jsp" flush="true"/>
	</div>

	<div id="main">
		<div class="container">
			<div class="course-content">
				<div class="course-nav-box">
					<div style="font-size: 16px; font-weight: 700;
  						color: #14191e;position: relative; margin-top: 20px;">
						<span>课程列表</span>
					</div>
					<div style="border-bottom: 1px solid #d0d6d9;">
					</div>
					<div class="course-nav-row clearfix">
						<span class="hd l">分类：</span>
						
						<!-- 课程类别 -->
						<div class="bd" id="courseCatgHtml"></div>
						
					</div>
				</div>
				<div class="course-list">
					<!-- 课程列表 -->
					<div class="js-course-lists">
						<ul>
							<c:forEach items="${ requestScope.courseList }" var="course">
								<li class="course-one">
									<a target="_blank" href="play/${ course.courseId }">
										<div class="course-list-img">
											<img width="240" height="135" src="${ course.courseImage }">
										</div>
										<h5><span>${ course.courseName }</span></h5>
										<div class="tips">
											<p class="text-ellipsis">${ course.courseInfo }</p>
										</div>
									</a>
								</li>
							</c:forEach>
						</ul>
					</div>
					<!-- 分页 -->
					<div class="page" id="pageHtml"></div>
				</div>
			</div>
		</div>
	</div>
	</body>
<link href="${ pageContext.request.contextPath }/css/course_list.css" rel="stylesheet">
<style type="text/css">
	.theactive{
	    background: #00BCD4;
   		color: #ffffff;
	}
</style>
</html>

