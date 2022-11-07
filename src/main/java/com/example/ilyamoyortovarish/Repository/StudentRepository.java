package com.example.ilyamoyortovarish.Repository;


import com.example.ilyamoyortovarish.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
}
