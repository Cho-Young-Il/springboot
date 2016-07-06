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
	},
	pageable : {
		pageNo : 1,
		size : 20,
		searchType : undefined,
		searchKeyword : undefined
	}
};

function uploadFile(formData, url) {
	var isNotERR = true;
	$.ajax({
		url : url,
		data : formData,
		dataType : "text",
		processData : false,
		contentType : false,
		type : "post",
		success : function(data) {
			if(data.Msg) {
				alert("Error : " + data.errMsg);
				isNotERR = false;
			}
		}
	});
	return isNotERR;
}
