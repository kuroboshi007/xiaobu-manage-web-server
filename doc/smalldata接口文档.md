<font face="微软雅黑" size="6">**smalldata接口文档**</font>  
<font face="微软雅黑" size="3">当前版本V1.0</font>

----------
##### 1\.注册：
> ###### 1\.1管理员用注册接口
> 说明：标注数据管理后台的管理员用户注册  
> 接口地址：/signup/signupManager  
> 请求方式：POST  
> ##### 请求参数： 
>                名称           说明         数据类型         必选
>              username        用户名        String           Y
>              password        密码          String           Y
>              phone           电话号码      String           Y
>              vCode           验证码        String           Y
> ##### 应答参数：
>                名称           说明         数据类型
>                code          请求状态      String
>                message       返回信息      String
>                result        返回数据      
>                timestamp     时间戳       
> ##### 返回信息示例：
>               
				{
			    "timestamp": 1524041560641,
			    "message":返回提示信息（一般为成功、失败等）,
			    "result":,
			    "code": 200
                }
##### 2\.登录
> ###### 2\.1系统管理员登录接口
> 说明：  
> 接口地址：/login/checkManagerLogin  
> 请求方式：POST
> ##### 请求参数：
>                名称           说明         数据类型         必选
>              username        用户名        String           Y
>              password        密码          String           Y
> ##### 应答参数：
>
> ##### 返回消息示例：
>            <!DOCTYPE html>
             <html xmlns="http://www.w3.org/1999/xhtml">
			    <head>
			        <meta charset="utf-8">
			        <meta http-equiv="X-UA-Compatible" content="IE=edge">
			        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
			        <link rel="stylesheet" href="/statics/plugin/bootstrap-3.3.7/css/bootstrap.min.css">
			        <link rel="stylesheet" href="/statics/plugin/font-awesome-4.7.0/css/font-awesome.min.css">
			        <link rel="stylesheet" href="/statics/plugin/AdminLTE-2.4.3/css/AdminLTE.min.css">
			        <link rel="stylesheet" href="/statics/plugin/layer/theme/default/layer.css">
			    </head>
			    <body class="hold-transition login-page">
			        <div class="login-box">
					</div>
					        <script src="/statics/plugin/jquery-3.2.1.min.js"></script>
					        <script src="/statics/plugin/bootstrap-3.3.7/js/bootstrap.min.js"></script>
					        <script src="/statics/plugin/layer/layer.js"></script>
					        <script src="/js/common/login.js"></script>
					<script>
					    var myData=smalldata;
					    var indexData ={'userName':smalldata,'userEmail':,'userType':Manager,'userPhone':15185175127}
					</script>
					    </body>
					</html>  
> ##### 2\.2甲方人员登录接口
> 说明：  
> 接口地址：/login/checkConsumerLogin  
> 请求方式：POST
> ##### 请求参数：
>                名称           说明         数据类型         必选
>              username        用户名        String           Y
>              password        密码          String           Y
> ##### 应答参数：
>
> ##### 返回消息示例：
>            <!DOCTYPE html>
             <html xmlns="http://www.w3.org/1999/xhtml">
			    <head>
			        <meta charset="utf-8">
			        <meta http-equiv="X-UA-Compatible" content="IE=edge">
			        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
			        <link rel="stylesheet" href="/statics/plugin/bootstrap-3.3.7/css/bootstrap.min.css">
			        <link rel="stylesheet" href="/statics/plugin/font-awesome-4.7.0/css/font-awesome.min.css">
			        <link rel="stylesheet" href="/statics/plugin/AdminLTE-2.4.3/css/AdminLTE.min.css">
			        <link rel="stylesheet" href="/statics/plugin/layer/theme/default/layer.css">
			    </head>
			    <body class="hold-transition login-page">
			        <div class="login-box">
					</div>
					        <script src="/statics/plugin/jquery-3.2.1.min.js"></script>
					        <script src="/statics/plugin/bootstrap-3.3.7/js/bootstrap.min.js"></script>
					        <script src="/statics/plugin/layer/layer.js"></script>
					        <script src="/js/common/login.js"></script>
					<script>
					    var myData=smalldata;
					    var indexData ={'userName':smalldata,'userEmail':,'userType':Manager,'userPhone':15185175127}
					</script>
					    </body>
					</html>  
> ##### 2\.3团队管理员登录接口
> 说明：  
> 接口地址：/login/checkOrganizationLogin  
> 请求方式：POST
> ##### 请求参数：
>                名称           说明         数据类型         必选
>              username        用户名        String           Y
>              password        密码          String           Y
> ##### 应答参数：
>
> ##### 返回消息示例：
>            <!DOCTYPE html>
             <html xmlns="http://www.w3.org/1999/xhtml">
			    <head>
			        <meta charset="utf-8">
			        <meta http-equiv="X-UA-Compatible" content="IE=edge">
			        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
			        <link rel="stylesheet" href="/statics/plugin/bootstrap-3.3.7/css/bootstrap.min.css">
			        <link rel="stylesheet" href="/statics/plugin/font-awesome-4.7.0/css/font-awesome.min.css">
			        <link rel="stylesheet" href="/statics/plugin/AdminLTE-2.4.3/css/AdminLTE.min.css">
			        <link rel="stylesheet" href="/statics/plugin/layer/theme/default/layer.css">
			    </head>
			    <body class="hold-transition login-page">
			        <div class="login-box">
					</div>
					        <script src="/statics/plugin/jquery-3.2.1.min.js"></script>
					        <script src="/statics/plugin/bootstrap-3.3.7/js/bootstrap.min.js"></script>
					        <script src="/statics/plugin/layer/layer.js"></script>
					        <script src="/js/common/login.js"></script>
					<script>
					    var myData=smalldata;
					    var indexData ={'userName':smalldata,'userEmail':,'userType':Manager,'userPhone':15185175127}
					</script>
					    </body>
					</html>  
##### 3\.获取短信验证码接口
>说明：注册时获取手机短信验证码  
>请求方式：POST  
>请求地址：/baseinterface/obtainSms
> ##### 请求参数： 
>                名称           说明         数据类型         必选
>              number        电话号码        String             Y
> ##### 应答参数：
>                名称           说明         数据类型
>                code          请求状态      String
>                message       返回信息      String
>                result        返回数据      
>                timestamp     时间戳       
> ##### 返回信息示例：
>               
				{
			    "timestamp": 1524041560641,
			    "message":返回提示信息（一般为成功、失败等）,
			    "result":,
			    "code": 200
                }
##### 4\.采集
>###### 4\.1采集任务列表List接口
>说明：  
>请求方式：POST  
>请求地址：/sdCollectTask/selectCollectTaskInfo
> ##### 请求参数： 
>                名称           说明                           数据类型         必选
>                start        分页数据起始位子                  Integer          Y
>                           ，例：需要显示size=10
>                           的第2页信息时，
>                           此时start=“10” 
>                length     当前页显示长度                      Integer          Y     
> ##### 应答参数：
>                名称           说明         数据类型
>                code          请求状态      String
>                message       返回信息      String
>                result        返回数据      
>                timestamp     时间戳       
> ##### 返回信息示例：
>               
				{
			    "result": {
			        "draw": null,
			        "start": 10,
			        "length": 10,
			        "recordsTotal": 0,
			        "recordsFiltered": 0,
			        "data": []
			    },
			    "code": 200,
			    "message": "获取成功",
			    "timestamp": 1534319154679
				}


###### 5\.甲方信息
>####### 5\.1甲方信息列表List接口
> 说明：<br>
> 请求方式：POST<br>
> 请求地址：/sdConsumer/selectConsumerInfo
> ##### 请求参数：
>                名称           说明                           数据类型         必选
>                start        分页数据起始位子                  Integer          Y
>                           ，例：需要显示size=10
>                           的第2页信息时，
>                           此时start=“10” 
>                length     当前页显示长度                      Integer          Y 
> ##### 应答参数：
>                名称           说明         数据类型
>                code          请求状态      String
>                message       返回信息      String
>                result        返回数据      
>                timestamp     时间戳       
> ##### 返回信息示例：
>               
				{
			    "result": {
			        "draw": null,
			        "start": 10,
			        "length": 10,
			        "recordsTotal": 0,
			        "recordsFiltered": 0,
			        "data": []
			    },
			    "code": 200,
			    "message": "获取成功",
			    "timestamp": 1534319154679
				}

>####### 5\.2新增甲方信息接口
>说明：<br>
>请求方式：POST <br>
>请求地址：/sdConsumer/insertConsumerInfo
>##### 请求参数：
>            名称              说明         数据类型       必选
>            name              姓名         String        
>            phone             电话号码      String         
>            email             邮箱          String 
>            username          账号          String        Y
>            password          密码          String        Y
>##### 应答参数：
>            名称              说明         数据类型
>            code             请求状态      String
>            message          返回信息      String
>            timestamp        时间戳 
>###### 返回信息示例：

             {
    			"code": 200,
    			"message": "新增成功",
   				"timestamp": 1534411596050
             }

>####### 5\.3修改甲方信息接口
>说明：<br>
>请求方式：POST <br>
>请求地址：/sdConsumer/updateConsumerInfo
>##### 请求参数：
>            名称              说明         数据类型       必选
>            id                             int            Y
>            name              姓名          String        
>            phone             电话号码      String         
>            email             邮箱          String 
>            username          账号          String        Y
>##### 应答参数：
>            名称              说明         数据类型
>            code             请求状态      String
>            message          返回信息      String
>            timestamp        时间戳 
>###### 返回信息示例：

             {
    			"code": 200,
    			"message": "修改成功",
   				"timestamp": 1534411596050
             }

				
>####### 5\.4删除甲方信息接口
>说明：<br>
>请求方式：GET <br>
>请求地址：/sdConsumer/deleteConsumer
>##### 请求参数：
>            名称              说明         数据类型       必选
>            id                              int          Y
>##### 应答参数：
>            名称              说明         数据类型
>            code             请求状态      String
>            message          返回信息      String
>            timestamp        时间戳 
>###### 返回信息示例：

             {
    			"code": 200,
    			"message": "删除成功",
   				"timestamp": 1534411596050
             }




###### 6\.团体组织信息
>####### 6\.1团体组织信息List接口
> 说明：<br>
> 请求方式：POST<br>
> 请求地址：/sdOrganization/selectOrganizationInfo
> ##### 请求参数：
>                名称           说明                           数据类型         必选
>                start        分页数据起始位子                  Integer          Y
>                           ，例：需要显示size=10
>                           的第2页信息时，
>                           此时start=“10” 
>                length     当前页显示长度                      Integer          Y 
> ##### 应答参数：
>                名称           说明         数据类型
>                code          请求状态      String
>                message       返回信息      String
>                result        返回数据      
>                timestamp     时间戳       
> ##### 返回信息示例：
>               
				{
			    "result": {
			        "draw": null,
			        "start": 10,
			        "length": 10,
			        "recordsTotal": 0,
			        "recordsFiltered": 0,
			        "data": []
			    },
			    "code": 200,
			    "message": "获取成功",
			    "timestamp": 1534319154679
				}



>####### 6\.2新增团体组织信息接口
>说明：<br>
>请求方式：POST <br>
>请求地址：/sdOrganization/insertOrganizationInfo
>##### 请求参数：
>            名称              说明         数据类型       必选
>            name              姓名         String        
>            intro             介绍         String         
>            username          账号         String         Y
>            password          密码         String         Y
>##### 应答参数：
>            名称              说明         数据类型
>            code             请求状态      String
>            message          返回信息      String
>            timestamp        时间戳 
>###### 返回信息示例：

             {
    			"code": 200,
    			"message": "新增成功",
   				"timestamp": 1534411596050
             }



>####### 6\.3修改团体组织信息接口
>说明：<br>
>请求方式：POST <br>
>请求地址：/sdOrganization/updateOrganizationInfo
>##### 请求参数：
>            名称              说明         数据类型       必选
>            name              姓名         String        
>            intro             介绍         String         
>            username          账号         String         Y
>##### 应答参数：
>            名称              说明         数据类型
>            code             请求状态      String
>            message          返回信息      String
>            timestamp        时间戳 
>###### 返回信息示例：

             {
    			"code": 200,
    			"message": "修改成功",
   				"timestamp": 1534411596050
             }

>####### 6\.4删除团体组织信息接口
>说明：<br>
>请求方式：POST <br>
>请求地址：/sdOrganization/deleteOrganizationInfo
>##### 请求参数：
>            名称              说明         数据类型       必选
>            id                            int            Y
>##### 应答参数：
>            名称              说明         数据类型
>            code             请求状态      String
>            message          返回信息      String
>            timestamp        时间戳 
>###### 返回信息示例：

             {
    			"code": 200,
    			"message": "删除成功",
   				"timestamp": 1534411596050
             }