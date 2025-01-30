package com.nexaiprotocol.model.request.gpt;


import lombok.Data;

/**
 * @since 1.0
 */

@Data
public class Usage {
    private int promptTokens;
    private int completionTokens;
    private int totalTokens;
    private CompletionTokensDetails completionTokensDetails;
}
