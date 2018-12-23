<%@page pageEncoding="UTF-8" %>
<script type="text/css">


</script>
<script type="text/javascript">
    var albumId;
    var toolbar = [{
        iconCls: 'icon-add',
        text: "专辑详情",
        handler: function () {
            //获取选中行
            var row = $("#album").treegrid("getSelected");
            // console.log(row)
            if (row.children != null) {
                albumId = row.id;
                $("#showAlbumDialog").dialog("open");

            } else {
                $.messager.alert({
                    msg: '请先选中专辑'
                })
            }

        }
    }, '-', {
        text: "添加专辑",
        iconCls: 'icon-edit',
        handler: function () {
            $("#addAlbumDialog").dialog("open");


        }
    }, '-', {
        text: "添加音频",
        iconCls: 'icon-remove',
        handler: function () {
            var row = $("#album").treegrid("getSelected");
            if (row.children != null) {
                albumId = row.id;
                $("#AddChapterDialog").dialog("open");
            } else {
                $.messager.alert({
                    msg: '请先选中专辑'
                })
            }


        }
    }, '-', {
        text: "音频下载",
        iconCls: 'icon-save',
        handler: function () {
            var row = $("#album").treegrid("getSelected");
            if (row.children == null) {
                location.href = "${pageContext.request.contextPath}/chapter/download?url=" + row.url;
            } else {
                $.messager.alert({
                    msg: '请先选中音频'
                })
            }

        }
    }];

    function show(value, row, index) {
        if (value != undefined) {
            return "<audio class='audio1' src='${pageContext.request.contextPath}/img/chapter/" + value + "' controls=\"controls\">\n" +
                "</audio>";
        } else {
            return "";
        }

    }


    $(function () {


        $('#album').treegrid({
            url: '${pageContext.request.contextPath}/album/queryAll',
            idField: 'id',
            treeField: 'title',
            columns: [[
                {field: 'title', title: '名字', width: 60},
                {field: 'url', title: '下载地址', width: 80, formatter: show},
                {field: 'size', title: '大小', width: 80},
                {field: 'duration', title: '时长', width: 80}
            ]],
            fit: true,
            fitColumns: true,
            toolbar: toolbar,
            pagination: true,
            pageSize: 3,
            pageList: [1, 3, 5, 6]
        });

        $("#showAlbumDialog").dialog({
            title: '专辑详情',
            width: 300,
            height: 400,
            modal: true,
            resizable: true,
            href: "${pageContext.request.contextPath}/view/album/showAlbum.jsp",
            closed: true,
            cache: false
        })
        $("#addAlbumDialog").dialog({
            title: '添加专辑',
            width: 300,
            height: 400,
            modal: true,
            resizable: true,
            href: "${pageContext.request.contextPath}/view/album/AddAlbum.jsp",
            closed: true,
            cache: false
        })
        $("#AddChapterDialog").dialog({
            title: '添加音频',
            width: 300,
            height: 400,
            modal: true,
            resizable: true,
            href: "${pageContext.request.contextPath}/view/album/AddChapter.jsp",
            closed: true,
            cache: false
        })
    });


</script>
<div id="AddChapterDialog"></div>
<div id="addAlbumDialog"></div>
<div id="showAlbumDialog"></div>
<table id="album"></table>