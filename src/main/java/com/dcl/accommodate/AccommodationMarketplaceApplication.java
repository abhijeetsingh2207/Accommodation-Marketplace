package com.dcl.accommodate;

import com.dcl.accommodate.jwt.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AccommodationMarketplaceApplication {
   @Autowired
   private JwtService jwtService;
	public static void main(String[] args) {
		 SpringApplication.run(AccommodationMarketplaceApplication.class, args);

	}

}
