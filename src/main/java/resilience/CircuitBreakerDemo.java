package resilience;

import com.alibaba.fastjson.JSONObject;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;

@Slf4j
public class CircuitBreakerDemo {

    public static JSONObject getResponse(int i) {
        JSONObject result = new JSONObject();
        if (i % 2 == 0) {
            result.put("success", true);
            return result;
        } else {
            throw new RuntimeException("no even");
        }
    }

    public static void main(String[] args) {

        // 断路器配置(全局配置: 兼容springboot - application.yml)
        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
                // 调用异常的请求比例
                .failureRateThreshold(50)
                // 慢调用的请求比例
                .slowCallRateThreshold(50)
                // 慢调用的请求阈值
                .slowCallDurationThreshold(Duration.ofMillis(1000))
                // 断路器半开状态(开启状态经过一段时间 -> 半开, 请求放行尝试调用后端服务)下允许通过的调用次数: Todo 每秒？
                .permittedNumberOfCallsInHalfOpenState(3)
                // 断路器计算失败率或慢调用率之前所需的最小调用数(满足最小值的条件后才会基于断路配置进行判断)
                .minimumNumberOfCalls(10)
                // 滑动窗口的类型(基于数量 | 基于时间)
                .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.COUNT_BASED)
                // 滑动窗口的大小(数量: 次 | 时间: 秒)
                .slidingWindowSize(500)
                // 记录为失败的异常列表(用于统计失败率)
                .recordExceptions(Exception.class)
                // 被忽略的异常类型(不统计成功失败)
                .ignoreExceptions(IndexOutOfBoundsException.class)
                // 自定义断言(评估异常是否被记录)
                .recordException(e -> e.getMessage().contains("自定义记录异常的断言"))
                // 自定义断言(评估异常是否被忽略)
                .ignoreException(e -> e.getMessage().contains("自定义忽略异常的断言"))
                .build();

        // 使用默认配置创建circuitBreakerRegistry
        CircuitBreakerRegistry circuitBreakerRegistry = CircuitBreakerRegistry.of(circuitBreakerConfig);

        // 使用circuitBreakerRegistry创建断路器，配置是默认配置
        CircuitBreaker circuitBreakerWithDefaultConfig = circuitBreakerRegistry.circuitBreaker("circuitBreaker1");

        // 使用circuitBreakerRegistry创建断路器，配置是自定义配置
        CircuitBreaker circuitBreakerWithCustomConfig = circuitBreakerRegistry.circuitBreaker("circuitBreaker1", circuitBreakerConfig);

        // 处理CircuitBreakerEvent事件
        circuitBreakerWithCustomConfig.getEventPublisher()
                .onSuccess(event -> System.out.println("执行成功"))
                .onError(event -> System.out.println("执行异常"));

        // 使用断路器修饰需要的方法
//        circuitBreakerWithCustomConfig.decorateConsumer(CircuitBreakerDemo::getResponse);

        for(int i = 0; i <= 100; i++) {
            try {
                System.out.printf("序号[%s]开始请求", i);
                int finalI = i;
                circuitBreakerWithCustomConfig.executeRunnable(new Runnable() {
                    @Override
                    public void run() {
                        getResponse(finalI);
                    }
                });
                Thread.sleep(1000);
            } catch (Exception e) {
//                e.printStackTrace();
            }
        }

    }

}
