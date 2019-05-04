package me.ukuz.designpattern.proxy.cglib;

import net.sf.cglib.core.DefaultGeneratorStrategy;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: ukuz90
 * @create: 2019-05-04
 */
public class TimeUseCglibDynamicProxy {

    private TimeUseCglibDynamicProxy() {
    }

    public static <T> T newInstance(Class<T> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setStrategy(new DefaultGeneratorStrategy());

        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                long start = System.currentTimeMillis();
                Object ret = proxy.invokeSuper(obj, args);
                System.out.println(String.format("invoke %s#%s use %dms", obj.getClass().getSimpleName(),
                        method.getName(), System.currentTimeMillis() - start));

                return ret;
            }
        });

        return (T) enhancer.create();
    }



}
