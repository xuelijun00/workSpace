$(function(){
	function thirdStep(){}
	$('#login-button').click(function(event) {
		$.ajax({  
            type:'POST',  
            url:contentPath + '/login',  
            async: false ,  
            dataType:'json',
            data:$(".form").serializeArray(),
            success:function(data){
            	$("#error").text("");
            	if(data.status === 200){
            		event.preventDefault();
            		$('form').fadeOut(500);
            		$('.wrapper').addClass('form-success');
            		setTimeout("thirdStep()", 5000);
            		window.location = contentPath + "/user/showView";
            	}else{
            		$("#error").text(data.message);
            	}
            }  
        });  
	});
	 $("body").keydown(function() {
         if (event.keyCode == "13") {//keyCode=13是回车键
             $('#login-button').click();
         }
     });
});