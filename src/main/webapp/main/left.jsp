<%@ page language="java" pageEncoding="UTF-8" %>
<script type="text/javascript">

    // function onc(node){
    // 	alert("3333")
    //     // console.log(node); // 节点的json对象
    //     //console.log(node.target); // 节点的DOM对象
    //     // 判断 是否是叶子节点--调tree的isLeaf方法，是 输出
    //     // var bn = $("#tree1").tree("isLeaf", node.target);
    //     // console.log(bn);
    //     // if (bn){ // 是叶节点
    //         //获取对应的页面路径
    // 		// if($("#tabs1").tabs("exists",node.text)){
    //         //     $("#tabs1").tabs("select",node.text);
    //         // }else {
    //         //     if(node.text=="主页"){
    //         //         $("#tabs1").tabs("add",{
    //         //             title:node.text,
    //         //             href:node.mypath
    //         //         })
    //         //     }else{
    //         //         $("#tabs1").tabs("add",{
    //         //             title:node.text,
    //         //             closable:true,
    //         //             href:node.mypath
    //         //         })
    //         //     }
    //         // }
    //     }

    // function title(list) {
    //     //console.log(list)
    //     // if (list.length != 0) {
    //     //     var str = "";
    //     //     for (var i = 0; i < list.length; i++) {
    //     //         //console.log(list[i].title)
    //     //         //str = str + "<a class='l-btn'  data-options='iconCls:'icon-man'>" + list[i].title + "</a><br>";
    //     //         str = str + "<a  >" + list[i].title + "</a><br>";
    //     //     }
    //     //     return str;
    //     // } else {
    //     //     return "<a href=''>空空如也</a>"
    //     // }
    //
    //     }

    function showSecond(list) {
        var ul = $("<ul id='second-tree' class='easyui-tree'></ul>");
        if (list.length != 0) {
            for (var i = 0; i < list.length; i++) {
                var li = $("<li >" + list[i].title + "</li>");
                ul.append(li);
            }
            ul.tree({
                onClick: function (node) {
                    console.log(node)
                    if ($("#tabs1").tabs("exists", node.text)) {
                        $("#tabs1").tabs("select", node.text);
                    } else {
                        $("#tabs1").tabs("add", {
                            title: node.text,
                            closable: true,
                            pill: true,
                            fit: true
                        });
                    }
                }
            });
            return ul;
        } else {
            return "控控乳液"
        }
    }


    $(function () {
        $.post(
            "${pageContext.request.contextPath}/menu/queryAll",
            function (result) {
                // console.log(result)
                // console.log(result.length)
                //console.log(result[0].list.length)
                for (var i = 0; i < result.length; i++) {
                    // console.log("result[i].id="+result[i].id+"   result[i].title"+result[i].title)
                    $("#menu").accordion('add', {
                        iconCls: result[i].iconcls,
                        title: result[i].title,
                        content: showSecond(result[i].list),
                        selected: false
                    });
                }

            },
            "JSON"
        )

    })
</script>


<div id="menu" class="easyui-accordion">


</div>