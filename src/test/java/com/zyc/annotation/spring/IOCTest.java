package com.zyc.annotation.spring;

import com.zyc.annotation.spring.bean.Person;
import com.zyc.annotation.spring.config.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

public class IOCTest {

    @SuppressWarnings("resource")
    @Test
    public void testBeanNames(){

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfComponnetScan.class);
        //打印所有bean名称
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String s: beanDefinitionNames
             ) {
            System.out.println(s);
        }
    }


    @Test
    public void Test02 (){

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfConditional.class);
        Environment environment = applicationContext.getEnvironment();
        //获取操作系统的名称
        String property = environment.getProperty("os.name");
        System.out.println(property);
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String s :
                beanNamesForType) {
            System.out.print(s);
        }
    }

    @Test
    public void Test03() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfRegisterBean.class);
        String[] beanNamesForType = applicationContext.getBeanDefinitionNames();
        for (String s :
                beanNamesForType) {
            System.out.println(s);
        }
        Object bean = applicationContext.getBean("myFactoryBean");
        System.out.println(bean.getClass());

    }

    @Test
    public void Test04(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLiftCycle.class);
        applicationContext.close();
    }
    @Test
    public void TestOfValue(){

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfValue.class);
        Person bean = applicationContext.getBean(Person.class);
        System.out.println(bean);

    }
    @Test
    public void TestOfAutowired(){

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);

    }

    @Test
    public void TestOfProfile(){
        //ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.getEnvironment().setActiveProfiles("dev", "prov");
        applicationContext.register(MainConfigOfProfile.class);
        applicationContext.refresh();
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String s : beanDefinitionNames) {
            System.out.println(s);
        }
    }

}