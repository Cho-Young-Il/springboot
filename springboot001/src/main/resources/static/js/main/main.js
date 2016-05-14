/* 
 * modal -> global val
 * regist modal
 */
$("#signUpBtn").click(function() {
	modal.fadeIn("slow");
});

$("#close").click(function() {
	modal.fadeOut("slow");
});


/* member regist ajax */
$("#memAddBtn").click(function() {
	var $mpwd = $("#mpwd");
	var $mpwdConfirm = $("#mpwdConfirm");
	var $mname = $("#mname");
	var $memail = $("#memail");
	var $mid = $("#mid");
	
	if($mpwd.val() != $mpwdConfirm.val()) {
		alert("Passwords are not same");
		$mpwd.val("").focus();
		$mpwdConfirm.val("");
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
	
	console.log($("#signup").serialize());
	console.log($memail.val());
	
	$.post("/member/add",
		$("#signup").serialize()
	, function(data) {
		alert("Complete registration");
		location.href = "/";
	}).fail(function(e) {
		alert("Fail registration");
		$mid.val("").focus();
		$mname.val("");
		$mpwd.val("");
		$mpwdConfirm.val("");
		$memail.val("");
	});
	return false;
});
