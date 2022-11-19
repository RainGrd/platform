$(function () {

    /**
     * 返回按钮点击事件
     */
    $("#back").on("click", function () {
        window.location.href = "developer/toAppInfoList.do";
    });

    $("#send").on("click", function () {
        // 收集参数
        let appId = $('#id').val();
        let versionNo = $("#versionNo").val();
        let versionSize = $("#versionSize").val();
        console.log(versionSize)
        if (!isNumber(versionSize)) {
            alert("版本大小只能为数字");
            return false;
        }
        let publishStatus = $("#publishStatus").val();
        let versionInfo = $("#versionInfo").val();
        let file = $("#a_downloadLink")[0].files[0];
        // 添加参数
        let formData = new FormData();
        formData.append("appId", appId);
        formData.append("versionNo", versionNo);
        formData.append("versionSize", versionSize);
        formData.append("publishStatus", publishStatus);
        formData.append("versionInfo", versionInfo);
        formData.append("file", file);
        //发送请求
        $.ajax({
            url: 'developer/insertAppVersion.do',
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
function isNumber(val) {

    var regPos = /^[0-9]+.?[0-9]*/; //判断是否是数字。

    if (regPos.test(val)) {
        return true;
    } else {
        return false;
    }
}
      
      
      