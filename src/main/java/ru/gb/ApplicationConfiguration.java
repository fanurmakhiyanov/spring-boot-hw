package ru.gb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class ApplicationConfiguration {

    @Bean
    StudentRepository myStudentRepositoryBean() {
        return new StudentRepository();
    }
}
