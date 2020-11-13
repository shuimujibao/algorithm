package config;

import constant.ConfigConstants;
import feign.Logger;
import feign.Request;
import feign.Retryer;
import org.springframework.context.annotation.Bean;

/**
 * @author sunxiaoyu3
 * @description feign配置
 * @createTime 2020/11/13 09:46:00
 */
public class FeignConfiguration {
    /**
     * 日志输出
     *
     * @return Logger.Level
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    /**
     * 请求设置
     *
     * @return Request.Options
     */
    @Bean
    public Request.Options options() {
        return new Request.Options(ConfigConstants.FEIGN_CONSTANT.CONNECT_TIMEOUT_MILLIS, ConfigConstants.FEIGN_CONSTANT.READ_TIME_OUT_MILLIS);
    }

    /**
     * 重试设置 （默认5次）
     *
     * @return Retryer
     */
    @Bean
    public Retryer feignRetryer() {
        return new Retryer.Default();
    }

    /**
     * feign默认日志输出级别调整有debug --> info
     *
     * @return Logger
     */
    @Bean
    Logger FeignLoggerInFo() {
        return new FeignLoggerConfiguration();
    }
}
