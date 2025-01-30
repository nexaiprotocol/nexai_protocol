package com.nexaiprotocol.protocol.core.privacy;


import com.nexaiprotocol.protocol.core.privacy.impl.EncryptionMetadata;

/**
 * <h2>Note: Development version, still incomplete.</h2>
 * Represents encrypted data with associated cryptographic metadata
 *
 * @since 1.0
 */

public class EncryptedData {
    private byte[] ciphertext;
    private EncryptionMetadata metadata;

    /**
     * @param ciphertext Encrypted byte array
     * @param metadata   Contextual encryption parameters
     */
    public EncryptedData(byte[] ciphertext, EncryptionMetadata metadata) {
        this.ciphertext = ciphertext;
        this.metadata = metadata;
    }

    // TODO  Getters and validation methods
}