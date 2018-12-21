<%@page pageEncoding="UTF-8" %>
<script type="text/javascript">
    $(function () {
        //初始加载数据
        $("#showAlbumForm").form("load", "${pageContext.request.contextPath}/album/queryOne?id=" + albumId);
        //form表
        $("#showAlbumForm").form({
            onLoadSuccess: function (res) {
                console.log(res)
                $("#img").prop("src", "${pageContext.request.contextPath}" + res.coverImg);
                // $("#brief").html(res.brief);
                $("#textarea").text(res.brief);


            }
        });
    })
</script>
<form id="showAlbumForm" method="post">
    ID :<input disabled="true" id="showAlbumFormId" name="id"/><br/>
    专辑主题:<input disabled="true" name="title"/><br/>
    数 量:<input disabled="true" name="count"/><br/>
    评 分:<input disabled="true" name="score"/><br/>
    创 作 者:<input disabled="true" name="author"/><br/>
    歌 颂 者:<input disabled="true" name="broadcast"/><br/>
    图 片:<img width="250px" id="img" src=""><br/>
    日 期:<input disabled="true" type="date" name="pubDate"/><br/>
    简 介:
    <textarea rows="5" cols="25" id="textarea"></textarea>
</form>

