/* member regist ajax */
$("#signup").submit(function() {
	var $mpwd = $("#signup #mpwd");
	var $mpwdConfirm = $("#signup #mpwdConfirm");
	var $mname = $("#signup #mname");
	var $memail = $("#signup #memail");
	var $mid = $("#signup #mid");
	
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
	
	if(main.idCheckStatus != "ok") {
		alert("Please do id check\nOR ID Duplicated");
		$mid.focus().select();
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
	if(!regex.test($memail.val())) {
		alert("Check email address");
		$memail.focus().select();
		return false;
	}
	
	$.post("/member/add",
		$("#signup").serialize()
	, function(data) {
		if(data.err) {
			var errMsg = data.errMsg;
			if(errMsg == "ERR_PASS") {
				alert("Passwords are not same");
				$mpwd.val("").focus();
				$mpwdConfirm.val("");
			} else if(errMsg == "ERR_NAME") {
				alert("Cannot include null with namespace");
				$mname.focus().select();
			} else {
				alert("Check email address");
				$memail.focus().select();
			} 
		} else {
			alert("Complete registration");
			location.href = "/";
		}
	}, "json").fail(function(e) {
		alert("Fail registration");
		$mid.val("").focus();
		$mname.val("");
		$mpwd.val("");
		$mpwdConfirm.val("");
		$memail.val("");
	});
	return false;
});

/* node id duplication check */
$("#mid").keyup(function() {
	$.getJSON(nodeRoot + "/idCheck?callback=?&mid=" + $("#mid").val(), function(data) {
		/* idCheckstatus -> global val */
		main.idCheckStatus = data.status;
		if(main.idCheckStatus == "ok") {
			$("#midDiv > *").css("color", "blue");
		} else {
			$("#midDiv > *").css("color", "red");
		}
	});
});

$("#close").click(function() {
	main.modal.fadeOut("slow");
});