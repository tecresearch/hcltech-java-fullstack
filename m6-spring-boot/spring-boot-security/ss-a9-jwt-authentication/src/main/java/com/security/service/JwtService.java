package com.security.service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public interface JwtService
{
    // Replace this with a secure key in a real application, ideally fetched from environment variables
    public static final String SECRET = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";

    // Generate token with given user name
    public String generateToken(String userName);

    // Create a JWT token with specified claims and subject (user name)
     String createToken(Map<String, Object> claims, String userName);
    // Get the signing key for JWT token
     Key getSignKey();

    // Extract the username from the token
    public String extractUsername(String token);

    // Extract the expiration date from the token
    public Date extractExpiration(String token);

    // Extract a claim from the token
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver);

    // Extract all claims from the token
     Claims extractAllClaims(String token);

    // Check if the token is expired
     Boolean isTokenExpired(String token);

    // Validate the token against user details and expiration
     public Boolean validateToken(String token, UserDetails userDetails);

    public Boolean validateToken1(String token);


}