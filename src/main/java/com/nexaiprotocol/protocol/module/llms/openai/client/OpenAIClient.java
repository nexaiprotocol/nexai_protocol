package com.nexaiprotocol.protocol.module.llms.openai.client;


import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.nexaiprotocol.protocol.module.llms.openai.config.OpenAIModelConfig;
import com.nexaiprotocol.model.request.ChatRequest;
import com.nexaiprotocol.model.request.ChatResponse;
import com.nexaiprotocol.model.request.gpt.ChatCompletionResponse;
import com.nexaiprotocol.protocol.module.llms.strategy.ModelClientProvider;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @since 1.0
 */


@Component("openai")
public class OpenAIClient implements ModelClientProvider {

    private final OpenAIModelConfig openaiModelConfig;

    private final RestTemplate restTemplate;

    public OpenAIClient(OpenAIModelConfig openaiModelConfig, RestTemplate restTemplate) {
        this.openaiModelConfig = openaiModelConfig;
        this.restTemplate = restTemplate;
    }

    @PostConstruct
    public void validateConfig() {
        if (openaiModelConfig.getChatGptApiKey() == null || openaiModelConfig.getChatGptApiUrl() == null) {
            throw new IllegalArgumentException("ChatGPT API configuration is missing");
        }
    }


    @Override
    public ChatResponse callModel(ChatRequest request) {

        JSONObject body = new JSONObject();
        body.put("model", openaiModelConfig.getChatGptModel());
        body.put("messages", buildMessages(request.getPrompt()));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + openaiModelConfig.getChatGptApiKey());

        HttpEntity<String> entity = new HttpEntity<>(body.toJSONString(), headers);

        try {
            ResponseEntity<JSONObject> responseEntity = restTemplate.postForEntity(
                    openaiModelConfig.getChatGptApiUrl(),
                    entity,
                    JSONObject.class
            );

            JSONObject response = responseEntity.getBody();
            ChatCompletionResponse chatCompletionResponse = JSONObject.parseObject(String.valueOf(response), ChatCompletionResponse.class);
            if (response == null || !response.containsKey("choices")) {
                throw new RuntimeException("Invalid response from ChatGPT API");
            }

//            System.out.println(response.toJSONString(JSONWriter.Feature.PrettyFormat));

//            String text = response.getJSONArray("choices")
//                    .getJSONObject(0)
//                    .getJSONObject("message")
//                    .getString("content");

            String content = chatCompletionResponse.getChoices()
                    .getFirst()
                    .getMessage()
                    .getContent();

            ChatResponse chatResponse = new ChatResponse();
            chatResponse.setResponse(content);
            chatResponse.setModel("gpt-4o-mini");
            return chatResponse;
        } catch (Exception e) {
            throw new RuntimeException("Failed to call ChatGPT API", e);
        }
    }

    private JSONArray buildMessages(String userMessage) {

        JSONArray messages = new JSONArray();
        JSONObject developerMessage = new JSONObject();
        developerMessage.put("role", "system");
        developerMessage.put("content", "You are a helpful assistant.");
        messages.add(developerMessage);

        JSONObject userInput = new JSONObject();
        userInput.put("role", "user");
        userInput.put("content", userMessage);
        messages.add(userInput);

        return messages;
    }

}
