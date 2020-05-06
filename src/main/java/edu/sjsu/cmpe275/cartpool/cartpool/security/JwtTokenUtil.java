package edu.sjsu.cmpe275.cartpool.cartpool.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTokenUtil {

    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final long EXPIRATION = 1000 * 24 * 60 * 60 * 7;
    public static final String SECRET_KEY = "cartpool_secret";

    public static String generateJsonWebToken(String username, String role) {

        Map<String, Object> map = new HashMap<>();

        String token = Jwts
                .builder()
                .setSubject(username)
                .setClaims(map)
                .claim("username", username)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY).compact();
        return token;
    }

    public static Claims validateToken(String token) {
        try {
            final Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
            return claims;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getUsername(String token){
        Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        return claims.get("username").toString();
    }

    public static String getUserRole(String token){
        Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        return claims.get("role").toString();
    }

    public static boolean isExpiration(String token){
        Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        return claims.getExpiration().before(new Date());
    }

    public static void main(String[] args) {
        String name = "test";
        String role = "ROLE_USER";
        String token = generateJsonWebToken(name, role);
        System.out.println(token);

        Claims claims = validateToken(token);
        System.out.println(claims.get("username"));

        System.out.println(getUsername(token));
        System.out.println(getUserRole(token));
        System.out.println(isExpiration(token));

    }
}
