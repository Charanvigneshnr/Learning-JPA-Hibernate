package com.charan.learnjpaandhibernate.course.jdbc;

import com.charan.learnjpaandhibernate.course.Course;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {
    private final CourseJdbcRepository repository;

    public CourseJdbcCommandLineRunner(CourseJdbcRepository repository) {
        this.repository = repository;
    }
    String[] course = {"Spring Boot", "AWS", "DevOps", "JavaEE"};
    @Override
    public void run(String... args) {
        int i;
        int len = course.length;
        for (i = 0; i < len; i++) {
            repository.insert(new Course((long)i+1,course[i], "Charan"));
        }
        repository.deleteById(4);
        System.out.println(repository.findById(3));
        System.out.println(repository.findById(1));
    }
}
