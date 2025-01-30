package com.nexaiprotocol.api.v1.web;


import com.nexaiprotocol.common.result.ResponseResult;
import com.nexaiprotocol.common.util.WalletUtils;
import com.nexaiprotocol.model.entity.WalletEntity;
import com.nexaiprotocol.protocol.module.mainnet.wallet.SolanaWalletService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Wallet Controller
 * <p>
 * This controller provides RESTful APIs for managing wallet-related operations, such as generating
 * mnemonic codes and creating wallets. It supports Solana blockchain wallets through the {@link SolanaWalletService}.
 * </p>
 *
 * @since 1.0
 */
@Log4j2
@Tag(name = "Wallet Controller")
@RestController
@RequestMapping("/api/v1/ai/wallet")
public class WalletController {

    private final SolanaWalletService solanaWalletService;

    /**
     * Constructs a new WalletController with the specified SolanaWalletService.
     *
     * @param solanaWalletService the service used to perform Solana wallet operations
     */
    public WalletController(SolanaWalletService solanaWalletService) {
        this.solanaWalletService = solanaWalletService;
    }

    /**
     * Generates a new mnemonic code.
     * <p>
     * This endpoint generates a random mnemonic code (12 or 24 words) that can be used to create a new wallet.
     * </p>
     *
     * @return a {@link ResponseResult} object containing the generated mnemonic code
     */
    @Operation(summary = "Creat Mnemonic Code")
    @GetMapping("/mnemonic")
    public ResponseResult creatMnemonicCode() {
        try {
            List<String> mnemonicCode = WalletUtils.creatMnemonicCode();
            return ResponseResult.success().data("result", mnemonicCode);
        } catch (Exception e) {
            return ResponseResult.error().msg(e.getMessage());
        }
    }

    /**
     * Creates a new wallet using the provided mnemonic code.
     * <p>
     * This endpoint creates a new wallet entity using the specified mnemonic code. The wallet entity
     * includes the private key, public key, and wallet address.
     * </p>
     *
     * @param mnemonicCode the mnemonic code used to create the wallet
     * @return a {@link ResponseResult} object containing the created wallet entity
     */
    @Operation(summary = "Creat Wallet")
    @PostMapping("/wallet")
    public ResponseResult creatWallet(@RequestBody List<String> mnemonicCode) {
        try {
            WalletEntity walletEntity = solanaWalletService.createWallet(mnemonicCode);
            return ResponseResult.success().data("result", walletEntity);
        } catch (Exception e) {
            return ResponseResult.error().msg(e.getMessage());
        }
    }
}
