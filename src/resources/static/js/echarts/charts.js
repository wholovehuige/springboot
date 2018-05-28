/**
 * Created by roy on 2017/8/10.
 */

var setCharts = function(Etext,Esubtext,titleData,datadata) {
    option = {
        title : {
            text: Etext,
            subtext: Esubtext,
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: titleData
        },
        series : [
            {
                name: '访问来源',
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:datadata,
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };

    return option;
}

var roomCharts = function(Etext,Esubtext,titleData,datadata) {
    option = {
        title : {
            text: Etext,
            subtext: Esubtext,
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: titleData
        },
        series : [
            {
                name: '客房类型占比',
                type: 'pie',
                radius : '55%',
                roseType : 'radius',
                center: ['50%', '60%'],
                data:datadata,
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };

    return option;
}