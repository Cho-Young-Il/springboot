/* regist modal */
var modal = $("#myModal");
var signUpBtn = $("#signUpBtn");
var closeBtn = $("span.close");

signUpBtn.click(function() {
	modal.fadeIn("slow");
});

closeBtn.click(function() {
	modal.fadeOut("slow");
});

window.onclick = function(event) {
	if(event.target == modal) {
		modal.fadeOut("slow");
	}
};