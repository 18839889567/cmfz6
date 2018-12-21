<%@page pageEncoding="UTF-8" %>
<script type="text/javascript">
    $(function () {
        console.log(albumId)
        $("#addChapterFormAid").val(albumId)

        $("#addChapterFormBtn").linkbutton({
            text: '提交',
            iconCls: 'icon-add',
            onClick: function () {
                $("#addChapterForm").form("submit", {
                    url: "${pageContext.request.contextPath}/chapter/insert",
                    onSubmit: function () {
                    }, onSuccess: function () {
                        alert("55555")
                        $.messager.show({
                            title: "系统提示",
                            msg: "添加成功"
                        });
                        $("#AddChapterDialog").dialog("close");
                        $("#album").datagrid("reload");
                    }
                });
            }
        });

        $("#addChapterFormTitle").validatebox({
            required: true
        });
        $("#addChapterFormSize").validatebox({
            required: true
        });
        $("#addChapterFormDuration").validatebox({
            required: true
        });
    })

</script>


<form id="addChapterForm" method="post" enctype="multipart/form-data">

    音频名称:<input id="addChapterFormTitle" name="title"/><br/>
    音频大小:<input id="addChapterFormSize" name="size"/><span>(单位)M</span><br/>
    音频时长:<input id="addChapterFormDuration" name="duration"/><br/>
    添加音频: <input type="file" name="file"/><br/>
    <input <%--hidden="true"--%> id="addChapterFormAid" name="aId" value=""/><br/>
    <a id="addChapterFormBtn" value="提交"/>
</form>