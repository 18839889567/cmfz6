<%@page pageEncoding="UTF-8" %>
<script type="text/javascript">
    $(function () {
        $("#addBannerFormBtn").linkbutton({
            text: '提交',
            iconCls: 'icon-add',
            onClick: function () {
                $("#addBannerForm").form("submit", {
                    url: "${pageContext.request.contextPath}/banner/insert",
                    onSubmit: function () {

                    }, onSuccess: function () {
                        $.messager.show({
                            title: "系统提示",
                            msg: "添加成功"
                        });
                        $("#addBannerDialog").dialog("close");
                        $("#edatagrid").datagrid("reload");
                    }

                });
            }
        });
        $("#addBannerFormDescription").validatebox({
            required: true
        });
        $("#addBannerFormTitle").validatebox({
            required: true
        });
        $("#addBannerFormStatus").validatebox({
            required: true
        });

    })
</script>

<form id="addBannerForm" method="post" enctype="multipart/form-data">


    名称:<input id="addBannerFormTitle" name="title"/> <br/>
    状态:<input id="addBannerFormStatus" name="status"/><br/>
    描述:
    <input id="addBannerFormDescription" name="description"><br>
    图片： <input type="file" name="file"/>
    <a id="addBannerFormBtn" value="提交"/>

</form>