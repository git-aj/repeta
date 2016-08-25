package com.test.dao;

import com.test.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PersonDaoImpl implements PersonDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private RowMapper<Person> personMapper;

    @Override
    public List<String> getNames() {
        return jdbcTemplate.getJdbcOperations().queryForList("select name from people", String.class);
    }

    @Override
    public List<Person> getPeople() {
        return jdbcTemplate.query("select name, surname, age from people;", personMapper);
    }

    @Override
    public List<Person> getPeople(String name) {
        Map<String, String> params = new HashMap<>();
        params.put("name", name);
        return jdbcTemplate.query("select name, surname, age from people where name = :name", params, personMapper);
    }

}
