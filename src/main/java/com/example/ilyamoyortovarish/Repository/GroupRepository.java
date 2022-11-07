package com.example.ilyamoyortovarish.Repository;


import com.example.ilyamoyortovarish.Entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



@Repository
public interface GroupRepository extends JpaRepository<Group,Integer> { // обязательно наследуем от этого класса и в
    // параметры вставляем то с чем будет взаимодействоать integer ставим потому что будет работать с айди а он у нас тип инт
    // благодаря этому у нас появляются все опциональные методы такие как сохранить удалить и т д




}
