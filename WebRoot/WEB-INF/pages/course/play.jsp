<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>课程 - ${ requestScope.course.courseName }</title>
		
  		<link href="${ pageContext.request.contextPath }/css/self_bt.css" rel="stylesheet">
  		<link rel="stylesheet" href="${ pageContext.request.contextPath }/css/font-awesome.min.css">
  		
  		<script src="${ pageContext.request.contextPath }/js/lib/jquery-2.0.0.min.js"></script>
  		<script src="${ pageContext.request.contextPath }/js/user/favorCourse.js"></script>
  		
	</head>
	<body style="background-color: rgb(247, 247, 247)">

		<%-- <input type="hidden" id="uuid" value="${ user.uuid }">
		<input type="hidden" id="cuid" value="${ course.cuid }"> --%>
		
		<div id="indextop" class="header ">
			<jsp:include page="/WEB-INF/pages/common/header.jsp" flush="true"/>
		</div>
		
		<div
			style="text-align: center; color: rgb(0, 188, 212); box-sizing: border-box; padding: 30px 16px; background-color: rgb(255, 255, 255);">
			<h1 class="rmq-106fafbb rmq-572b3dda"
				style="letter-spacing: 2px; display: inline-block; border-bottom-width: 2px; border-bottom-style: solid; border-bottom-color: rgb(255, 226, 0); padding-bottom: 1rem; margin-bottom: 2rem; font-size: 20px;">
				${ requestScope.video.videoName }
			</h1>
			<div style="max-width: 1000px; margin: 0px auto;">
				<video controls="" style="width: 100%;">
				<source
					src="${ requestScope.video.videoUrl }"
					type="video/mp4"></source>
				<p>
					To view this video please enable JavaScript, and consider upgrading
					to a web browser that supports HTML5 video.
				</p>
				</video>
			</div>
		</div>

		<div style="display: flex;
			max-width: 1000px; margin: 0px auto;">
			
			<!-- 关注教师 -->
			<div style="margin-top: 50px; 
				box-shadow: rgba(0, 0, 0, 0.117647) 0px 1px 6px, rgba(0, 0, 0, 0.117647) 0px 1px 4px; 
				border-radius: 2px; background-color: rgb(255, 255, 255); width: 480px; margin-left: 40px;">
				<a href="javascript:void(0);"><span id="follow-teacher" 
				<c:choose>
					<c:when test="${ requestScope.isFollowTeacher }">
						class="icon-heart"
					</c:when>
					<c:otherwise>
						class="icon-heart-empty"
					</c:otherwise>
				</c:choose>
				 style="font-size: 18px; 
					float: right; padding-top: 8px; padding-right: 8px; 
					color: rgb(0, 188, 212);"
					aria-hidden="true" onclick="follow('${ teacher.userId }')">&nbsp;&nbsp;收藏</span></a>
				<img src="${ teacher.userIcon }"
					style="display: block; width: 80px; height: 80px; margin: 32px auto 20px;">
				<div
					style="font-size: 20px; color: rgb(0, 0, 0); text-align: center;">
					${ teacher.userName }
				</div>
				<div style="padding: 16px; margin-bottom: 30px;">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					${ teacher.userInfo }	
				</div>
			</div>
			
			<!-- 收藏课程 -->
			<div style="margin-top: 50px; 
				box-shadow: rgba(0, 0, 0, 0.117647) 0px 1px 6px, rgba(0, 0, 0, 0.117647) 0px 1px 4px; 
				border-radius: 2px; background-color: rgb(255, 255, 255); width: 480px; margin-left: 40px;">
				<a href="javascript:void(0);"><span id="favor-course" 
				<c:choose>
					<c:when test="${ requestScope.isFavorCourse }">
						class="icon-heart"
					</c:when>
					<c:otherwise>
						class="icon-heart-empty"
					</c:otherwise>
				</c:choose>
				 style="font-size: 18px; 
					float: right; padding-top: 8px; padding-right: 8px; 
					color: rgb(0, 188, 212);"
					aria-hidden="true" onclick="favor('${ course.courseId }')">&nbsp;&nbsp;收藏</span></a>
				<img src="${ course.courseImage }"
					style="display: block; width: 80px; height: 80px; margin: 32px auto 20px;">
				<div
					style="font-size: 20px; color: rgb(0, 0, 0); text-align: center;">
					${ course.courseName }
				</div>
				<div style="padding: 16px; margin-bottom: 30px;">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					${ course.courseInfo }	
				</div>
			</div>
		</div>

		<div class="rmq-705b3f38"
			style="margin-top: 50px; padding-top: 30px; padding-bottom: 30px; background-color: rgb(255, 255, 255);">
			<div
				style="box-shadow: rgba(0, 0, 0, 0.117647) 0px 1px 6px, rgba(0, 0, 0, 0.117647) 0px 1px 4px; border-radius: 2px; max-width: 1000px; margin: 0px auto;">
				<h3
					style="color: rgb(255, 255, 255); text-align: center; padding: 30px 0px; font-size: 25px; margin-top: 0px; margin-bottom: 0px; background: rgb(0, 188, 212);">
					课程内容
				</h3>
				<div style="padding: 16px 16px 30px;">
					<div style="padding: 8px 0px;">
						<c:forEach items="${ requestScope.videos }" var="video">
							<div>
								<div
									style="color: rgba(0, 0, 0, 0.6); display: block; font-size: 16px; line-height: 16px; position: relative; transition: all 450ms cubic-bezier(0.23, 1, 0.32, 1) 0ms; margin-left: 0px; padding: 16px 16px 16px 72px;">
									<svg viewBox="0 0 24 24"
										style="display: block; fill: rgb(117, 117, 117); 
										height: 24px; width: 24px; 
										transition: all 450ms cubic-bezier(0.23, 1, 0.32, 1) 0ms;
										 position: absolute; top: 0px; margin: 12px; color: rgb(117, 117, 117);
										  left: 4px; -webkit-user-select: none;">
									<path d="M2.01 21L23 12 2.01 3 2 10l15 2-15 2z"></path>
									</svg>
									<a href="/ezmooc/play/${ course.courseId }/${ video.videoId }" style="color: #428bca;">
										${ video.videoName }
									</a>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
    
	</body>
</html>
