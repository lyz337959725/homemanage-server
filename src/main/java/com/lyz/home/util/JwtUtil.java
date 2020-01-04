package com.lyz.home.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

@Data
@Component
@ConfigurationProperties("jwt.config")
public class JwtUtil {

    private String key;

    private Long ttl;

    /**
     *生成token
     */
    public String createJwt(String userId){
        return Jwts.builder()
                .setId(userId)
                .setIssuedAt(new Date())
                .signWith(generalKey(),SignatureAlgorithm.HS256)
                .setExpiration(new Date(System.currentTimeMillis() + ttl))
                .compact();
    }

    /**
     *解析token
     */
    public Claims parseJwt(String token){
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(generalKey()).parseClaimsJws(token).getBody();
        }catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    /**
     * 生成key
     */
    private SecretKey generalKey() {
        return new SecretKeySpec(key.getBytes(),
                SignatureAlgorithm.HS256.getJcaName());
    }
}
