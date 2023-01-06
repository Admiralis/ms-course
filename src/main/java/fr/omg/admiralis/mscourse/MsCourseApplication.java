package fr.omg.admiralis.mscourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MsCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCourseApplication.class, args);
	}

}
