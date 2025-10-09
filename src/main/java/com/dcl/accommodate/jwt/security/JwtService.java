package com.dcl.accommodate.jwt.security;

import com.dcl.accommodate.appConfig.AppEnv;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.Duration;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

@Service
public class JwtService {

    private  Key key;
    public JwtService(AppEnv secret){
        this.key = Keys.hmacShaKeyFor(Base64.getDecoder().decode(secret.getJwt().getSecret()));
    }
   public String generateToken(Map<String,Object> claims, String subject, Duration tty){
       var systemMillis = System.currentTimeMillis();
       return Jwts.builder()
               .setClaims(claims)
               .setIssuedAt(new Date(systemMillis))
               .setExpiration(new Date(systemMillis + tty.toMillis()))
               .setSubject(subject)
               .signWith(key,SignatureAlgorithm.HS256)
               .compact();    //alternative to build method, that return encoded JWT string

   }

   public Claims extractCLaims(String token){
       return Jwts.parserBuilder()
               .setSigningKey(key)
               .build()
               .parseClaimsJws(token)
               .getBody();
   }

}
