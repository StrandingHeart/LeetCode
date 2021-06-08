package other.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理扩展类，在原有对象的基础上附加额外功能
 * @author zhangyong
 * Created on 2021-06-08
 */
public class BusinessInvocation implements InvocationHandler {

    /**
     * target为原对象
     */
    private Object target;

    public BusinessInvocation(Object target) {
        this.target = target;
    }

    /**
     * 当我们的动态代理对象调用一个方法时候，这个方法的调用就会被转发到实现InvocationHandler 接口类的 invoke 方法来调用。
     * proxy :动态生成的代理类
     * method : 与代理类对象调用的方法相对应
     * args : 当前 method 方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before JDK动态代理");
        Object result = method.invoke(target, args);
        // 输出100，源对象方法的返回值
        System.out.println(result);
        System.out.println("after JDK动态代理");
        return result;
    }
}
