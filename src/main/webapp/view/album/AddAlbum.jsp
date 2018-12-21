<%@page pageEncoding="UTF-8" %>
<script type="text/javascript">
    $(function () {
        $("#showAlbumFormBtn").linkbutton({
            text: '提交',
            iconCls: 'icon-add',
            onClick: function () {
                $("#showAlbumForm").form("submit", {
                    url: "${pageContext.request.contextPath}/album/insert",
                    onSubmit: function () {

                    }, onSuccess: function () {
                        $.messager.show({
                            title: "系统提示",
                            msg: "添加成功"
                        });
                        $("#addAlbumDialog").dialog("close");
                        $("#album").datagrid("reload");
                    }

                });
            }
        });
        $("#showAlbumFormTitle").validatebox({
            required: true
        });
        $("#showAlbumFormCount").validatebox({
            required: true
        });
        $("#showAlbumFormScore").validatebox({
            required: true
        });
        $("#showAlbumFormAuthor").validatebox({
            required: true
        });
        $("#showAlbumFormBroadcast").validatebox({
            required: true
        });
        $("#showAlbumFormpubDate").datebox({
            required: true

        });


    })

</script>


<form id="showAlbumForm" method="post" enctype="multipart/form-data">

    专辑主题:<input id="showAlbumFormTitle" name="title"/><br/>
    评 分:<input id="showAlbumFormScore" name="score"/><br/>
    创 作 者:<input id="showAlbumFormAuthor" name="author"/><br/>
    歌 颂 者:<input id="showAlbumFormBroadcast" name="broadcast"/><br/>
    图 片: <input type="file" name="file"/><br/>
    日 期:<input id="showAlbumFormpubDate" name="pubDate"/><br/>
    简 介: <textarea rows="5" cols="25" id="textarea" name="brief"></textarea>
    <a id="showAlbumFormBtn" value="提交"/>
</form>