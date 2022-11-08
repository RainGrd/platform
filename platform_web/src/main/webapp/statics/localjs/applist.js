$(function () {
    /**
     * 所属平台下俩列表选线变化事件
     */
    $("#queryFlatformId").change(function () {
        queryAppInfoListConditionForPageAndCount(1, 5);
    })
    /**
     * 一级下拉列表选项变化事件
     */
    $("#queryCategoryLevel1").change(function () {
        queryAppInfoListConditionForPageAndCount(1, 5);
        var queryCategoryLevel1 = $("#queryCategoryLevel1").val();
        if (queryCategoryLevel1 !== '' && queryCategoryLevel1 != null) {
            $.ajax({
                // async: false,
                type: "GET",//请求类型
                url: "backend/getAppCategoryLevelList.do",//请求的url
                data: {parentId: queryCategoryLevel1},//请求参数
                dataType: "json",//ajax接口（请求url）返回的数据类型
                success: function (data) {//data：返回数据（json对象）
                    // console.log(data)
                    $("#queryCategoryLevel2").html("");
                    var options = "<option value=\"\">--请选择--</option>";
                    for (var i = 0; i < data.length; i++) {
                        options += "<option value=\"" + data[i].id + "\">" + data[i].categoryName + "</option>";
                    }
                    $("#queryCategoryLevel2").html(options);
                },
                error: function (data) {//当访问时候，404，500 等非200的错误状态码
                    alert("加载二级分类失败！");
                }
            });
        } else {
            $("#queryCategoryLevel2").html("");
            var options = "<option value=\"\">--请选择--</option>";
            $("#queryCategoryLevel2").html(options);
        }
        $("#queryCategoryLevel3").html("");
        var options = "<option value=\"\">--请选择--</option>";
        $("#queryCategoryLevel3").html(options);
    });
    /**
     * 二级下拉列表选项变化事件
     */
    $("#queryCategoryLevel2").change(function () {
        var queryCategoryLevel2 = $("#queryCategoryLevel2").val();
        queryAppInfoListConditionForPageAndCount(1, 5);
        if (queryCategoryLevel2 != '' && queryCategoryLevel2 != null) {
            $.ajax({
                type: "GET",//请求类型
                url: "backend/getAppCategoryLevelList.do",//请求的url
                data: {parentId: queryCategoryLevel2},//请求参数
                dataType: "json",//ajax接口（请求url）返回的数据类型
                success: function (data) {//data：返回数据（json对象）
                    // console.log(data)
                    $("#queryCategoryLevel3").html("");
                    var options = "<option value=\"\">--请选择--</option>";
                    for (var i = 0; i < data.length; i++) {
                        //alert(data[i].id);
                        //alert(data[i].categoryName);
                        options += "<option value=\"" + data[i].id + "\">" + data[i].categoryName + "</option>";
                    }
                    $("#queryCategoryLevel3").html(options);
                },
                error: function (data) {//当访问时候，404，500 等非200的错误状态码
                    alert("加载三级分类失败！");
                }
            });
        } else {
            $("#queryCategoryLevel3").html("");
            var options = "<option value=\"\">--请选择--</option>";
            $("#queryCategoryLevel3").html(options);
        }
    });
    // 初始化查询
    queryAppInfoListConditionForPageAndCount(1, 5)
    /**
     * 审核按钮点击事件
     */
    $("#tableData").on("click", ".checkApp", function () {
        var obj = $(this);
        var status = obj.attr("status");
        var vid = obj.attr("versionId");
        console.log(status)
        console.log(vid);
        if (status === "1" && vid !== "" && vid !== null) {//待审核状态下才可以进行审核操作
            // window.location.href = "check?aid=" + obj.attr("appInfoId") + "&vid=" + obj.attr("versionId");
            window.location.href = 'backend/toAppCheck.do?appInfoId=' + obj.attr("appInfoId") + "&versionId=" + vid
        } else if (vid !== "" || vid !== null) {
            alert("该APP应用没有上传最新版本,不能进行审核操作！");
        } else if (status !== "1") {
            alert("该APP应用的状态为：【" + obj.attr("statusName") + "】,不能进行审核操作！");
        }
    });

    /**
     * 首页点击按钮
     */
    $("#firstBtn").on("click", function () {
        queryAppInfoListConditionForPageAndCount(1, 5);
    });
    /**
     * 最后一页点击按钮事件
     */
    $("#lastBtn").on('click', function () {
        queryAppInfoListConditionForPageAndCount($("#navigateLastPage").text(), 5)
    })
    /**
     * 上一页
     */
    $("#onBtn").on('click', function () {
        queryAppInfoListConditionForPageAndCount($("#navigateFirstPage").text() - 1, 5)
    })
    /**
     * 下一页
     */
    $("#nextBtn").on('click', function () {
        queryAppInfoListConditionForPageAndCount($("#navigateFirstPage").text() + 1, 5)
    });
    /**
     * 查询按钮点击事件
     */
    $('#queryBtn').on('click', function () {
        queryAppInfoListConditionForPageAndCount(1, 5);
    });
});

/**
 * 查询函数
 * @param current
 * @param pageSize
 */
function queryAppInfoListConditionForPageAndCount(current, pageSize) {
    //收集参数
    let softwareName = $("#querySoftwareName").val();
    let flatformId = $("#queryFlatformId").val();
    let categoryLevel1 = $("#queryCategoryLevel1").val();
    let categoryLevel2 = $("#queryCategoryLevel2").val();
    let categoryLevel3 = $("#queryCategoryLevel3").val();
    $.ajax({
        type: 'post',
        url: 'backend/queryAppInfoListConditionForPageAndCount.do',
        dataType: 'json',
        contentType: "application/json;charset=utf-8",
        data: JSON.stringify({
            softwareName: softwareName,
            flatformId: softwareName,
            categoryLevel1: categoryLevel1,
            categoryLevel2: categoryLevel2,
            categoryLevel3: categoryLevel3,
            current: current,
            pageSize: pageSize,
        }),
        success: function (result) {
            // console.log(result);
            let list = result.list;
            $('#tableData').html('');
            let str = '';
            // 遍历数据
            $.each(list, function (index, obj) {
                str += ' <tr role="row" class="odd">\n' +
                    '<td tabindex="0" class="sorting_1">' + obj.softwareName + '</td>\n' +
                    '<td>' + obj.apkName + '</td>\n' +
                    '<td>' + obj.flatFormName + '</td>\n' +
                    '<td>' + obj.categoryLevel1Name + ' -> ' + obj.categoryLevel2Name + '\n' +
                    '    -> ' + obj.categoryLevel3Name + '</td>\n' +
                    '<td>' + obj.statusName + '</td>\n' +
                    '<td>' + obj.softwareSize + '</td>\n' +
                    '<td>' + obj.downloads + '</td>\n' +
                    '<td>' + obj.versionName + '</td>\n' +
                    '<td>\n' +
                    '    <button type="button" class="checkApp btn btn-default "\n' +
                    '            appInfoId="' + obj.id + '" versionId="' + obj.versionId + '"\n' +
                    '            status="' + obj.status + '"\n' +
                    '            statusName="' + obj.statusName + '"\n' +
                    '            data-toggle="tooltip" data-placement="top" title=""\n' +
                    '            data-original-title="查看并审核手游">审核\n' +
                    '    </button>\n' +
                    ' </td>\n' +
                    '</tr>'

            });
            $('#tableData').html(str);
            // 分页条信息
            $("#total").text(result.total);
            $("#navigateFirstPage").text(result.pageNum);
            $("#navigateLastPage").text(result.navigateLastPage);
        }, error: function (error) {
            console.log('出错了');
        }
    })
}





