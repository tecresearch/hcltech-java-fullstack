##Spring Bean lifecycle:
The Spring Bean lifecycle is a fundamental concept in the Spring Framework. It describes the sequence of steps that a Spring-managed bean goes through from its instantiation to its destruction. Below is a simple Spring program that demonstrates the lifecycle of a Spring bean using the InitializingBean, DisposableBean interfaces, and custom init and destroy methods.

#Steps in the Spring Bean Lifecycle:
Instantiation: The bean is instantiated by the Spring container.

Population of Properties: Dependencies are injected into the bean.

Bean Post-Processing: Custom logic can be applied using BeanPostProcessor.

Initialization: The afterPropertiesSet() method (from InitializingBean) or a custom init method is called.

Bean is Ready: The bean is ready to be used.

Destruction: The destroy() method (from DisposableBean) or a custom destroy method is called before the bean is destroyed.

##Explanation of the Output:
Instantiation: The bean is created using the constructor.

Population of Properties: The message property is set.

Initialization: The afterPropertiesSet() method (from InitializingBean) is called.

Custom Initialization: The customInit() method is called.

Bean in Use: The printMessage() method is called.

Destruction: The destroy() method (from DisposableBean) is called.

Custom Destruction: The customDestroy() method is called.

Key Points:
The InitializingBean and DisposableBean interfaces provide lifecycle callbacks.

Custom init and destroy methods can be configured in the beans.xml file.

The AbstractApplicationContext is used to register a shutdown hook, ensuring that the destroy methods are called when the application exits.

This program demonstrates the complete lifecycle of a Spring bean. You can extend it further by adding BeanPostProcessor for additional customization.