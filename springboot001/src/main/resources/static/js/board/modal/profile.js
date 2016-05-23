/*profile modal control...*/
$('i[data-toggle="tooltip"]').tooltip();

$("#myProfile").click(function(event) {
	event.preventDefault();
	board.modal.profile.modal.fadeIn("slow");
});

$("#modifyModalCloseBtn").click(function(event) {
	event.preventDefault();
	board.modal.profile.modal.fadeOut("slow");
});

$("#showModPassDiv").click(function() {
	if (board.modal.profile.passDivIsDisplay) {
		board.modal.profile.passDivIsDisplay = false;
		$(".mod-pass-div").fadeOut("fast");
	} else {
		board.modal.profile.passDivIsDisplay = true;
		$(".mod-pass-div").fadeIn("fast");
	}
});


/*profile image file...*/
$("#profileImageEdit").click(function(event) {
	event.preventDefault();
	$("#profileImageFile").click();
});

$("#profileImageFile").change(function(event) {
	var file = event.target.files[0];
	var strExt = event.target.value.split('.').pop().toLowerCase();
	if($.inArray(strExt, ["jpg", "jpeg", "png", "gif"]) == -1) {
		alert("Only image file can be uploaded");
		return false;
	} else {
		var reader = new FileReader();
		reader.readAsDataURL(file);
		reader.onload = function(event) {
			var imageThumnail = event.target.result;
			$("#profileImage").attr("src", imageThumnail);
		}
	}
});

$("#profileImageDelete").click(function(event) {
	event.preventDefault();
	//.. 삭제 로직...
	$("#profileImage").attr("src", board.modal.profile.baseUserIcon);
});