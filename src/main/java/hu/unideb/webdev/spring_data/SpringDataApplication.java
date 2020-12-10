package hu.unideb.webdev.spring_data;

import hu.unideb.webdev.spring_data.dao.*;
import hu.unideb.webdev.spring_data.dao.entity.ActorEntity;
import hu.unideb.webdev.spring_data.model.Actor;
import hu.unideb.webdev.spring_data.model.Category;
import hu.unideb.webdev.spring_data.model.Language;
import hu.unideb.webdev.spring_data.service.ActorService;
import hu.unideb.webdev.spring_data.service.CategoryService;
import hu.unideb.webdev.spring_data.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.Timestamp;
import java.util.Date;

@SpringBootApplication
public class SpringDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

}
