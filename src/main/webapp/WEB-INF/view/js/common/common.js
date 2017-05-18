var common = {
		chart:function(operation){
			var chart1 = new Highcharts.Chart('container',{
				credits:{enabled:false},//去除版权信息
			    chart: {zoomType: 'xy' },
			    title: operation.title,
			    xAxis: [{categories: operation.categories,crosshair: true,min:0, max:14,}],
			    yAxis: operation.y,
			    scrollbar: { enabled: true },//设置滚动条    
			    tooltip: {shared: true},
			    legend: {
			    	layout: 'horizontal',align: 'left',x: 120,verticalAlign: 'top',y: 25,floating: true,
			        backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'
			    },
			    //'1月份业绩目标', '1月份销售额', '1月份预计销售额','1月份预计百分比', '1季度业绩目标' , '1季度销售额', '1季度预计销售额', '1季度预计百分比'
			    series: operation.series
			});
			return chart1;
		},
		grid:function(opation){
			$(opation.id?opation.id:"#list2").jqGrid({
				url : opation.url,//组件创建完成之后请求数据的url
				datatype : "json",//请求数据返回的类型。可选json,xml,txt
				//colNames : [ '平台名称', '报表时间', targetCompletionRate.month+'月份业绩目标', targetCompletionRate.month+'月份销售额', targetCompletionRate.month+'月份预计销售额',targetCompletionRate.month+'月份预计百分比', targetCompletionRate.month+'季度业绩目标' , targetCompletionRate.month+'季度销售额', targetCompletionRate.month+'季度预计销售额', targetCompletionRate.month+'季度预计百分比'],//jqGrid的列显示名字
				colNames : opation.colNames,
				colModel : opation.colModel,
				rowNum : opation.rowNum,//一页显示多少条
				rowList : [20, 60, 100 ],//可供用户选择一页显示多少条
				pager: opation.pager?opation.pager:"#pager2",//表格页脚的占位符(一般是div)的id
				sortname : opation.sortname,//初始化的时候排序的字段
				sortorder : opation.sortorder,//排序方式,可选desc,asc
				mtype : "get",//向后台请求数据的ajax的类型。可选post,get
				viewrecords : true,
				caption : opation.title,//表格的标题名字
				height : opation.height//表格的大小
			});
			/*创建jqGrid的操作按钮容器*/
			/*可以控制界面上增删改查的按钮是否显示*/
			jQuery(opation.id?opation.id:"#list2").jqGrid('navGrid', opation.pager?opation.pager:"#pager2", {edit : false,add : false,del : false});
		},
		refreshData:function(gridUrl,chart,operation){
			if(chart != null && operation != null){
				while(chart.series.length > 0) {  
					chart.series[0].remove();  
	            }
				for(var i=0;i<operation.series.length;i++){
					chart.addSeries(operation.series[i]);
				}
				chart.xAxis[0].setCategories(operation.categories,true);
				chart.redraw();//重新渲染数据
			}
			$('#list2').jqGrid('clearGridData');
			$('#list2').jqGrid('setGridParam', {url: gridUrl}).trigger('reloadGrid');
		},
};