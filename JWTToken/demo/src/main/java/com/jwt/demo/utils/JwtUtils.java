package com.jwt.demo.utils;

import com.jwt.demo.entity.User;
import com.jwt.demo.exception.AccessDeniedException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class JwtUtils
{
    private static String secret= "Secret_key";
    private static long expiryDuration = 60 * 60;

    public String generateJwt(User user)
    {

        long milliTime = System.currentTimeMillis();
        long expiryTime = milliTime + expiryDuration * 1000;

        Date issuedAt = new Date();
        Date expiryAt = new Date(expiryTime);
        //claims
        Claims claims = Jwts.claims().
                setIssuer(user.getId().toString())
                .setIssuedAt(issuedAt)
                .setExpiration(expiryAt);

        //Optional claims
        claims.put("type",user.getUserType());
        claims.put("name",user.getName());
        claims.put("emailId",user.getEmailId());

        //Generate tokens
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS384,secret)
                .compact();
    }

    public Claims verify(String authorization) throws Exception
    {

        try
        {
            Claims claims= Jwts.parser().setSigningKey(secret).parseClaimsJws(authorization).getBody();
            return claims;
        }
        catch (Exception e)
        {
            throw new AccessDeniedException("Access denied bro");
        }
    }


}
