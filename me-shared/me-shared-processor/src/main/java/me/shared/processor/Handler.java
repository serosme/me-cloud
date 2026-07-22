package me.shared.processor;

public interface Handler<C extends Context<?, ?>> {
    /**
     * 是否应该处理
     *
     * @param context 上下文
     * @return 是否应该处理
     */
    default boolean shouldHandle(C context) {
        return true;
    }

    /**
     * 处理
     *
     * @param context 上下文
     */
    void handle(C context);
}
