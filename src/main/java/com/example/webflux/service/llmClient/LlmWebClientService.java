package com.example.webflux.service.llmClient;

import com.example.webflux.model.llmclient.LlmChatRequestDto;
import com.example.webflux.model.llmclient.LlmChatResponseDto;
import com.example.webflux.model.llmclient.LlmType;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface LlmWebClientService {

    Mono<LlmChatResponseDto> getChatCompletion(LlmChatRequestDto llmChatRequestDto);

    LlmType getLlmType();

}
