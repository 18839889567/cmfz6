<%@ page pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="main" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '分析查询'
        },
        tooltip: {},
        legend: {
            data: ['销量']
        },
        xAxis: {
            data: ["7天", "14天", "21天"]
        },
        yAxis: {},

    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
    $.ajax({
        type: "get",
        url: "${pageContext.request.contextPath}/user/queryByDate",
        dataType: "JSON",
        success: function (data) {
            console.log(data)
            myChart.setOption({
                series: [{
                    // 根据名字对应到相应的系列
                    name: '销量',
                    data: data,
                    type: "bar"
                }]
            })
        }
    })
</script>
