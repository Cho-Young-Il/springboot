/*board regist modal click init input tag*/
$("#newPostBtn").click(function() {
	$("#newPostModal input").val("");
	$("#newPostModal textarea").val("");
	$("#newPostModal #cntMsg").html("200 remaining");
});

/* check exceeding 200 characters */
$("#newPostModal #bcontent").keyup(function() {
	var maxByte = 200;
	chkword(this, maxByte);
}).autoGrow();

function chkword(obj, maxByte) {
    var strValue = obj.value;
    var strLen = strValue.length;
    var totalByte = 0;
    var len = 0;
    var oneChar = "";
    var str2 = "";
 
        for (var i = 0; i < strLen; i++) {
            oneChar = strValue.charAt(i);
            if (escape(oneChar).length > 4) {
                totalByte += 2;
            } else {
                totalByte++;
            }
 
            if (totalByte <= maxByte) {
                len = i + 1;
            }
        }
        
        $("#newPostModal #cntMsg").html((maxByte - totalByte) + " remaining");
 
        if (totalByte > maxByte) {
            alert("Can not exceed 200 characters.");
        str2 = strValue.substr(0, len);
        obj.value = str2;
        chkword(obj, maxByte);
    }
}


/* image file upload */
$("#newPostModal #searchImage").click(function() {
	$("#newPostModal #attachFiles").trigger("click");
	return false;
});

var attachFiles = [];
var attachFileIndex = 0;
var attachFileCnt = 0;

$("#newPostModal #attachFiles").change(function(event) {
	event.preventDefault();
	event.stopPropagation();
	
	var files = event.target.files;
	imageUtil(files);
	
	$(this).val("");
	return false;
});

$(".fileDrop").on("dragenter dragover", function(event) {
	event.preventDefault();
	event.stopPropagation();
	$("#newPostModal .file-drag").css("opacity", "0.7");
}).on("drop", function(event) {
	event.preventDefault();
	event.stopPropagation();
	$("#newPostModal .file-drag").css("opacity", "0");
	
	var files = event.originalEvent.dataTransfer.files;
	imageUtil(files);
}).on("dragleave dragend", function(event) {
	event.preventDefault();
	event.stopPropagation();
	$("#newPostModal .file-drag").css("opacity", "0");
});

function imageUtil(files) {
	var filesLen = files.length;
	for(var i = 0; i < filesLen; i++) {
		var imageFile = files[i];
		var imageFileName = imageFile.name;
		var strExt = imageFileName
						.substring(imageFileName.lastIndexOf(".") + 1, imageFileName.length)
						.toLowerCase();
		if(imageFile.size <= 10485760 
			&& $.inArray(strExt, ["jpg", "jpeg", "png", "gif"]) != -1) {
			
			var reader = new FileReader();
			reader.readAsDataURL(imageFile);
			reader.onload = function(event) {
				var imageThumbnail = event.target.result;
				var attachFileThumb = 
					'<div class="col-md-4" id="attachFileThumb' + attachFileIndex + '">' +
						'<div class="thumbnail-wrapper">' +
							'<div class="thumbnail" id="thumbnail' + attachFileIndex + '">' +
								'<div class="centered">' +
									'<img src="' + imageThumbnail + '">' +
								'</div>' +
								'<div class="thumbnail-hover">' +
									'<a id="deleteBoardFile">' +
										'<i class="fa fa-fw fa-close pull-right" id="deleteFileThumb' + attachFileIndex + '" style="color: white;" ' + 
											'attachFileThumbNo="' + attachFileIndex + '" data-toggle="tooltip" data-original-title="Close"></i>' +
									'</a>' +
								'</div>' +
							'</div>' +
						'</div>' +
					'</div>';
				$("#newPostModal").on("mouseenter", 
						"#thumbnail" + attachFileIndex, function() {
					var that = $(this).context.children[1];
					$(that).css("opacity", "0.7");
				}).on("mouseleave", "#thumbnail" + attachFileIndex, function() {
					var that = $(this).context.children[1];
					$(that).css("opacity", "0");
				});
				
				$("#newPostModal").on("click", 
						"#deleteFileThumb" + attachFileIndex, function() {
					var attachFileThumbNo = $(this).attr("attachFileThumbNo");
					$("#newPostModal #attachFileThumb" + attachFileThumbNo)
							.fadeOut(500, function() {
								$(this).remove();
							});
					attachFiles[attachFileThumbNo] = undefined;
					attachFileCnt--;
				});
				
				$("#newPostModal #attachFileThumbDiv").append(attachFileThumb);				
				imageFile.index = attachFileIndex++;
				attachFileCnt++;
				attachFiles.push(imageFile);
			}
		}
	}
	return false;
}


/*board regist*/
$("#newPostModal #boardAddForm").submit(function() {
	var formData = new FormData();
	formData.append("btitle", $("#newPostModal #boardAddForm #btitle").val());
	formData.append("bcontent", $("#newPostModal #boardAddForm #bcontent").val());
	formData.append("mno", $("#newPostModal #boardAddForm #mnoHidden").text());
	
	Array.prototype.sort.call(attachFiles);
	for(var i = 0; i < attachFileCnt; i++) {
		formData.append(i, attachFiles[i]);
	}
	
	if(uploadFile(formData, "/board/regist")) {
		alert("Success regist new post");
		location.href = "/board/list";
	}
	return false;
});