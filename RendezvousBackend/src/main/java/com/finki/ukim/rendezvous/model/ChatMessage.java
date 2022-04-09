package com.finki.ukim.rendezvous.model;

import com.finki.ukim.rendezvous.model.enums.MessageType;
import lombok.Builder;
import lombok.Getter;

@Builder
public class ChatMessage {

    @Getter
    private MessageType type;

    @Getter
    private String content;

    @Getter
    private String sender;

    @Getter
    private String time;
}
