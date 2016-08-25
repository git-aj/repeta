package com.test.dao;

import com.test.model.Person;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PersonRowMapper implements RowMapper<Person> {

    @Override
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {
        Person result = new Person();
        result.setName(resultSet.getString("name"));
        result.setSurname(resultSet.getString("surname"));
        result.setAge(resultSet.getInt("age"));
        return result;
    }

}
