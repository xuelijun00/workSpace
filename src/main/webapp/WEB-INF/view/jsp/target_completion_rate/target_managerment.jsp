<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>YKSUI框架 - 需求管理</title>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="ibox-title"><h5>各平台目标管理</h5></div>
    <div class="ibox-content">
    <form class="form-inline">
       <div class="form-group">
          <label>月份：</label>
          <input type="text" id="date" class="form-control" placeholder="" readonly="readonly">
        </div>
        <!-- <div class="form-group">
            <button type="button" class="btn btn-primary add-space" id="query">查询</button>
        </div> -->
     </form>
     <div class="hr-line-dashed"></div>
	     <h2 class="text-center bottom20">各平台目标管理</h2>
	     <div class="mbottom"> <a href="###" data-toggle="modal" data-target="#addtarget">
	     <i class="fa fa-plus"></i>新增目标</a> 
	     <!--  <a href="javascript:void(0);" data-toggle="modal" data-target=".modifyreport" >修改</a> -->
     </div>
     <!-- <div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div> -->
	<div class="ibox-content">
		<table id="list2" class="tablegrid"></table>
		<div id="pager2"></div>
	</div>
     <!-- <div class="hr-line-dashed"></div> -->
     
</div>
</div>
<!-- 模态框弹窗  -->
<!-- Modal -->
<div class="modal fade" id="addtarget" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">新增目标</h4>
    </div>
    <form class="form-inline" id="form1">
        <div class="modal-body">
            <div class="form-group">
	          <label>月份：</label>
	          <input type="text" id="date1" class="form-control" placeholder="" readonly="readonly">
	        </div>
            <table class="table table-bordered top20">
                <thead>
                <tr>
                    <th>平台</th>
                    <th>目标销售额</th>
                    <th>目标利润</th>
                    <th>实际销售额</th>
                    <th>实际利润</th>
                    <th>净利目标</th>
                </tr>
                </thead>
                <tbody id="tbody">
                <tr class="tr">
                    <td><div class="form-group">
                        <select class="form-control platform" name="platform" data-placeholder="请选择" >
                        </select>
                        </div>
                    </td>
                    <td><input type="text" name="performanceTargets" class="form-control w80" placeholder=""></td>
                    <td><input type="text" name="targetProfit" class="form-control w80" placeholder=""></td>
                    <td><input type="text" name="sales" class="form-control w80" placeholder=""></td>
                    <td><input type="text" name="actualProfit" class="form-control w80" placeholder=""></td>
                    <td><input type="text" name="netProfitTarget" class="form-control w80" placeholder=""></td>
                </tr>
                </tbody>
            </table>
            <div class="mbottom"> <a href="javascript:void(0);" id="insertRecord"><i class="fa fa-plus"></i>新增</a>
            <a href="javascript:void(0);" id="deleteRecord"><i class="fa fa-plus"></i>删除</a></div>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-primary" data-dismiss="modal" id="inster">新增</button>
        </div>
    </form>
    </div>
  </div>
</div>

<%@include file="/WEB-INF/view/jsp/include/common.jsp" %>
<script type="text/javascript" src="js/plugins/layer/layer.js"></script>
<script type="text/javascript">

function Modify(platform)
{
	  layer.open({
          type: 2,
          title: '修改',
          maxmin: true,
          shadeClose: true, //点击遮罩关闭层
          area : ['780px' , '350px'],
         // content :contextPath +'/common?path=target_completion_rate/test'
           content: '<form class="form-inline" id="form1"><div class="form-group"><label>日期：</label>'+
	        ' <input type="text" id="date2" class="form-control" placeholder=""></div>'+
          '<table class="table table-bordered top20" style="width:700px;margin:0 auto;">'+
              '<thead><tr><th>平台</th><th>目标销售额</th><th>目标利润</th><th>实际销售额</th><th>实际利润</th>'+
             '</tr></thead>'+
              '<tbody id="tbody">'+
              '<tr class="tr">'+
                  '<td><div class="form-group">'+
                      '<select class="form-control platform" name="platform" data-placeholder="请选择" >'+
                      '</select>'+
                     ' </div>'+
                 ' </td>'+
                  '<td><input type="text" name="performanceTarget" class="form-control w80" placeholder=""></td>'+
                  '<td><input type="text" name="targetprofit" class="form-control w80" placeholder=""></td>'+
                  '<td><input type="text" name="monthSales" class="form-control w80" placeholder=""></td>'+
                  '<td><input type="text" name="actualprofit" class="form-control w80" placeholder=""></td>'+
             ' </tr>'+
              '</tbody>'+
         ' </table>'+   
      '<div class="modal-footer">'+
         ' <button type="button" class="btn btn-primary" data-dismiss="modal" id="inster">修改</button>'+
      '</div></form>' 
          });

	  
}

(function(){
	$("#date").jeDate({
        isinitVal: true,
        isTime:false,
        ishmsVal: false,
        format: "YYYY-MM",
        zIndex:3000,
        isClear:false,
        choosefun:function(val,month,b) {
        	common.refreshData(contextPath + "/report/targetcompletioncrate/grid?month=" + month);
        },
        okfun:function(val,date,b) {
        	common.refreshData(contextPath + "/report/targetcompletioncrate/grid?month=" + month);
        }
    });
	$("#date1").jeDate({
        isinitVal: true,
        isTime:false,
        ishmsVal: false,
        format: "YYYY-MM",
        zIndex:3000,
        isClear:false,
    });
	$.ajax({
		url : contextPath + "/report/targetcompletioncrate/platform",
		cache : false,
		type:"get",
		async: false,
		success : function(data) {
			if(data != null && data.length > 0){
				$(".platform").empty();
				for(var i=0;i<data.length;i++){
					$(".platform").append("<option value='"+ data[i] +"'>"+ data[i] +"</option>");
				}
			}
		}
	});
	$("#insertRecord").on("click",function(){
		$("#tbody tr:eq(0)").clone().prependTo("#tbody");
	});
	$("#deleteRecord").on("click",function(){
		var trs = $("#tbody tr");
		if(trs.length > 1){
			trs[trs.length - 1].remove();
		}
	});
	$("#myModalLabel").on("click",function(){
		var trs = $("#tbody tr");
		for (var i = 1; i < trs.length; i++) {
			trs[i].remove();
		}
	});
	common.grid({
		title:"各平台目标管理"
		,url:contextPath + "/report/targetcompletioncrate/grid?month=" + $("#date").val()
		,colNames:[ '月份', '平台名称','目标销售额', '实际销售额', '目标利润','实际利润','净利目标','净利完成率']  //
		,colModel:[ {name : 'reportMonth',index : 'reportMonth',width : 120}, 
		             {name : 'platform',index : 'platform',width : 120}, 
		             {name : 'performanceTargets',index : 'performanceTargets',width : 120,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"}, 
		             {name : 'sales',index : 'sales' ,width : 120,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		             {name : 'targetProfit',index : 'targetProfit',width : 120,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		             {name : 'actualProfit',index : 'actualProfit',width : 120,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		             {name : 'netProfitTarget',index : 'netProfitTarget',width : 120,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"},
		             {name : 'netProfitCompletionRate',index : 'netProfitCompletionRate',width : 120,formatter:'integer', formatoptions:{thousandsSeparator: ',', defaulValue:"",decimalPlaces:2},align:"right"}
		             /* {name:'Modify',index:'platform',width:80,align:"center",formatter:function(cellvalue, options, rowObject){
		            	 return "<a href='#' style='color:#f60'  onclick='Modify(\""+ rowObject.platform +"\")'>修改</a>";
		             },sortable:false} */
		             ],
		 sortname:"reportDate"
		,sortorder:"asc"
		,height:"520px"
	});
	
	$("#inster").on("click",function(){
		var month = $("#date1").val();
		var reg = /^\d+(\.\d+)?$/;
		var array = $("#form1").serializeArray();
		for(var i=0;i<array.length / 6;i++){
			if(reg.test(array[i*6+1].value.trim()) && reg.test(array[i*6+2].value.trim()) && reg.test(array[i*6+3].value.trim()) && reg.test(array[i*6+4].value.trim())){
				var record = {"platform":array[i*6].value,"performanceTargets":array[i*6+1].value,"targetProfit":array[i*6+2].value,"sales":array[i*6+3].value,"actualProfit":array[i*6+4].value,"netProfitTarget":array[i*6+5].value,"reportMonth":month};
				$.ajax({
					url : contextPath + "/report/targetcompletioncrate/update",
					cache : false,
					type:"POST",
					data:record,
					success : function(data) {}
				});
			}else{
				alert("第"+  (i+1) + "行有非法数字或者数据为空");
				return;
			}
		}
		common.refreshData(contextPath + "/report/targetcompletioncrate/grid?month=" + $("#date").val());
	});
})();
</script>
</body>
</html>
