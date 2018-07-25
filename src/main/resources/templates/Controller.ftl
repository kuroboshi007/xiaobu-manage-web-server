package ${package_name}.controller;
import ${package_name}.service.${table_name}Service;
import ${package_name}.entity.${table_name};
import com.xiaobu.common.base.BaseController;
import com.xiaobu.common.config.Code;
import com.xiaobu.common.util.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;

/**
* 描述：${table_annotation}controller
* @author ${author}
* @date ${date}
*/
@Controller
@RequestMapping("/${table_name?uncap_first}")
public class ${table_name}Controller extends BaseController{

    private Logger logger = LoggerFactory.getLogger(${table_name}Controller.class);

    @Autowired
    private ${table_name}Service ${table_name?uncap_first}Service;

    /**
    * 描述：根据Id 查询
    * @param id  ${table_annotation}id
    */
    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Object findById(@PathVariable("id") Integer id)throws Exception {
        ${table_name} ${table_name?uncap_first} = ${table_name?uncap_first}Service.getById(id);
        
        return actionResult(Code.OK,${table_name?uncap_first});
    }

    /**
    * 描述:创建${table_annotation}
    * 保存
    * @param ${table_name?uncap_first}DTO  ${table_annotation}DTO
    */
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object create(@RequestBody ${table_name} ${table_name?uncap_first}) throws Exception {
    try {
        // 修改
		if(ValidateUtil.isNotEmpty(${table_name?uncap_first}.get${pkField?cap_first}())){
			
			${table_name?uncap_first}Service.update(${table_name?uncap_first});
		}
		// 新增
			else{
				${table_name?uncap_first}Service.add(${table_name?uncap_first});
			}
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
		}
        return actionResult(Code.OK);
    }

    /**
    * 描述：删除${table_annotation}
    * @param id ${table_annotation}id
    */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object deleteById(@PathVariable("id") Integer id) throws Exception {
    try {
        	${table_name?uncap_first}Service.delete(id);
    	} catch (Exception e) {
		
		logger.error(e.getMessage(), e);
		return actionResult(Code.OK);
	}
	return actionResult(Code.INTERNAL_SERVER_ERROR);
  }
}