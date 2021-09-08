package com.example.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class ASameOrderFilter implements GlobalFilter, Ordered {

    final Logger logger = LoggerFactory.getLogger(PrePostRequestFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("same order filter pre log");
        return chain
                .filter(exchange)
                .then(Mono.fromRunnable(() -> logger.info("same order filter post log")));
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
