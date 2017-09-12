var targetCompletionRateCommon = {
	month:new Date().getMonth() + 1,
	categories:[],
	chart:function(option){
		var chart = echarts.init(document.getElementById('container'));
		chart.setOption(option);
		return chart;
	},
	getOpation:function(operation){
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
			                    res += '<br/>' + params[i].seriesName + ' : ' + (params[i].value ? params[i].value : '-');
			                } else {
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
			        start: 0,
			        end: 100
			    }, {
			        type: 'slider',
			        yAxisIndex: 0,
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
			    }] 
			    ,color:['#c23531','#2f4554', '#61a0a8', '#d48265', '#91c7ae','#749f83', '#FF6E97','#212122', '#546570', '#c4ccd3']
			    ,xAxis: [
			        {
			            type: 'category',
			            data: operation.categories,
			            axisLine: { onZero: false },
			            axisPointer: {
			                type: 'shadow'
			            }
			        }
			    ],
			    yAxis: [{
			        type: 'value',
			        name: '刻度',
			        /*min: 0,*/
			        position: 'left',
			        axisLabel: {
			            formatter: '{value} '
			        }
			    }, {
			        type: 'value',
			        name: '率',
			        /*min: 0,*/
			        position: 'right',
			        axisLabel: {
			            formatter: '{value} '
			        }
			    }],
			    series: operation.series
		};
		return option;
	},
	loadData:function(urlChart){
		$.ajax({
			url : urlChart,
			cache : false,
			type:"get",
			success : function(data) {
				if(data && data != null && data.length > 0){
					var title = ['业绩目标', '销售额', '预计销售额', '业绩完成率', '实际净利', '目标净利', '净利完成率'];
					var array1 = [[],[],[],[],[],[],[],[]];
					var platformArray = [];
					for(var j=0;j<data.length;j++){
						array1[0].push(data[j].performanceTargets);            //业绩目标
						array1[1].push(data[j].sales);                         //销售额
						array1[2].push(data[j].estimatedSales);                //预计销售额
						array1[3].push(data[j].salesPercentage);               //业绩完成率
						array1[4].push(data[j].actualProfit);                  //实际利润
						array1[5].push(data[j].targetProfit);                  //实际是目标净利
						array1[6].push(data[j].netProfitCompletionRate);       //净利完成率
						
						/*configplatformgoal_new表中的platform为匹配被特殊使用，
						 * 在实际页面报表中的“平台名称”是configplatformgoal_new表中的name，
						 * 所以这里用data[j].name
						*/
						platformArray.push(data[j].name + '\n' + data[j].reportMonth);                      					
						}
					targetCompletionRateCommon.categories = platformArray;
					var seriess = [];
					for(var i=0;i<title.length;i++){
						var series = {};
						if(i == 3 || i==6){
							series = {name: title[i],type: 'line',yAxisIndex: 1,data:array1[i],tooltip: {valueSuffix: '' }};
						}else{
							series = {name: title[i],type: 'bar',data:array1[i],tooltip: {valueSuffix: '' }};
						}
						seriess.push(series);
					}
					var op = {
								/*title:{text:'各平台'+ targetCompletionRateCommon.month +'月份业绩目标及完成率'}
								,*/categories:platformArray
								,series:seriess
							}
					var opa = targetCompletionRateCommon.getOpation(op);
					targetCompletionRateCommon.chart(opa);
				}
			}
		});
	}
	,gridData:function(gridUrl){
		/*$(".ui-jqgrid-title").text("各平台"+ targetCompletionRate.month +"月份业绩目标及完成率");*/
		$('#list2').jqGrid('clearGridData');
		$('#list2').jqGrid('setGridParam', {url: gridUrl}).trigger('reloadGrid');
		$(".ui-jqgrid-bdiv").width($(".ui-jqgrid-bdiv").width() + 3);
	}
	,refreshData:function(gridUrl,chartUrl){  //重
		targetCompletionRateCommon.loadData(chartUrl);
		targetCompletionRateCommon.gridData(gridUrl);
	}
	,exportData:function(url, name){
		var startMonth = $("#startMonth").val();
		var endMonth = $("#endMonth").val();
		var fileName = name+ startMonth + '-' + endMonth +"月份业绩目标及完成率 "+ new Date().toLocaleDateString() + ".csv";
		var title = [ '平台名称', '月份', '业绩目标', '预计业绩完成率', '销售额', '预计销售额','业绩完成率', '实际净利', '目标净利', '报表时间','净利完成率'];
		var tableData;
		$.ajax({
			url : url,
			cache : false,
			type:"get",
			async: false,
			success : function(data) {
				if(data != null && data.rows.length > 0){
					for(var i=0;i<data.rows.length;i++){
						data.rows[i].reportDate = new Date(data.rows[i].reportDate).toLocaleDateString();
					}
					tableData = data.rows;
				}
			}
		});
		var cloumn = ['name','reportMonth','performanceTargets','estimatedSalesPercentage','sales','estimatedSales','salesPercentage'
		              ,'actualProfit','targetProfit','reportDate','netProfitCompletionRate'];
		exportDataToCSV('#list2',title,tableData,fileName,cloumn);
	}
};
(function(){
	$("#startMonth").jeDate({
        isinitVal: true,
        initAddVal:{MM:"-1"},
        isTime:false,
        ishmsVal: false,
        format: "YYYY-MM",
        zIndex:3000,
        isClear:false,
        choosefun:function(val) {
        	targetCompletionRateCommon.month = new Date($("#startMonth").val()).getMonth() + 1;
        },
        okfun:function(val) {
        	targetCompletionRateCommon.month = new Date($("#startMonth").val()).getMonth() + 1;
        }
    });
	$("#endMonth").jeDate({
        isinitVal: true,
        isTime:false,
        ishmsVal: false,
        format: "YYYY-MM",
        zIndex:3000,
        isClear:false,
        choosefun:function(val) {
        	targetCompletionRateCommon.month = new Date($("#endMonth").val()).getMonth() + 1;
        },
        okfun:function(val) {
        	targetCompletionRateCommon.month = new Date($("#endMonth").val()).getMonth() + 1;
        }
    });
	targetCompletionRateCommon.loadData(test.getUrl());
	// 创建jqGrid组件
	jQuery("#list2").jqGrid({
				caption:test.BUSINESS + "各月业绩目标及完成率",
				url : test.getUrl(1),//组件创建完成之后请求数据的url
				datatype : "json",//请求数据返回的类型。可选json,xml,txt
				colNames : [ '平台名称', '月份', '业绩目标', '预计业绩完成率', '销售额', '预计销售额','业绩完成率', '实际净利', '目标净利', '报表时间','净利完成率'],
				colModel : [ //jqGrid每一列的配置信息。包括名字，索引，宽度,对齐方式.....
				             {name : 'name',index : 'name',width : 155}, 
				             {name : 'reportMonth',index : 'reportMonth',width : 125}, 
				             {name : 'performanceTargets',index : 'performanceTargets',width : 125,formatter:'integer', formatoptions:{thousandsSeparator: ',',decimalPlaces:2},align:"right"}, 
				             {name : 'estimatedSalesPercentage',index : 'estimatedSalesPercentage',width : 135,formatter:'integer', formatoptions:{decimalPlaces:2},align:"right"} ,
				             {name : 'sales',index : 'sales',width : 125,formatter:'integer', formatoptions:{thousandsSeparator: ',',decimalPlaces:2},align:"right"}, 
				             {name : 'estimatedSales',index : 'estimatedSales',width : 125,formatter:'integer', formatoptions:{thousandsSeparator: ',',decimalPlaces:2},align:"right"}, 
				             {name : 'salesPercentage',index : 'salesPercentage',width : 115,formatter:'integer', formatoptions:{decimalPlaces:2},align:"right"} ,
				             {name : 'actualProfit',index : 'actualProfit',width : 125,formatter:'integer', formatoptions:{thousandsSeparator: ',',decimalPlaces:2},align:"right"} ,
				             {name : 'targetProfit',index : 'targetProfit',width : 125,formatter:'integer', formatoptions:{thousandsSeparator: ',',decimalPlaces:2},align:"right"} ,
				             {name : 'reportDate',index : 'reportDate',width : 125,formatter:function(val){return new Date(val).toLocaleDateString();}}, 
				             {name : 'netProfitCompletionRate',index : 'netProfitCompletionRate',width : 115,formatter:'integer', formatoptions:{thousandsSeparator: ',',decimalPlaces:2},align:"right"} ,
				           ],
				rowNum : 20,//一页显示多少条
				rowList : [ 20, 40, 50 ],//可供用户选择一页显示多少条
				pager : '#pager2',//表格页脚的占位符(一般是div)的id
				sortname : 'reportMonth',//初始化的时候排序的字段
				sortorder : "desc",//排序方式,可选desc,asc
				mtype : "get",//向后台请求数据的ajax的类型。可选post,get
				viewrecords : true,
				height:"450px",
				shrinkToFit : false,
				autoScroll : false,
				//caption : "各平台1月份业绩目标及完成率"//表格的标题名字
			});
	/*创建jqGrid的操作按钮容器*/
	/*可以控制界面上增删改查的按钮是否显示*/
	$("#list2").setGridWidth(document.body.clientWidth*0.94);
	jQuery("#list2").jqGrid('navGrid', '#pager2', {edit : false,add : false,del : false,search:false});
})();