/*profile modal control...*/
$('i[data-toggle="tooltip"]').tooltip();

$("#myProfile").click(function(event) {
	event.preventDefault();
	$("#profileModal input[type=password]").val("");
	$("#deleteMemberForm input[type=password]").val("");
	board.modal.profile.modal.fadeIn("slow");
});

$("#profileModal #modifyModalCloseBtn").click(function(event) {
	event.preventDefault();
	board.modal.profile.modal.fadeOut("slow");
});

$("#profileModal #showModPassForm").click(function() {
	if (board.modal.profile.passDivIsDisplay) {
		board.modal.profile.passDivIsDisplay = false;
		$("#modPassForm").fadeOut("fast");
	} else {
		board.modal.profile.passDivIsDisplay = true;
		$("#modPassForm").fadeIn("fast");
	}
});


/*profile image file...*/
$("#profileModal #profileImageEdit").click(function(event) {
	event.preventDefault();
	$("#profileImageFile").click();
});

$("#profileModal #profileImageFile").change(function(event) {
	event.preventDefault();
	event.stopPropagation();
	var imageFile = event.target.files[0];
	var imageFileName = imageFile.name;
	var strExt = imageFileName
					.substring(imageFileName.lastIndexOf(".") + 1, imageFileName.length)
					.toLowerCase();
	if($.inArray(strExt, ["jpg", "jpeg", "png", "gif"]) == -1) {
		alert("Only image file can be uploaded");
	} else if(imageFile.size > 10485760) {
		alert("Image file size must be less than 10MB");
	} else {
		var formData = new FormData();
		formData.append("file", imageFile);
		
		if(uploadFile(formData, "/member/updateImage")) {
			var reader = new FileReader();
			reader.readAsDataURL(imageFile);
			reader.onload = function(event) {
				var imageThumnail = event.target.result;
				$("#profileImage").attr("src", imageThumnail);
			}
		}
	}
	return false;
});


$("#profileModal #profileImageDelete").click(function(event) {
	event.preventDefault();
	
	$.get("/member/deleteImage", function(data) {
		var baseUserIcon = board.modal.profile.baseUserIcon;
		$("#profileImage").attr("src", baseUserIcon);
		loginMember.mphoto = baseUserIcon;
	});
});


$("#profileModal #modProfileForm").submit(function() {
	var $memail = $("#modProfileForm #memail");
	var $mpwd = $("#modProfileForm #mpwd");
	var $mpwdConfirm = $("#modProfileForm #mpwdConfirm");
	var regex=/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;
	
	if(!regex.test($memail.val())) {
		alert("Check email address");
		$email.focus().select();
		return false;
	}

	if($mpwd.val() != $mpwdConfirm.val()) {
		alert("Passwords are not same");
		$mpwd.val("").focus();
		$mpwdConfirm.val("");
		return false;
	}
	
	$.post("/member/updateProfile",
		$("#modProfileForm").serialize()
	, function(data) {
		if(data.err) {
			var errMsg = data.errMsg;
			if(errMsg == "ERR_PASS") {
				alert("Passwords are not same");
				$mpwd.val("").focus();
				$mpwdConfirm.val("");
			} else {
				alert("Check email address");
				$memail.focus().select();
			}
		} else {
			alert("Complete update");
			$mpwd.val("");
			$mpwdConfirm.val("");
		}
	}, "json");
	return false;
});

$("#profileModal #modPassForm").submit(function() {
	var $curPwd = $("#modPassForm #curPwd");
	var $newPwd = $("#modPassForm #newPwd");
	var $cPwd = $("#modPassForm #cPwd");
	
	if($newPwd.val() != $cPwd.val()) {
		alert("Passwords are not same");
		$newPwd.val("").focus();
		$cPwd.val("");
		return false;
	}
	if($curPwd.val() == $newPwd.val()) {
		alert("Same Passwords");
		$curPwd.val("").focus();
		$newPwd.val("");
		$cPwd.val("");
		return false;
	}
	
	$.post("/member/updatePwd",
		$("#modPassForm").serialize()
	, function(data) {
		if(data.err) {
			alert("Check passwords");
		} else {
			alert("Password changed");
		}
		$curPwd.val("").focus();
		$newPwd.val("");
		$cPwd.val("");
	}, "json");
	return false;
});

$("#deleteMemberForm").submit(function() {
	var $mpwd = $("#deleteMemberForm #mpwd");
	var $mpwdConfirm = $("#deleteMemberForm #mpwdConfirm");
	
	if($mpwd.val() != $mpwdConfirm.val()) {
		alert("Passwords are not same");
		$mpwd.val("").focus();
		$mpwdConfirm.val("");
		return false;
	}
	
	$("#profileModal #profileImageDelete").trigger("click");
	
	$.post("/member/delete",
		$("#deleteMemberForm").serialize()	
	, function(data) {
		if(data.err) {
			alert("Check Passwords");
			$mpwd.val("").focus();
			$mpwdConfirm.val("");
		} else {
			alert("Deleted your account");
			location.href="/member/logout";
		}
	});
	return false;
});

