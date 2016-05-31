/*profile modal control...*/
if(!loginMember) {
	$('i[data-toggle="tooltip"]').tooltip();
	
	$("#myProfile").click(function(event) {
		event.preventDefault();
		$("#profileModal #profileMname").text(loginMember.mname);
		$("#profileModal #profileMid").text(loginMember.mid);
		$("#profileModal input[name=memail]").val(loginMember.memail);
		var baseUserImage = board.modal.profile.baseUserIcon;
		$("#profileModal #profileImage").attr("src", 
				loginMember.mphoto == baseUserImage ? baseUserImage : loginMember.mphoto);
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
		var strExt = event.target.value.split('.').pop().toLowerCase();
		if($.inArray(strExt, ["jpg", "jpeg", "png", "gif"]) == -1) {
			alert("Only image file can be uploaded");
			return false;
		} else {
			var formData = new FormData();
			formData.append('file', imageFile);
			if(!uploadFile(formData)) {
				return false;
			}
			
			var reader = new FileReader();
			reader.readAsDataURL(imageFile);
			reader.onload = function(event) {
				var imageThumnail = event.target.result;
				$("#profileImage").attr("src", imageThumnail);
			}
		}
	});
	
	
	$("#profileModal #profileImageDelete").click(function(event) {
		event.preventDefault();
		
		$.get("/member/deleteImage", function(data) {
			var baseUserIcon = board.modal.profile.baseUserIcon;
			$("#profileImage").attr("src", baseUserIcon);
			loginMember.mphoto = baseUserIcon;
		});
	});
	
	
	$("#profileModal #modProfileBtn").click(function() {
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
			if(data == "ERR_PASS") {
				alert("Check passwords");
				$mpwd.val("").focus();
				$mpwdConfirm.val("");
			} else if(data == "ERR_EMAIL") {
				alert("Check email address");
				$memail.focus().select();
			} else {
				alert("Complete update");
				loginMember.memail = $memail.val();
				$mpwd.val("");
				$mpwdConfirm.val("");
			}
		});
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
			if(data) {
				alert("Check passwords");
			} else {
				alert("Password changed");
			}
			$curPwd.val("").focus();
			$newPwd.val("");
			$cPwd.val("");
		});
		return false;
	});
}

function uploadFile(formData) {
	$.ajax({
		url : "/member/updateImage",
		data : formData,
		dataType : "text",
		processData : false,
		contentType : false,
		type : "post",
		success : function(data) {
			if(data) {
				alert("Error : " + data);
				return false;
			}
			return true;
		}
	});
}
