<%@ page language="java" import="java.util.*" 
contentType="text/html;charset=UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>EasyMOOC - 用户登录</title>
		<link href="${ pageContext.request.contextPath }/css/login.css" rel="stylesheet">
		<link href="${ pageContext.request.contextPath }/css/self_bt.css" rel="stylesheet">
		<link href="${ pageContext.request.contextPath }/css/signin.css" rel="stylesheet">
		<script src="${ pageContext.request.contextPath }/js/lib/jquery-2.0.0.min.js" type="text/javascript"></script>
		<script src="${ pageContext.request.contextPath }/js/lib/bootstrap.min.js" type="text/javascript"></script>
		
		<script src="${ pageContext.request.contextPath }/js/user/login.js" type="text/javascript"></script>
		
		<style type="text/css">
			.login-content {
				position: relative;
				background-color: #fff;
				border: 1px solid #fff;
				border-radius: 6px;
				background-clip: padding-box;
				outline: none
			}
			.login-modal-header {
				min-height: 16.42857143px;
				text-align: center;
			}
		</style>
	</head>

	<body style="background: url(${ pageContext.request.contextPath }/images/zlogin.jpg)">
		<div class="login-content"
					style="width: 400px; height: 360px;  margin-left: 150px; margin-top: 160px; padding: 10px">
					<div class="login-modal-header" style="margin-top: 20px">
						<h3 style="font-weight: normal; font-size: 26px; color: #666666;">
						用户登录
						</h3>
					</div>
					<div>
						<form class="form-signin" id="submit_login">
							<div id="loginFalse" style="height:8px;padding:0px 0px 22px 0px" ></div>
							<input type="text" id="uaccount_login" class="signin-form-control" name="userName"
								placeholder="请输入手机/邮箱/用户名" required="" autofocus="">
							<div style="height: 30px">
							</div>
							<input type="password" id="upass_login" name="password"
								class="signin-form-control" placeholder="请输入密码" required="">
							<div style="height:22px" id="upassLoginVali">
								
							</div>
							<div class="checkbox">
								<label  style="font-weight: normal; font-size: 14px; color: #666666;">
									<input type="checkbox" value="remember-me" >
									记住密码
								</label>
							</div>
							<button class="btn btn-lg btn-primary btn-block" type="submit">
								登录
							</button>
						</form>
					</div>
				</div>
	</body>
</html>