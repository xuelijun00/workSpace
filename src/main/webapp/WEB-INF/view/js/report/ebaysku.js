$(function () {
	
  
	// 创建jqGrid组件
	jQuery("#list_sku").jqGrid(
			{
				url : contextPath + '/report/ebaydomesticsku/grid',//组件创建完成之后请求数据的url
				datatype : "json",//请求数据返回的类型。可选json,xml,txt
				colNames : [  'sku', '原始sku', '日期（day）', '订单数' ,'数量' ,'订单金额_美元'],//jqGrid的列显示名字
				colModel : [ //jqGrid每一列的配置信息。包括名字，索引，宽度,对齐方式.....
				             {name : 'sku',index : 'sku',width : 255}, 
				             {name : 'skuOld',index : 'skuOld',width : 205}, 
				             {name : 'reportDate1',index : 'reportDate1',align : "right",width : 205}, 
				             {name : 'orders',index : 'orders',sortable : "true",width : 205},
				             {name : 'quantity',index : 'quantity',sortable : "true",width : 205},
				             {name : 'sales',index : 'sales',sortable : "true",width : 205}
				           ],
				rowNum : 20,//一页显示多少条
				rowList : [ 10, 20, 30 ],//可供用户选择一页显示多少条
				pager : '#pager_sku',//表格页脚的占位符(一般是div)的id
				sortname : 'reportDate1',//初始化的时候排序的字段
				sortorder : "desc",//排序方式,可选desc,asc
				height  : "450",
				mtype : "get",//向后台请求数据的ajax的类型。可选post,get
				viewrecords : true,
				//height:"200px"
				//caption : "JSON Example"//表格的标题名字
			});
	/*创建jqGrid的操作按钮容器*/
	/*可以控制界面上增删改查的按钮是否显示*/
	jQuery("#list_sku").jqGrid('navGrid', '#pager_sku', {edit : false,add : false,del : false});
	
});