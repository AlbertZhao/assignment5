package com.zhaoshijie.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class JwtTokenUtil {

    @Value("${auth.publicKeyString}")
    private static String publicKeyString;


    public String generateToken(RSAPublicKey publicKey, RSAPrivateKey privateKey) {
        String jwtToken;
        try{
            Algorithm algorithm = Algorithm.RSA256(publicKey, privateKey);
            jwtToken = JWT.create().sign(algorithm);
        } catch (JWTCreationException exception) {
            throw exception;
        }

        return jwtToken;

    }

    public static Map<String, String> verifyToken(String jwtToken) throws Exception {
        Algorithm algorithm = Algorithm.RSA256(getRSAPublicKey(), getRSAPrivateKey());
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJwt = verifier.verify(jwtToken);
        Map<String, Claim> claimsMap = decodedJwt.getClaims();
        Map<String, String> resultClaims = new HashMap<>(claimsMap.size());
        claimsMap.forEach((k,v) -> resultClaims.put(k,v.asString()));
        return resultClaims;
    }




    private static RSAPublicKey getRSAPublicKey() {
        byte[] byteKey = Base64.getDecoder().decode(publicKeyString.getBytes());
        X509EncodedKeySpec x509publicKey = new X509EncodedKeySpec(byteKey);
        KeyFactory kf = null;
        try {
            kf = KeyFactory.getInstance("RSA");
            return (RSAPublicKey) kf.generatePublic(x509publicKey);
        } catch (Exception e) {
            log.error("Get public key with error:" , e);
        }
        return null;
    }

    private static RSAPrivateKey getRSAPrivateKey() {
        return null;
    }



}
