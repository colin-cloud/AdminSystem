package com.company.boot.config;

import ch.qos.logback.core.db.DBHelper;
import com.company.boot.bean.Car;
import com.company.boot.bean.Host;
import com.company.boot.bean.Pet;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @author 小白学java
 * @version 3.0
 */

/**
 * 1. 配置类里面使用@Bean标注在方法上给容器添加组件，组件名就是方法名，默认是单实例的
 * 2. 配置类本身也是组件
 * 3. proxyBeanMethods：代理bean的方法
 *      Full:proxyBeanMethods = true 重量级配置
 *      Lite:proxyBeanMethods = false ->解决组件依赖 轻量级配置
 * 4. @Import({Host.class, DBHelper.class}):
 *      给容器中自动创建出这两个类型的的组件，默认组件的名字就是全类名：app.getBeanNamesForType
 */
@Import({Host.class, DBHelper.class})
@Configuration(proxyBeanMethods = true) //告诉SpringBoot这是一个配置类
//@ConditionalOnBean(name = "tom") //告诉SpringBoot这个配置类只有tom组件存在时才创建组件
@ImportResource("classpath:beans.xml") // 导入外部配置文件
@EnableConfigurationProperties(Car.class)
//1. 开启car属性配置功能
//2. 把car这个组件自动注入到容器中
public class MyConfig {

    @Bean("tom")
    public Pet pet01() {
        return new Pet("小花");
    }

    @Bean //给容器添加组件, 以方法名作为组件的id，返回类型就是组件类型，返回的值，就是组件容器的实例
    @ConditionalOnBean(name = "tom") //当容器中有tom组件时才注入host01 , 需要tom组件配置在前
    public Host host01(){
        Host host = new Host("小王", 19);
        //proxyBeanMethods = true : host组件依赖了pet组件
        //proxyBeanMethods = false : 不依赖
        host.setPet(pet01());
        return host;
    }
}
