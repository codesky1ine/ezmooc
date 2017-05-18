$(function(){
	
	if ($('#inputKeyWord').val().length != 0) {
		$('#searchStr').html('');
		searchCourse();
	}	
	
	$('#inputKeyWord').blur(function(){
		if ($('#inputKeyWord').val().length == 0) {
			$('#searchStr').html('搜索');
		}	
	});
	
	$('#inputKeyWord').focus(function(){
		$('#searchStr').html('');
	});
	
	$('#inputKeyWord').keydown(function(event){
		if (event.keyCode == 13) {
			searchCourse();
		}
	});
});


function searchCourse() {
	var keyword = $('#inputKeyWord').val();
	if (keyword.length != 0) {
		$.ajax({
			type: "POST",
			url: "search/course",		
			data: {"keyword":keyword},
			success: function(msg){
				refresh(msg);
			},
			error: function(msg){}
		});
	}
	
}

function refresh(msg) {
	var data = JSON.parse(msg);
	var courses = data.courses;
	var coursesHtml = genCoursesList(courses);
	$('#video-item').html(coursesHtml);
}

function genCoursesList(courses) {
	var videoListHtml = "";
	for (var i = 0; i < courses.length; i++) {
		videoListHtml += "<a class='item' target='_blank' " +
							"href='/ezmooc/play/"+courses[i].courseId+"'>" +
							"<div class='left' style='height: 130px; width: 200px'>" +
								"<img src='"+courses[i].courseImage+"' style='height: 130px; width: 200px'>" + 
							"</div>" +
							"<div class='right'>" +
								"<div class='title'>" + courses[i].courseName + "</div>" +
								"<div class='date'>" + courses[i].courseInfo + "</div>" +
							"</div>" +
						"</a>";
					
	}
	
	return videoListHtml;
}