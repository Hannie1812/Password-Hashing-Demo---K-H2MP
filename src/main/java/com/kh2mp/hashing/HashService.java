package com.kh2mp.hashing;

import org.springframework.stereotype.Service;
import java.security.MessageDigest;

@Service
public class HashService {
    public String hash(String input, String algorithm, String salt) throws Exception {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        if (salt != null && !salt.isEmpty()) {
            md.update(salt.getBytes());
        }
        byte[] messageDigest = md.digest(input.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }
}