package com.xusanjin.mytest.service.impl;

import com.xusanjin.mytest.dao.PersonDao;
import com.xusanjin.mytest.entity.Person;
import com.xusanjin.mytest.service.PersonService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@Log4j2
public class PersonServiceImpl  implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Override
    public List<Person> listPerson() {
        return personDao.getAll();
    }

}
