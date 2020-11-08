package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class StudentRepository {
    private List<Student> students = new ArrayList<>();
    private AtomicInteger studentCount = new AtomicInteger(students.size());

    public StudentRepository() {
        initStudents();
    }

    public void initStudents() {
        String[] StudentsName = {"成吉思汗", "鲁班七号", "太乙真人","钟无艳", "花木兰",
                "雅典娜", "芈月", "白起", "刘禅", "庄周", "马超", "刘备", "哪吒", "大乔","蔡文姬"};
        for(String name : StudentsName) {
            save(new Student(name));
        }
    }

    public Student save(Student student) {
        student.setId(studentCount.incrementAndGet());
        students.add(student);
        return student;
    }

    public Student findById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public void deleteById(int id) {
        students.remove(findById(id));
    }

    public Student update(int id, Student student) {
        Student student1 = findById(id);
        student1.setName(student.getName() != null ? student.getName() : student1.getName());
        student1.setGender(student.getGender() != null ? student.getGender() : student1.getGender());
        student1.setNote(student.getNote() != null ? student.getNote() : student1.getNote());
        return student1;
    }

    public List<Student> findAll() {
        return students;
    }

    public List<Student> findAllByGender(String gender) {
        List<Student> studentList = new ArrayList<>();
        for (Student student : students) {
            if (student.getGender().equals(gender)) {
                studentList.add(student);
            }
        }
        return studentList;
    }
}
