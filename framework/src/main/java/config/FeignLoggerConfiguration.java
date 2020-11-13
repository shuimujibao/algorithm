package config;

import feign.Request;
import feign.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author sunxiaoyu3
 * @description feign默认日志输出级别调整有debug --> info
 * @createTime 2020/11/13 09:48:00
 */
public class FeignLoggerConfiguration extends feign.Logger {
    private final Logger logger;

    FeignLoggerConfiguration() {
        this(feign.Logger.class);
    }

    private FeignLoggerConfiguration(Class<?> clazz) {
        this(LoggerFactory.getLogger(clazz));
    }

    private FeignLoggerConfiguration(Logger logger) {
        this.logger = logger;
    }


    @Override
    protected void logRequest(String configKey, feign.Logger.Level logLevel, Request request) {
        if (logger.isInfoEnabled()) {
            super.logRequest(configKey, logLevel, request);
        }
    }

    @Override
    protected Response logAndRebufferResponse(String configKey, feign.Logger.Level logLevel, Response response, long elapsedTime)
            throws IOException {
        if (logger.isInfoEnabled()) {
            return super.logAndRebufferResponse(configKey, logLevel, response, elapsedTime);
        }
        return response;
    }

    @Override
    protected void log(String configKey, String format, Object... args) {
        // Not using SLF4J's support for parameterized messages (even though it
        // would be more efficient) because it would
        // require the incoming message formats to be SLF4J-specific.
        if (logger.isInfoEnabled()) {
            logger.info(String.format(methodTag(configKey) + format, args));
        }
    }
}
