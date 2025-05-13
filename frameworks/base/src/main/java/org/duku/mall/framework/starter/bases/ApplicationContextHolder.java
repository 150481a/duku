package org.duku.mall.framework.starter.bases;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.annotation.Annotation;
import java.util.Map;

public class ApplicationContextHolder  implements ApplicationContextAware, DisposableBean {


    private static ApplicationContext  CONTEXT;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextHolder.CONTEXT = applicationContext;
    }


    /**
     *  根据类型获取ioc容器中的bean
     * @param clazz
     * @return
     * @param <T>
     */
    public static <T> T getBean(Class<T> clazz) {
        return CONTEXT.getBean(clazz);
    }

    /**
     * 根据bean名称获取ioc容器中的bean
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName) {
            return CONTEXT.getBean(beanName);
    }

    /**
     * 根据bean名称和类型获取ioc容器中的bean
     * @param name
     * @param clazz
     * @return
     * @param <T>
     */
    public static <T> T getBean(String name, Class<T> clazz) {
        return CONTEXT.getBean(name, clazz);
    }


    /**
     * 根据类型获取ioc容器中所有bean
     * @param clazz
     * @return
     * @param <T>
     */
    public static <T> Map<String, T> getBeansOfType(Class<T> clazz) {
        return CONTEXT.getBeansOfType(clazz);
    }

    /**
     * 根据注解类型获取ioc容器中所有带有该注解的bean
     * @param beanName
     * @param annotationType
     * @return
     * @param <A>
     */
    public static <A extends Annotation> A findAnnotationOnBean(String beanName, Class<A> annotationType) {
        return CONTEXT.findAnnotationOnBean(beanName, annotationType);
    }

    /**
     * 获取ioc容器实例
     * @return
     */
    public static ApplicationContext getInstance() {
        return CONTEXT;
    }


    @Override
    public void destroy() throws Exception {
    }
}
