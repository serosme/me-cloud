package com.example.shared.processor;

import lombok.Data;

@Data
public class Context<I, O> {
    private I in;
    private O out;
}
