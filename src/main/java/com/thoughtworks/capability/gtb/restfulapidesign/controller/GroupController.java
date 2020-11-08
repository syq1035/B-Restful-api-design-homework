package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.service.GroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroupController {
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping("/groups")
    public ResponseEntity<List<Group>> grouping() {
        return ResponseEntity.created(null).body(groupService.grouping());
    }

    @GetMapping("/groups")
    public ResponseEntity<List<Group>> getAllGroups() {
        return ResponseEntity.ok(groupService.getAllGroups());
    }

    @PatchMapping("/groups")
    public ResponseEntity<Group> updateGroupName(@RequestParam Integer id, @RequestParam String name) {
        return ResponseEntity.ok(groupService.updateGroupName(id, name));
    }
}
