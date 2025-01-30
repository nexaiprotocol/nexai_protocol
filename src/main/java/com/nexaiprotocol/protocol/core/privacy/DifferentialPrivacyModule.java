package com.nexaiprotocol.protocol.core.privacy;

import com.nexaiprotocol.protocol.core.privacy.exception.DifferentialPrivacyException;
import com.nexaiprotocol.protocol.core.privacy.impl.PrivacyOperation;

import java.util.List;

/**
 * <h2>Note: Development version, still incomplete.</h2>
 * Applies differential privacy mechanisms to protect encrypted data operations.
 * Ensures statistical privacy guarantees through calibrated noise injection.
 *
 * <h2>Supported Mechanisms</h2>
 * <ul>
 *   <li>Laplace Mechanism</li>
 *   <li>Gaussian Mechanism</li>
 *   <li>Exponential Mechanism (for discrete values)</li>
 * </ul>
 *
 * @since 1.0
 */
public interface DifferentialPrivacyModule {

    /**
     * Injects noise into encrypted data with (ε,δ)-differential privacy guarantees
     *
     * @param encryptedData Original encrypted data
     * @param epsilon       Privacy budget (ε > 0)
     * @param delta         Privacy parameter (0 ≤ δ < 1)
     * @param sensitivity   L1/L2 sensitivity of the operation
     * @return Noisy encrypted data
     * @throws DifferentialPrivacyException If parameters are invalid
     */
    EncryptedData addNoise(EncryptedData encryptedData,
                           double epsilon,
                           double delta,
                           double sensitivity)
            throws DifferentialPrivacyException;

    /**
     * Calculates privacy budget consumption for complex workflows
     *
     * @param operations Sequence of privacy operations
     * @return Remaining privacy budget
     */
    double calculateBudgetConsumption(List<PrivacyOperation> operations);
}