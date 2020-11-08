package com.thoughtworks.capability.gtb.restfulapidesign.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    private Integer id;
    private String name;
    private String note;
    private List<Student> students = new ArrayList<>();

    public Group(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public void add(Student student){
        students.add(student);
    }
}
