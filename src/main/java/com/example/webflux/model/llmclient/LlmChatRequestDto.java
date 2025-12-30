package com.example.webflux.model.llmclient;

import com.example.webflux.model.user.chat.UserChatRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LlmChatRequestDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 5009353172145761069L;

    private String userRequest;
    private String systemPrompt;
    private Boolean userJson;
    private LlmModel limModel;

    public LlmChatRequestDto(UserChatRequestDto userChatRequestDto, String systemPrompt) {
        this.userRequest = userChatRequestDto.getRequest();
        this.systemPrompt = systemPrompt;
        this.limModel = userChatRequestDto.getLimModel();
    }
}
