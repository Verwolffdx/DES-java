package com.datwhite;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class GenerateKey {
    private String key;
    private int length;

    public GenerateKey(int length) {
        this.length = length;
    }

    private String getKey() {
        return key;
    }

    public String generate() throws NoSuchAlgorithmException {
        SecureRandom random = SecureRandom.getInstanceStrong();
        byte[] values = new byte[length];
        random.nextBytes(values);

        key = Base64.getEncoder().encodeToString(values).substring(0, length);

        return key;
    }
}
