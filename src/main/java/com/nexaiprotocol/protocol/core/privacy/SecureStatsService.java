package com.nexaiprotocol.protocol.core.privacy;


import com.nexaiprotocol.protocol.core.privacy.exception.SecureComputationException;

import java.util.List;

/**
 * <h2>Note: Development version, still incomplete.</h2>
 * Performs privacy-preserving statistical computations on encrypted data
 *
 * @since 1.0
 */
public interface SecureStatsService {

    /**
     * Computes encrypted mean value across multiple ciphertexts
     *
     * @param encryptedDataList List of encrypted data points
     * @return Encrypted mean value
     * @throws SecureComputationException If computation fails
     */
    EncryptedData computeEncryptedMean(List<EncryptedData> encryptedDataList)
            throws SecureComputationException, SecureComputationException;

    /**
     * Securely aggregates encrypted values
     *
     * @param encryptedDataList Data to aggregate
     * @return Encrypted sum
     */
    EncryptedData secureSum(List<EncryptedData> encryptedDataList);
}