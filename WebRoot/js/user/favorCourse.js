var isFavor = "false";
var isFollow = "false";

$(function(){
	if( $('#favor-course').attr("class") == "icon-heart" ){
		isFavor = "true";
	}
	if( $('#follow-teacher').attr("class") == "icon-heart" ){
		isFollow = "true";
	}
})

//收藏课程
function favor(courseId){
	if(isFavor == "true"){
		
		//已收藏，则取消收藏
		$.ajax({
			type: "POST",
			url: "/ezmooc/unfavor?courseId="+courseId,
			success: function(msg) {
				//取消收藏成功 isFavor=false;
				isFavor = JSON.parse(msg).isFavor;
				if(isFavor == "false"){
					iconToggle("favor-course");
				}
			},
			error: function(msg) {
			}
		});
		
	} else if(isFavor == "false"){
		
		//未收藏，则收藏
		$.ajax({
			type: "POST",
			url: "/ezmooc/favor?courseId="+courseId,
			success: function(msg) {
				//收藏成功 isFavor=true;
				isFavor = JSON.parse(msg).isFavor;
				if(isFavor == "true"){
					iconToggle("favor-course");
				}
			},
			error: function(msg) {
			}
		});
		
	}
}

//关注教师 
function follow(teacherId){
	if(isFollow == "true"){
		
		//已关注，则取消关注
		$.ajax({
			type: "POST",
			url: "/ezmooc/unfollow?teacherId="+teacherId,
			success: function(msg) {
				//取消关注成功 isFollow=false;
				isFollow = JSON.parse(msg).isFollow;
				if(isFollow == "false"){
					iconToggle("follow-teacher");
				}
			},
			error: function(msg) {
			}
		});
		
	} else if(isFavor == "false"){
		
		//未关注，则关注
		$.ajax({
			type: "POST",
			url: "/ezmooc/follow?teacherId="+teacherId,
			success: function(msg) {
				//关注成功 isFollow=true;
				isFollow = JSON.parse(msg).isFollow;
				if(isFollow == "true"){
					iconToggle("follow-teacher");
				}
			},
			error: function(msg) {
			}
		});
		
	}
}

function iconToggle(str) {
	$('#'+str).toggleClass('icon-heart-empty');
	$('#'+str).toggleClass('icon-heart');
}





















