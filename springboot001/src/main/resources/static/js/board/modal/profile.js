/*profile modal control...*/
if(!loginMember) {
	$('i[data-toggle="tooltip"]').tooltip();
	
	$("#myProfile").click(function(event) {
		event.preventDefault();
		$("#profileModal #profileMname").text(loginMember.mname);
		$("#profileModal #profileMid").text(loginMember.mid);
		$("#profileModal input[name=profileMemail]").val(loginMember.memail);
		var baseUserImage = board.modal.profile.baseUserIcon;
		$("#profileModal #profileImage").attr("src", 
				loginMember.mphoto == baseUserImage ? baseUserImage : loginMember.mphoto);
		board.modal.profile.modal.fadeIn("slow");
	});
	
	$("#profileModal #modifyModalCloseBtn").click(function(event) {
		event.preventDefault();
		board.modal.profile.modal.fadeOut("slow");
	});
	
	$("#profileModal #showModPassDiv").click(function() {
		if (board.modal.profile.passDivIsDisplay) {
			board.modal.profile.passDivIsDisplay = false;
			$(".mod-pass-div").fadeOut("fast");
		} else {
			board.modal.profile.passDivIsDisplay = true;
			$(".mod-pass-div").fadeIn("fast");
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
			var reader = new FileReader();
			reader.readAsDataURL(imageFile);
			reader.onload = function(event) {
				var imageThumnail = event.target.result;
				$("#profileImage").attr("src", imageThumnail);
			}
		
			var formData = new FormData();
			formData.append('file', imageFile);
			uploadFile(formData);
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
			}
			
		}
	});
}
