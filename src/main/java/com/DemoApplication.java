package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.ijpay.config.StartupRunner;
import com.ijpay.config.TaskRunner;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@MapperScan("com.ijpay.mapper")
@ComponentScan({"com","me.chanjar"})
@EnableAutoConfiguration
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
//		SpringApplication springApplication = new SpringApplication(DemoApplication.class);
//		//禁止命令行设置参数
//		springApplication.setAddCommandLineProperties(false);
//		springApplication.run(args);
	}
	
	 @Bean
     public StartupRunner startupRunner(){

         return new StartupRunner();
     }

     @Bean
     public TaskRunner taskRunner(){
         return new TaskRunner();
     }
}
