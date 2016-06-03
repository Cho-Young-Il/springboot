var main = {
	/* regist modal */
	modal : $("#myModal"),
	idCheckStatus : "none"
};

var board = {
	modal : {
		profile : {
			modal : $("#profileModal"),
			btn : $("#myprofile"),
			close : $("#modifyModalCloseBtn"),
			passDivIsDisplay : false,
			baseUserIcon : "/images/base-user.png"
		}
	}
};

var loginMember;
$.getJSON("/member/loginMember", function(data) {
	loginMember = data;
});

function uploadFile(formData, url) {
	var isERR = false;
	$.ajax({
		url : url,
		data : formData,
		dataType : "text",
		processData : false,
		contentType : false,
		type : "post",
		success : function(data) {
			if(data) {
				alert("Error : " + data);
				isERR = true;
			}
		}
	});
	return isERR;
}
