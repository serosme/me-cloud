package me.processor;

import org.springframework.context.ApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Processor {
    private final ApplicationContext applicationContext;

    public Processor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @SuppressWarnings("unchecked")
    public <C extends Context<?, ?>> void process(C context) {
        Class<C> type = (Class<C>) context.getClass();
        ResolvableType resolvableType = ResolvableType.forClassWithGenerics(Handler.class, type);

        List<Handler<C>> handlers = new ArrayList<>();
        for (String name : applicationContext.getBeanNamesForType(resolvableType)) {
            handlers.add((Handler<C>) applicationContext.getBean(name));
        }
        AnnotationAwareOrderComparator.sort(handlers);

        for (Handler<C> handler : handlers) {
            if (handler.shouldHandle(context)) {
                handler.handle(context);
            }
        }
    }
}
