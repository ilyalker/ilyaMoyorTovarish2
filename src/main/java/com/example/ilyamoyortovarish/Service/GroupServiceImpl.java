package com.example.ilyamoyortovarish.Service;

import com.example.ilyamoyortovarish.Repository.DTO.GroupDTO;
import com.example.ilyamoyortovarish.Entity.Group;
import com.example.ilyamoyortovarish.Repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service // ну это то де самое что и помпонент только это испоьзуют для сервисов и никакой доп логики тут нет))
public class GroupServiceImpl implements GroupService{


    @Autowired
    private GroupRepository repository;

    @Override
    public void addGroup(GroupDTO groupDTO) {

        Group group = new Group();
        group.setGroupNumber(groupDTO.getNumber());
        repository.save(group);


    }

    @Override
    public List<Group> getAllGroups() {
        List<Group> groups;
        groups = repository.findAll();
        return groups;
    }

    @Override
    public void deleteGroup(GroupDTO groupDTO) {
        Group group = new Group();
       List <Group> allGroups = getAllGroups();
       group.setGroupNumber(groupDTO.getNumber());

        for (  Group groupIn : allGroups ) {
            if(groupIn.getGroupNumber().equals(group.getGroupNumber())){

                group = groupIn;

            }
        }

        repository.deleteById(group.getGroupId());
    }

    @Override
    public void saveGroup(Group group) {
        repository.save(group);
    }

    @Override
    public List<Group> savAllGroups(List<Group> groups) {
        return repository.saveAll(groups);
    }


}

