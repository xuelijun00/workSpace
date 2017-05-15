$(function () {
	
	
	    var st = $('#start_date').val();
	    var et = $('#end_date').val();
	    var url = contextPath + '/report/dailysales/grid?st=' + st + "&et=" + et+ "&business=a_ll";
	$.ajax({
		url : url,
		success : function(data) {
			
			  var rpdate = [];
			  var salerp = [];
			  var orderrp = [];
             

              for(var i=0;i<data.length;i++){
            	  rpdate.push(data[i].reportDate1);
            	  salerp.push(data[i].sales);
            	  orderrp.push(data[i].orders);
              }
			 $('#container').highcharts({
			        chart: {
			            zoomType: 'xy'
			        },
			        title: {
			            text: '	销售业绩报表'
			        },
			        subtitle: {
			            text: '数据来源:'
			        },
			        xAxis: [{
			        	categories: rpdate,
			            crosshair: true
			        }],
			        yAxis: [{ // Primary yAxis
			            labels: {
			                format: '{value}',
			                style: {
			                    color: Highcharts.getOptions().colors[1]
			                }
			            },
			            title: {
			                text: '订单数',
			                style: {
			                    color: Highcharts.getOptions().colors[1]
			                }
			            }
			        }, { // Secondary yAxis
			            title: {
			                text: '销售额',
			                style: {
			                    color: Highcharts.getOptions().colors[0]
			                }
			            },
			            labels: {
			                format: '{value} ',
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
			            layout: 'vertical',
			            align: 'left',
			            x: 120,
			            verticalAlign: 'top',
			            y: 10,
			            floating: true,
			            backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'
			        },
			        series: [{
			            name: '销售额',
			            type: 'column',
			            yAxis: 1,
			            data: 
			            	salerp,
			            tooltip: {
			                valueSuffix: ' '
			            }
			        }, {
			            name: '订单数',
			            type: 'spline',
			            data: orderrp,
			            tooltip: {
			                valueSuffix: ''
			            }
			        }]
			    });
		}
	})
   
	// 创建jqGrid组件
	jQuery("#list2").jqGrid(
			{
				url : contextPath + '/report/dailysales/grid?business=a_ll',//组件创建完成之后请求数据的url
				datatype : "json",//请求数据返回的类型。可选json,xml,txt
				colNames : [ '报表时间', '平台名称', '销售额', '订单数'],//jqGrid的列显示名字
				colModel : [ //jqGrid每一列的配置信息。包括名字，索引，宽度,对齐方式.....
				             {name : 'reportDate1',index : 'reportDate1',width : 255}, 
				             {name : 'business',index : 'business',width : 205}, 
				             {name : 'sales',index : 'sales',align : "right",width : 205}, 
				             {name : 'orders',index : 'orders',sortable : "true",width : 205}
				           ],
				rowNum : 20,//一页显示多少条
				rowList : [ 10, 20, 30 ],//可供用户选择一页显示多少条
				pager : '#pager2',//表格页脚的占位符(一般是div)的id
				sortname : 'reportDate1',//初始化的时候排序的字段
				sortorder : "asc",//排序方式,可选desc,asc
				height  : "300",
				mtype : "get",//向后台请求数据的ajax的类型。可选post,get
				viewrecords : true,
				//height:"200px"
				//caption : "JSON Example"//表格的标题名字
			});
	/*创建jqGrid的操作按钮容器*/
	/*可以控制界面上增删改查的按钮是否显示*/
	jQuery("#list2").jqGrid('navGrid', '#pager2', {edit : false,add : false,del : false});
	
});
function refreshGridData(){
	var st = $('#start_date').val();
	var et = $('#end_date').val();
	var url = contextPath + '/report/dailysales/grid?st=' + st + "&et=" + et+ "&business=a_ll";
	$('#list2').jqGrid('clearGridData');
	$('#list2').jqGrid('setGridParam', {url: url}).trigger('reloadGrid');
	
	$.ajax({
		url : url,
		success : function(data) {
			  var rpdate = [];
			  var salerp = [];
			  var orderrp = [];
            
              for(var i=0;i<data.length;i++){
            	  rpdate.push(data[i].reportDate1);
            	  salerp.push(data[i].sales);
            	  orderrp.push(data[i].orders);
              }
			 $('#container').highcharts({
			        chart: {
			            zoomType: 'xy'
			        },
			        title: {
			            text: '	销售业绩报表'
			        },
			        subtitle: {
			            text: '数据来源:'
			        },
			        xAxis: [{
			        	categories: rpdate,
			            crosshair: true
			        }],
			        yAxis: [{ // Primary yAxis
			            labels: {
			                format: '{value}',
			                style: {
			                    color: Highcharts.getOptions().colors[1]
			                }
			            },
			            title: {
			                text: '订单数',
			                style: {
			                    color: Highcharts.getOptions().colors[1]
			                }
			            }
			        }, { // Secondary yAxis
			            title: {
			                text: '销售额',
			                style: {
			                    color: Highcharts.getOptions().colors[0]
			                }
			            },
			            labels: {
			                format: '{value} ',
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
			            layout: 'vertical',
			            align: 'left',
			            x: 120,
			            verticalAlign: 'top',
			            y: 10,
			            floating: true,
			            backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'
			        },
			        series: [{
			            name: '销售额',
			            type: 'column',
			            yAxis: 1,
			            data: 
			            	salerp,
			            tooltip: {
			                valueSuffix: ' '
			            }
			        }, {
			            name: '订单数',
			            type: 'spline',
			            data: orderrp,
			            tooltip: {
			                valueSuffix: ''
			            }
			        }]
			    });
		}
	})	
}