<%@page pageEncoding="UTF-8" %>
<script type="text/css">


</script>
<script type="text/javascript">
    var albumId;
    var toolbar = [{
        iconCls: 'icon-add',
        text: "添加",
        handler: function () {
            alert('编辑按钮')
        }
    }, '-', {
        text: "修改",
        iconCls: 'icon-edit',
        handler: function () {
            //获取选中行
            var row = $("#user").edatagrid("getSelected");
            if (row != null) {
                //编辑指定行
                var index = $("#user").edatagrid("getRowIndex", row);
                $("#user").edatagrid("editRow", index);
            } else {
                alert("请先选中行")
            }


        }
    }, '-', {
        text: "删除",
        iconCls: 'icon-remove',
        handler: function () {
            var ro = $("#user").edatagrid("getSelected");
            console.log(ro);
            $('#edatagrid').edatagrid('destroyRow');
        }
    }, '-', {
        text: "导入",
        iconCls: 'icon-remove',
        handler: function () {
            location.href = "${pageContext.request.contextPath}/poi/downloadUser"
        }
    }, '-', {
        text: "导出",
        iconCls: 'icon-remove',
        handler: function () {
            location.href = "${pageContext.request.contextPath}/poi/poiImportUser"
        }
    }]


    $(function () {


        $('#user').edatagrid({
            url: '${pageContext.request.contextPath}/user/queryByPage',
            updateUrl: '${pageContext.request.contextPath}/user/update',
            destroyUrl: '${pageContext.request.contextPath}/user/delete',
            idField: 'id',
            treeField: 'title',
            columns: [[
                {field: 'id', title: 'ID', width: 60},
                {field: 'phone', title: '电话', width: 80},
                {field: 'sign', title: '签名', width: 80},
                {field: 'name', title: '名字', width: 80},
                {field: 'dharma', title: '法号', width: 80},
                {field: 'sex', title: '性别', width: 80},
                {field: 'city', title: '城市', width: 80},
                {
                    field: 'status', title: '状态', width: 80, editor: {
                        type: "text",
                        options: {required: true}
                    }
                },
                {field: 'regDate', title: '创建日期', width: 80},
            ]],
            fit: true,
            fitColumns: true,
            toolbar: toolbar,
            pagination: true,
            pageSize: 3,
            pageList: [1, 3, 5, 6],
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}' + rowData.headPic + '" style="height:50px;"></td>' +
                    '</tr></table>';
            },
            onDestroy: function (index, row) {
                console.log(index + "+++" + row);
            },


        });


    });


</script>

<table id="user"></table>