package com.example.shared.core;

public interface Handler<C extends Context<?, ?>> {
    default boolean shouldHandle(C context) {
        return true;
    }

    void handle(C context);
}
