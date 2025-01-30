package com.nexaiprotocol.model.request.gpt;


import lombok.Data;

/**
 * @since 1.0
 */

@Data
public class Message {
    private String role;
    private String content;
}
