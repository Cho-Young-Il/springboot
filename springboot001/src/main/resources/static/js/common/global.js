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
