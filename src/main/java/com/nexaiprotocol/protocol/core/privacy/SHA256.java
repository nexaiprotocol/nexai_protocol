package com.nexaiprotocol.protocol.core.privacy;


import com.nexaiprotocol.protocol.core.privacy.exception.CryptoConfigurationException;
import org.bouncycastle.util.encoders.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <h2>Note: Development version, still incomplete.</h2>
 * SHA-256 implementation with salt support
 *
 * @since 1.0
 */
public class SHA256 implements SecureHashAlgorithm {
    @Override
    public String hash(byte[] data, byte[] salt) throws CryptoConfigurationException {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            if (salt != null) md.update(salt);
            byte[] digest = md.digest(data);
            return Hex.toHexString(digest);
        } catch (NoSuchAlgorithmException e) {
            throw new CryptoConfigurationException("SHA-256 unavailable", e);
        }
    }

    @Override
    public boolean verify(byte[] data, byte[] salt, String expectedHash) throws CryptoConfigurationException {
        return hash(data, salt).equals(expectedHash);
    }
}
