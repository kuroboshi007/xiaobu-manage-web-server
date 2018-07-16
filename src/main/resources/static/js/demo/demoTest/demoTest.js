$(function(){
	// validate验证
	$('#demoTestForm').validate();
	
	// 日期
	$('.datepicker').datetimepicker({
		language: 'zh-CN',
		format: 'yyyy-mm-dd',
		autoclose: true,
		todayBtn: true,
		clearBtn:true,
		minView: 2
	}).on('changeDate', function(event){
		
		$('#demoTestForm').validate().element($(this));
	});
});

// 保存
function save(){

	saveByAjax('demoTestForm','/demoTest/save','/demoTest/init');
}