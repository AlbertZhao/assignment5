package com.zhaoshijie.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class JwtTokenUtil {

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

    public static Map<String, String> verifyToken(String jwtToken, Supplier< RSAPublicKey > publicKey, Supplier<RSAPrivateKey> privateKey) throws Exception {
        Algorithm algorithm = Algorithm.RSA256(publicKey.get(), privateKey.get());
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJwt = verifier.verify(jwtToken);
        Map<String, Claim> claimsMap = decodedJwt.getClaims();
        Map<String, String> resultClaims = new HashMap<>(claimsMap.size());
        claimsMap.forEach((k,v) -> resultClaims.put(k,v.asString()));
        return resultClaims;
    }



}
