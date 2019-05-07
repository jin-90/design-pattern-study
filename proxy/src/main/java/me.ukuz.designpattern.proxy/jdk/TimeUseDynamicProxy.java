package me.ukuz.designpattern.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ukuz90
 * @date 2019-05-04
 */
public class TimeUseDynamicProxy implements InvocationHandler {

    private Object target;

    private TimeUseDynamicProxy(Object target) {
        this.target = target;
    }


    @SuppressWarnings("unchecked")
    public static <T> T newInstance(Class<?> clazz) throws IllegalAccessException, InstantiationException {
        Object target = clazz.newInstance();
        TimeUseDynamicProxy proxy = new TimeUseDynamicProxy(target);
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), proxy);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();

        Object ret = method.invoke(this.target, args);

        System.out.println(String.format("invoke %s#%s use %dms", this.target.getClass().getSimpleName(),
                method.getName(), System.currentTimeMillis() - start));

        return ret;
    }
}
