package other.proxy;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author zhangyong
 * Created on 2021-06-08
 */
public class CglibFactory {

    /**
     * 使用Enhancer来创建代理对象
     * @param classZ
     * @return  
     * @author zhangyong
     */
    public static Object getInstance(Class<?> classZ){
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(classZ.getClassLoader());
        // 设置被代理类
        enhancer.setSuperclass(classZ);
        enhancer.setCallback(new CglibMethodInterceptor());
        return enhancer.create();
    }
}
