var common = {
		testFun:function(a,b,c){
			debugger;
		},
		chart:function(operation){
			var chart1 = new Highcharts.Chart('container',{
				credits:{enabled:false},//去除版权信息
				exporting:{enabled:false},
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
		echartsOption :function (operation){
			var common1 = common;
			var legenddata = [];
			for(var i=0;i<operation.series.length;i++){
				legenddata.push(operation.series[i].name);
			}
			var option = {
				tooltip: {
			        trigger: 'axis',
			        formatter: function(params, ticket, callback) {
			            var res = params[0].name;
			            for (var i = 0, l = params.length; i < l; i++) {
			                if (params[i].seriesType === 'line') {
			                	if(params[i].seriesName == '环比增长率（美元）' || params[i].seriesName == '税后综合利润率(百分比)'){
				                    res += '<br/>' + params[i].seriesName + ' : ' + (params[i].value ? params[i].value.toFixed(2) +'%': '-');
			                	}else{
				                	res += '<br/>' + params[i].seriesName + ' : ' + (params[i].value ? params[i].value : '-');
				                }  
			                } else{
			                	res += '<br/>' + params[i].seriesName + ' : ' + (params[i].value ? params[i].value : '-');
			                }
			            }
			            return res;
			        }
				},
				grid: {
			        containLabel: true
			    },
			    legend: {
			        data: legenddata
			    },
			    toolbox: {
			        feature: {
			            dataView: {show: true, readOnly: false},
			            magicType: {show: true, type: ['line', 'bar']},
			            restore: {show: true},
			            saveAsImage: {show: true}
			        }
			    }
			    ,dataZoom: [{
			        type: 'slider',
			        xAxisIndex: 0,
			        filterMode: 'empty',
			        startValue: 0,
			        endValue: 100
			    }, {
			        type: 'slider',
			        yAxisIndex: 0,
			        left: '3%',
			        filterMode: 'empty',
			        start: 0,
			        end: 100
			    }, {
			        type: 'slider',
			        yAxisIndex: 1,
			        left: '94%',
			        filterMode: 'empty',
			        start: 0,
			        end: 100
			    }, {
			        type: 'inside',
			        xAxisIndex: 0,
			        filterMode: 'empty',
			        start: 0,
			        end: 100
			    }, {
			        type: 'inside',
			        yAxisIndex: 0,
			        filterMode: 'empty',
			        start: 0,
			        end: 100
			    }, {
			        type: 'inside',
			        yAxisIndex: 1,
			        filterMode: 'empty',
			        start: 0,
			        end: 100
			    }]
			   /* ,color:['#c23531','#2f4554', '#61a0a8', '#d48265', '#91c7ae','#749f83', '#FF6E97','#212122', '#546570', '#c4ccd3']*/
			    ,color: common.selectColors(operation)
			    ,xAxis: [
			        {
			            type: 'category',
			            data: operation.categories,
			            axisLine: { onZero: common.axisLine(operation)},
			            axisPointer: {
			                type: 'shadow'
			            }
			        }
			    ],
			    yAxis: operation.y,
			    series: operation.series,
			};
			return option;
		},
		/*自定义（图形的onZero的显示方式）*/
		axisLine:function(operation){
			if(operation.series[0].customOnZero === 1){
				return true;
			}else{
				return false;
			}
		},
		
		/*自己定义的（颜色）*/
		selectColors:function(operation){
			var colors =[];
			if(operation.series[0].customColors === 1){
				colors=['#7BB5EC','#434343', '#c23531', '#d48265', '#61a0a8','#749f83', '#FF6E97','#212122', '#546570', '#c4ccd3'];
			}else{
				colors=['#434343','#7BB5EC', '#c23531', '#d48265', '#61a0a8','#749f83', '#FF6E97','#212122', '#546570', '#c4ccd3'];
			}
			return colors;
		},
		echarts:function(operation){
			var chart = echarts.init(document.getElementById('container'));
			var option = common.echartsOption(operation);
			chart.setOption(option);
			return chart;
		},
		grid:function(opation){
			$(opation.id?opation.id:"#list2").jqGrid({
				url : opation.url,//组件创建完成之后请求数据的url
				datatype : "json",//请求数据返回的类型。可选json,xml,txt
				colNames : opation.colNames,
				colModel : opation.colModel,
				rowNum : opation.rowNum,//一页显示多少条
				rowList : [20, 60, 100 ],//可供用户选择一页显示多少条
				pager: opation.pager?opation.pager:"#pager2",//表格页脚的占位符(一般是div)的id
				sortname : opation.sortname,//初始化的时候排序的字段
				sortorder : opation.sortorder,//排序方式,可选desc,asc
				mtype : "get",//向后台请求数据的ajax的类型。可选post,get
				viewrecords : true,
				shrinkToFit:!opation.shrinkToFit?true:false,
                autoScroll: !opation.autoScroll?true:false,
				caption : opation.title,//表格的标题名字
				height : opation.height?opation.height:"520px",//表格的大小
				footerrow : opation.footerrow?true:false,
				userDataOnFooter:opation.userDataOnFooter?true:false,
				gridComplete:opation.gridComplete?opation.gridComplete:null,
			});
			/*创建jqGrid的操作按钮容器*/
			/*可以控制界面上增删改查的按钮是否显示*/
			$(opation.id?opation.id:"#list2").setGridWidth(document.body.clientWidth*0.94);
			jQuery(opation.id?opation.id:"#list2").jqGrid('navGrid', opation.pager?opation.pager:"#pager2", {edit : false,add : false,del : false,search:false});
			//$(".ui-jqgrid-bdiv").css("overflow-x","hidden");
			$(".ui-jqgrid-bdiv").width($(".ui-jqgrid-bdiv").width() + 3);
		}
		,refreshData:function(gridUrl,chart,operation){
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
			//$(".ui-jqgrid-bdiv").css("overflow-x","hidden");
			$(".ui-jqgrid-bdiv").width($(".ui-jqgrid-bdiv").width() + 3);
		}
		,refreshData1:function(gridUrl,chart,operation){
			if(chart){
				var option = common.echartsOption(operation);
				chart.setOption(option);
			}
			$('#list2').jqGrid('clearGridData');
			$('#list2').jqGrid('setGridParam', {url: gridUrl}).trigger('reloadGrid');
			//$(".ui-jqgrid-bdiv").css("overflow-x","hidden");
			$(".ui-jqgrid-bdiv").width($(".ui-jqgrid-bdiv").width() + 3);
		},
};

$(function(){
    $(window).resize(function(){
    	try{$("#list2").setGridWidth(document.body.clientWidth*0.94);}catch(e){}
    });
    $(window).resize(function(){
    	try{$("#list1").setGridWidth(document.body.clientWidth*0.94);}catch(e){}
    });
});
