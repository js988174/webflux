package com.example.webflux.model.llmclient.gpt.request;

import com.example.webflux.model.llmclient.LlmChatRequestDto;
import com.example.webflux.model.llmclient.LlmModel;
import com.example.webflux.model.llmclient.gpt.GptMessageRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GptChatRequestDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -9073152758692500958L;

    private List<GptCompletionRequestDto> message;
    private LlmModel model;
    private Boolean stream;
    private GptResponseFormat response_format;

    public GptChatRequestDto(LlmChatRequestDto llmChatRequestDto) {

        if(Optional.ofNullable(llmChatRequestDto.getUserJson()).filter(userJson -> userJson).isPresent()) {
            this.response_format = new GptResponseFormat("json_object");
        }

        this.message = List.of(new GptCompletionRequestDto(GptMessageRole.SYSTEM, llmChatRequestDto.getSystemPrompt()),
            new GptCompletionRequestDto(GptMessageRole.USER, llmChatRequestDto.getUserRequest()));

        this.model = llmChatRequestDto.getLimModel();
    }
}
