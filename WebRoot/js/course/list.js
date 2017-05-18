function genCourseCatgHtml(courseCatgList, courseCatgId, sort){
	//生成超链接html
	var ahtml = "";
	ahtml += "<a href='list?";
	if(sort){
		ahtml += "sort="+sort;
	}
	
	//生成html
	var html = "";
	html += "<ul>";
	
	if(!courseCatgId){
		html += "<li class='course-nav-item on'>";
	}else{
		html += "<li class='course-nav-item'>";
	}
	html += ahtml+"'>全部分类</a></li>";
	
	for(var i = 0; i < courseCatgList.length; i++){
		if(courseCatgId && courseCatgList[i].courseCatgId == courseCatgId){
			html += "<li class='course-nav-item on'>";
		}else{
			html += "<li class='course-nav-item'>";
		}
		html += ahtml+"courseCatgId="+courseCatgList[i].courseCatgId+"'>"+courseCatgList[i].courseCatgName+"</a></li>";
	}
	
	html += "</ul>";
	
	return html;
}

function getPageHtml(page, pageCount, courseCatgId, sort){
	var size = 5;//如：| 2 | 3 | 4 | 5 | 6 | 有5个格子  size=5	且size只能为单数
	
	if(page == null){
		page =1;
	}
	var midPage = page;//如：| 2 | 3 | 4 | 5 | 6 | 4就是midPage
	
	//生成超链接html
	var ahtml = "";
	ahtml += "<a href='list?";
	if(courseCatgId){
		ahtml += "courseCatgId="+courseCatgId+"&";
	}
	if(sort){
		ahtml += "sort="+sort+"&";
	}
	
	
	//生成html
	var html = "";
	//当前页为第一页，生成的"上一页"没有点击功能
	if(page == 1){
		//显示不可点击的<a>
		html += "<span class='disabled_page'>首页</span>";
		html += "<span class='disabled_page'>上一页</span>";
	} else{
		html += ahtml+"page=1'>首页</a>";
		html += ahtml+"page="+(page-1)+"'>上一页</a>";
	}
	
	if(pageCount > size){	
		//总页数大于5
		if(page < Math.ceil(size/2)){	
			//例：| 1 | 2 | 3 | 4 | 5 | 当前页为1、2、3时，midPage都是3
			midPage = Math.ceil(size/2);
		} else if(page > pageCount - Math.floor(size/2)){	
			//设总共15页：| 11 | 12 | 13 | 14 | 15 | 当前页为13、14、15时，midPage都是13
			midPage = pageCount - Math.floor(size/2);
		}
		for (var i = -1 * Math.floor(size/2); i <= Math.floor(size/2); i++) {
			var editPage = midPage + i;
			if(editPage == page){
				//生成页面跳转按钮时使当前页按钮高亮
				html += "<a class='active' href='javascript:void(0)'>"+page+"</a>";
			} else{
				html += ahtml+"page="+editPage+"'>"+editPage+"</a>";
			}
		}
	} else{
		for (var i = 1; i <= pageCount; i++) {
			if(i == page){
				//生成页面跳转按钮时使当前页按钮高亮
				html += "<a class='active' href='javascript:void(0)'>"+page+"</a>";
			} else{
				html += ahtml+"page="+i+"'>"+i+"</a>";
			}
		}
	}
	
	//当前页为最后一页，生成的"下一页"没有点击功能
	if(page == pageCount || pageCount == 0){
		//显示不可点击的<a>
		html += "<span class='disabled_page'>下一页</span>";
		html += "<span class='disabled_page'>尾页</span>";
	} else{
		html += ahtml+"page="+( page+1 )+"'>下一页</a>";
		html += ahtml+"page="+pageCount+"'>尾页</a>";
	}
	
	return html;
}