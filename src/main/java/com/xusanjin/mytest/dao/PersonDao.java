package com.xusanjin.mytest.dao;

import com.xusanjin.mytest.entity.Person;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface PersonDao {

    List<Person> getAll();

}
