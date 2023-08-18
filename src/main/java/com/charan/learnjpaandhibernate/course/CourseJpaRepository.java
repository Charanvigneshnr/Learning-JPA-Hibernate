package com.charan.learnjpaandhibernate.course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
@Repository
public class CourseJpaRepository {
    @PersistenceContext
    private EntityManager entityManger;
    public void insert(Course course){
        entityManger.merge(course);
    }
    public Course findById(long id){
        return entityManger.find(Course.class,id);
    }
    public void deleteById(int course){
        Course course1 = entityManger.find(Course.class, course);
        entityManger.remove(course1);
    }
}
