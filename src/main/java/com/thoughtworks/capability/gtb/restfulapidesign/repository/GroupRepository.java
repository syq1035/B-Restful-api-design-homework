package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class GroupRepository {
    private List<Group> groups = new ArrayList<>();
    private AtomicInteger groupCount = new AtomicInteger(groups.size());
    private final Integer GROUP_COUNT = 6;
    private final StudentRepository studentRepository;


    public GroupRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Group> grouping() {
        initGroups();
        List<Student> students = studentRepository.findAll();
        Collections.shuffle(students);
        int flag = 0;
        for(Student student: students) {
            groups.get(flag).add(student);
            flag ++;
            flag = flag >= GROUP_COUNT ? 0 : flag;
        }
        return groups;
    }

    public void initGroups() {
        groups.clear();
        for (int i = 0; i < GROUP_COUNT; i ++){
            groups.add(new Group(groupCount.incrementAndGet(), (i + 1) + " 组"));
        }
    }
}
