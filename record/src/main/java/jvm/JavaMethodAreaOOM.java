package jvm;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author sunxiaoyu3
 * @description 借助CGLib使得方法区出现内存溢出异常
 * @createTime 2020/09/18 11:20:00
 * <p>
 * VM Args: -XX:PerSize=10M -XX:MaxPerSize=10M
 */
public class JavaMethodAreaOOM {

    static class OOMObject {
    }

    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);

            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                    return proxy.invokeSuper(obj, args);
                }
            });
        }
    }
}
