package com.example.demo.dao;

import com.example.demo.bean.Person;
import com.example.demo.support.CustomRepository;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PersonRepository extends CustomRepository<Person,Long> {

    @Query("Select p from Person p where p.name=:name")
    List<Person> findByName(@Param("name")String name);

    @Query("select p from Person p where p.name= :name and p.address= :address")
    Person findByNameAndAddress(@Param("name") String name, @Param("address")String address);

    @Modifying
    @Transactional
    @Query("update Person p set p.name=:name where p.id=:id")
    int setName(@Param("name")String name,@Param("id")Long id);

}
