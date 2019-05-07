package me.ukuz.designpattern.proxy.cglib;

import net.sf.cglib.core.DefaultGeneratorStrategy;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @author ukuz90
 * @date 2019-05-04
 */
public class TimeUseCglibDynamicProxy {

    private TimeUseCglibDynamicProxy() {
    }

    @SuppressWarnings("unchecked")
    public static <T> T newInstance(Class<T> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setStrategy(new DefaultGeneratorStrategy());

        enhancer.setCallback((MethodInterceptor) (obj, method, args, proxy) -> {

                long start = System.currentTimeMillis();
                Object ret = proxy.invokeSuper(obj, args);
                System.out.println(String.format("invoke %s#%s use %dms", obj.getClass().getSimpleName(),
                        method.getName(), System.currentTimeMillis() - start));

                return ret;

        });

        return (T) enhancer.create();
    }



}
