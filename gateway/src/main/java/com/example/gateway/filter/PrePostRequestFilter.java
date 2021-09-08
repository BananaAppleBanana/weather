package com.example.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 *  filter order global
 *  {
 *   "org.springframework.cloud.gateway.filter.LoadBalancerClientFilter@77856cc5": 10100,
 *   "org.springframework.cloud.gateway.filter.RouteToRequestUrlFilter@4f6fd101": 10000,
 *   "org.springframework.cloud.gateway.filter.NettyWriteResponseFilter@32d22650": -1,
 *   "org.springframework.cloud.gateway.filter.ForwardRoutingFilter@106459d9": 2147483647,
 *   "org.springframework.cloud.gateway.filter.NettyRoutingFilter@1fbd5e0": 2147483647,
 *   "org.springframework.cloud.gateway.filter.ForwardPathFilter@33a71d23": 0,
 *   "org.springframework.cloud.gateway.filter.AdaptCachedBodyGlobalFilter@135064ea": 2147483637,
 *   "org.springframework.cloud.gateway.filter.WebsocketRoutingFilter@23c05889": 2147483646
 * }
 */
@Component
public class PrePostRequestFilter implements GlobalFilter, Ordered {

    final Logger logger = LoggerFactory.getLogger(PrePostRequestFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("pre log");
        return chain
                .filter(exchange)
                .then(Mono.fromRunnable(() -> logger.info("post log")));
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
