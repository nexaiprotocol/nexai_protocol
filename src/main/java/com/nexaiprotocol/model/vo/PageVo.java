package com.nexaiprotocol.model.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @since 1.0
 */

@Data
@Schema(description = "Pagination parameters for querying user lists.")
public class PageVo implements Serializable {

    @Schema(description = "Page number (defaults to 1 if not provided).", example = "1")
    private int page = 1;

    @Schema(description = "Number of items per page (defaults to 10 if not provided).", example = "10")
    private int size = 10;
}
