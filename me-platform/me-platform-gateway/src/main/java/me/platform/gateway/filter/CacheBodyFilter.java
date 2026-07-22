package me.platform.gateway.filter;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.event.EnableBodyCachingEvent;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CacheBodyFilter {
    private final RouteLocator routeLocator;
    private final ApplicationEventPublisher publisher;

    @EventListener(RefreshRoutesEvent.class)
    public void onRoutesRefreshed() {
        routeLocator.getRoutes().subscribe(routeDefinition -> {
            EnableBodyCachingEvent event = new EnableBodyCachingEvent(new Object(), routeDefinition.getId());
            publisher.publishEvent(event);
        });
    }
}
