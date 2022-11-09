function delFile(id) {
    $.ajax({
        type: "GET",//请求类型
        url: "developer/delFile.do",//请求的url
        data: {id: id, flag: 'apk'},//请求参数
        dataType: "json",//ajax接口（请求url）返回的数据类型
        success: function (data) {//data：返回数据（json对象）
            if (data.code === 1) {
                alert("删除成功！");
                $("#uploadFile").show();
                $("#apkFile").html('');
            } else if (data.code === 0) {
                alert("删除失败！");
            }
        },
        error: function (data) {//当访问时候，404，500 等非200的错误状态码
            alert("请求错误！");
        }
    });
}

$(function () {
    /**
     * 返回按钮
     */
    $("#back").on("click", function () {
        window.location.href = 'developer/toAppInfoList.do'
    });

    //上传APK文件---------------------
    let downloadLink = $("#downloadLink").val();
    let id = $("#id").val();
    let apkFileName = $("#apkFileName").val();
    if (downloadLink == null || downloadLink === "") {
        $("#uploadFile").show();
    } else {
        $("#apkFile").append("<p>" + apkFileName +
            "&nbsp;&nbsp;<a href=\"" + downloadLink + "?m=" + Math.random() + "\" >下载</a> &nbsp;&nbsp;" +
            "<a href=\"javascript:;\" onclick=\"delFile('" + id + "');\">删除</a></p>");
    }


    $("#send").on('click', function () {
        // 收集参数
        let id = $('#id').val();
        let appId = $('#appId').val();
        let versionNo = $("#versionNo").val();
        let versionSize = $("#versionSize").val();
        if (!isNumber(versionSize)) {
            alert("版本大小只能为数字");
            return false;
        }
        let publishStatus = $("#publishStatus").val();
        let versionInfo = $("#versionInfo").val();
        let file = $("#attach")[0].files[0];
        // 添加参数
        let formData = new FormData();
        formData.append("id", id);
        formData.append("appId", appId);
        formData.append("versionNo", versionNo);
        formData.append("versionSize", versionSize);
        formData.append("publishStatus", publishStatus);
        formData.append("versionInfo", versionInfo);
        formData.append("file", file);
        //发送请求
        $.ajax({
            url: 'developer/appVersionModifySend.do',
            type: 'post',
            data: formData,
            cache: false,//不缓存数据
            processData: false,//不转换数据
            contentType: false,
            dataType: 'json',
            success: function (result) {
                console.log(result);
                if (result.code === 0) {
                    alert(result.message);
                } else {
                    //跳转首页
                    window.location.href = "developer/toAppInfoList.do";
                }
            }
        });
    })
});
/**
 * 校验只要是数字（包含正负整数，0以及正负浮点数）就返回true
 * @param val
 * @returns {boolean}
 */
function isNumber(val){

    var regPos = /^[0-9]+.?[0-9]*/; //判断是否是数字。

    if(regPos.test(val) ){
        return true;
    }else{
        return false;
    }
}

      
      
      