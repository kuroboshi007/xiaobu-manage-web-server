function modalAlert(message){
	
	var tplhtml = '<div class="modal fade" id="_modal_alert_div">'
		+ '<div class="modal-dialog">'
		+ '<div class="modal-content">'
		+ '<div class="modal-header">'
		+ '<button type="button" class="close" onclick="closeModal(\'_modal_alert_div\')">'
		+ '<span aria-hidden="true">&times;</span></button>'
        + '<h4 class="modal-title">提示信息</h4>'
        + '</div>'
        + '<div class="modal-body">'
        + '<p>' + message + '</p>'
        + '</div>'
        + '<div class="modal-footer">'
        + '<button type="button" class="btn btn-primary" onclick="closeModal(\'_modal_alert_div\')">确定</button>'
        + '</div>'
        + '</div>'
        + '</div>'
        + '</div>';
        
	$('body').append(tplhtml);
	
	$('#_modal_alert_div').on('hidden.bs.modal', function () {
		
		$('body').find('#_modal_alert_div').remove();
	});
	
	$('#_modal_alert_div').modal({'backdrop': 'static'});
}
function modalConfirm(message){
	
	var tplhtml = '<div class="modal fade" id="_modal_confirm_div">'
		+ '<div class="modal-dialog">'
		+ '<div class="modal-content">'
		+ '<div class="modal-header">'
		+ '<button type="button" class="close" onclick="closeModal(\'_modal_confirm_div\')">'
		+ '<span aria-hidden="true">&times;</span></button>'
        + '<h4 class="modal-title">确认信息</h4>'
        + '</div>'
        + '<div class="modal-body">'
        + '<p>' + message + '</p>'
        + '</div>'
        + '<div class="modal-footer">'
        + '<button type="button" class="btn btn-primary ok">确定</button>'
        + '<button type="button" class="btn btn-default cancel">取消</button>'
        + '</div>'
        + '</div>'
        + '</div>'
        + '</div>';
        
	$('body').append(tplhtml);
	
	$('#_modal_confirm_div').on('hidden.bs.modal', function () {
		
		$('body').find('#_modal_confirm_div').remove();
	});
	
	$('#_modal_confirm_div').modal({'backdrop': 'static'});
	
	return {
        on: function (callback) {
            if (callback && callback instanceof Function) {
            	$('#_modal_confirm_div').find('.ok').click(function(){ 
            		callback(true);
            		closeModal('_modal_confirm_div');
            	});
                $('#_modal_confirm_div').find('.cancel').click(function(){ 
                	callback(false);
                	closeModal('_modal_confirm_div');
                });
            }
        }
    };
}
function closeModal(modal_id){
	
	$('#'+modal_id).modal('hide');
	// $('body').find('.modal-backdrop').remove();
	// $('body').find('#'+modal_id).remove();
}

