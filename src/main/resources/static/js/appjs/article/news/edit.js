$().ready(function() {
	$('.summernote').summernote({
		height : '220px',
		lang : 'zh-CN',
        callbacks: {
            onImageUpload: function(files, editor, $editable) {
                console.log("onImageUpload");
                sendFile(files);
            }
        }
    });
	var content = $("#content").val();
	$('#content_sn').summernote('code', content);
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
	var content_sn = $("#content_sn").summernote('code');
	$("#content").val(content_sn);
	$.ajax({
		cache : true,
		type : "POST",
		url : "/article/news/update",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			title : "required",
			pic : "required",
			content : "required"
		},
		messages : {
			title : "请填写文章标题",
			pic : "请上传文章封面",
			content : "请填写文章内容"
		}
	});
}