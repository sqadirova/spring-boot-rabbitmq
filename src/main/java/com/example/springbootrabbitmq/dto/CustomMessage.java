package com.example.springbootrabbitmq.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomMessage {
    private String content;
    private int priority;
}
