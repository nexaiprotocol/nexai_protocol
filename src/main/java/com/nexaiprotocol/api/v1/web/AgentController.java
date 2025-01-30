package com.nexaiprotocol.api.v1.web;


import com.nexaiprotocol.common.exception.PromptGenerationException;
import com.nexaiprotocol.common.result.ResponseResult;
import com.nexaiprotocol.model.entity.AgentEntity;
import com.nexaiprotocol.protocol.core.chat.ChatModelService;
import com.nexaiprotocol.protocol.core.agent.AgentBuilder;
import com.nexaiprotocol.model.vo.AgentModelVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * In progress
 * @since 1.0
 *
 */

@Log4j2
@Tag(name = "Agent Controller")
@RestController
@RequestMapping("/api/v1/ai/agent")
public class AgentController {

    private final ChatModelService chatModelService;

    private final AgentBuilder agentBuilder;

    public AgentController(
            ChatModelService chatModelService,
            AgentBuilder agentBuilder) {
        this.chatModelService = chatModelService;
        this.agentBuilder = agentBuilder;
    }

    @Operation(summary = "Creat Agent")
    @PostMapping("/creat")
    public ResponseResult creatAgent(@RequestBody AgentModelVo agentModelVo) throws PromptGenerationException {
        AgentEntity agent = this.agentBuilder.creatAgent(agentModelVo);
        if (Objects.nonNull(agent)) {
            return ResponseResult.error().msg("Failed to create Agent.");
        } else {
            return ResponseResult.success().data("agent", agent);
        }
    }

    @Operation(summary = "Get Agent By Id")
    @PostMapping("/id/{id}")
    public Optional<AgentEntity> getAgentById(@PathVariable("id") String id) {
        Optional<AgentEntity> agentById = this.agentBuilder.getAgentById(id);
        return agentById;
    }

    @Operation(summary = "Get All Agents")
    @PostMapping("/all")
    public Map<String, List<AgentEntity>> getAllAgents() {
        List<AgentEntity> agentEntityList = new ArrayList<>();
        return Map.of("all", agentEntityList);
    }

    @Operation(summary = "Delete Agent")
    @DeleteMapping("/delete/{agentId}")
    public Map<String, String> deleteAgent(@PathVariable String agentId) {

        return Map.of("delete", agentId);
    }
}
