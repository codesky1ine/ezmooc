
$(function(){
	$("#submit_login").submit(function(){
		loginSubmit();
		return false;
	});
	$("#close_login").click(function(){
		$("#uaccountLoginVali").html("");
		$("#upassLoginVali").html("");
		$("#loginFalse").html("");
	});
	$("#logout").click(logout);
});

function uaccountLoginVali(){
	var uaccount = $("#uaccount_login").val();
	var regexPhone = /^1(3[0-9]|4[5|7]|5[0-3|5-9]|8[0-9]|70)\d{8}$/;
	var regexEmail = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
	
	if( regexPhone.test(uaccount) ){
		//使用$().attr只能设置标签上已有的属性，$().prop则可添加不存在的属性
		$("#uaccount_login").prop("name", "phone");
	} else if( regexEmail.test(uaccount) ){
		$("#uaccount_login").prop("name", "email");
	} else{
		$("#uaccount_login").prop("name", "userName");
	}
	$("#uaccountLoginVali").html("");
	return true;
}

function upassLoginVali(){
	var upass = $("#upass_login").val();
	if(upass.length < 6){
		$("#upassLoginVali").html("<div style='color:red'>密码长度必须大于等于6位数</div>");
		return false;
	}else if(upass.length > 15){
		$("#upassLoginVali").html("<div style='color:red'>密码长度必须小于等于15位数</div>");
		return false;
	}else{
		$("#upassLoginVali").html("");
		return true;
	}
}

function loginSubmit(){
	if(!uaccountLoginVali()){
		$("#uaccount_login").focus();
		return;
	}
	if(!upassLoginVali()){
		$("#upass_login").focus();
		return;
	}
	
	$.ajax({
		"type":"POST",
		"url":"/ezmooc/userLogin?"+$("#submit_login").serialize(),		 	
		"success":function(msg){
			
			var roleId = JSON.parse(msg).roleId;
			if(roleId == '002'){
				var reg = /\/ezmooc\/login$/;
				if( reg.test(window.location.href) ){
					window.location.href = "/ezmooc/list";
				}else{
					window.location.href = window.location.href;
				} 
			} else if(roleId == '001'){
				window.location.href = "/ezmooc/teacher";
			} else if(roleId == '000'){
				window.location.href = "/ezmooc/admin";
			} else{
				$("#loginFalse").html("<div style='color: red;font-size:15px'>账号或密码错误</div>");
			}
			
		},
		"error":function(msg){}
	});
}


function logout(){
	$.ajax({
		"type":"POST",
		"url":"/ezmooc/userLogout",
		"success":function(msg){
			window.location.href = window.location.href;
		}
	});
;}













