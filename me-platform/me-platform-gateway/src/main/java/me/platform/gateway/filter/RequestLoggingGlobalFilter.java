package me.platform.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

@Slf4j
@Component
public class RequestLoggingGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();

        // 请求方法
        HttpMethod method = request.getMethod();

        // 请求路径
        String path = request.getURI().getRawPath();

        // 请求头
        StringBuilder headers = new StringBuilder();
        request.getHeaders().forEach((key, value) -> headers.append(key).append(": ").append(String.join(",", value)).append("; "));

        // 请求参数
        String queryParams = request.getQueryParams().toSingleValueMap().toString();

        // 请求体
        String queryBody = "";
        MediaType contentType = request.getHeaders().getContentType();
        if (MediaType.APPLICATION_JSON.equalsTypeAndSubtype(contentType)) {
            DataBuffer cachedRequestBody = exchange.getAttribute(ServerWebExchangeUtils.CACHED_REQUEST_BODY_ATTR);
            if (!ObjectUtils.isEmpty(cachedRequestBody)) {
                queryBody = cachedRequestBody.toString(StandardCharsets.UTF_8);
            }
        }

        log.info("method = {} path = {} headers = {} queryParams = {} queryBody = {}", method, path, headers, queryParams, queryBody);

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
