package com.xiaobu.common.util;


import io.jsonwebtoken.*;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class JwtManager {

    //加密私钥
    private final static String base64Secret = "MDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZjY=";
    //过期时间
    private final static int expiresSecond = 172800000;

    public static Claims parseJWT(String jsonWebToken) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(base64Secret))
                    .parseClaimsJws(jsonWebToken).getBody();
            return claims;
        } catch (Exception ex) {
            return null;
        }
    }


    //1、确定加盐算法结构
    /**
     * 生成随机数（盐）并和“”做md5加密
     * +用户信息做md5加密
     * */
    //2、tokenId的确定
    public static String createToken(String username, String roles, String privileges){
        //选择签名的算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //获取时间戳
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //生成签名密钥
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(base64Secret);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

       /* Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("user_name", username);
        claims.put("user_role", roles);
        claims.put("user_privilege", privileges);
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")//头部
                .setClaims(claims)
                .setId("tokenid")
                .signWith(signatureAlgorithm, signingKey);//尾巴;*/
        //添加构成JWT的参数
        JwtBuilder builder = Jwts.builder()
                .setHeaderParam("typ", "JWT")//头部
                .claim("user_name", username)
                .claim("user_role", roles)
                .claim("user_privilege", privileges)
                .setId("tokenid")
                .signWith(signatureAlgorithm, signingKey);//尾巴
        //添加Token过期时间
        if (expiresSecond >= 0) {
            long expMillis = nowMillis + expiresSecond;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp).setNotBefore(now);
        }

        //生成JWT
        return builder.compact();
    }

    public static void validateToken(String token) {
        try{
            Claims claims = parseJWT(token);
            String username = claims.get("user_name").toString();
            String role = claims.get("user_role").toString();
            String user_privilege = claims.get("user_privilege").toString();
            String tokenid = claims.getId();
            System.out.println("[user_name]:"+username);
            System.out.println("[user_role]:"+role);
            System.out.println("[tokenid]:"+tokenid);
            System.out.println("[user_privilege]:"+user_privilege);
        } catch(ExpiredJwtException e) {
            System.out.println("token expired");
        } catch (InvalidClaimException e) {
            System.out.println("token invalid");
        } catch (Exception e) {
            System.out.println("token error");
        }
    }

    public static void main(String[] args) {
        System.out.println(createToken("admin","add","23"));
    }

}
