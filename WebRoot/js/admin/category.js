var page = 1;
//当类别名从A改为B再改回A时，会查询到A已经存在。此处引入该变量避免自身查询。
var currentUpdateCcname;

function requestList(data){
	$.ajax({
		"type":"POST",
		"url":"/ezmooc/admin/courseCatg/view",
		"data":data,
		"success":function(msg){
			refresh(msg);
		}
	});
}

$(function(){
	requestList();
	
	$('#add_ccname').blur(function(){
		ccnameValidate("add");
	});
	$('#update_ccname').blur(function(){
		ccnameValidate("update");
	});
	
	$("#addForm").submit(function(){
		addSubmit();
		return false;
	});
	
	$("#searchForm").submit(function(){
		var searchKey = $("#searchKey").val();
		var data = {};
		data["courseCatgName"] = searchKey;
		
		requestList(data);
		
		return false;
	});
	
	$("#updateForm").submit(function(){
		updateSubmit();
		return false;
	});
	
	$("#addModal").on("hidden.bs.modal", function(){
		$("#add_ccname").val("");
		$("#add_ccname_validate").html("");
	});
	$("#updateModal").on("hidden.bs.modal", function(){
		$("#update_ccname").val("");
		$("#update_ccname_validate").html("");
	});
});

function ccnameValidate(operate){
	var ccname = $("#"+operate+"_ccname").val();
	
	//改回了一开始读取的课程类别 
	if(operate=="update" && currentUpdateCcname == ccname){
		$("#"+operate+"_ccname_validate").html("");
		return true;
	}
	
	//课程类别为空
	if(!ccname){
		$("#"+operate+"_ccname_validate").html(
			"<div style='color:red;'>课程类别不能为空</div>");
		return false;
	}
	
	var passValidate = false;
	$.ajax({
   		type:"POST",
   		url:"/ezmooc/admin/courseCatg/exist",	
   		data: {"courseCatgName":ccname},
   		async:false,
   		success:function(msg){
   			var isExist = JSON.parse(msg).isExist;
   			if(isExist){
   				$("#"+operate+"_ccname_validate").html(
   					"<div style='color:red;'>此课程类别已存在</div>");
   				passValidate =  false;
   			}else{
	  			$("#"+operate+"_ccname_validate").html(
   					"<div style='color:green;'>此课程类别可用</div>");
   				passValidate =  true;
   			}
   		},
   		error:function(msg){}
   	});
			
	return passValidate;
}

function addSubmit() {
	
	if(!ccnameValidate("add")){
		$('#add_ccname').focus();
		return;
	}
	
	$.ajax({
		"type":"POST",
		"url":"/ezmooc/admin/courseCatg/add?"+$("#addForm").serialize()+"&page="+page,		 	
		"success":function(msg){
			refresh(msg);
		},
		"error":function(msg){}
	});
	$('#addModal').modal('hide');
}


function updateRead(courseCatgId) {
	
	$.ajax({
		"type":"POST",
		"url":"/ezmooc/admin/courseCatg/find",	
		data: {"courseCatgId":courseCatgId},
		"success":function(msg){
			var data = JSON.parse(msg);
			var category = data.courseCatg;
			currentUpdateCcname = category.courseCatgName;
			$("#update_ccname").val(currentUpdateCcname);
			$("#update_ccuid").val(category.courseCatgId);
		},
		"error":function(msg){}
	});
}

function updateSubmit() {
	
	if(!ccnameValidate("update")){
		$('#update_ccname').focus();
		return;
	}
	
	$.ajax({
		"type":"POST",
		"url":"/ezmooc/admin/courseCatg/update?"+$("#updateForm").serialize()+"&page="+page,	 	
		"success":function(msg){
			refresh(msg);
		},
		"error":function(msg){}
	});
	$('#updateModal').modal('hide');
}

function deleteRead(ccuid) {
	$("#delete_ccuid").val(ccuid);
}

function deleteSubmit() {
	$.ajax({
		"type":"POST",
		"url":"/ezmooc/admin/courseCatg/delete?courseCatgId="+$("#delete_ccuid").val()+"&page="+page,		 	
		"success":function(msg){
			refresh(msg);
		},
		"error":function(msg){}
	});
}

function refresh(msg) {
	var data = JSON.parse(msg);
	
	var categories = data.ccs;
	var tableHtml = genTable(categories);
	$("#categoryTable").html(tableHtml);
	$("#sum").html("共"+categories.length+"条&nbsp;&nbsp;&nbsp;");

	var pages = data.pageCount;
	page = data.page;
	var pageUlHtml = genPageUl(pages, page);
	$("#pageUl").html(pageUlHtml);
	
	//$("#searchKey").val("");
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
			"<li class='disabled'><a href='javascript:void(0);'>&laquo;</a></li>";
	} else{
		pageUlHtml += 
			"<li><a href='javascript:void(0);' onclick='page--;turnPage()'>&laquo;</a></li>";
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
					"<li class='active'><a href='javascript:void(0);' onclick='page="+(midPage + i)+";turnPage()'>"+(midPage + i)+"</a></li>";
			} else{
				pageUlHtml += 
					"<li><a href='javascript:void(0);' onclick='page="+(midPage + i)+";turnPage()'>"+(midPage + i)+"</a></li>";
			}
		}
	} else{
		for (var i = 1; i <= pages; i++) {
			if(i == page){
				pageUlHtml += 
					"<li class='active'><a href='javascript:;' onclick='page="+i+";turnPage()'>"+i+"</a></li>";
			} else{
				pageUlHtml += 
					"<li><a href='javascript:void(0);' onclick='page="+i+";turnPage()'>"+i+"</a></li>";
			}
		}
	}
	
	if(page == pages || pages == 0){
		pageUlHtml += 
			"<li class='disabled'><a href='javascript:void(0);' >&raquo;</a></li>";
	} else{
		pageUlHtml += 
			"<li><a href='javascript:void(0);' onclick='page++;turnPage()'>&raquo;</a></li>";
	}
	
	return pageUlHtml;
}

function genTable(categories){
	var tableHtml = "";
	tableHtml += "<table class='table table-striped thread-table'>";
	tableHtml += 	"<thead>";
	tableHtml += 		"<tr>";
	tableHtml += 			"<th>课程类别名</th>";
	tableHtml += 			"<th class='thread-actions'>操作</th>";
	tableHtml += 		"</tr>";
	tableHtml += 	"</thead>";
	
	tableHtml += 	"<tbody>";
	for(var i = 0; i < categories.length; i++){
		var category = categories[i];
		tableHtml += 	"<tr>";
		tableHtml += 		"<td>"+category.courseCatgName+"</td>";
		tableHtml += 		"<td>";
		tableHtml += 			"<a href='javascript:;' class='edit-thread' onclick='updateRead(\""+category.courseCatgId+"\")'" +
								"data-toggle='modal' data-target='#updateModal'>修改 </a>";
		tableHtml += 			"<a href='javascript:;' class='delete-thread' onclick='deleteRead(\""+category.courseCatgId+"\")'" +
								"data-toggle='modal' data-target='#deleteModal'>删除</a>";
		tableHtml += 		"</td>";
		tableHtml += 	"</tr>";
	}
	tableHtml += 	"</tbody>";
	tableHtml += "</table>";
	
	return tableHtml;
}

