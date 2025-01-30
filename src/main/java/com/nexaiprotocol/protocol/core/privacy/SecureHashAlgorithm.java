package com.nexaiprotocol.protocol.core.privacy;


import com.nexaiprotocol.protocol.core.privacy.exception.CryptoConfigurationException;
import com.nexaiprotocol.protocol.core.privacy.impl.AuditTrail;

/**
 * <h2>Note: Development version, still incomplete.</h2>
 * Defines cryptographic hash functions for generating tamper-evident data digests.
 * Ensures data integrity and authenticity in security-sensitive operations.
 *
 * <h2>Supported Algorithms</h2>
 * <ul>
 *   <li>SHA-256</li>
 *   <li>SHA-3-512</li>
 *   <li>BLAKE2b</li>
 * </ul>
 *
 * @see AuditTrail
 * @since 1.0
 */
public interface SecureHashAlgorithm {

    /**
     * Generates a cryptographic hash of the input data
     *
     * @param data Raw byte array to be hashed
     * @param salt Optional randomness to prevent rainbow table attacks (null for unsalted)
     * @return Hexadecimal string representation of the hash
     * @throws NullPointerException If data is null
     */
    String hash(byte[] data, byte[] salt) throws CryptoConfigurationException;

    /**
     * Verifies data against a known hash
     *
     * @param data         Original data bytes
     * @param salt         Salt used in initial hashing (null if unsalted)
     * @param expectedHash Known hash value to compare against
     * @return true if recomputed hash matches expected value
     */
    boolean verify(byte[] data, byte[] salt, String expectedHash) throws CryptoConfigurationException;
}