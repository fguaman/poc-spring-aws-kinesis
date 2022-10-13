package cl.guaman.pocspringawskinesis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class PocSpringAwsKinesisApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocSpringAwsKinesisApplication.class, args);
	}

}
