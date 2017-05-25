<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>YKSUI框架 - 需求管理</title>
</head>
<body class="gray-bg">


    <form class="form-inline" id="form1">
        <div class="modal-body">
            <div class="form-group">
	         <label>日期：</label>
	         <input type="text" id="date1"class="form-control" placeholder="">
	        </div>
            <table class="table table-bordered top20">
                <thead>
                <tr>
                    <th>平台</th>
                    <th>目标销售额</th>
                    <th>目标利润</th>
                    <th>实际销售额</th>
                    <th>实际利润</th>
                </tr>
                </thead>
                <tbody id="tbody">
                <tr class="tr">
                    <td><div class="form-group">
                        <select class="form-control platform" name="platform" data-placeholder="请选择" >
                        </select>
                        </div>
                    </td>
                    <td><input type="text" name="performanceTarget" class="form-control w80" placeholder=""></td>
                    <td><input type="text" name="targetprofit" class="form-control w80" placeholder=""></td>
                    <td><input type="text" name="monthSales" class="form-control w80" placeholder=""></td>
                    <td><input type="text" name="actualprofit" class="form-control w80" placeholder=""></td>
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
 
<%@include file="/WEB-INF/view/jsp/include/common.jsp" %>

<script type="text/javascript">
	$("#date1").jeDate({
        isinitVal: true,
        isTime:false,
        ishmsVal: false,
        format: "YYYY-MM",
        zIndex:3000
    });
	
	
</script>
</body>
</html>
