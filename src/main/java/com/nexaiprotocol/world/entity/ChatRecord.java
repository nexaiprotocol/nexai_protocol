package com.nexaiprotocol.world.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Chat entity class
 *
 * @since 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatRecord implements Serializable {

    @Serial
    private static final long serialVersionUID = -4771898625574689378L;
    private Long id;

    private String prompt;

    private String response;

    private String provider;

    private LocalDateTime timestamp;
}

