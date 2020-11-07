package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class StudentRepository {
    private List<Student> students;
    private AtomicInteger studentCount;

    public StudentRepository() {
        this.students = new ArrayList<>();
        this.studentCount = new AtomicInteger(students.size());
    }

    public Student save(Student student) {
        student.setId(this.studentCount.incrementAndGet());
        this.students.add(student);
        return student;
    }

}
