package com.wesker.webflux.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * 业务处理器 相当于Controller里的具体处理方法
 *
 * @author MR.ZHANG
 * @create 2018-08-25 10:25
 */
@Component
public class TimeHandler {

    /**
     * 返回日期字符串的ServerResponse
     */
    public Mono<ServerResponse> getDate(ServerRequest serverRequest) {
        return ok().contentType(MediaType.TEXT_PLAIN).body(
                Mono.just("Today is " + LocalDate.now()), String.class
        );
    }

    /**
     * 返回时间字符串的ServerResponse
     * @param serverRequest
     * @return
     */
    public Mono<ServerResponse> getTime(ServerRequest serverRequest) {
        return ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(
                Mono.just("Current time is " + LocalTime.now()), String.class
        );
    }

    /**
     * 每秒推送一次
     * @param serverRequest
     * @return
     */
    public Mono<ServerResponse> sendTimePerSec(ServerRequest serverRequest) {
        return ok().contentType(MediaType.TEXT_EVENT_STREAM).body(
                Flux.interval(Duration.ofSeconds(1)).
                        map(l ->  "Current time : " + LocalTime.now()),
                String.class);
    }
}
