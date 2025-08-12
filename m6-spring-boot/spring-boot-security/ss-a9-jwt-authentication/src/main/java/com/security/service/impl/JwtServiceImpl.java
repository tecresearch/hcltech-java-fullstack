package com.security.service.impl;
import com.security.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

@Component
public class JwtServiceImpl implements JwtService
{
    // Replace this with a secure key in a real application, ideally fetched from environment variables
    public static final String SECRET = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";
    private Set<String> blacklistedTokens = ConcurrentHashMap.newKeySet(); // Thread-safe set for blacklisting tokens

    // Generate token with given user name
    public String generateToken(String userName)
    {
    	System.out.println("Generate token...");
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userName);
    }
    // Create a JWT token with specified claims and subject (user name)
    public String createToken(Map<String, Object> claims, String userName)
    {
    	System.out.println("Create token...");
        String token=Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30)) // Token valid for 30 minutes
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
        System.out.println("Generated token:"+token);
        return token;
    }
    // Get the signing key for JWT token
    public Key getSignKey()
    {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    // Extract the username from the token
    public String extractUsername(String token)
    {
        return extractClaim(token, Claims::getSubject);
    }
    // Extract the expiration date from the token
    public Date extractExpiration(String token)
    {
        return extractClaim(token, Claims::getExpiration);
    }
    // Extract a claim from the token
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver)
    {
    	final Claims claims = extractAllClaims(token);
        if(claims==null)
        	return null;
        return claimsResolver.apply(claims);
    }
    // Extract all claims from the token
    public Claims extractAllClaims(String token)
    {
    	try
    	{
            Claims claims=Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
            return claims;
    	}
    	catch(Exception ex)
    	{
    		System.out.println("Invalid token");
    	}
        return null;
    }
    // Check if the token is expired
    public Boolean isTokenExpired(String token)
    {
        return extractExpiration(token).before(new Date());
    }
    // Validate the token against user details and expiration
     public Boolean validateToken(String token, UserDetails userDetails)
    {
        final String username = extractUsername(token);
        boolean valid=(username.equals(userDetails.getUsername()) && !isTokenExpired(token));
        return valid;
    }
    public Boolean validateToken1(String token)
    {
        return (!isTokenExpired(token));
    }

}