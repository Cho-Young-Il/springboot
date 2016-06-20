$("#goTop").on("click", function() {
	$.smoothScroll({
		easing: "easeOutExpo",
		speed: 500
	});
});

$(".board-list a.search-type").click(function(event) {
	event.preventDefault();
	var searchType = $(event.target).html();
	$(".board-list #searchType").html(searchType);
	$(".board-list input[name=type]").val(searchType.toLowerCase());
});