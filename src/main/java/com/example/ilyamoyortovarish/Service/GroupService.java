package com.example.ilyamoyortovarish.Service;


import com.example.ilyamoyortovarish.Repository.DTO.GroupDTO;
import com.example.ilyamoyortovarish.Entity.Group;

import java.util.List;

public interface GroupService {
    void addGroup(GroupDTO group);
    List<Group> getAllGroups();

  void deleteGroup(GroupDTO groupDTO);

  void saveGroup(Group group);

  List<Group> savAllGroups(List<Group> groups);

  }

