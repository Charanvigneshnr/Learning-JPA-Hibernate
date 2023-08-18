package com.charan.learnjpaandhibernate.course.jdbc;

import com.charan.learnjpaandhibernate.course.Course;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
    private final JdbcTemplate springJdbcTemplete;
    private static final String INSERT_QUERY =
            "INSERT INTO course (id,name,author) VALUES(?,?,?);";
    private static final String DELETE_QUERY =
            "DELETE FROM course WHERE id = ?;";

    private static final String SELECT_QUERY = "SELECT * FROM course WHERE id=?;";
    public CourseJdbcRepository(JdbcTemplate springJdbcTemplete) {
        this.springJdbcTemplete = springJdbcTemplete;
    }

    public void insert(Course course){
        springJdbcTemplete.update(INSERT_QUERY, course.id(),course.name(),course.author());
    }
    public void deleteById(long id){
        springJdbcTemplete.update(DELETE_QUERY, id);
    }

    public Course findById(long id){
        return springJdbcTemplete.queryForObject(SELECT_QUERY,new BeanPropertyRowMapper<>(Course.class),id);
    }

}
