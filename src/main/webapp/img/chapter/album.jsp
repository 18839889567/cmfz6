<%@page pageEncoding="UTF-8" %>

<script>
    var toolbar = [{
        iconCls: 'icon-add',
        text: "专辑详情",
        handler: function () {
            alert('编辑按钮')
        }
    }, '-', {
        text: "添加专辑",
        iconCls: 'icon-edit',
        handler: function () {
            //获取选中行
            var row = $("#dg").edatagrid("getSelected");
            if (row != null) {
                //编辑指定行
                var index = $("#dg").edatagrid("getRowIndex", row);
                $("#dg").edatagrid("editRow", index);
            } else {
                alert("请先选中行")
            }


        }
    }, '-', {
        text: "添加音频",
        iconCls: 'icon-remove',
        handler: function () {
            alert('帮助按钮')
        }
    }, '-', {
        text: "音频下载",
        iconCls: 'icon-save',
        handler: function () {
            $("#dg").edatagrid("saveRow")

        }
    }]
    $(function () {
        $('#album').treegrid({
            method: "get",
            url: '${pageContext.request.contextPath}/album/queryAllAlbum',
            idField: 'id',
            treeField: 'title',
            pagination: true,
            pageList: [1, 3, 5, 7, 9],
            pageSize: 3,
            columns: [[
                {field: 'title', title: '名字', width: 30},
                {field: 'duration', title: '时长', width: 40},
                {field: 'size', title: '大小', width: 40},
                {field: 'url', title: '试听', width: 80, formatter: myOpt},
                {field: 'xxx', title: '下载链接', width: 80, formatter: myOpt2}
            ]],
            fit: true,
            fitColumns: true,
            toolbar: toolbar,
            onLoadSuccess: function (row, data) {
                $.each(data.rows, function (i, n) {
                    $.ajax({
                        type: "post",
                        url: "${pageContext.request.contextPath}/chapter/queryChapterByAlbumId",
                        data: "id=" + n.id,
                        success: function (result) {
                            $('#album').treegrid("append", {
                                parent: n.id,
                                data: result
                            });
                        }
                    });
                });
            }

        });
    })

    function myOpt(value) {
        if (value != undefined) {
            return "<audio class='audio1' src='${pageContext.request.contextPath}/audio" + value + "' controls=\"controls\">\n" +
                "</audio>";
        }

    }

    function myOpt2(value, row) {
        if (row.url != undefined) {
            return "<a href='#'>" + row.url + "</a>";
        }
    }

</script>


<table id="album"></table>