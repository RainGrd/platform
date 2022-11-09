$(function () {
    /**
     * 所属平台下拉列表选择变化事件
     */
    $("#queryFlatformId").change(function () {
        queryAppInfoListConditionForPageAndCount(1, 5);
    })
    /**
     * 手游状态下拉列表选择变化事件
     */
    $("#queryStatus").change(function () {
        queryAppInfoListConditionForPageAndCount(1, 5);
    })
    /**
     * 一级下拉列表选项变化事件
     */
    $("#queryCategoryLevel1").change(function () {

        let queryCategoryLevel1 = $("#queryCategoryLevel1").val();
        console.log(queryCategoryLevel1);
        queryAppInfoListConditionForPageAndCount(1, 5);
        if (queryCategoryLevel1 !== '' && queryCategoryLevel1 != null) {
            $.ajax({
                // async: false,
                type: "GET",//请求类型
                url: "developer/getAppCategoryLevelList.do",//请求的url
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
        queryAppInfoListConditionForPageAndCount(1, 5);
    });
    /**
     * 二级下拉列表选项变化事件
     */
    $("#queryCategoryLevel2").change(function () {

        var queryCategoryLevel2 = $("#queryCategoryLevel2").val();
        queryAppInfoListConditionForPageAndCount(1, 5);
        if (queryCategoryLevel2 !== '' && queryCategoryLevel2 !== null) {
            $.ajax({
                type: "GET",//请求类型
                url: "developer/getAppCategoryLevelList.do",//请求的url
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
                    console.log(data)
                    alert("加载三级分类失败！");
                }
            });
        } else {
            $("#queryCategoryLevel3").html("");
            var options = "<option value=\"\">--请选择--</option>";
            $("#queryCategoryLevel3").html(options);
            queryAppInfoListConditionForPageAndCount(1, 5);
        }
    });
    // 初始化查询
    queryAppInfoListConditionForPageAndCount(1, 5)
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
    /**
     * 新增版本按钮点击事件
     */
    $("#tableData").on("click", ".addVersion", function () {
        var obj = $(this);
        console.log(1);
        window.location.href = "developer/toAppVersionAdd.do?id=" + obj.attr("appInfoId");
    });
    /**
     * 修改手游信息的按钮点击事件
     */
    $("#tableData").on("click", '.modifyVersion', function () {
        var obj = $(this);
        var status = obj.attr("status");
        var versionId = obj.attr("versionId");
        var appInfoId = obj.attr("appInfoId");
        if (status === "1" || status === "3") {//待审核、审核未通过状态下才可以进行修改操作
            if (versionId == null || versionId === "") {
                alert("该APP应用无版本信息，请先增加版本信息！");
            } else {
                window.location.href = "developer/toAppVersionModify.do?versionId=" + versionId + "&appInfoId=" + appInfoId;
            }
        } else {
            alert("该APP应用的状态为：【" + obj.attr("statusName") + "】,不能修改其版本信息，只可进行【新增版本】操作！");
        }
    });
    /**
     * 修改手游信息按钮点击事件
     */
    $("#tableData").on("click", '.modifyAppInfo', function () {
        var obj = $(this);
        var status = obj.attr("status");
        if (status === "1" || status === "3") {//待审核、审核未通过状态下才可以进行修改操作
            window.location.href = "developer/toAppInfoModify.do?id=" + obj.attr("appInfoId");
        } else {
            alert("该APP应用的状态为：【" + obj.attr("statusName") + "】,不能修改！");
        }
    });

    $(document).on("click", ".saleSwichOpen,.saleSwichClose", function () {
        var obj = $(this);
        var appInfoId = obj.attr("appInfoId");
        var saleSwitch = obj.attr("saleSwitch");
        if ("open" === saleSwitch) {
            saleSwitchAjax(appInfoId, obj);
        } else if ("close" === saleSwitch) {
            if (confirm("你确定要下架您的APP应用【" + obj.attr("appsoftwarename") + "】吗？")) {
                saleSwitchAjax(appInfoId, obj);
            }
        }
    });

    var saleSwitchAjax = function (appId, obj) {
        $.ajax({
            type: "PUT",
            url: appId + "/sale.json",
            dataType: "json",
            success: function (data) {
                /*
                 * resultMsg:success/failed
                 * errorCode:exception000001
                 * appId:appId
                 * errorCode:param000001
                 */
                if (data.errorCode === '0') {
                    if (data.resultMsg === "success") {//操作成功
                        if ("open" === obj.attr("saleSwitch")) {
                            //alert("恭喜您，【"+obj.attr("appsoftwarename")+"】的【上架】操作成功");
                            $("#appInfoStatus" + obj.attr("appInfoId")).html("已上架");
                            obj.className = "saleSwichClose";
                            obj.html("下架");
                            obj.attr("saleSwitch", "close");
                            $("#appInfoStatus" + obj.attr("appInfoId")).css({
                                'background': 'green',
                                'color': '#fff',
                                'padding': '3px',
                                'border-radius': '3px'
                            });
                            $("#appInfoStatus" + obj.attr("appInfoId")).hide();
                            $("#appInfoStatus" + obj.attr("appInfoId")).slideDown(300);
                        } else if ("close" === obj.attr("saleSwitch")) {
                            //alert("恭喜您，【"+obj.attr("appsoftwarename")+"】的【下架】操作成功");
                            $("#appInfoStatus" + obj.attr("appInfoId")).html("已下架");
                            obj.className = "saleSwichOpem";
                            obj.html("上架");
                            obj.attr("saleSwitch", "open");
                            $("#appInfoStatus" + obj.attr("appInfoId")).css({
                                'background': 'red',
                                'color': '#fff',
                                'padding': '3px',
                                'border-radius': '3px'
                            });
                            $("#appInfoStatus" + obj.attr("appInfoId")).hide();
                            $("#appInfoStatus" + obj.attr("appInfoId")).slideDown(300);
                        }
                    } else if (data.resultMsg === "failed") {//删除失败
                        if ("open" === obj.attr("saleSwitch")) {
                            alert("恭喜您，【" + obj.attr("appsoftwarename") + "】的【上架】操作失败");
                        } else if ("close" === obj.attr("saleSwitch")) {
                            alert("恭喜您，【" + obj.attr("appsoftwarename") + "】的【下架】操作失败");
                        }
                    }
                } else {
                    if (data.errorCode === 'exception000001') {
                        alert("对不起，系统出现异常，请联系IT管理员");
                    } else if (data.errorCode === 'param000001') {
                        alert("对不起，参数出现错误，您可能在进行非法操作");
                    }
                }
            },
            error: function (data) {
                if ("open" === obj.attr("saleSwitch")) {
                    alert("恭喜您，【" + obj.attr("appsoftwarename") + "】的【上架】操作成功");
                } else if ("close" === obj.attr("saleSwitch")) {
                    alert("恭喜您，【" + obj.attr("appsoftwarename") + "】的【下架】操作成功");
                }
            }
        });
    };


    $(".viewApp").on("click", function () {
        var obj = $(this);
        window.location.href = "appview/" + obj.attr("appInfoId");
    });

    $(".deleteApp").on("click", function () {
        var obj = $(this);
        if (confirm("你确定要删除APP应用【" + obj.attr("appsoftwarename") + "】及其所有的版本吗？")) {
            $.ajax({
                type: "GET",
                url: "delapp.json",
                data: {id: obj.attr("appInfoId")},
                dataType: "json",
                success: function (data) {
                    if (data.delResult == "true") {//删除成功：移除删除行
                        alert("删除成功");
                        obj.parents("tr").remove();
                    } else if (data.delResult == "false") {//删除失败
                        alert("对不起，删除AAP应用【" + obj.attr("appsoftwarename") + "】失败");
                    } else if (data.delResult == "notexist") {
                        alert("对不起，APP应用【" + obj.attr("appsoftwarename") + "】不存在");
                    }
                },
                error: function (data) {
                    alert("对不起，删除失败");
                }
            });
        }
    });
})


/**
 * 分页查询
 * @param current
 * @param pageSize
 */
function queryAppInfoListConditionForPageAndCount(current, pageSize) {
    //收集参数
    let status = $("#queryStatus").val();
    let softwareName = $("#querySoftwareName").val();
    let flatformId = $("#queryFlatformId").val();
    let categoryLevel1 = $("#queryCategoryLevel1").val();
    let categoryLevel2 = $("#queryCategoryLevel2").val();
    let categoryLevel3 = $("#queryCategoryLevel3").val();
    $.ajax({
        type: 'post',
        url: 'developer/queryAppInfoListConditionForPageAndCount.do',
        dataType: 'json',
        contentType: "application/json;charset=utf-8",
        data: JSON.stringify({
            status: status,
            softwareName: softwareName,
            flatformId: flatformId,
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
                    '<td>' + obj.softwareSize + '</td>\n' +
                    '<td>' + obj.flatFormName + '</td>\n' +
                    '<td>' + obj.categoryLevel1Name + ' -> ' + obj.categoryLevel2Name + '\n' +
                    '    -> ' + obj.categoryLevel3Name + '</td>\n' +
                    '<td>' + obj.statusName + '</td>\n' +
                    '<td>' + obj.downloads + '</td>\n' +
                    '<td>' + obj.versionName + '</td>\n' +
                    '<td>\n' +
                    '<div class="btn-group">\n' +
                    '    <button type="button" class="btn btn-danger">点击操作</button>\n' +
                    '    <button type="button" class="btn btn-danger dropdown-toggle"\n' +
                    '            data-toggle="dropdown" aria-expanded="false">\n' +
                    '        <span class="caret"></span>\n' +
                    '        <span class="sr-only">Toggle Dropdown</span>\n' +
                    '    </button>\n' +
                    '    <ul class="dropdown-menu" role="menu">\n'
                if (obj.status === 2 || obj.status === 5) {
                    str += '<li><a class="saleSwichOpen" saleSwitch="open"\n' +
                        'appInfoId=' + obj.id + '  appsoftwarename=' + obj.softwareName + '\n' +
                        'data-toggle="tooltip" data-placement="top" title=""\n' +
                        'data-original-title="恭喜您，您的审核已经通过，您可以点击上架发布您的APP">上架</a></li>\n'
                }
                if (obj.status === 4) {
                    str += '<li> <a class="saleSwichClose" saleSwitch="close"\n' +
                        'appInfoId=' + obj.id + '  appsoftwarename=' + obj.softwareName + '\n' +
                        'data-toggle="tooltip" data-placement="top" title=""\n' +
                        'data-original-title="您可以点击下架来停止发布您的APP，市场将不提供APP的下载">下架</a></li>\n'
                }
                str +=
                    '        <li><a class="addVersion" appInfoId="' + obj.id + '"\n' +
                    '               data-toggle="tooltip" data-placement="top" title=""\n' +
                    '               data-original-title="新增APP版本信息">新增版本</a>\n' +
                    '        </li>\n' +
                    '        <li><a class="modifyVersion"\n' +
                    '               appInfoId="' + obj.id + '" versionId="' + obj.versionId + '"\n' +
                    '               status="' + obj.status + '"\n' +
                    '               statusName="' + obj.statusName + '"\n' +
                    '               data-toggle="tooltip" data-placement="top" title=""\n' +
                    '               data-original-title="修改APP最新版本信息">修改版本</a>\n' +
                    '        </li>\n' +
                    '        <li><a class="modifyAppInfo"\n' +
                    '               appInfoId="' + obj.id + '" status="' + obj.status + '"\n' +
                    '               statusName="' + obj.statusName + '"\n' +
                    '               data-toggle="tooltip" data-placement="top" title=""\n' +
                    '               data-original-title="修改APP基础信息">修改</a></li>\n' +
                    '        <li><a class="viewApp"\n' +
                    '               appInfoId="' + obj.id + '"  data-toggle="tooltip"\n' +
                    '               data-placement="top" title=""\n' +
                    '               data-original-title="查看APP基础信息以及全部版本信息">查看</a></li>\n' +
                    '        <li><a class="deleteApp"\n' +
                    '               appInfoId="' + obj.id + '"  appsoftwarename=' + obj.softwareName + '\n' +
                    '               data-toggle="tooltip" data-placement="top" title=""\n' +
                    '               data-original-title="删除APP基础信息以及全部版本信息">删除</a></li>\n' +
                    '    </ul>\n' +
                    '</div>\n' +
                    '</td>\n' +
                    '</tr>'
                /*if (obj.status === 2 || obj.status === 5) {
                    $('#tableData .swich_' + index).html('<a class="saleSwichOpen" saleSwitch="open"\n' +
                        'appInfoId=' + obj.id + '  appsoftwarename=' + obj.softwareName + '\n' +
                        'data-toggle="tooltip" data-placement="top" title=""\n' +
                        'data-original-title="恭喜您，您的审核已经通过，您可以点击上架发布您的APP">上架</a>')
                }
                if (obj.status === 4) {
                    $('#tableData .swich_' + index).html(' <a class="saleSwichClose" saleSwitch="close"\n' +
                        'appInfoId=' + obj.id + '  appsoftwarename=' + obj.softwareName + '\n' +
                        'data-toggle="tooltip" data-placement="top" title=""\n' +
                        'data-original-title="您可以点击下架来停止发布您的APP，市场将不提供APP的下载">下架</a>')
                }*/
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


