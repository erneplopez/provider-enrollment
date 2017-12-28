package com.behavnotea.providerenrollment;

import com.behavnotea.providerenrollment.services.ProviderStatusImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProviderEnrollmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProviderEnrollmentApplication.class, args);

		//ApplicationContext ctx = SpringApplication.run(ProviderEnrollmentApplication.class, args);

		//ProviderStatusImpl controller = (ProviderStatusImpl) ctx.getBean("providerStatusImpl");

		//controller.get("","");

		//System.out.println("*********"+controller.get("","").get("value")+"***********");
	}
}
