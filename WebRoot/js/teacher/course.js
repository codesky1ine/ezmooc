var page = 1;
			
$(function(){
	
	$.ajax({
		"type":"POST",
		"url":"/ezmooc/teacher/course/courseCatgs",	
		"success":function(msg){
			genSelect(msg);   						
		}
	});
	
	requestList();
	
	$('#add_cname').blur(function(){
		cnameValidate("add");
	});
	
	$("#addForm").submit(function(){
		addSubmit();
		return false;
	});
	
	$('#edit_cname').blur(function(){
		cnameValidate("edit");
	});
	
	$("#editForm").submit(function(){
		editSubmit();
		return false;
	});
	
	$("#searchForm").submit(function(){
		var searchKey = $("#searchKey").val();
		var data = {};
		data["courseName"] = searchKey;
		
		requestList(data);
		
		return false;
	});
	
	$("#editModal").on("hidden.bs.modal", function(){
		operateClear("edit");
	});
	
	$("#addModal").on("hidden.bs.modal", function(){
		operateClear("add");
	});
	
});

function requestList(data){
	$.ajax({
		"type":"POST",
		"url":"/ezmooc/teacher/course/view",
		"data":data,
		"success":function(msg){
			refresh(msg);
		}
	});
}

function operateClear(operate){
	if(operate == 'edit'){
		$("#"+operate+"_cuid").val("");
	}
	$("#"+operate+"_cname").val("");
	$("#"+operate+"_cname_validate").html("");
	$("#"+operate+"_cinfo").val("");
}

function cnameValidate(operate){
	var passValidate = false;
	var cname = $("#"+operate+"_cname").val();
	
	//改回了一开始读取的课程类别 
	if(operate=="edit" && currentUpdateCname == cname){
		$("#"+operate+"_cname_validate").html("");
		return true;
	}
	
	if(!cname){
		$("#"+operate+"_cname_validate").html(
			"<div style='color:red;'>课程名不能为空</div>");
		return false;
	}
	
	$.ajax({
   		type:"POST",
   		url:"/ezmooc/teacher/course/exist",	
   		data:{"courseName":cname},
   		async:false,
   		success:function(msg){
   			var isExist = JSON.parse(msg).isExist;
   			if(isExist){
   				$("#"+operate+"_cname_validate").html(
   					"<div style='color:red;'>此课程名已存在</div>");
   				passValidate =  false;
   			}else{
	  			$("#"+operate+"_cname_validate").html(
   					"<div style='color:green;'>此课程名可用</div>");
   				passValidate =  true;
   			}
   		}
   	});
			
	return passValidate;
}

function addSubmit() {
	
	if(!cnameValidate("add")){
		$('#add_cname').focus();
		return;
	}
	
	$.ajax({
		"type":"POST",
		"url":"/ezmooc/teacher/course/add?page="+page,		 	
		"success":function(msg){
			refresh(msg);
		},
		data: new FormData($('#addForm')[0]),
		processData: false,
		contentType: false
	});
	
	$('#addModal').modal('hide');
}

function editSubmit() {
	
	if(!cnameValidate("edit")){
		$('#edit_cname').focus();
		return;
	}
	
	$.ajax({
		"type":"POST",
		"url":"/ezmooc/teacher/course/update?page="+page,		 	
		"success":function(msg){
			refresh(msg);
		},
		data: new FormData($('#editForm')[0]),
	    processData: false,
	    contentType: false
	});
	
	$('#editModal').modal('hide');
}

//修改时读取修改项数据
var currentUpdateCname;
function updateRead(courseId) {
	$.ajax({
		"type":"POST",
		"url":"/ezmooc/teacher/course/find",		
		data:{"courseId":courseId},
		"success":function(msg){
			var course = JSON.parse(msg).course;
			$("#edit_cuid").val(course.courseId);
			$("#edit_ccuid").val(course.courseCatgId);
			currentUpdateCname = course.courseName;
			$("#edit_cname").val(currentUpdateCname);
			$("#edit_cinfo").val(course.courseInfo);
		},
		"error":function(msg){}
	});
}

//添加删除项的Id至表单
function deleteRead(courseId) {
	$("#delete_cuid").val(courseId);
}

function deleteSubmit() {
	$.ajax({
		"type":"POST",
		"url":"/ezmooc/teacher/course/delete?courseId="+$("#delete_cuid").val()+"&page="+page,		 	
		"success":function(msg){
			refresh(msg);
		}
	});
}

function refresh(msg) {
	var data = JSON.parse(msg);
	
	var courses = data.courses;
	var tableHtml = genTable(courses);
	$("#courseTable").html(tableHtml);
	$("#sum").html("共"+courses.length+"条&nbsp;&nbsp;&nbsp;");
	
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
		if(page < 3){
			midPage = 3;
		} else if(page > pages - 2){
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

function genTable(courses){
	var tableHtml = "";
	tableHtml += "<table class='table table-striped thread-table'>";
	tableHtml += 	"<thead>";
	tableHtml += 		"<tr>";
	tableHtml += 			"<th class='thread-title'>课程名</th>";
	tableHtml += 			"<th class='thread-name'>课程简介</th>";
	tableHtml += 			"<th class='thread-title'>所属课程类别</th>";
	tableHtml += 			"<th class='thread-actions'>操作</th>";
	tableHtml += 		"</tr>";
	tableHtml += 	"</thead>";
	
	tableHtml += 	"<tbody>";
	for(var i = 0; i < courses.length; i++){
		var course = courses[i];
		tableHtml += 	"<tr>";
		tableHtml += 		"<td class='thread-name'>"+course.courseName+"</td>";
		tableHtml += 		"<td class='thread-title'>"+course.courseInfo+"</td>";
		tableHtml += 		"<td class='thread-title'>"+course.courseCatg.courseCatgName+"</td>";
		tableHtml += 		"<td>";
		tableHtml += 			"<a href='javascript:;' class='edit-thread' onclick='updateRead(\""+course.courseId+"\")'" +
								"data-toggle='modal' data-target='#editModal'>编辑 </a>";
		tableHtml += 			"<a href='javascript:;' class='delete-thread' onclick='deleteRead(\""+course.courseId+"\")'" +
								"data-toggle='modal' data-target='#deleteModal'>删除</a>";
		tableHtml += 		"</td>";
		tableHtml += 	"</tr>";
	}
	tableHtml += 	"</tbody>";
	tableHtml += "</table>";
	
	return tableHtml;
}

function genSelect(msg){
	var categories = JSON.parse(msg).categories;
	var selectHtml = "";
	selectHtml += "<select name='courseCatgId' class='form-control' id='edit_ccuid'>";		
	for(var i = 0; i < categories.length; i++){
		var category = categories[i];
		selectHtml += "<option value="+category.courseCatgId+">"+category.courseCatgName+"</option>";		
	}
	selectHtml += "</select>";	
	$("#addCategorySelect").html(selectHtml);
	$("#editCategorySelect").html(selectHtml);
}



















