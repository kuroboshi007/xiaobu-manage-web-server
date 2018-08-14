function login(){

    //询问框

    layer.confirm('你想登录吗？你真的想登录吗？你确定你想登录吗？', {
        btn: ['我真的很想登录','我一点都不想登录'] //按钮
    }, function(){
        layer.msg('做梦吧', {icon: 2});
    }, function(){
        layer.msg('对，乖！', {
            time: 20000, //20s后自动关闭
            btn: ['无耻', '不要脸']
        });
    });
}
document.onkeyup = function(event){
	
    var e = event || window.event || arguments.callee.caller.arguments[0];
              
    if(e && e.keyCode==13){

    	
    	login();
    }
};