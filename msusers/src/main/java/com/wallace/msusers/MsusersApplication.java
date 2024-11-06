package com.wallace.msusers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableFeignClients
public class MsusersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsusersApplication.class, args);
	}

	@Bean
	public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
	}

}
