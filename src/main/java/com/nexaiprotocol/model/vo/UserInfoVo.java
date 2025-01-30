package com.nexaiprotocol.model.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @since 1.0
 */

@Data
@Schema(description = "User information value object.")
public class UserInfoVo implements Serializable {


    @Schema(description = "Username", example = "Username for login")
    private String username;

    @Schema(description = "Email address", example = "example@example.com")
    private String email;

    @Schema(description = "Phone number for 2FA or contact", example = "1234567890")
    private String mobile;

    @Schema(description = "URL to the user's profile picture", example = "")
    private String avatarUrl;


    @Schema(description = "User's blockchain wallet address (e.g., Ethereum, Solana)", example = "")
    private String walletAddress;

    @Schema(description = "Blockchain network (e.g., Ethereum, Binance Smart Chain, Polygon)", example = "Ethereum")
    private String blockchainNetwork;

    @Schema(description = "Public key for cryptographic operations", example = "")
    private String publicKey;

    @Schema(description = "Timestamp when the account was created", example = "")
    private Long createdAt;

    @Schema(description = "Indicates if the account is active", example = "true")
    private boolean isActive;
}
