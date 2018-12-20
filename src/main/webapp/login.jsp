<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>持名法州后台管理中心</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/IconExtension.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>

    <link rel="icon" href="img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="css/common.css" type="text/css"></link>
    <link rel="stylesheet" href="css/login.css" type="text/css"></link>
    <script type="text/javascript" src="script/common.js"></script>
    <script type="text/javascript">

        $(function () {
            $("#loginFormName").validatebox({
                required: true
            });

            $("#loginBtn").linkbutton({
                iconCls: 'icon-add',
                onClick: function () {
                    $("#loginForm").form("submit", {
                        url: "${pageContext.request.contextPath}/admin/login",
                        onSubmit: function () {
                            return $("#loginForm").form("validate");
                        },
                        success: function (result) {
                            console.log(result)
                            if ("ok" == result) {
                                location.href = "${pageContext.request.contextPath}/main/main.jsp"
                            }
                            $.messager.show({
                                title: "系统提示",
                                msg: result
                            });
                        }


                    });
                }
            });

            $("#enCode").validatebox({
                required: true
            });
            $("#loginFormPassword").validatebox({
                required: true
            });


        });
    </script>
</head>
<body>

<div class="login">
    <form id="loginForm" method="post">

        <table>
            <tbody>
            <tr>
                <td width="190" rowspan="2" align="center" valign="bottom">
                    <img src="img/header_logo.gif"/>
                </td>
                <th>
                    用户名:
                </th>
                <td>
                    <input id="loginFormName" type="text" name="name" class="text" maxlength="20"/>
                </td>
            </tr>
            <tr>
                <th>
                    密&nbsp;&nbsp;&nbsp;码:
                </th>
                <td>
                    <input id="loginFormPassword" type="password" name="password" class="text" maxlength="20"
                           autocomplete="off"/>
                </td>
            </tr>

            <tr>
                <td>&nbsp;</td>
                <th>验证码:</th>
                <td>
                    <input type="text" id="enCode" name="code" class="text captcha" maxlength="4" autocomplete="off"/>
                    <img id="captchaImage" class="captchaImage" width="100px"
                         src="${pageContext.request.contextPath}/admin/ImageAction"
                         onclick="document.getElementById('captchaImage').src ='${pageContext.request.contextPath}/admin/ImageAction?time='+(new Date()).getTime()"
                         title="点击更换验证码"/>
                </td>
            </tr>
            <tr>
                <td>
                    &nbsp;
                </td>
                <th>
                    &nbsp;
                </th>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <th>&nbsp;</th>
                <td>
                    <input type="button" class="homeButton" value="" onclick="location.href='/'"><input id="loginBtn"
                                                                                                        type="button"
                                                                                                        class="loginButton"
                                                                                                        value="登录"></td>
            </tr>
            </tbody>
        </table>
        <div class="powered">COPYRIGHT © 2008-2017.</div>
        <div class="link">
            <a href="http://www.chimingfowang.com/">持名佛网首页</a> |
            <a href="http://www.chimingbbs.com/">交流论坛</a> |
            <a href="">关于我们</a> |
            <a href="">联系我们</a> |
            <a href="">授权查询</a>
        </div>
    </form>
</div>
</body>
</html>