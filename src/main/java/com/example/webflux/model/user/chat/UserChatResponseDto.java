package com.example.webflux.model.user.chat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserChatResponseDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 8146559329035188345L;

    private String response;

}
