# design-pattern-study

[TOC]

## 类型

### 原型模式

原型模式就是以一个对象为原型复制另外一个具有相同属性且相对独立的对象，在java中的体现是对象的克隆技术。这对于创建过程复杂的对象来说，就能提高代码的可读性。

### 工厂模式

对于一些有同类属性且易变的产品类，可以使用工厂模式，这样子用户只需关心抽象接口。而抽象接口也只要关心产品接口类。

* 简单工厂：简单工厂可以根据传入参数的不同，可以产生不同的产品类。一个工厂类通常只有一个方法，并且在一个类中封装了多个产品类的创建。这样子可以减少类个数，但是也带来一个问题。若是有新增产品类，那就要去修改工厂类。这违背了开闭原则。
* 工厂方法：一个工厂抽象类，只定义产生产品的抽象方法。每个具体工厂类只实现创建具体产品类。由用户来决定选择哪个具体工厂类，这样子若有新增产品类，只需增加新的具体工厂类即可，符合开闭原则。不过类个数会比较多就是。

### 观察者模式

如果项目中有一些产品的会因为另一个产品的变化而产生变化，那可以采用观察者模式，比如项目中有关于玩家消耗金币，可能达成某些任务，也会达成某些成就，甚至还会影响到后续出的一些系统，这时候用观察者模式，就可以解耦，产出端，不必了解消费端的细节。

### 策略模式

一个策略抽象类，通常只有一个抽象的行为。一个具体的策略类只实现一个具体的行为，由用户来选择使用哪一个具体的策略类，这样子也是符合开闭原则。这可能跟工厂方法模式有点像，策略模式是属于行为型模式，而工厂方法属于创建型模式，两者的关注点不太一样。

### 委派模式

委派者有任务需要处理，但他实际上不用关心具体的处理者是谁。他只要把任务委派给一个任务调度管理者，由这个管理者来调度任务到具体的处理者手上。委派模式关注的是这个调度者，也就是调度任务的过程。

### 代理模式

通常在不修改被目标类的前提下，要做到增强目标类现有方法的能力，这时候可以考虑代理模式。比如我们要对每个方法做耗时监控，可以使用代理模式。

* 静态代理：静态代理，要和被目标类实现同一个接口类或者继承同一个父类，如果要对每个类的方法做耗时监控，相当于要为每个类做一个代理类。这样子类个数会很多，无疑是可怕的。
* 动态代理：如果是JDK动态代理的话，目标类必须有一个抽象的接口类，因为JDK动态代理会生成一个继承Proxy的子类作为代理类。

### 模板模式

我们在项目中会遇到某些业务，他的相似的业务规则，只是在某一环节有略微的差异，这时候可以使用模板方法模式。

### 适配器模式

在已有的老旧系统，不改变原有代码的基础上做扩展，通常实现一个新接口并且继承一个旧的业务类。

## 应用

### Spring中应用

工厂方法模式：FactoryBean / EventListenerFactory/ AopProxyFactory

简单工厂模式：AbstractAutowireCapableBeanFactory

模板方法模式：AbstractApplicationContext

```java
public class AbstractApplicationContext implements ConfigurableApplicationContext {
  ...
  @Override
	public void refresh() throws BeansException, IllegalStateException {
		synchronized (this.startupShutdownMonitor) {
			// Prepare this context for refreshing.
			prepareRefresh();

			// Tell the subclass to refresh the internal bean factory.
			ConfigurableListableBeanFactory beanFactory = obtainFreshBeanFactory();

			// Prepare the bean factory for use in this context.
			prepareBeanFactory(beanFactory);

			try {
				// Allows post-processing of the bean factory in context subclasses.
				postProcessBeanFactory(beanFactory);

				// Invoke factory processors registered as beans in the context.
				invokeBeanFactoryPostProcessors(beanFactory);

				// Register bean processors that intercept bean creation.
				registerBeanPostProcessors(beanFactory);

				// Initialize message source for this context.
				initMessageSource();

				// Initialize event multicaster for this context.
				initApplicationEventMulticaster();

				// Initialize other special beans in specific context subclasses.
				onRefresh();

				// Check for listener beans and register them.
				registerListeners();

				// Instantiate all remaining (non-lazy-init) singletons.
				finishBeanFactoryInitialization(beanFactory);

				// Last step: publish corresponding event.
				finishRefresh();
			}

			...
		}
	}
  ...
}
```



策略模式：AbstractAutowireCapableBeanFactory

```java
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory
		implements AutowireCapableBeanFactory {
	...
  protected BeanWrapper instantiateBean(final String beanName, final RootBeanDefinition mbd) {
		try {
			...
				beanInstance = getInstantiationStrategy().instantiate(mbd, beanName, parent);
			BeanWrapper bw = new BeanWrapperImpl(beanInstance);
			initBeanWrapper(bw);
			return bw;
		}
		catch (Throwable ex) {
			...
		}
	}
	...
	
}
```



责任链模式：ReflectiveMethodInvocation/ HandlerExecutionChain 

```java
public class ReflectiveMethodInvocation implements ProxyMethodInvocation, Cloneable {
  ...
	protected final List<?> interceptorsAndDynamicMethodMatchers;
  ...
  public Object proceed() throws Throwable {
		//	We start with an index of -1 and increment early.
		if (this.currentInterceptorIndex == this.interceptorsAndDynamicMethodMatchers.size() - 1) {
			return invokeJoinpoint();
		}

		Object interceptorOrInterceptionAdvice =
				this.interceptorsAndDynamicMethodMatchers.get(++this.currentInterceptorIndex);
		if (interceptorOrInterceptionAdvice instanceof InterceptorAndDynamicMethodMatcher) {
			// Evaluate dynamic method matcher here: static part will already have
			// been evaluated and found to match.
			InterceptorAndDynamicMethodMatcher dm =
					(InterceptorAndDynamicMethodMatcher) interceptorOrInterceptionAdvice;
			Class<?> targetClass = (this.targetClass != null ? this.targetClass : this.method.getDeclaringClass());
			if (dm.methodMatcher.matches(this.method, targetClass, this.arguments)) {
				return dm.interceptor.invoke(this);
			}
			else {
				// Dynamic matching failed.
				// Skip this interceptor and invoke the next in the chain.
				return proceed();
			}
		}
		else {
			// It's an interceptor, so we just invoke it: The pointcut will have
			// been evaluated statically before this object was constructed.
			return ((MethodInterceptor) interceptorOrInterceptionAdvice).invoke(this);
		}
	}
  ...
}
```



适配器模式：AfterReturningAdviceAdapter/ MethodBeforeAdviceAdapter/ ThrowAdviceAdapter / RequestMappingHandlerAdapter 

代理模式：JdkDynamicAopProxy/ CglibAopProxy

```java
final class JdkDynamicAopProxy implements AopProxy, InvocationHandler, Serializable {
  ...
    @Override
	public Object getProxy(@Nullable ClassLoader classLoader) {
		if (logger.isTraceEnabled()) {
			logger.trace("Creating JDK dynamic proxy: " + this.advised.getTargetSource());
		}
		Class<?>[] proxiedInterfaces =  	AopProxyUtils.completeProxiedInterfaces(this.advised, true);
		findDefinedEqualsAndHashCodeMethods(proxiedInterfaces);
		return Proxy.newProxyInstance(classLoader, proxiedInterfaces, this);
	}
  ...
}

```



## 示例

* [工厂模式](https://github.com/jin-90/design-pattern-study/blob/master/factory) 
* [观察者模式](https://github.com/jin-90/design-pattern-study/tree/master/observer)
* [策略模式](https://github.com/jin-90/design-pattern-study/tree/master/strategy)
* [委派模式](https://github.com/jin-90/design-pattern-study/tree/master/delegate)
* [代理模式](https://github.com/jin-90/design-pattern-study/tree/master/proxy)
* [单例模式](https://github.com/zhuangjinjin/design-pattern-study/tree/master/singleton)
* [模板模式](https://github.com/zhuangjinjin/design-pattern-study/tree/master/template)
* [适配器模式](https://github.com/zhuangjinjin/design-pattern-study/tree/master/adapter)
* [原型模式](https://github.com/zhuangjinjin/design-pattern-study/tree/master/prototype)

