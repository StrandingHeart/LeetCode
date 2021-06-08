package other.proxy;

/**
 * @author zhangyong
 * Created on 2021-06-08
 */
public class Main {
    public static void main(String[] args) {
        // JDK 动态代理只能代理实现了接口的类或者直接代理接口
        BusinessService businessService = (BusinessService) JdkProxyFactory.getInstance(new BusinessServiceImpl());
        businessService.getUserId();
        // cglib方式动态代理,CGLIB 动态代理是通过生成一个被代理类的子类来拦截被代理类的方法调用，因此不能代理声明为 final 类型的类和方法
        BusinessService businessService2 = (BusinessService) CglibFactory.getInstance(BusinessServiceImpl.class);
        // 加上other.proxy.BusinessServiceImpl.getName 方法的final就访问不了了。
        businessService2.getName();
        //before JDK动态代理
        //100
        //after JDK动态代理
        //before cglib 调用动态代理
        //this is my name
        //after cglib 调用动态代理
    }
}
