package com.nexaiprotocol.protocol.core.privacy;


import com.nexaiprotocol.protocol.core.privacy.exception.HomomorphicEncryptionException;
import com.nexaiprotocol.protocol.core.privacy.impl.CkksPrivacyProcessor;

/**
 * <h2>Note: Development version, still incomplete.</h2>
 * Core interface for privacy-preserving computations using homomorphic encryption (HE).
 * Defines cryptographic primitives and operations for secure data processing while
 * maintaining encrypted state.
 *
 * <h2>Architectural Context</h2>
 * <pre>
 * ┌───────────────────┐       ┌──────────────────────┐
 * │ PrivacyProcessor  │<------│ EncryptedPreprocessor │
 * │ (Interface)       │       │ (Concrete Class)      │
 * └───────────────────┘       └──────────────────────┘
 *        ▲                             ▲
 *        │                             │
 * ┌─────────────────────┐       ┌──────────────────────┐
 * │ CkksPrivacyProcessor│       │   SecureDataOperator │
 * │ (Implementation)    │       │     (Interface)      │
 * └─────────────────────┘       └──────────────────────┘
 * </pre>
 *
 * <h2>Key Responsibilities</h2>
 * <ul>
 *   <li>Data encryption/decryption using HE schemes</li>
 *   <li>Homomorphic arithmetic operations</li>
 *   <li>Ciphertext metadata management</li>
 *   <li>Cryptographic parameter validation</li>
 * </ul>
 *
 * <h2>Security Properties</h2>
 * <ul>
 *   <li>Semantic security for encrypted data</li>
 *   <li>Post-quantum safety for configured schemes</li>
 *   <li>Context-aware noise management</li>
 *   <li>Automatic parameter sanitization</li>
 * </ul>
 *
 * @see CkksPrivacyProcessor
 * @see EncryptedPreprocessor
 * @see SecureDataOperator
 * @since 1.0
 */

public interface PrivacyProcessor {

    /**
     * Encrypts raw data using configured homomorphic encryption scheme
     *
     * @param rawData Original data bytes to encrypt
     * @return Container holding encrypted data and metadata
     * @throws HomomorphicEncryptionException If encryption parameters are invalid
     */
    EncryptedData encrypt(byte[] rawData) throws HomomorphicEncryptionException;

    /**
     * Decrypts homomorphically encrypted data back to plaintext
     *
     * @param encryptedData Container with ciphertext and encryption metadata
     * @return Decrypted raw bytes
     * @throws HomomorphicEncryptionException If decryption fails or metadata mismatch
     */
    byte[] decrypt(EncryptedData encryptedData) throws HomomorphicEncryptionException;

    /**
     * Performs homomorphic addition on two encrypted values
     *
     * @param ciphertext1 First encrypted operand
     * @param ciphertext2 Second encrypted operand
     * @return New encrypted result of addition operation
     */
    EncryptedData homomorphicAdd(EncryptedData ciphertext1, EncryptedData ciphertext2);

    /**
     * Performs homomorphic multiplication on two encrypted values
     *
     * @param ciphertext1 First encrypted operand
     * @param ciphertext2 Second encrypted operand
     * @return New encrypted result of multiplication operation
     */
    EncryptedData homomorphicMultiply(EncryptedData ciphertext1, EncryptedData ciphertext2);

    /**
     * Performs encrypted scalar addition (plaintext + ciphertext)
     *
     * @param scalar     Plaintext value to add
     * @param ciphertext Encrypted operand
     * @return New encrypted result
     */
    EncryptedData scalarAdd(double scalar, EncryptedData ciphertext) throws HomomorphicEncryptionException;

    /**
     * Performs encrypted scalar multiplication (plaintext * ciphertext)
     *
     * @param scalar     Plaintext multiplier
     * @param ciphertext Encrypted multiplicand
     * @return New encrypted result
     */
    EncryptedData scalarMultiply(double scalar, EncryptedData ciphertext);
}
