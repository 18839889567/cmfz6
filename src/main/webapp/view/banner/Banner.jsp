<%@page pageEncoding="UTF-8" %>
<script type="text/javascript">
    $(function () {
        $("#edatagrid").edatagrid({
            updateUrl: "${pageContext.request.contextPath}/banner/update",
            url: '${pageContext.request.contextPath}/banner/queryByPage',
            destroyUrl: '${pageContext.request.contextPath}/banner/delete',
            columns: [[
                {field: 'id', title: 'ID', width: 100},
                {field: 'title', title: '名称', width: 100},
                {
                    field: 'status', title: '状态',
                    // formatter:function(value,row,index){
                    //     console.log(row)
                    //     if(row.status=='1')
                    //         return 'Y'
                    //     else
                    //         return 'N'},
                    editor: {
                        type: "text",
                        options: {required: true}
                    }
                    , width: 100
                },
                {field: 'pubDate', title: '修改时间', width: 100, align: 'right'}
            ]],
            fit: true,
            fitColumns: true,
            pagination: true,
            pageSize: 5,
            pageList: [1, 3, 5, 6],
            toolbar: [{
                iconCls: 'icon-add',
                text: "增加",
                handler: function () {
                    $("#addBannerDialog").dialog("open");
                }
            }, '-', {
                iconCls: 'icon-edit',
                text: "修改",
                handler: function () {
                    //获取选中行
                    var row = $("#edatagrid").edatagrid("getSelected");
                    if (row != null) {
                        //编译指定行
                        var index = $("#edatagrid").edatagrid("getRowIndex", row);
                        $("#edatagrid").edatagrid("editRow", index);
                    } else {
                        alert("请先选中行")
                    }


                }
            }, '-', {
                iconCls: 'icon-remove',
                text: "删除",
                handler: function () {
                    var row = $("#edatagrid").edatagrid("getSelected");
                    $.post("${pageContext.request.contextPath}/banner/delete",
                        "id=" + row.id,
                        function (result) {
                            $('#edatagrid').edatagrid('destroyRow');

                        }
                    )


                }
            }, '-', {
                iconCls: 'icon-save',
                text: "保存",
                handler: function () {
                    $("#edatagrid").edatagrid("saveRow")
                }
            }]
            , view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}' + rowData.imgPath + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>描述: ' + rowData.description + '</p>' +
                    '<p>日期: ' + rowData.pubDate + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }
        })
//添加
        $("#addBannerDialog").dialog({
            title: '添加轮播图',
            width: 300,
            height: 400,
            modal: true,
            resizable: true,
            href: "${pageContext.request.contextPath}/view/banner/AddBanner.jsp",
            closed: true,
            cache: false
        })


    });


</script>


<div id="addBannerDialog"></div>
<table id="edatagrid"></table>