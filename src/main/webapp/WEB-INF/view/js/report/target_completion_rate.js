(function(){
	var chart = Highcharts.chart('container',{
		credits:{enabled:false},//去除版权信息
        chart: {zoomType: 'xy' },
        title: {text: '各平台一月份业绩目标及完成率'},
        xAxis: [{
            categories: [],
            crosshair: true
        }],
        yAxis: [{ // Secondary yAxis
            title: {
                text: '销售额',
                style: {
                    color: Highcharts.getOptions().colors[1]
                }
            },
            labels: {
                format: '{value}',
                style: {
                    color: Highcharts.getOptions().colors[1]
                }
            },
        },{ // Primary yAxis
            labels: {
                format: '{value} %',
                style: {
                    color: Highcharts.getOptions().colors[0]
                }
            },
            title: {
                text: '预计百分比',
                style: {
                    color: Highcharts.getOptions().colors[0]
                }
            },
            opposite: true
        }],
        tooltip: {
            shared: true
        },
        legend: {
            layout: 'horizontal',
            align: 'left',
            x: 120,
            verticalAlign: 'top',
            y: 25,
            floating: true,
            backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'
        },
        //'1月份业绩目标', '1月份销售额', '1月份预计销售额','1月份预计百分比', '1季度业绩目标' , '1季度销售额', '1季度预计销售额', '1季度预计百分比'
        series: []
    });
	
	loadData();
	function loadData() {
		chart.showLoading();
		$.ajax({
			url : contextPath + '/report/targetcompletioncrate/histogram',
			success : function(data) {
				if(data && data != null && data.length > 0){
					var title = ['1月份业绩目标','1月份销售额','1月份预计销售额','1月份预计百分比','1季度业绩目标','1季度销售额','1季度预计销售额','1季度预计百分比'];
					var categories = [];
					var array1 = [];
					for(var i=0;i<title.length;i++){
						for(var j=0;j<data.length;j++){
							categories[j] = data[j].name;
							if(i == 0){
								array1[j] = data[j].month1;
							}else if(i == 1){
								array1[j] = data[j].month1sales;
							}else if(i == 2){
								array1[j] = data[j].month1estimatesales;
							}else if(i == 3){
								array1[j] = data[j].month1percent;
							}else if(i == 4){
								array1[j] = data[j].quarter1;
							}else if(i == 5){
								array1[j] = data[j].quarter1sales;
							}else if(i == 6){
								array1[j] = data[j].quarter1estimatesales;
							}else if(i == 7){
								array1[j] = data[j].quarter1percent;
							}
						}
						chart.xAxis[0].setCategories(categories,true);
						var series = {};
						if(i == 3 || i==7){
							series = { name: title[i],type: 'spline',yAxis: 1,data: array1,tooltip: {valueSuffix: '%'}};
						}else{
							series = {name: title[i],type: 'column',data:array1,tooltip: {valueSuffix: '' }};
						}
						chart.addSeries(series);
					}
				}
			},
			cache : false
		});
		chart.hideLoading();
	}
	
	// 创建jqGrid组件
	jQuery("#list2").jqGrid(
			{
				url : contextPath + '/report/targetcompletioncrate/grid?month=1',//组件创建完成之后请求数据的url
				datatype : "json",//请求数据返回的类型。可选json,xml,txt
				colNames : [ '平台名称', '报表时间', '1月份业绩目标', '1月份销售额', '1月份预计销售额','1月份预计百分比', '1季度业绩目标' , '1季度销售额', '1季度预计销售额', '1季度预计百分比'],//jqGrid的列显示名字
				colModel : [ //jqGrid每一列的配置信息。包括名字，索引，宽度,对齐方式.....
				             {name : 'name',index : 'name',width : 155}, 
				             {name : 'reportDate1',index : 'reportDate1',width : 105}, 
				             {name : 'performanceTarget',index : 'performanceTarget',align : "right",width : 105}, 
				             {name : 'monthSales',index : 'monthSales',align : "right",width : 105}, 
				             {name : 'estimatedSales',index : 'estimatedSales',align : "right",width : 105}, 
				             {name : 'estimatedPercent',index : 'estimatedPercent',sortable : "true",width : 105} ,
				             {name : 'quarterlySalesTarget',index : 'quarterlySalesTarget',sortable : "true",width : 105} ,
				             {name : 'quarterlySales',index : 'quarterlySales',sortable : "true",width : 105} ,
				             {name : 'quarterlyEstimatedSales',index : 'quarterlyEstimatedSales',sortable : "true",width : 105} ,
				             {name : 'quarterlyEstimatedPercent',index : 'quarterlyEstimatedPercent',sortable : "true",width : 105}
				           ],
				rowNum : 20,//一页显示多少条
				rowList : [ 10, 20, 30 ],//可供用户选择一页显示多少条
				pager : '#pager2',//表格页脚的占位符(一般是div)的id
				sortname : 'name',//初始化的时候排序的字段
				sortorder : "asc",//排序方式,可选desc,asc
				mtype : "get",//向后台请求数据的ajax的类型。可选post,get
				viewrecords : true,
				//height:"200px"
				//caption : "JSON Example"//表格的标题名字
			});
	/*创建jqGrid的操作按钮容器*/
	/*可以控制界面上增删改查的按钮是否显示*/
	jQuery("#list2").jqGrid('navGrid', '#pager2', {edit : false,add : false,del : false});
})();