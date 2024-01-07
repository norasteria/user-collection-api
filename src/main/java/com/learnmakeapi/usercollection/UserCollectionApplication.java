package com.learnmakeapi.usercollection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {
		"com.learnmakeapi.usercollection.repository",
})
@SpringBootApplication
//@EnableJpaAuditing(dateTimeProviderRef = "auditingDateTimeProvider")
public class UserCollectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserCollectionApplication.class, args);
	}

}
