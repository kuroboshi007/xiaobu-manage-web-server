package com.xiaobu.common.interceptor;

import java.util.HashSet;
import java.util.Set;

import com.xiaobu.common.config.Code;
import com.xiaobu.common.constant.SysMessage;
import com.xiaobu.web.system.entity.SdConsumer;
import com.xiaobu.web.system.entity.SdManager;
import com.xiaobu.web.system.entity.SdOrganization;
import com.xiaobu.web.system.service.SdConsumerService;
import com.xiaobu.web.system.service.SdManagerService;
import com.xiaobu.web.system.service.SdOrganizationService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.xiaobu.common.util.JwtManager;
import com.xiaobu.common.util.MD5Util;
import com.xiaobu.web.system.entity.SdUser;
import com.xiaobu.web.system.service.SdUserService;

import io.jsonwebtoken.Claims;


public class CustomRealm extends AuthorizingRealm{

	private Logger logger = LoggerFactory.getLogger(CustomRealm.class);
	
	@Autowired
	private SdUserService sdUserService;

    @Autowired
    private SdOrganizationService sdOrganizationService;

    @Autowired
    private SdManagerService sdManagerService;

    @Autowired
    private SdConsumerService sdConsumerService;
	/**
	 *  身份信息授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("————权限认证————");
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获得该用户角色
        String role = "admin";
        Set<String> set = new HashSet<>();
        //需要将 role 封装到 Set 作为 info.setRoles() 的参数
        set.add(role);
        //设置该用户拥有的角色
        info.setRoles(set);
        return info;
	}
	
	
	
	/**
	 * 
	 *身份信息验证
	 *Shiro中，最终是通过 Realm 来获取应用程序中的用户、角色及权限信息的。
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		// TODO Auto-generated method stub
		logger.info("身份验证方法");
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		//获取token
		String jwttoken = token.getUsername();
		
		//获取盐
		String salt = new String((char[]) token.getCredentials());
		
		Claims claims = JwtManager.parseJWT(jwttoken,salt);
		
		String username = claims.get("user_name").toString();
        String userType = claims.get("user_type").toString();
        //查詢系统用戶信息
        if(userType.equals("Manager")) {
            SdManager sdManager=sdManagerService.selectByUsername(username);
            if(sdManager == null) {
                throw new AuthenticationException("token认证失败！");
            }
            //查询甲方用户信息
        }else if(userType.equals("Consumer")){
            SdConsumer sdConsumer = sdConsumerService.selectByUsername(username);
            if(sdConsumer ==null){
                throw new AuthenticationException("token认证失败！");
            }
            //查询团队用户信息
        }else {
            SdOrganization sdOrganization = sdOrganizationService.selectByUsername(username);
            if(sdOrganization == null) {
                throw new AuthenticationException("token认证失败！");
            }
        }

		return new SimpleAuthenticationInfo(token.getPrincipal(), "Consumer", getName());
		
	}

}
