package com.example.webflux.model.llmclient;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LimModel {
    GPT_40("gpt-40", LimType.GPT),
    GEMINI_2_0_FLASH("gemini-2.0-flash", LimType.GEMINI);

    private final String code;
    private final LimType limType;

}
