package com.charan.learnjpaandhibernate.course;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class CourseCommandLineRunner implements CommandLineRunner {
    private final CourseJpaRepository repository;
    public CourseCommandLineRunner(CourseJpaRepository repository) {
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
