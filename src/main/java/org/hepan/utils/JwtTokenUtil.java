package org.hepan.utils;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.hepan.enums.ResEnums;
import org.hepan.exception.SysException;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * @author hepan
 * @date 2024/05/31
 * @description
 */
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtTokenUtil {

    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "$2a$10$khMzocJpIzuhkiqSFLQ/euwedqw/ocRjZUI0SsS/TDY0e4RZIxh0C";

//    @Resource
//    RedisUtil redisUtil;
//    @Autowired
//    public RedisUtil redisUtil;


    private static String secret;

    private Integer expiration;

    public Claims getClaimsFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
        return claims;
    }

    public String getUserNameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    /**
     * 验证token是否还有效 返回true就是过期
     * @param token    客户端传入的token
     */
    public boolean validateToken(String token) {
//        String usernameToken = getUserNameFromToken(token);
//        return usernameToken.equals(username) && !isTokenExpired(token);
        try {
            Date expiredDate = getClaimsFromToken(token).getExpiration();
            return expiredDate.before(new Date());
        }catch (Exception e) {
            throw new SysException(ResEnums.TOKEN_EXPIRE);
        }
    }

    public String generateToken(Map<String, Object> claims) {
        String token = Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
        return token;
    }

//    public String generateToken(String userEmail) {
//        Map<String, Object> claims = new HashMap<>(16);
//        claims.put(CLAIM_KEY_USERNAME, userEmail);
//        claims.put(CLAIM_KEY_CREATED, new Date());
//        return generateToken(claims);
//    }

    public Date generateExpirationDate() {

        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Integer getExpiration() {
        return expiration;
    }

    public void setExpiration(Integer expiration) {
        this.expiration = expiration;
    }
}

