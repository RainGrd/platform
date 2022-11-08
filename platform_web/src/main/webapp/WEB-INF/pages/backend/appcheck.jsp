<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="common/header.jsp" %>
<div class="clearfix"></div>
<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>查看并审核手游信息 <i class="fa fa-user"></i><small>${sessionScope.userSession.userName}</small></h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_title">
                <h2>手游基础信息</h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_content1">
                <form class="form-horizontal form-label-left" action="checksave" method="post">
                    <input id="appId" type="hidden" name="id" value="${appInfo.id}">
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="softwareName">软件名称 <span
                                class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="softwareName" class="form-control col-md-7 col-xs-12"
                                   value="${appInfo.softwareName}"
                                   type="text" readonly="readonly">
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="apkName">APK名称 <span
                                class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="apkName" type="text" class="form-control col-md-7 col-xs-12"
                                   value="${appInfo.apkName}" readonly="readonly">
                        </div>
                    </div>

                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">支持ROM <span
                                class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="supportROM" class="form-control col-md-7 col-xs-12"
                                   value="${appInfo.supportROM}" type="text" readonly="readonly">
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="interfaceLanguage">界面语言 <span
                                class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="interfaceLanguage" class="form-control col-md-7 col-xs-12" readonly="readonly"
                                   value="${appInfo.interfaceLanguage}" type="text">
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="softwareSize">软件大小 <span
                                class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="softwareSize" type="text" value="${appInfo.softwareSize}"
                                   class="form-control col-md-7 col-xs-12" readonly="readonly">
                        </div>
                    </div>

                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="downloads">下载次数 <span
                                class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="downloads" type="text" value="${appInfo.downloads}"
                                   class="form-control col-md-7 col-xs-12" readonly="readonly">
                        </div>
                    </div>

                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="flatFormName">所属平台 <span
                                class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="flatFormName" type="text" class="form-control col-md-7 col-xs-12"
                                   value="${appInfo.flatFormName}" flatFormId="${appInfo.flatFormId}"
                                   readonly="readonly">

                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="category">所属分类 <span
                                class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="category" type="text" categoryLevel1="${appInfo.categoryLevel1}"
                                   categoryLevel2="${appInfo.categoryLevel2}" categoryLevel3="${appInfo.categoryLevel3}"
                                   class="form-control col-md-7 col-xs-12"
                                   value="${appInfo.categoryLevel1Name} --> ${appInfo.categoryLevel2Name} --> ${appInfo.categoryLevel3Name}"
                                   readonly="readonly">
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="statusName">手游状态 <span
                                class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="statusName" type="text" class="form-control col-md-7 col-xs-12"
                                   value="${appInfo.statusName}" status="${appInfo.status}" readonly="readonly">
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="appInfo">应用简介 <span
                                class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
              <textarea id="appInfo" class="form-control col-md-7 col-xs-12" readonly="readonly">
                  ${appInfo.appInfo}
              </textarea>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="logoPicPath">LOGO图片 <span
                                class="required">*</span>
                        </label>
                        <div id="logoPicPath" class="col-md-6 col-sm-6 col-xs-12">
                            <c:choose>
                                <c:when test="${appInfo.logoPicPath == null || appInfo.logoPicPath == ''}">
                                    暂无
                                </c:when>
                                <c:otherwise>
                                    <img src="${appInfo.logoPicPath}" width="100px" alt=""/>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-6 col-md-offset-3">
                            <button id="approved" type="button" name="status" value="2" class="btn btn-success">审核通过
                            </button>
                            <button id="audit" type="button" name="status" value="3" class="btn btn-success">审核不通过
                            </button>
                            <button type="button" class="btn btn-primary" id="back">返回</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="clearfix"></div>
            <div class="x_title">
                <h2>最新版本信息</h2>
                <ul class="nav navbar-right panel_toolbox">
                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                    </li>
                </ul>
                <div class="clearfix"></div>
            </div>
            <div class="x_content" style="display: block;">
                <br>
                <form class="form-horizontal form-label-left">
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="versionNo">版本号 <span
                                class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="versionNo" class="form-control col-md-7 col-xs-12"
                                   value="${appVersion.versionNo}"
                                   type="text" readonly="readonly">
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="versionSize">版本大小 <span
                                class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="versionSize" type="number" value="${appVersion.versionSize }"
                                   class="form-control col-md-7 col-xs-12">
                        </div>
                    </div>

                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="publishStatus">发布状态 <span
                                class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="hidden" name="publishStatus" id="publishStatus" value="3">预发布
                        </div>
                    </div>

                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="versionInfo">版本简介 <span
                                class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
              <textarea id="versionInfo" class="form-control col-md-7 col-xs-12">
                  ${appVersion.versionInfo }</textarea>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="downloadLink">apk文件 <span
                                class="required">*</span>
                        </label>
                        <div id="downloadLink" class="col-md-6 col-sm-6 col-xs-12">
                            <c:choose>
                                <c:when test="${appVersion.downloadLink == null || appVersion.downloadLink == ''}">
                                    暂无
                                </c:when>
                                <c:otherwise>
                                    <p>${appVersion.apkFileName}&nbsp;&nbsp;
                                        <a href="${appVersion.downloadLink}">下载</a>
                                    </p>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                    <br/><br/>
                </form>
            </div>
            <div class="clearfix"></div>
            <br/><br/>
        </div>
    </div>
    <%@include file="common/footer.jsp" %>
    <script src="statics/localjs/appcheck.js"></script>