//@笔记 	不要只通过一个按钮，来实现文件上传的提交和其他内容的提交。最好分两个按钮。
//		这个js就是只通过一个按钮实现的，代码写得我想死，而且很乱。
//		当然这也可能是能力问题，但是在能力相同的前提下，分两个按钮写出来的代码更优秀（我猜的）。

var page = 1;
var modelUpdateId;//模态框上显示的，待修改的视频的Id，用于生成对应的file form

$(function(){
	
	$.ajax({
		"type":"POST",
		"url":"/ezmooc/teacher/video/courses",	
		"success":function(msg){
			genSelect(msg, "add");   						
			genSelect(msg, "edit");   						
		}
	});
	
	requestList();
	
	$("#addForm").submit(function(){
		addSubmit();
		return false;
	});
	
	$('#add_vname').blur(function(){
		vnameValidate("add");
	});
	
	$("#editForm").submit(function(){
		editSubmit();
		return false;
	});
	
	$('#edit_vname').blur(function(){
		vnameValidate("edit");
	});
	
	//TODO 理解该事件的具体实现
	//在修改框隐藏的时候，判断用户是否选择了上传文件
	$("#editModal").on("hide.bs.modal", function(){
		operateClear("edit");
		
		//file input有内容，则隐藏；否则删除file form
		var fileLength = $("#uploadForm"+modelUpdateId+" > input[type='file']").prop("files").length;
		if(fileLength > 0){
			$("#uploadForm"+modelUpdateId).hide();
		}else{
			$("#uploadForm"+modelUpdateId).remove();
		}
		isSubmitHide = false;
	});
	
	$("#addModal").on("hide.bs.modal", function(){
		operateClear("add");
	});
	
	$("#searchForm").submit(function(){
		var searchKey = $("#searchKey").val();
		var data = {};
		data["videoName"] = searchKey;
		
		requestList(data);
		
		return false;
	});
});

function addSubmit() {
	
	if(!vnameValidate("add")){
		$('#add_vname').focus();
		return;
	}
	
	$.ajax({
		"type":"POST",
		"url":"/ezmooc/teacher/video/add?page="+page,		 	
		"success":function(msg){
			refresh(msg);
		},
		data: new FormData($('#addForm')[0]),
		processData: false,
		contentType: false
	});
	
	$('#addModal').modal('hide');
}

var isSubmitHide = false;
function editSubmit() {
	
	if(!vnameValidate("edit")){
		$('#edit_vname').focus();
		return;
	}
	
	//第一个ajax修改信息，第二个ajax上传视频
	$.ajax({
		"type":"POST",
		"url":"/ezmooc/teacher/video/update?"+$("#editForm").serialize()+"&page="+page,		 	
		"success":function(msg){
			var editVideoId = JSON.parse(msg).editVideoId;
			
			refresh(msg);
			
			//如果file form存在，则发送ajax请求上传。(file form不存在的原因：file未选择文件，在hide回调函数中将file form直接删除)
			var fileForm = $("#uploadForm"+editVideoId).length;
			if(fileForm > 0){
				isSubmitHide = true;
				
				$("#uploadForm"+editVideoId).ajaxSubmit({
					beforeSubmit:function(){
						//如果局部变量editVideoId不存在则放弃提交
						return editVideoId;
					},
					
					uploadProgress: function(event, position, total, percentComplete) {
						
						$("#progress"+editVideoId).width(percentComplete+"%");
						$("#progressVal"+editVideoId).html("&nbsp;&nbsp;&nbsp;"+(percentComplete-1)+"%");
					},
					success : function(msg) {
						//上传成功后删除Id对应的uploadForm表单
						var uploadVideoId = JSON.parse(msg).uploadVideoId;
						$("#uploadForm"+uploadVideoId).remove();
						
						requestList();
					},
					extraData : { "uploadVideoId" : editVideoId },
				}); 
			}
			
		}
	});
	
	//隐藏模态框（调用on hide.bs.model）
	$('#editModal').modal('hide');
}

//修改时读取修改项数据
var currentUpdateVname;
function updateRead(videoId) {
	$.ajax({
		"type":"POST",
		"url":"/ezmooc/teacher/video/find",		 	
		data:{"videoId":videoId},
		"success":function(msg){
			var video = JSON.parse(msg).video;
			$("#edit_cuid").val(video.courseId);
			
			currentUpdateVname = video.videoName;
			$("#edit_vname").val(currentUpdateVname);
			
			modelUpdateId = video.videoId;
			$("#edit_vuid").val(modelUpdateId);
			
			//表单是否已经存在
			if( $("#uploadForm"+modelUpdateId) > 0 ){
				$("#uploadForm"+modelUpdateId).show();
			}else{
				var uploadFormHtml = "";
				uploadFormHtml += "<form id='uploadForm"+modelUpdateId+"' action='/ezmooc/teacher/video/uploadVideo' method='post' enctype='multipart/form-data'>";
				uploadFormHtml += 	"<input id='videoFile' type='file' name='videoFile'/>";
				uploadFormHtml += "</form>";
				
				$("#uploadFormDiv").append(uploadFormHtml);
			}
		}
	});
}

//添加删除项的Id至表单
function deleteRead(vuid) {
	$("#delete_vuid").val(vuid);
}

function deleteSubmit() {
	$.ajax({
		"type":"POST",
		"url":"/ezmooc/teacher/video/delete?videoId="+$("#delete_vuid").val()+"&page="+page,		 	
		"success":function(msg){
			refresh(msg);
		}
	});
}

function refresh(msg) {
	var data = JSON.parse(msg);
	
	var videos = data.videos;
	var tableHtml = genTable(videos);
	$("#videoTable").html(tableHtml);
	$("#sum").html("共"+videos.length+"条&nbsp;&nbsp;&nbsp;");
	
	var pages = data.pages;
	page = data.page;
	var pageUlHtml = genPageUl(pages, page);
	$("#pageUl").html(pageUlHtml);
	
	$("#searchKey").val("");
}

function turnPage(){
	var searchKey = $("#searchKey").val();
	var searchType = $("#search_type").val();
	var data = {"page":page};
	
	if(searchKey != ""){
		data[searchType] = searchKey;
	}
	
	requestList(data);
}

function genPageUl(pages, page){
	var pageUlHtml = "";

	var midPage = page;
	
	if(page == 1){
		pageUlHtml += 
			"<li class='disabled'><a href='javascript:;'>&laquo;</a></li>";
	} else{
		pageUlHtml += 
			"<li><a href='javascript:;' onclick='page--;turnPage()'>&laquo;</a></li>";
	}
	
	if(pages > 5){
		if(page < 3){//当前页已到头
			midPage = 3;
		} else if(page > pages - 2){//当前页已到尾
			midPage = pages - 2;
		}
		for (var i = -2; i <= 2; i++) {
			if(midPage + i == page){
				pageUlHtml += 
					"<li class='active'><a href='javascript:;' onclick='page="+(midPage + i)+";turnPage()'>"+(midPage + i)+"</a></li>";
			} else{
				pageUlHtml += 
					"<li><a href='javascript:;' onclick='page="+(midPage + i)+";turnPage()'>"+(midPage + i)+"</a></li>";
			}
		}
	} else{
		for (var i = 1; i <= pages; i++) {
			if(i == page){
				pageUlHtml += 
					"<li class='active'><a href='javascript:;' onclick='page="+i+";turnPage()'>"+i+"</a></li>";
			} else{
				pageUlHtml += 
					"<li><a href='javascript:;' onclick='page="+i+";turnPage()'>"+i+"</a></li>";
			}
		}
	}
	
	if(page == pages || pages == 0){
		pageUlHtml += 
			"<li class='disabled'><a href='javascript:;' >&raquo;</a></li>";
	} else{
		pageUlHtml += 
			"<li><a href='javascript:;' onclick='page++;turnPage()'>&raquo;</a></li>";
	}
	
	return pageUlHtml;
}

function genTable(videos){
	var tableHtml = "";
	tableHtml += "<table class='table table-striped thread-table'>";
	tableHtml += 	"<thead>";
	tableHtml += 		"<tr>";
	tableHtml += 			"<th class='thread-name'>视频名</th>";
	tableHtml += 			"<th class='thread-name'>所属课程</th>";
	tableHtml += 			"<th class='thread-actions'>操作</th>";
	tableHtml += 		"</tr>";
	tableHtml += 	"</thead>";
	
	tableHtml += 	"<tbody>";
	for(var i = 0; i < videos.length; i++){
		var video = videos[i];
		tableHtml += 	"<tr>";
		tableHtml += 		"<td class='thread-name'>"+video.videoName+"</td>";
		tableHtml += 		"<td class='thread-name'>"+video.course.courseName+"</td>";
		tableHtml += 		"<td>";
		
		var isUpload = false;
		$("#uploadFormDiv > form").each(function(i, eachForm){
			var eachId = eachForm.getAttribute("id").substring(10);
			if(video.videoId == eachId){
				isUpload = true;
			}
		});
		
		if(isUpload){
			tableHtml += "<div class='progress progress-striped active' style='height:8px;width:74px;margin:5px 0px 0px 0px;float: left;'>";
			tableHtml += 	"<div class='progress-bar' role='progressbar' aria-valuenow='60' aria-valuemin='0' aria-valuemax='100' " +
								" id=progress"+video.videoId+">";
			tableHtml += 	"</div>";
			tableHtml += "</div>";
			tableHtml += "<p style='color: #3080C8;margin:0px 0px 0px 0px' id=progressVal"+video.videoId+"></p>"
				
		}else{
			tableHtml += "<a href='javascript:;' class='edit-thread' onclick='updateRead(\""+video.videoId+"\")'" +
							"data-toggle='modal' data-target='#editModal'>编辑 </a>&nbsp;";
			tableHtml += "<a href='javascript:;' class='delete-thread' onclick='deleteRead(\""+video.videoId+"\")'" +
							"data-toggle='modal' data-target='#deleteModal'>删除</a>";
		}
		
		
		tableHtml += 		"</td>";
		tableHtml += 	"</tr>";
	}
	tableHtml += 	"</tbody>";
	tableHtml += "</table>";
	
	return tableHtml;
}

function genSelect(msg, operate){
	var courses = JSON.parse(msg).courses;
	var selectHtml = "";
	selectHtml += "<select name='courseId' class='form-control' id='"+operate+"_cuid'>";		
	for(var i = 0; i < courses.length; i++){
		var course = courses[i];
		selectHtml += "<option value="+course.courseId+">"+course.courseName+"</option>";		
	}
	selectHtml += "</select>";	
	$("#"+operate+"CourseSelect").html(selectHtml);
}

function requestList(data){
	$.ajax({
		"type":"POST",
		"url":"/ezmooc/teacher/video/view",	
		"data":data,
		"success":function(msg){
			refresh(msg);
		},
		"error":function(msg){}
	});
}

function operateClear(operate){
	$("#"+operate+"_cuid").val("");
	$("#"+operate+"_vname").val("");
	$("#"+operate+"_vname_validate").html("");
	if(operate == 'edit'){
		$("#"+operate+"_vuid").val("");
	}
}

function vnameValidate(operate){
	var passValidate = false;
	var vname = $("#"+operate+"_vname").val();
	
	if(operate=="edit" && currentUpdateVname == vname){
		$("#"+operate+"_vname_validate").html("");
		return true;
	}
	
	if(!vname){
		$("#"+operate+"_vname_validate").html(
			"<div style='color:red;'>视频名不能为空</div>");
		return false;
	}
	
	$.ajax({
   		type:"POST",
   		url:"/ezmooc/teacher/video/exist",	
   		data:{"videoName":vname},
   		async:false,
   		success:function(msg){
   			var isExist = JSON.parse(msg).isExist;
   			if(isExist){
   				$("#"+operate+"_vname_validate").html(
   					"<div style='color:red;'>此课程名已存在</div>");
   				passValidate =  false;
   			}else{
	  			$("#"+operate+"_vname_validate").html(
   					"<div style='color:green;'>此课程名可用</div>");
   				passValidate =  true;
   			}
   		},
   		error:function(msg){}
   	});
			
	return passValidate;
}
