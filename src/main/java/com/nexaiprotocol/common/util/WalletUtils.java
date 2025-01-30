package com.nexaiprotocol.common.util;


import org.bitcoinj.core.Base58;
import org.bitcoinj.crypto.MnemonicCode;
import org.bitcoinj.crypto.MnemonicException;
import org.p2p.solanaj.core.Account;
import org.p2p.solanaj.core.PublicKey;

import java.security.SecureRandom;
import java.util.List;

/**
 * Utility class for working with mnemonic codes.
 * <p>
 * This class provides helper methods for generating and validating mnemonic phrases,
 * as well as deriving seeds from mnemonic codes. It follows the BIP-39 standard for
 * mnemonic generation and seed derivation.
 * </p>
 *
 * @since 1.0
 */
public class WalletUtils {
    /**
     * Generates a random mnemonic phrase.
     * <p>
     * This method creates a mnemonic phrase using a secure random number generator.
     * The entropy is used to ensure the randomness and security of the mnemonic.
     * </p>
     * Generate a random mnemonic phrase (12 words)
     *
     * @return a list of words representing the mnemonic phrase
     * @throws MnemonicException if the entropy length is invalid
     */
    public static List<String> creatMnemonicCode() {
        try {
            byte[] entropy = new byte[16]; // 128 bits of entropy
            SecureRandom random = new SecureRandom();
            random.nextBytes(entropy);
            List<String> mnemonic = MnemonicCode.INSTANCE.toMnemonic(entropy);
            MnemonicCode.INSTANCE.check(mnemonic);
            return mnemonic;
        } catch (MnemonicException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Validates a mnemonic phrase.
     * <p>
     * This method checks if the provided mnemonic phrase is valid according to the BIP-39 standard.
     * </p>
     *
     * @param mnemonic the list of words representing the mnemonic phrase
     * @return true if the mnemonic is valid, false otherwise
     */
    public static boolean validateMnemonic(List<String> mnemonic) {
        try {
            MnemonicCode.INSTANCE.check(mnemonic);
            return true;
        } catch (MnemonicException e) {
            return false;
        }
    }

    public static String RestoreAccountFromPrivateKey88(String privateKeySol88) {
        byte[] privateKeyBytes = Base58.decode(privateKeySol88);
        Account from = new Account(privateKeyBytes);
        PublicKey publicKey = from.getPublicKey();
        System.out.println("Public Key: " + publicKey.toBase58());
        return publicKey.toBase58();
    }

    public static String RestoreAccountFromPrivateKey128(String privateKeySol128) {
        //  your_sol_128_private_key_here
        byte[] privateKeyBytes = hexStringToByteArray(privateKeySol128);
        Account account = new Account(privateKeyBytes);
        PublicKey publicKey = account.getPublicKey();
        return publicKey.toBase58();
    }

    private static byte[] hexStringToByteArray(String hex) {
        int len = hex.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
                    + Character.digit(hex.charAt(i + 1), 16));
        }
        return data;
    }
}
