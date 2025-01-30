package com.nexaiprotocol.model.request.gpt;


import lombok.Data;

/**
 * @since 1.0
 */

@Data
public class Choice {
    private int index;
    private Message message;
    private Object logprobs; // Null in your JSON, can use Object or JsonNode
    private String finishReason;
}
