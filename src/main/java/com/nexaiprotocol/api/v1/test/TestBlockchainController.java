package com.nexaiprotocol.api.v1.test;


import com.nexaiprotocol.common.result.ResponseResult;
import com.nexaiprotocol.common.util.WalletUtils;
import com.nexaiprotocol.model.entity.WalletEntity;
import com.nexaiprotocol.protocol.module.mainnet.BlockchainService;
import com.nexaiprotocol.protocol.module.mainnet.wallet.impl.DefaultSolanaWalletService;
import com.nexaiprotocol.protocol.module.mainnet.wallet.SolanaWalletService;
import com.alibaba.fastjson2.JSONObject;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @since 1.0
 */
@Log4j2
@Tag(name = "Test Blockchain Controller")
@RestController
@RequestMapping("/api/v1/ai/chain")
public class TestBlockchainController {

    private final BlockchainService simpleBlockchainService;

    private final SolanaWalletService solanaWalletService;

    public TestBlockchainController(BlockchainService simpleBlockchainService,
                                    DefaultSolanaWalletService solanaWalletService) {
        this.simpleBlockchainService = simpleBlockchainService;
        this.solanaWalletService = solanaWalletService;
    }

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

    @Operation(summary = "Creat Wallet")
    @GetMapping("/wallet")
    public ResponseResult creatWallet() {
        try {
            List<String> mnemonicCode = WalletUtils.creatMnemonicCode();
            System.out.println(mnemonicCode.toString());
            WalletEntity walletEntity = solanaWalletService.createWallet(mnemonicCode);
            return ResponseResult.success().data("result", walletEntity);
        } catch (Exception e) {
            return ResponseResult.error().msg(e.getMessage());
        }
    }

    @Operation(summary = "Get balance")
    @GetMapping("/balance")
    public ResponseResult getBalance(@RequestParam String chain, @RequestParam String address) {
        try {
            String balance = simpleBlockchainService.getBalance(chain, address);
            return ResponseResult.success().data("result", balance);
        } catch (Exception e) {
            return ResponseResult.error().msg(e.getMessage());
        }
    }

    @Operation(summary = "Get block height")
    @GetMapping("/blockHeight")
    public ResponseResult getBlockHeight(@RequestParam String chain) {
        try {
            long blockHeight = simpleBlockchainService.getBlockHeight(chain);
            return ResponseResult.success().data("result", blockHeight);
        } catch (Exception e) {
            return ResponseResult.error().msg(e.getMessage());
        }
    }

    @Operation(summary = "Get transaction")
    @GetMapping("/tx")
    public ResponseResult getTransaction(@RequestParam String chain, String txHash) {
        try {
            JSONObject transaction = simpleBlockchainService.getTransaction(chain, txHash);
            return ResponseResult.success().data("result", transaction);
        } catch (Exception e) {
            return ResponseResult.error().msg(e.getMessage());
        }
    }

    @Operation(summary = "Get Recent Blockhash")
    @GetMapping("/block/hash")
    public ResponseResult getRecentBlockhash(@RequestParam String chain) {
        try {
            String blockhash = simpleBlockchainService.getRecentBlockhash(chain);
            return ResponseResult.success().data("result", blockhash);
        } catch (Exception e) {
            return ResponseResult.error().msg(e.getMessage());
        }
    }

    @Operation(summary = "Send Transaction Test")
    @GetMapping("/transaction")
    public ResponseResult sendTransaction(@RequestParam String chain, String storeData) {
        try {
            String transaction = simpleBlockchainService.sendTransaction(chain, storeData);
            return ResponseResult.success().data("result", transaction);
        } catch (Exception e) {
            return ResponseResult.error().msg(e.getMessage());
        }
    }
}
