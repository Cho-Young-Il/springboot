/* 
 * modal -> global val
 * regist modal
 */
$("#signUpBtn").click(function() {
	main.modal.fadeIn("slow");
});

/* login ajax */
$("#signin").submit(function() {
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
