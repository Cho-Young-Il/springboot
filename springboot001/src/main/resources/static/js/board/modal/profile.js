$('i[data-toggle="tooltip"]').tooltip();
var modal = $("#profileModal");
var btn = $("#myProfile");
var close = $("#modifyModalCloseBtn");
btn.click(function(event) {
	event.preventDefault();
	modal.fadeIn("slow");
});

close.click(function(event) {
	event.preventDefault();
	modal.fadeOut("slow");
});

var passDivIsDisplay = false;
$("#showModPassDiv").click(function() {
	if (passDivIsDisplay) {
		passDivIsDisplay = false;
		$(".mod-pass-div").fadeOut("fast");
	} else {
		passDivIsDisplay = true;
		$(".mod-pass-div").fadeIn("fast");
	}
});