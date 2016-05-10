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

/* member regist ajax */
var memAdd = function() {
	var $mpass = $("#mpass");
	var $mpassConfirm = $("#mpassConfirm");
	var $mname = $("#mname");
	var $memail = $("#memail");
	var $mid = $("#mid");
	
	if($mpass.val() != $mpassConfirm.val()) {
		alert("Passwords are not same");
		$mpass.val("").focus();
		$mpassConfirm.val("");
		return false;
	}
	
	if($mname.val().indexOf(" ") >= 0) {
		alert("Cannot include null with namespace");
		$mname.focus().select();
		return false;
	}
	
	var mnameLen = $mname.val().length;
	for(var i = 0; i < mnameLen; i++) {
		var ch = $mname.val().charAt(i);
		if(ch >= '0' && ch <= '9') {
			alert("Cannot include number character with namespace");
			$mname.focus().select();
			return false;
		}
	}
	
	var regex=/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;
	if(regex.test($memail.val()) === false) {
		alert("Check email address");
		return false;
	}
	
	$.post("/member/add.json", {
		mid		: $mid.val(),
		mname	: $mname.val(),
		mpwd	: $mpass.val(),
		memail	: $memail.val()
	}, function(resultObj) {
		if(resultObj.status == "success") {
			alert("Complete registration");
			location.href = "/";
		} else {
			alert("Fail registration");
			$mid.val("").focus();
			$mname.val("");
			$mpass.val("");
			$mpassConfirm.val("");
			$memail.val("");
		}
	}, "json");
	return false;
};
