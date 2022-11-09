function loadCategoryLevel(pid, cl, categoryLevel) {
    console.log(pid);
    $.ajax({
        type: "GET",//请求类型
        url: "developer/getAppCategoryLevelList.do",//请求的url
        data: {parentId: pid},//请求参数
        dataType: "json",//ajax接口（请求url）返回的数据类型
        success: function (data) {//data：返回数据（json对象）
            $("#" + categoryLevel).html("");
            var options = "<option value=\"\">--请选择--</option>";
            for (var i = 0; i < data.length; i++) {
                if (cl !== null && cl === undefined && data[i].id === cl) {
                    options += "<option selected=\"selected\" value=\"" + data[i].id + "\" >" + data[i].categoryName + "</option>";
                } else {
                    options += "<option value=\"" + data[i].id + "\">" + data[i].categoryName + "</option>";
                }
            }
            $("#" + categoryLevel).html(options);
        },
        error: function (data) {//当访问时候，404，500 等非200的错误状态码
            alert("加载分类列表失败！");
        }
    });
}

/**
 * 删除文件函数
 * @param id
 */
function delFile(id) {
    $.ajax({
        type: "GET",//请求类型
        url: "developer/delFile.do",//请求的url
        data: {id: id, flag: 'logo'},//请求参数
        dataType: "json",//ajax接口（请求url）返回的数据类型
        success: function (data) {//data：返回数据（json对象）
            if (data.code === 1) {
                alert(data.message);
                $("#uploadFile").show();
                $("#logoFile").html('');
            } else if (data.code === 0) {
                alert(data.message);
            }
        },
        error: function (data) {//当访问时候，404，500 等非200的错误状态码
            alert("请求错误！");
        }
    });
}


$(function () {
    //动态加载所属平台列表
    /*$.ajax({
        type: "GET",//请求类型
        url: "datadictionarylist.json",//请求的url
        data: {tcode: "APP_FLATFORM"},//请求参数
        dataType: "json",//ajax接口（请求url）返回的数据类型
        success: function (data) {//data：返回数据（json对象）
            var fid = $("#fid").val();
            $("#flatformId").html("");
            var options = "<option value=\"\">--请选择--</option>";
            for (var i = 0; i < data.length; i++) {
                if (fid != null && fid != undefined && data[i].valueId == fid) {
                    options += "<option selected=\"selected\" value=\"" + data[i].valueId + "\" >" + data[i].valueName + "</option>";
                } else {
                    options += "<option value=\"" + data[i].valueId + "\">" + data[i].valueName + "</option>";
                }
            }
            $("#flatformId").html(options);
        },
        error: function (data) {//当访问时候，404，500 等非200的错误状态码
            alert("加载平台列表失败！");
        }
    });*/

    var cl1 = $("#cl1").val();
    var cl2 = $("#cl2").val();
    var cl3 = $("#cl3").val();
    //动态加载一级分类列表
    loadCategoryLevel(null, cl1, "categoryLevel1");
    //动态加载二级分类列表
    loadCategoryLevel(cl1, cl2, "categoryLevel2");
    //动态加载三级分类列表
    loadCategoryLevel(cl2, cl3, "categoryLevel3");

    //联动效果：动态加载二级分类列表
    $("#categoryLevel1").change(function () {
        var categoryLevel1 = $("#categoryLevel1").val();
        if (categoryLevel1 !== '' && categoryLevel1 != null) {
            loadCategoryLevel(categoryLevel1, cl2, "categoryLevel2");
        } else {
            $("#categoryLevel2").html("");
            var options = "<option value=\"\">--请选择--</option>";
            $("#categoryLevel2").html(options);
        }
        $("#categoryLevel3").html("");
        var options = "<option value=\"\">--请选择--</option>";
        $("#categoryLevel3").html(options);
    });
    //联动效果：动态加载三级分类列表
    $("#categoryLevel2").change(function () {
        var categoryLevel2 = $("#categoryLevel2").val();
        if (categoryLevel2 != '' && categoryLevel2 != null) {
            loadCategoryLevel(categoryLevel2, cl3, "categoryLevel3");
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
        window.location.href = "developer/toAppInfoList.do";
    });


    //LOGO图片---------------------
    var logoPicPath = $("#logoPicPath").val();
    var id = $("#id").val();
    if (logoPicPath == null || logoPicPath === "") {
        $("#uploadFile").show();
    } else {
        $("#logoFile").append("<p><img src=\"" + logoPicPath + "?m=" + Math.random() + "\" width=\"100px;\"/> &nbsp;&nbsp;" +
            "<a href=\"javascript:;\" onclick=\"delFile('" + id + "');\">删除</a></p>");

    }
    /**
     * 保存并再次提交审核按钮点击事件
     */
    $("#sendAudit").on('click', function () {
        send(1);
    });
    /**
     * 保存按钮点击事件
     */
    $('#send').on('click', function () {
        let val = $("#status").val();
        send(val)
    });

    function send(statusValue) {
        //获取参数
        let id = $("#id").val()
        let softwareName = $("#softwareName").val();
        let apkName = $("#APKName").val();
        let supportROM = $("#supportROM").val();
        let interfaceLanguage = $("#interfaceLanguage").val();
        let softwareSize = $("#softwareSize").val();
        let downloads = $("#downloads").val();
        let flatFormId = $("#fid").val();
        let categoryLevel1 = $("#categoryLevel1").val();
        let categoryLevel2 = $("#categoryLevel2").val();
        let categoryLevel3 = $("#categoryLevel3").val();
        let logoPicPath = $("#logoPicPath").val();
        let logoLocPath = $("#logoLocPath").val();
        let status = statusValue;
        let appInfo = $("#appInfo").val();
        let file = $("#attach")[0].files[0];
        let val = $("#attach").val();
        console.log(file);
        //添加参数
        let formData = new FormData();
        formData.append("id", id)
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
        formData.append("logoPicPath", logoPicPath)
        formData.append("logoLocPath", logoLocPath)
        formData.append("file", file)
        console.log(formData)
        //发送请求
        $.ajax({
            type: "POST",
            url: "developer/updateSend.do",
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
    }
});

/**
 * 非空函数
 */
function notNull(value) {
    if (value === null || value === '' || value === undefined) {
        return true;
    }
}
      
      
      