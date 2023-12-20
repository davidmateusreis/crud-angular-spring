package com.david.crudspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.david.crudspring.enums.Category;
import com.david.crudspring.model.Course;
import com.david.crudspring.model.Lesson;
import com.david.crudspring.repository.CourseRepository;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	@Profile("dev")
	CommandLineRunner initDatabase(CourseRepository courseRepository) {
		return args -> {
			courseRepository.deleteAll();

			for (int i = 0; i < 20; i++) {

				Course c = new Course();

				c.setName("Angular com Spring");
				c.setCategory(Category.FRONTEND);

				Lesson lesson = new Lesson();
				lesson.setName("Introduction");
				lesson.setYoutubeUrl("12345678910");
				lesson.setCourse(c);
				c.getLessons().add(lesson);

				Lesson lesson1 = new Lesson();
				lesson1.setName("Angular");
				lesson1.setYoutubeUrl("12345678910");
				lesson1.setCourse(c);
				c.getLessons().add(lesson1);

				courseRepository.save(c);
			}
		};
	}

}
