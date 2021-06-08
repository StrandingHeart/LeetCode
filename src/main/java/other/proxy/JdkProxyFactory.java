package other.proxy;

import java.lang.reflect.Proxy;

/**
 * @author zhangyong
 * Created on 2021-06-08
 */
public class JdkProxyFactory {

    /**
     * 根据对象来获取对应的加载器去加载class对象
     * 根据对象反射取接口
     * 实现InvocationHandler的代理类
     * @param target
     * @return
     */
    public static Object getInstance(Object target){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),new BusinessInvocation(target));
    }
}
