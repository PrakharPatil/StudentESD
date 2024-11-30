//package com.prakharpatil.studentesd.Service;
//
//import com.prakharpatil.studentesd.Model.Admin;
//import com.prakharpatil.studentesd.Model.Student;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.stereotype.Service;
//
//import javax.crypto.SecretKey;
//import java.util.Date;
//
//@Service
//public class JwtService {
//    private final SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
//
//    public String generateToken(Admin admin) {
//        return Jwts.builder()
//                .setSubject(admin.getUsername())
//                .claim("id", admin.getId())
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 day
//                .signWith(key)
//                .compact();
//    }
//}
