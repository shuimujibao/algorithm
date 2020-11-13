package constant;

/**
 * @author sunxiaoyu3
 * @description 系统配置常量
 * @createTime 2020/11/13 09:47:00
 */
public interface ConfigConstants {
    /**
     * feign
     */
    class FEIGN_CONSTANT {
        /**
         * 连接超时时间
         */
        public static final int CONNECT_TIMEOUT_MILLIS = 20000;
        /**
         * 读取数据超时时间
         */
        public static final int READ_TIME_OUT_MILLIS = 30000;

        /**
         * 熔断提示
         */
        public static final String DEFAULT_MESSAGE = "服务器开小差了.";
    }
}
