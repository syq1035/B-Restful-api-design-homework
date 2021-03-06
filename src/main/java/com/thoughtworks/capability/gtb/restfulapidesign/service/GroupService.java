package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<Group> grouping() {
        return groupRepository.grouping();
    }

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public Group updateGroupName(Integer id, String name) {
        return groupRepository.updateNameById(id, name);
    }
}
