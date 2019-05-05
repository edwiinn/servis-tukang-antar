package tc.pbkk.servistukangantar.restapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@ComponentScan("tc.pbkk.servistukangantar")
@EnableJpaRepositories("tc.pbkk.servistukangantar.dao")
@EntityScan("tc.pbkk.servistukangantar.model")
@SpringBootApplication
public class ServisTukangAntarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServisTukangAntarApplication.class, args);
	}

}
