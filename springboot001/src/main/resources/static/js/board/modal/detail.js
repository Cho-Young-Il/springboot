function clickBoardDetailLink(event) {
	event.preventDefault();
	var bno = $(event.target).attr("boardNo");
	
	$.getJSON("/board/detail?bno=" + bno, function(data) {
		
	}).fail(function(e) {
		console.log(e);
	});
}