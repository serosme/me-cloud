package com.example.shared.core.processor;

import lombok.Data;

@Data
public class Context<I, O> {
    private I in;
    private O out;
}
