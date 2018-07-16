$(function(){
	// validate验证
	$('#sysDictionaryForm').validate();
});

// 新增
function addItem(){
	
	$('#childrenTable tbody').append($('#trTemplate tbody').html());
	
	resetTrNum('childrenTable');
}

// 删除
function removeItem(item){
	
	$(item).parent().parent().remove();
	
	resetTrNum('childrenTable');
}

// 保存
function save(){
	
	saveByAjax('sysDictionaryForm','/sysDictionary/save','/sysDictionary/init');
}