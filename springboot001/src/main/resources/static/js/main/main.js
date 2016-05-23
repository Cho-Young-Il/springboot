/* 
 * modal -> global val
 * regist modal
 */
$("#signUpBtn").click(function() {
	main.modal.fadeIn("slow");
});

$("#close").click(function() {
	main.modal.fadeOut("slow");
});


/* member regist ajax */
$("#memAddBtn").click(function() {
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
		return false;
	}
	
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


/* login ajax */
$("#signInBtn").click(function() {
	$.post("/member/login",
		$("#signin").serialize()
	, function(data) {
		var url = data.url;
		if(url) {
			location.href = url;
		} else {
			alert("Login Fail.\nCheck ID or Password");
		}
	}, "json").fail(function(e) {
		console.log(e);
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