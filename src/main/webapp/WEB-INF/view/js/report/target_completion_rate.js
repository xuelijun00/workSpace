var targetCompletionRate = {
	month:'1',
	chart:Highcharts.chart('container',{
		credits:{enabled:false},//去除版权信息
	    chart: {zoomType: 'xy' },
	    exporting:{enabled:false},
	    title: {},
	    xAxis: [{categories: [],crosshair: true}],
	    yAxis: [{ 
	        title: {text: '销售额',style: { color: Highcharts.getOptions().colors[1]}},
	        labels: { format: '{value}',style: {color: Highcharts.getOptions().colors[1] }},
	        crosshair: true
	    },{ 
	        labels: {format: '{value} %',style: {color: Highcharts.getOptions().colors[0]}},
	        title: { text: '预计百分比',style: {color: Highcharts.getOptions().colors[0]}},
	        opposite: true
	    }],
	    tooltip: {shared: true},
	    legend: {
	    	layout: 'horizontal',align: 'left',x: 120,verticalAlign: 'top',y: 25,floating: true,
	        backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'
	    },
	    //'1月份业绩目标', '1月份销售额', '1月份预计销售额','1月份预计百分比', '1季度业绩目标' , '1季度销售额', '1季度预计销售额', '1季度预计百分比'
	    series: []
	}),
	loadData:function(platform){
		targetCompletionRate.chart.title.textSetter('各平台'+ targetCompletionRate.month +'月份业绩目标及完成率');
		var url = contextPath + '/report/targetcompletioncrate/histogram';
		if(platform != null && $("#" + platform).val() != "all"){
			url = url + "?platform=" + $("#" + platform).val();
		}
		targetCompletionRate.chart.showLoading();
		$.ajax({
			url : url,
			cache : false,
			type:"get",
			success : function(data) {
				if(data && data != null && data.length > 0){
					var title = [targetCompletionRate.month + '月份业绩目标',targetCompletionRate.month+'月份销售额',targetCompletionRate.month+'月份预计销售额',targetCompletionRate.month+'月份预计百分比',Math.ceil(parseInt(targetCompletionRate.month)*1/3)+'季度业绩目标',Math.ceil(parseInt(targetCompletionRate.month)*1/3)+'季度销售额',Math.ceil(parseInt(targetCompletionRate.month)*1/3)+'季度预计销售额',Math.ceil(parseInt(targetCompletionRate.month)*1/3)+'季度预计百分比'];
					var categories = [];
					var array1 = [[],[],[],[],[],[],[],[]];
					while(targetCompletionRate.chart.series.length > 0) {  
						targetCompletionRate.chart.series[0].remove();  
	                }
					for(var j=0;j<data.length;j++){
						categories.push(data[j].name);
						array1[0].push(data[j]["month" + targetCompletionRate.month]);
						array1[1].push(data[j]["month" + targetCompletionRate.month+"sales"]);
						array1[2].push(data[j]["month" + targetCompletionRate.month+"estimatesales"]);
						array1[3].push(data[j]["month" + targetCompletionRate.month+"percent"]);
						array1[4].push(data[j]["quarter"+Math.ceil(parseInt(targetCompletionRate.month)*1/3)] );
						array1[5].push(data[j]["quarter"+Math.ceil(parseInt(targetCompletionRate.month)*1/3)+"sales"]);
						array1[6].push(data[j]["quarter"+Math.ceil(parseInt(targetCompletionRate.month)*1/3)+"estimatesales"]);
						array1[7].push(data[j]["quarter"+Math.ceil(parseInt(targetCompletionRate.month)*1/3)+"percent"]);
					}
					for(var i=0;i<title.length;i++){
						var series = {};
						if(i == 3 || i==7){
							series = { name: title[i],type: 'spline',yAxis: 1,data: array1[i],tooltip: {valueSuffix: '%'}};
						}else{
							series = {name: title[i],type: 'column',data:array1[i],tooltip: {valueSuffix: '' }};
						}
						targetCompletionRate.chart.addSeries(series);
					}
					targetCompletionRate.chart.xAxis[0].setCategories(categories,true);
					targetCompletionRate.chart.redraw();//重新渲染数据
				}
			}
		});
		targetCompletionRate.chart.hideLoading();
	}
	,gridData:function(platform){
		$(".ui-jqgrid-title").text("各平台"+ targetCompletionRate.month +"月份业绩目标及完成率");
		var url = contextPath + '/report/targetcompletioncrate/grid?month=' + targetCompletionRate.month;
		if(platform != null && $("#" + platform).val() != "all"){
			url = url + "&platform=" + $("#" + platform).val();
		}
		$('#list2').jqGrid('clearGridData');
		$('#list2').jqGrid('setGridParam', {url: url}).trigger('reloadGrid');
	}
	,refreshData:function(platform){  //重
		targetCompletionRate.loadData(platform);
		targetCompletionRate.gridData(platform);
	}
	,exportData:function(){
		var fileName ="各平台"+ targetCompletionRate.month +"月份业绩目标及完成率" + new Date().getTime() + ".csv";
		var title = ['平台名称', '报表时间', '业绩目标', '销售额', '预计销售额','预计百分比', '季度业绩目标' , '季度销售额', '季度预计销售额', '季度预计百分比']
		var tableData;
		$.ajax({
			url : contextPath + '/report/targetcompletioncrate/grid?month=1',
			cache : false,
			type:"get",
			async: false,
			success : function(data) {
				if(data != null && data.rows.length > 0){
					tableData = data.rows;
				}
			}
		});
		var cloumn = ['name','reportDate1','performanceTarget','monthSales','estimatedSales','estimatedPercent','quarterlySalesTarget','quarterlySales','quarterlyEstimatedSales','quarterlyEstimatedPercent'];
		exportDataToCSV('#list2',title,tableData,fileName,cloumn);
	}
};
(function(){
	$(document).on("change",'#month',function(){
		targetCompletionRate.month = $(this).val();
	});
	$.ajax({
		url : contextPath + "/report/targetcompletioncrate/platform",
		cache : false,
		type:"get",
		async: false,
		success : function(data) {
			if(data != null && data.length > 0){
				//生成平台下拉框数据
				$("#form select[name='platform']").append("<option value='all'>全部</option>");
				for(var i=0;i<data.length;i++){
					$("#form select[name='platform']").append("<option value='"+ data[i] +"'>"+ data[i] +"</option>");
				}
			}
		}
	});
	targetCompletionRate.chart.title.textSetter('各平台'+ targetCompletionRate.month +'月份业绩目标及完成率');
	targetCompletionRate.loadData(null);
	// 创建jqGrid组件
	jQuery("#list2").jqGrid({
				url : contextPath + '/report/targetcompletioncrate/grid?month=1',//组件创建完成之后请求数据的url
				datatype : "json",//请求数据返回的类型。可选json,xml,txt
				//colNames : [ '平台名称', '报表时间', targetCompletionRate.month+'月份业绩目标', targetCompletionRate.month+'月份销售额', targetCompletionRate.month+'月份预计销售额',targetCompletionRate.month+'月份预计百分比', targetCompletionRate.month+'季度业绩目标' , targetCompletionRate.month+'季度销售额', targetCompletionRate.month+'季度预计销售额', targetCompletionRate.month+'季度预计百分比'],//jqGrid的列显示名字
				colNames : [ '平台名称', '报表时间', '业绩目标', '销售额', '预计销售额','预计百分比', '季度业绩目标' , '季度销售额', '季度预计销售额', '季度预计百分比'],
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
				rowNum : 10,//一页显示多少条
				rowList : [ 10, 30, 50 ],//可供用户选择一页显示多少条
				pager : '#pager2',//表格页脚的占位符(一般是div)的id
				sortname : 'name',//初始化的时候排序的字段
				sortorder : "asc",//排序方式,可选desc,asc
				mtype : "get",//向后台请求数据的ajax的类型。可选post,get
				viewrecords : true,
				//height:"200px",
				//caption : "各平台1月份业绩目标及完成率"//表格的标题名字
			});
	/*创建jqGrid的操作按钮容器*/
	/*可以控制界面上增删改查的按钮是否显示*/
	jQuery("#list2").jqGrid('navGrid', '#pager2', {edit : false,add : false,del : false,search:false});
})();