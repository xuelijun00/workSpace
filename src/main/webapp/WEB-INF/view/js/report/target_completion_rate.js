var targetCompletionRate = {
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
			        name: '销售额',
			        min: 0,
			        position: 'left',
			        axisLabel: {
			            formatter: '{value} '
			        }
			    }, {
			        type: 'value',
			        name: '预计百分比',
			        min: 0,
			        position: 'right',
			        axisLabel: {
			            formatter: '{value} '
			        }
			    }],
			    series: operation.series
		};
		return option;
	},
	loadData:function(platform){
		var url = contextPath + '/report/targetcompletioncrate/histogram?month=' + $("#month").val();
		if(platform != null && $("#" + platform).val() != "all"){
			url = url + "&platform=" + $("#" + platform).val();
		}
		$.ajax({
			url : url,
			cache : false,
			type:"get",
			success : function(data) {
				if(data && data != null && data.length > 0){
					var title = [targetCompletionRate.month + '月份业绩目标'
								 ,targetCompletionRate.month+'月份销售额'
					             ,targetCompletionRate.month+'月份预计销售额'
					             ,targetCompletionRate.month+'月份业绩完成率'
					            /*,Math.ceil(parseInt(targetCompletionRate.month)*1/3)+'季度业绩目标'
					             ,Math.ceil(parseInt(targetCompletionRate.month)*1/3)+'季度销售额'*/ 
					             ,targetCompletionRate.month+'月份实际净利'
					             /*,Math.ceil(parseInt(targetCompletionRate.month)*1/3)+'季度预计百分比'*/
					             ,targetCompletionRate.month+'月份目标净利'
					             ,targetCompletionRate.month+'月份净利完成率'];
					var array1 = [[],[],[],[],[],[],[]/*,[],[],[]*/];
					var platformArray = [];
					for(var j=0;j<data.length;j++){
						array1[0].push(data[j].performanceTargets);            //业绩目标
						array1[1].push(data[j].sales);                         //销售额
						array1[2].push(data[j].estimatedSales);                //预计销售额
						array1[3].push(data[j].estimatedPercentage);           //业绩完成率（原来是 预计百分比）
						/*array1[4].push(data[j].quarterlyPerformanceTargets);   //季度业绩目标
						array1[5].push(data[j].quarterlySales);                //季度销售额	
*/						array1[4].push(data[j].actualProfit);                  //实际利润
						/*array1[7].push(data[j].quarterlyEstimatedPercentage);  //季度预计百分比
*/						array1[5].push(data[j].targetProfit);                  //实际是目标净利
						array1[6].push(data[j].netProfitCompletionRate);       //净利完成率
						
						/*configplatformgoal_new表中的platform为匹配被特殊使用，
						 * 在实际页面报表中的“平台名称”是configplatformgoal_new表中的name，
						 * 所以这里用data[j].name
						*/
						platformArray.push(data[j].name);                      					
						}
					targetCompletionRate.categories = platformArray;
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
								title:{text:'各平台'+ targetCompletionRate.month +'月份业绩目标及完成率'}
								,categories:platformArray
								,series:seriess
							}
					var opa = targetCompletionRate.getOpation(op);
					targetCompletionRate.chart(opa);
				}
			}
		});
	}
	,gridData:function(platform){
		/*$(".ui-jqgrid-title").text("各平台"+ targetCompletionRate.month +"月份业绩目标及完成率");*/
		var url = contextPath + '/report/targetcompletioncrate/grid?month=' + $("#month").val();
		if(platform != null && $("#" + platform).val() != "all"){
			url = url + "&platform=" + $("#" + platform).val();
		}
		$('#list2').jqGrid('clearGridData');
		$('#list2').jqGrid('setGridParam', {url: url}).trigger('reloadGrid');
	}
	,refreshData:function(platform){  //重
		targetCompletionRate.loadData(platform);
		targetCompletionRate.gridData(platform);
		$(".ui-jqgrid-bdiv").css("overflow-x","hidden");
		$(".ui-jqgrid-bdiv").width($(".ui-jqgrid-bdiv").width() + 3);
	}
	,exportData:function(){
		var fileName ="各平台"+ targetCompletionRate.month +"月份业绩目标及完成率" + new Date().getTime() + ".csv";
		var title = ['平台名称', '报表时间', '业绩目标', '销售额', '预计销售额','业绩完成率'
		             , /*'季度业绩目标' , '季度销售额', '季度预计百分比',*/ '实际净利'
		             , '目标净利', '净利完成率']
		var tableData;
		var platform = $("#platform").val();
		url = contextPath + '/report/targetcompletioncrate/grid?month=' + $("#month").val();
		if(platform != null && platform != "all"){
			url = url + "&platform=" + platform;
		}
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
		var cloumn = ['name','reportDate','performanceTargets','sales','estimatedSales','estimatedPercentage'
		              ,/*'quarterlyPerformanceTargets','quarterlySales','quarterlyEstimatedPercentage',*/'actualProfit'
		              ,'targetProfit','netProfitCompletionRate'];
		exportDataToCSV('#list2',title,tableData,fileName,cloumn);
	}
};
(function(){
	$("#month").jeDate({
        isinitVal: true,
        isTime:false,
        ishmsVal: false,
        format: "YYYY-MM",
        zIndex:3000,
        isClear:false,
        choosefun:function(val) {
        	targetCompletionRate.month = new Date($("#month").val()).getMonth() + 1;
        },
        okfun:function(val) {
        	targetCompletionRate.month = new Date($("#month").val()).getMonth() + 1;
        }
    });
	$.ajax({
		url : contextPath + "/report/targetcompletioncrate/platform",
		cache : false,
		type:"get",
		async: false,
		success : function(data) {
			if(data != null && data.length > 0){
				$("#platform").append("<option value='all'>全部</option>");
				for(var i=0;i<data.length;i++){
					$("#platform").append("<option value='"+ data[i] +"'>"+ data[i] +"</option>");
				}
			}
		}
	});
	targetCompletionRate.loadData(null);
	// 创建jqGrid组件
	jQuery("#list2").jqGrid({
				caption:"各平台"+ targetCompletionRate.month +"月份业绩目标及完成率",
				url : contextPath + '/report/targetcompletioncrate/grid?month=' + $("#month").val(),//组件创建完成之后请求数据的url
				datatype : "json",//请求数据返回的类型。可选json,xml,txt
				colNames : [ '平台名称', '报表时间', '业绩目标', '销售额', '预计销售额','业绩完成率', /*'季度业绩目标' , '季度销售额', '季度预计百分比', */'实际净利', '目标净利','净利完成率'],
				colModel : [ //jqGrid每一列的配置信息。包括名字，索引，宽度,对齐方式.....
				             {name : 'name',index : 'name',width : 185}, 
				             {name : 'reportDate',index : 'reportDate',width : 135,formatter:function(val){return new Date(val).toLocaleDateString();}}, 
				             {name : 'performanceTargets',index : 'performanceTargets',width : 135,formatter:'integer', formatoptions:{thousandsSeparator: ',',decimalPlaces:2},align:"right"}, 
				             {name : 'sales',index : 'sales',width : 135,formatter:'integer', formatoptions:{thousandsSeparator: ',',decimalPlaces:2},align:"right"}, 
				             {name : 'estimatedSales',index : 'estimatedSales',width : 135,formatter:'integer', formatoptions:{thousandsSeparator: ',',decimalPlaces:2},align:"right"}, 
				             {name : 'estimatedPercentage',index : 'estimatedPercentage',width : 135,formatter:'integer', formatoptions:{decimalPlaces:2},align:"right"} ,
				             /*{name : 'quarterlyPerformanceTargets',index : 'quarterlyPerformanceTargets',width : 105,formatter:'integer', formatoptions:{thousandsSeparator: ',',decimalPlaces:2},align:"right"} ,
				             {name : 'quarterlySales',index : 'quarterlySales',width : 105,formatter:'integer', formatoptions:{thousandsSeparator: ',',decimalPlaces:2},align:"right"} ,
				             {name : 'quarterlyEstimatedPercentage',index : 'quarterlyEstimatedPercentage',width : 105,formatter:'integer', formatoptions:{decimalPlaces:2},align:"right"},*/
				             {name : 'actualProfit',index : 'actualProfit',width : 135,formatter:'integer', formatoptions:{thousandsSeparator: ',',decimalPlaces:2},align:"right"} ,
				             {name : 'targetProfit',index : 'targetProfit',width : 135,formatter:'integer', formatoptions:{thousandsSeparator: ',',decimalPlaces:2},align:"right"} ,
				             {name : 'netProfitCompletionRate',index : 'netProfitCompletionRate',width : 135,formatter:'integer', formatoptions:{thousandsSeparator: ',',decimalPlaces:2},align:"right"} ,
				           ],
				rowNum : 20,//一页显示多少条
				rowList : [ 20, 40, 50 ],//可供用户选择一页显示多少条
				pager : '#pager2',//表格页脚的占位符(一般是div)的id
				sortname : 'reportDate',//初始化的时候排序的字段
				sortorder : "desc",//排序方式,可选desc,asc
				mtype : "get",//向后台请求数据的ajax的类型。可选post,get
				viewrecords : true,
				height:"450px",
				//caption : "各平台1月份业绩目标及完成率"//表格的标题名字
			});
	/*创建jqGrid的操作按钮容器*/
	/*可以控制界面上增删改查的按钮是否显示*/
	jQuery("#list2").jqGrid('navGrid', '#pager2', {edit : false,add : false,del : false,search:false});
})();