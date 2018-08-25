package com.wesker.webflux.config;

import com.wesker.webflux.handler.TimeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * 路由拦截，相当于RequestMapping
 *
 * @author MR.ZHANG
 * @create 2018-08-25 10:23
 */
@Configuration
public class RouterConfig {
    @Autowired
    TimeHandler timeHandler;

    @Bean
    public RouterFunction<ServerResponse> timerRouter() {
        return route(GET("/time"),timeHandler::getTime)
                .andRoute(GET("/date"),timeHandler::getDate)
                .andRoute(GET("/times"),timeHandler::sendTimePerSec);
    }
}
