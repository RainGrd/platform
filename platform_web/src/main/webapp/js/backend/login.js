$(function () {
    /**
     * 密码框绑定登录按钮点击事件
     */
    $("#password").on('keyup', function (e) {
        if (e.key === "Enter") {
            $("#loginBtn").click();
        }
    })

    /**
     * 登录按钮点击事件
     */
    $("#loginBtn").on("click", function () {
        /*收集参数*/
        let userCode = $("#userName").val();
        let password = $("#password").val();
        /*检验字段是否为空*/
        if (notNull(userCode)) {
            $('#error').text("用户名不能为空").addClass("error");
            return false;
        }
        if (notNull(password)) {
            $('#error').text("密码不能为空");
            return false;
        }
        /*清空错误文本*/
        $('#error').text("");

        /*发送数据*/
        $.ajax({
            url: 'backend/login.do',
            type: 'post',
            contentType: 'application/json;charset=UTF-8',
            dataType: 'json',
            data: JSON.stringify({
                userCode: userCode,
                userPassword: password
            }),
            success: function (result) {
                console.log(result)
                // 响应成功
                if (result.code === 1) {
                    // 跳转至主页
                    window.location.href = "backend/backendIndex.do";
                } else if (result.code === 0) {
                    // 输出错误提示
                    $('#error').text(result.message)
                    // 清空文本
                    $("#userName").val('')
                    $("#password").val('')
                }
            }, error: function (error) {
                // console.log(error);
                console.log('出错了');
            }
        })
    })
});

/**
 * 非空函数
 */
function notNull(value) {
    if (value === null || value === '' || value === undefined) {
        return true;
    }
}