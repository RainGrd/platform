$(function () {
    /*//动态加载所属平台列表
    $.ajax({
        type:"GET",//请求类型
        url:"datadictionarylist.json",//请求的url
        data:{tcode:"APP_FLATFORM"},//请求参数
        dataType:"json",//ajax接口（请求url）返回的数据类型
        success:function(data){//data：返回数据（json对象）
            $("#flatformId").html("");
            var options = "<option value=\"\">--请选择--</option>";
            for(var i = 0; i < data.length; i++){
                options += "<option value=\""+data[i].valueId+"\">"+data[i].valueName+"</option>";
            }
            $("#flatformId").html(options);
        },
        error:function(data){//当访问时候，404，500 等非200的错误状态码
            alert("加载平台列表失败！");
        }
    });
    //动态加载一级分类列表
    $.ajax({
        type:"GET",//请求类型
        url:"categorylevellist.json",//请求的url
        data:{pid:null},//请求参数
        dataType:"json",//ajax接口（请求url）返回的数据类型
        success:function(data){//data：返回数据（json对象）
            $("#categoryLevel1").html("");
            var options = "<option value=\"\">--请选择--</option>";
            for(var i = 0; i < data.length; i++){
                options += "<option value=\""+data[i].id+"\">"+data[i].categoryName+"</option>";
            }
            $("#categoryLevel1").html(options);
        },
        error:function(data){//当访问时候，404，500 等非200的错误状态码
            alert("加载一级分类列表失败！");
        }
    });
    //动态加载二级分类列表
    $("#categoryLevel1").change(function(){
        var categoryLevel1 = $("#categoryLevel1").val();
        if(categoryLevel1 != '' && categoryLevel1 != null){
            $.ajax({
                type:"GET",//请求类型
                url:"categorylevellist.json",//请求的url
                data:{pid:categoryLevel1},//请求参数
                dataType:"json",//ajax接口（请求url）返回的数据类型
                success:function(data){//data：返回数据（json对象）
                    $("#categoryLevel2").html("");
                    var options = "<option value=\"\">--请选择--</option>";
                    for(var i = 0; i < data.length; i++){
                        options += "<option value=\""+data[i].id+"\">"+data[i].categoryName+"</option>";
                    }
                    $("#categoryLevel2").html(options);
                },
                error:function(data){//当访问时候，404，500 等非200的错误状态码
                    alert("加载二级分类失败！");
                }
            });
        }else{
            $("#categoryLevel2").html("");
            var options = "<option value=\"\">--请选择--</option>";
            $("#categoryLevel2").html(options);
        }
        $("#categoryLevel3").html("");
        var options = "<option value=\"\">--请选择--</option>";
        $("#categoryLevel3").html(options);
    });
    //动态加载三级分类列表
    $("#categoryLevel2").change(function(){
        var categoryLevel2 = $("#categoryLevel2").val();
        if(categoryLevel2 != '' && categoryLevel2 != null){
            $.ajax({
                type:"GET",//请求类型
                url:"categorylevellist.json",//请求的url
                data:{pid:categoryLevel2},//请求参数
                dataType:"json",//ajax接口（请求url）返回的数据类型
                success:function(data){//data：返回数据（json对象）
                    $("#categoryLevel3").html("");
                    var options = "<option value=\"\">--请选择--</option>";
                    for(var i = 0; i < data.length; i++){
                        options += "<option value=\""+data[i].id+"\">"+data[i].categoryName+"</option>";
                    }
                    $("#categoryLevel3").html(options);
                },
                error:function(data){//当访问时候，404，500 等非200的错误状态码
                    alert("加载三级分类失败！");
                }
            });
        }else{
            $("#categoryLevel3").html("");
            var options = "<option value=\"\">--请选择--</option>";
            $("#categoryLevel3").html(options);
        }
    });*/
    console.log(isNumber(-1));
    console.log(isIntNum(-1));
    console.log(isNumber(1));
    console.log(isIntNum(1));
    /**
     * 一级下拉列表选项变化事件
     */
    $("#categoryLevel1").change(function () {
        let queryCategoryLevel1 = $("#categoryLevel1").val();
        console.log(queryCategoryLevel1);
        if (queryCategoryLevel1 !== '' && queryCategoryLevel1 != null) {
            $.ajax({
                // async: false,
                type: "GET",//请求类型
                url: "developer/getAppCategoryLevelList.do",//请求的url
                data: {parentId: queryCategoryLevel1},//请求参数
                dataType: "json",//ajax接口（请求url）返回的数据类型
                success: function (data) {//data：返回数据（json对象）
                    // console.log(data)
                    $("#categoryLevel2").html("");
                    var options = "<option value=\"\">--请选择--</option>";
                    for (var i = 0; i < data.length; i++) {
                        options += "<option value=\"" + data[i].id + "\">" + data[i].categoryName + "</option>";
                    }
                    $("#categoryLevel2").html(options);
                },
                error: function (data) {//当访问时候，404，500 等非200的错误状态码
                    alert("加载二级分类失败！");
                }
            });
        } else {
            $("#categoryLevel2").html("");
            var options = "<option value=\"\">--请选择--</option>";
            $("#categoryLevel2").html(options);
        }
        $("#categoryLevel3").html("");
        var options = "<option value=\"\">--请选择--</option>";
        $("#categoryLevel3").html(options);
    });
    /**
     * 二级下拉列表选项变化事件
     */
    $("#categoryLevel2").change(function () {

        var queryCategoryLevel2 = $("#categoryLevel2").val();
        console.log(queryCategoryLevel2)
        if (queryCategoryLevel2 !== '' && queryCategoryLevel2 !== null) {
            $.ajax({
                type: "GET",//请求类型
                url: "developer/getAppCategoryLevelList.do",//请求的url
                data: {parentId: queryCategoryLevel2},//请求参数
                dataType: "json",//ajax接口（请求url）返回的数据类型
                success: function (data) {//data：返回数据（json对象）
                    // console.log(data)
                    $("#categoryLevel3").html("");
                    var options = "<option value=\"\">--请选择--</option>";
                    for (var i = 0; i < data.length; i++) {
                        //alert(data[i].id);
                        //alert(data[i].categoryName);
                        options += "<option value=\"" + data[i].id + "\">" + data[i].categoryName + "</option>";
                    }
                    $("#categoryLevel3").html(options);
                },
                error: function (data) {//当访问时候，404，500 等非200的错误状态码
                    console.log(data)
                    alert("加载三级分类失败！");
                }
            });
        } else {
            $("#categoryLevel3").html("");
            var options = "<option value=\"\">--请选择--</option>";
            $("#categoryLevel3").html(options);
        }
    });
    /**
     * 返回按钮
     */
    $("#back").on("click", function () {
        window.location.href = 'developer/toAppInfoList.do'
    });
    /**
     *
     */
    $("#APKName").on("blur", function () {
        let apkName = $("#APKName").val();
        //参数APKName为空，错误提示
        if (notNull(apkName)) {
            alert("APKName为不能为空！");
            return false;
        }
        //ajax后台验证--APKName是否已存在
        $.ajax({
            type: "GET",//请求类型
            url: "developer/apkexist.do",//请求的url
            data: {apkName: apkName},//请求参数
            dataType: "json",//ajax接口（请求url）返回的数据类型
            success: function (data) {//data：返回数据（json对象）
                if (data.code === 0) {
                    //账号不可用，错误提示
                    alert("该APKName已存在，不能使用！");
                    // 禁用保存按钮
                    $("#send").attr('disabled', true)
                } else {
                    // 启用保存按钮
                    $("#send").attr('disabled', false)
                }
            },
            error: function (data) {//当访问时候，404，500 等非200的错误状态码
                alert("请求错误！");
            }
        });
    });

    /**
     * LOGO图片保存位置
     */
    $("#a_logoPicPath").on('change', function () {
        //获取文件
        let value = $(this).val();
        //判断
        let lastIndexOf = value.lastIndexOf('.') + 1;
        value = value.substring(lastIndexOf);
        console.log(value)
        if (value !== 'jpg' && value !== 'jpeg' && value !== 'png') {
            alert("上传图片格式错误!");
            return false;
        }
    });
    /**
     * 保存按钮点击事件
     */
    $("#send").on('click', function () {
        // 获取参数
        let softwareName = $("#softwareName").val();
        let apkName = $("#APKName").val();
        let supportROM = $("#supportROM").val();
        let interfaceLanguage = $("#interfaceLanguage").val();
        let softwareSize = $("#softwareSize").val();
        let downloads = $("#downloads").val();
        let flatFormId = $("#flatFormId").val();
        let categoryLevel1 = $("#categoryLevel1").val();
        let categoryLevel2 = $("#categoryLevel2").val();
        let categoryLevel3 = $("#categoryLevel3").val();
        let status = $("#status").val();
        let appInfo = $("#appInfo").val();
        let file = $("#a_logoPicPath")[0].files[0];
        //非空判断
        if (notNull(softwareName)) {
            alert("软件名称不能为空！");
            return false;
        }
        if (notNull(apkName)) {
            alert("APK名称不能为空！");
            return false;
        }
        if (notNull(interfaceLanguage)) {
            alert("界面语言不能为空！");
            return false;
        }
        if (notNull(softwareSize)) {
            alert("软件大小不能为空！");
            return false;
        }
        if (notNull(downloads)) {
            alert("下载次数不能为空！");
            return false;
        }
        if (notNull(supportROM)) {
            alert("支持ROM不能为空！");
            return false;
        }
        if (notNull(flatFormId)) {
            alert("所属平台不能为空！");
            return false;
        }
        if (notNull(categoryLevel1)) {
            alert("一级分类不能为空！");
            return false;
        }
        if (notNull(categoryLevel2)) {
            alert("二级分类不能为空！");
            return false;
        }
        if (notNull(categoryLevel3)) {
            alert("三级分类不能为空！");
            return false;
        }

        if (notNull(appInfo)) {
            alert("应用简介不能为空！");
            return false;
        }
        if (notNull(file)) {
            alert("LOGO图片不能为空！");
            return false;
        }
        //数据校验
        if (!isNumber(softwareSize)) {
            alert("软件大小不能为负整数")
            return false;
        }
        if (!isNumber(downloads)) {
            alert("下载次数不能为负整数")
            return false;
        }
        //添加参数
        let formData = new FormData();
        formData.append("softwareName", softwareName)
        formData.append("apkName", apkName)
        formData.append("supportROM", supportROM)
        formData.append("interfaceLanguage", interfaceLanguage)
        formData.append("softwareSize", softwareSize)
        formData.append("downloads", downloads)
        formData.append("flatFormId", flatFormId)
        formData.append("categoryLevel1", categoryLevel1)
        formData.append("categoryLevel2", categoryLevel2)
        formData.append("categoryLevel3", categoryLevel3)
        formData.append("status", status)
        formData.append("appInfo", appInfo)
        formData.append("file", file)
        // Ajax 异步提交文件
        $.ajax({
            type: "post",
            url: "developer/insertSend.do",
            data: formData,//上一步的FormData
            cache: false,//不缓存数据
            processData: false,//不转换数据
            contentType: false,
            dataType: "json",
            success: function (data) {
                if (data.code === 0) {
                    // 保存失败
                    alert(data.message);
                } else {
                    //跳转页面
                    window.location.href = 'developer/toAppInfoList.do'
                }
            }
        });
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

/**
 * 校验只要是数字（包含正负整数，0以及正负浮点数）就返回true
 * @param val
 * @returns {boolean}
 */
function isNumber(val) {

    var regPos = /^[0-9]+.?[0-9]*/; //判断是否是数字。

    return regPos.test(val);
}

/**
 * 校验正负正数就返回true
 * @param val
 * @returns {boolean}
 */
function isIntNum(val) {
    var regPos = /^\d+$/; // 非负整数
    var regNeg = /^\-[1-9][0-9]*$/; // 负整数
    return regPos.test(val) && regNeg.test(val);
}


