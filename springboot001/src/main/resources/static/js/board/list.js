$("#goTop").on("click", function() {
	$.smoothScroll({
		easing: "easeOutExpo",
		speed: 500
	});
});

function getList() {
	$.getJSON("/board/list?" + $.param(board.pageable), function(data) {
		var pageMaker = data.pageMaker;
		var boardHTML = "";
		for(var b of data.boardList) {
			var bdepth = b.bdepth;
			
			boardHTML += '<li class="list-group-item" data-toggle="modal" data-target="#issue">';
			boardHTML += '	<div class="media">';
			for(var i = 0; i < bdepth; i++) {
				boardHTML += '		<i class="pull-left">&nbsp;&nbsp;</i>';				
			}
			boardHTML += '		<i class="fa fa-file-o pull-left"></i>';
			boardHTML += '		<span class="number pull-right"># ' + b.bno + '</span>';
			boardHTML += '		<div class="media-body">';
			if(bdepth != 0) {
				boardHTML += '			<div class="label label-primary">ㄴREPLY</div><br>';				
			}
			boardHTML += '			<div class="btitle"><a class="board-detail-link" boardNo=' + b.bno + '>' + b.btitle + '</a></div>';
			boardHTML += '			<p class="info">' + b.bwriter;
			boardHTML += '				<strong> /</strong>';
			boardHTML += '				<i class="fa fa-fw fa-clock-o"></i>' + b.bregDate;
			boardHTML += '				<strong> /</strong>';
			boardHTML += '				<i class="fa fa-comments"></i> ' + b.comments.length + ' comments';
			boardHTML += '			</p>';
			boardHTML += '		</div>';
			boardHTML += '	</div>';
			boardHTML += '</li>';			
		}
		$("#boardList").html(boardHTML);
		$("a.board-detail-link").click(clickBoardDetailLink);
		
		var paginationHTML = "";
		if(pageMaker.pageNo != 1) {
			paginationHTML += '<li><a class="page-link" pageNo=1>&lt&lt</a></li>';
		} 
		if(pageMaker.startPage != 1){
			paginationHTML += '<li><a class="page-link" pageNo=' + (pageMaker.startPage - 1) + '>&lt</li>'
		}
		for(var i = pageMaker.startPage; i <= pageMaker.endPage; i++) {
			paginationHTML += '<li';
			if(i == pageMaker.pageNo) {
				paginationHTML += ' class="active"'
			}
			paginationHTML += '><a class="page-link" pageNo=' + i + '>' + i + '</a></li>';
		}
		if(pageMaker.endPage != pageMaker.lastPage) {
			paginationHTML += '<li><a class="page-link" pageNo=' + (pageMaker.endPage + 1) + '>&gt</a></li>';
		}
		if(pageMaker.pageNo != pageMaker.lastPage) {
			paginationHTML += '<li><a class="page-link" pageNo=' + pageMaker.lastPage + '>&gt&gt</a></li>'
		}
		$(".board-list .pagination").html(paginationHTML);
		$("a.page-link").click(changePage);
		
		$(".board-list #searchType").html("FILTER BY");
		board.pageable.searchType = undefined;
		board.pageable.searchKeyword = undefined;
		board.pageable.pageNo = pageMaker.pageNo;
		board.pageable.size = pageMaker.size;
		
	}).fail(function(e) {
		console.log(e);
	});
};
getList();

$(".board-list a.search-type").click(function(event) {
	event.preventDefault();
	var searchType = $(event.target).html();
	$(".board-list #searchType").html(searchType);
	board.pageable.searchType = searchType;
});

$(".board-list #searchBtn").click(function() {
	board.pageable.searchKeyword = $(".board-list input[name=keyword]").val();
	getList();
	$(".board-list input[name=keyword]").val("");
});

$(".board-list a.row-per-page").click(function(event) {
	event.preventDefault();
	
	var rows = parseInt($(this).html().split(" ")[0]);
	board.pageable.size = rows;
	$(".board-list #rowsPerPage").html(rows + " rows")
	getList();
})

function changePage(event) {
	event.preventDefault();
	board.pageable.pageNo = $(event.target).attr("pageNo");
	getList();
}