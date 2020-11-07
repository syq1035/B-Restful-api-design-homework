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

    public Student findById(int id) {
        for (Student student : this.students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public void deleteById(int id) {
        this.students.remove(findById(id));
    }

    public List<Student> findAll() {
        return this.students;
    }

    public List<Student> findAllByGender(String gender) {
        List<Student> studentList = new ArrayList<>();
        for (Student student : this.students) {
            if (student.getGender().equals(gender)) {
                studentList.add(student);
            }
        }
        return studentList;
    }
}
