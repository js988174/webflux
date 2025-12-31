package com.example.webflux.service.llmClient;

import com.example.webflux.model.llmclient.LlmChatRequestDto;
import com.example.webflux.model.llmclient.LlmChatResponseDto;
import com.example.webflux.model.llmclient.LlmType;
import com.example.webflux.model.llmclient.gpt.request.GptChatRequestDto;
import com.example.webflux.model.llmclient.gpt.request.GptCompletionRequestDto;
import com.example.webflux.model.llmclient.gpt.response.GptChatResponseDto;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class GptWebClientService implements LlmWebClientService{

    private final WebClient webClient;

    @Value("${llm.gpt.key}")
    private String gptApiKey;

    @Override
    public Mono<LlmChatResponseDto> getChatCompletion(LlmChatRequestDto llmChatRequestDto) {
        GptChatRequestDto gptChatRequestDto = new GptChatRequestDto(llmChatRequestDto);
        return webClient.post()
                .uri("https://api.openai.com/v1/chat/completions")
                .header("Authorization", "Bearer " + gptApiKey)
                .bodyValue(gptChatRequestDto)
                .retrieve()
                .bodyToMono(GptChatResponseDto.class)
                .map(gptChatResponseDto -> new LlmChatResponseDto(gptChatResponseDto));
    }

    @Override
    public LlmType getLlmType() {
        return LlmType.GPT;
    }
}
