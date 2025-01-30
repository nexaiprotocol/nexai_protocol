package com.nexaiprotocol.model.request.gpt;


import lombok.Data;

/**
 * @since 1.0
 */

@Data
public class CompletionTokensDetails {
    private int reasoningTokens;
    private int acceptedPredictionTokens;
    private int rejectedPredictionTokens;
}
