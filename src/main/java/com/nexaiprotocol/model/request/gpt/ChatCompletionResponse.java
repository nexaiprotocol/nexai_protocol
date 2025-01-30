package com.nexaiprotocol.model.request.gpt;


import lombok.Data;

import java.util.List;

/**
 * @since 1.0
 */

@Data
public class ChatCompletionResponse {
    private String id;
    private String object;
    private long created;
    private String model;
    private String systemFingerprint;
    private List<Choice> choices;
    private String serviceTier;
    private Usage usage;
}
