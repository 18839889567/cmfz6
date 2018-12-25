<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>

<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="map" style="width: 600px;height:400px;"></div>

<script type="text/javascript">
    var myChart = echarts.init(document.getElementById('map'));

    option = {
        title: {
            text: 'iphone销量',
            subtext: '纯属虚构',
            left: 'center'
        },
        tooltip: {
            trigger: 'item'
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['用户数量']
        },
        visualMap: {
            min: 0,
            max: 7,
            left: 'left',
            top: 'bottom',
            text: ['高', '低'],           // 文本，默认为数值文本
            calculable: true
        },
        toolbox: {
            show: true,
            orient: 'vertical',
            left: 'right',
            top: 'center',
            feature: {
                mark: {show: true},
                dataView: {show: true, readOnly: false},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        series: [
            {
                name: '用户数量',
                type: 'map',
                mapType: 'china',
                roam: false,
                label: {
                    normal: {
                        show: false
                    },
                    emphasis: {
                        show: true
                    }
                },
                data: [
                    {name: '北京'},
                    {name: '天津'},
                    {name: '上海'},
                    {name: '重庆'},
                    {name: '河北'},
                    {name: '河南'},
                    {name: '云南'},
                    {name: '辽宁'},
                    {name: '黑龙江'},
                    {name: '湖南'},
                    {name: '安徽'},
                    {name: '山东'},
                    {name: '新疆'},
                    {name: '江苏'},
                    {name: '浙江'},
                    {name: '江西'},
                    {name: '湖北'},
                    {name: '广西'},
                    {name: '甘肃'},
                    {name: '山西'},
                    {name: '内蒙古'},
                    {name: '陕西'},
                    {name: '吉林'},
                    {name: '福建'},
                    {name: '贵州'},
                    {name: '广东'},
                    {name: '青海'},
                    {name: '西藏'},
                    {name: '四川'},
                    {name: '宁夏'},
                    {name: '海南'},
                    {name: '台湾', value: 0},
                    {name: '香港'},
                    {name: '澳门'}
                ]
            }

        ]
    };
    myChart.setOption(option)
    $.ajax({
        type: "get",
        url: "${pageContext.request.contextPath}/user/province2",
        dataType: "JSON",
        success: function (data) {
            console.log(data)
            myChart.setOption({
                series: [{
                    data: data
                }]
            })
        }
    })
</script>
