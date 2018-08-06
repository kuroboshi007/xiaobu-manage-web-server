package com.xiaobu.common.interceptor;

import java.util.HashSet;
import java.util.Set;

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
		SdUser user = sdUserService.selectByname(username);
		/*// 从数据库获取对应用户名密码的用户
        SdUser user = sdUserService.selectByname(token.getUsername());
        //获取用户提交表单时输入的密码
        String password = new String((char[]) token.getCredentials());
        //首先對用戶表單中的password進行一次MD5加密
		String MD5password = MD5Util.MD5(password);
		//获取前五位
		String before5 = user.getPassword().substring(0, 5);
		//获取后五位
		String after5 = user.getPassword().substring(user.getPassword().length()-5);
		//获取剔除盐之后的password
		String pwd =  user.getPassword().substring(5, user.getPassword().length()-5);
		//生成注册時隨機生成的盐
		String salt = before5+after5;
		String passWordandSalt = MD5Util.MD5(MD5password+salt);
        if(user == null) {
        	throw new AccountException("用户名不正确");
        }else if(!pwd.equals(passWordandSalt)) {
        	throw new AccountException("密码不正确");
        }*/
		return new SimpleAuthenticationInfo(token.getPrincipal(), user.getPassword(), getName());
		
	}

}