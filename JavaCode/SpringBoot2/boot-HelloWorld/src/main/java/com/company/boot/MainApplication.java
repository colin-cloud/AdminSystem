package com.company.boot;

import ch.qos.logback.core.db.DBHelper;
import com.company.boot.bean.Host;
import com.company.boot.bean.Pet;
import com.company.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * @author 小白学java
 * @version 3.0
 */

/**
 * @SpringBootApplication : 表示这是一个springboot应用
 */
//改变扫描路径：scanBasePackages
//@SpringBootApplication(scanBasePackages = "com.company")
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan()
public class MainApplication {

    public static void main(String[] args) {
        //1. 返回IOC容器
        ConfigurableApplicationContext applicationContext = SpringApplication.run(MainApplication.class, args);
        //2. 查看容器里面的组件
        for (String name : applicationContext.getBeanDefinitionNames()) {
            System.out.println(name);
        }
        //3. 获取组件
        Pet tom = applicationContext.getBean("tom", Pet.class);
        System.out.println(tom);
        //获取配置类组件
        //获取的是com.company.boot.config.MyConfig$$EnhancerBySpringCGLIB$$a4fb2295@7f34a967代理对象
        MyConfig myConfig = applicationContext.getBean(MyConfig.class);
        System.out.println(myConfig);
        //4. 得到的都是单实例对象
        //如果@Configuration(proxyBeanMethods = true)代理对象调用方法.SpringBoot总是会检查这个组件是否在容器中
        Host host01 = myConfig.host01();
        Host host02 = myConfig.host01();
        System.out.println(host01 == host02);
        //5. 获取Import所生成的组件
        for (String s : applicationContext.getBeanNamesForType(Host.class)) {
            System.out.println(s);
        }
        DBHelper helper = applicationContext.getBean(DBHelper.class);
        System.out.println(helper);
        //容器中是否有组件
        boolean exist = applicationContext.containsBean("host");
        System.out.println(exist);
    }
}
