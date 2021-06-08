package other.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zhangyong
 * Created on 2021-06-08
 */
public class CglibMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before cglib 调用动态代理");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println(result);
        System.out.println("after cglib 调用动态代理");
        return result;
    }
}
