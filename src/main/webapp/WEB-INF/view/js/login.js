(function(){
	$('#login-button').click(function(event) {
		$.ajax({  
            type:'POST',  
            url:contextPath + '/login',  
            async: false ,  
            dataType:'json',
            data:$(".form").serializeArray(),
            success:function(data){
            	$("#error").text("");
            	if(data.status !== 200){
                    $("#error").text(data.message);
            	}else{
            		window.location.href = contextPath + '/index';
            	}
            }  
        });  
	});
	$("[name='password']").keydown(function() {
		 if (event.keyCode == "13") {//keyCode=13是回车键
			 $('#login-button').click();
		 }
	});
})();
