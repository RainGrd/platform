/**
 * 返回按钮
 */
$("#back").on("click", function () {
    window.location.href = "backend/toAppList.do";
});
/**
 * 审核通过按钮点击事件
 */
$("#approved").on("click", function () {
    appCheck(2)
});

/**
 * 审核不通过按钮点击事件
 */
$('#audit').on('click', function () {
    appCheck(3);
})

/**
 * 审核事件
 */
function appCheck(status) {
    // 收集参数
    let appId = $("#appId").val();
    let versionSize = $('#versionSize').val();
    let versionInfo = $('#versionInfo').val();
    // 数据检验
    if (notNull(versionSize)) {
        alert("版本大小不饿能为空");
        return false;
    }
    if (notNull(versionInfo)) {
        alert("版本信息不能为空!")
        return false;
    }
    //发送请求
    $.ajax({
        url: "backend/appCheck.do",
        type: 'post',
        contentType: 'application/json',
        data: JSON.stringify({
            appId: appId,
            versionSize: versionSize,
            versionInfo: versionInfo,
            status: status,
        }), success: function (result) {
            if (result.code === 0) {
                alert(result.message);
            } else {
                // 跳转至展示页面
                window.location.href = 'backend/toAppList.do';
            }
        }
    })

}

/**
 * 非空函数
 */
function notNull(value) {
    if (value === null || value === '' || value === undefined) {
        return true;
    }
}