function login(){
	
	$.ajax({
		type: 'post',
		url: '/login/checkUser',
		data: $('#loginForm').serialize(),
		dataType: 'json',
		success: function(data){
			
			if(data.success){
				
				window.location.href = '/index';
			} else {
				
				modalAlert(data.message);
			}
		}
	});
}
document.onkeyup = function(event){
	
    var e = event || window.event || arguments.callee.caller.arguments[0];
              
    if(e && e.keyCode==13){
    	
    	login();
    }
};