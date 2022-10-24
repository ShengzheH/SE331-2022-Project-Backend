package se331.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.TimeZone;

@SpringBootApplication
public class ProjectApplication {
	@PostConstruct
	public void init(){
//		TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
        System.out.println("Spring boot application running in GMT timezone :"+new Date());
//        System.setProperty("proxyType", "4"); // 设置代理类型，4应该是指http
//        System.setProperty("proxyPort","11000"); // 设置代理的端口号
//        System.setProperty("proxyHost", "127.0.0.1"); // 设置代理的ip地址
//        System.setProperty("proxySet", "true"); // 使代理生效
	}
	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

}
