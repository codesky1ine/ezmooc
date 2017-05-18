$(function(){
	$('#headKeyWord').blur(function(){
		if($('#headKeyWord').val() <= 0){
			$('#headSearchStr').html('搜索');
		}
	});
	
	$('#headKeyWord').focus(function(){
		$('#headSearchStr').html('');	
	});
	
	$('#headKeyWord').keydown(function(event){
		if (event.keyCode == 13) {
			headSearch();
		}
	});
	
});

function headSearch() {
	var keyword = $('#headKeyWord').val();
	if (keyword.length > 0) {
		window.location.href="/ezmooc/search?keyword="+keyword;
	}
}
