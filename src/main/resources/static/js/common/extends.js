/**
 * DataTable
 */
jQuery.extend($.fn.dataTable.defaults, {
    "dom": "<'row'<'col-sm-12'tr>>" +
           "<'row'<'col-sm-5'i><'col-sm-7'p>>",//默认是lfrtip
    "processing": true,//加载中
    "serverSide": true,//服务器模式
    "searching": false,//datatables自带的搜索
    "scrollX": true,//X滑动条
    "pagingType": "full_numbers",//分页模式
    "ajax": {
        "type": "POST"
    },
    "autoWidth": false,
    "initComplete": function(settings, json){
		
		$('.dataTables_scrollHeadInner').css("width","100%");
		$('.dataTables_scrollHeadInner table').css("width","100%");
	},
    "language": {
        "processing": "加载中...",
        "lengthMenu": "每页显示 _MENU_ 条数据",
        "zeroRecords": "没有匹配结果",
        "info": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
        "infoEmpty": "显示第 0 至 0 项结果，共 0 项",
        /*"infoFiltered": "(由 _MAX_ 项结果过滤)",*/
        "infoFiltered": "",
        "infoPostFix": "",
        "search": "搜索:",
        "url": "",
        "emptyTable": "没有匹配结果",
        "loadingRecords": "载入中...",
        "thousands": ",",
        "paginate": {
            "first": "首页",
            "previous": "上一页",
            "next": "下一页",
            "last": "尾页"
        },
        "aria": {
            "sortAscending": ": 以升序排列此列",
            "sortDescending": ": 以降序排列此列"
        }
    }
});
/**
 * jquery validate
 * ======================================================
 */
jQuery.validator.addMethod("phone", function(value, element, options) {
	
	var phone_reg = /^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$/;
	
	return phone_reg.test(value);
}, $.validator.format("请输入正确的电话号码"));

jQuery.extend($.validator.defaults, {
	ignore: [],
	errorElement: "em",
	errorPlacement: function (error, element) {
		// Add the `help-block` class to the error element
		error.addClass("help-block");

//		if (element.prop("type") === "checkbox") {
//			error.insertAfter(element.parent("label"));
//		} else if(element.prop("class").indexOf("select2") > -1){
//			error.insertAfter(element.next());
//		} else {
//			error.insertAfter(element);
//		}
		
		if(element.closest("div.control-content").html()){
			
			error.insertAfter(element.closest("div.control-content").children().last());
		} else {
			
			error.insertAfter(element);
		}
	},
	highlight: function (element, errorClass, validClass) {
		
		if($(element).closest("div.control-content").html()){
			
			$(element).closest("div.control-content").addClass("has-error").removeClass("has-success");
		} else {
			
			$(element).parent().addClass("has-error").removeClass("has-success");
		}
	},
	unhighlight: function (element, errorClass, validClass) {
		
		if($(element).closest("div.control-content").html()){
			
			$(element).closest("div.control-content").addClass("has-success").removeClass("has-error");
		} else {
			
			$(element).parent().addClass("has-success").removeClass("has-error");
		}
	}
});
/**
 * jquery 扩展方法
 */
jQuery.fn.extend({
	
	/**
	 * 去掉验证
	 */
	'validateReset': function(){
		
		this.validate().resetForm();
		this.find('div').removeClass('has-error').removeClass('has-success');
	}

});

/**
 * 设置jQuery Ajax全局的参数
 */  
$.ajaxSetup({  
    type: "POST",  
    error: function(jqXHR, textStatus, errorThrown){  
        switch (jqXHR.status){  
            case(500):  
                alert("服务器系统内部错误");
                break;  
            case(401):  
                alert("未登录");  
            	location.reload();
                break;  
            case(403):  
                alert("无权限执行此操作");
            	break;
            case(404):  
                alert("找不到处理的方法");
                break;  
            case(408):  
                alert("请求超时");
                break;
            case(518):
            	alert("登录超时");
            	location.reload();
            	break;
        }  
    } 
});
// 日期格式化
Date.prototype.Format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}