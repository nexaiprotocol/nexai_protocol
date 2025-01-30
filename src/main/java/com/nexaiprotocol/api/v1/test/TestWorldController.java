package com.nexaiprotocol.api.v1.test;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @since 1.0
 */

@Log4j2
@Tag(name = "Test World Controller")
@RestController
@RequestMapping("/api/v1/ai/world")
public class TestWorldController {

    @Operation(summary = "World Test")
    @PostMapping("/test")
    public Map<String, String> test() {

        return Map.of(
                "question", "test",
                "answer", "test"
        );
    }
}
