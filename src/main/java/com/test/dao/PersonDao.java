package com.test.dao;

import com.test.model.Person;

import java.util.List;

public interface PersonDao {

    List<String> getNames();

    List<Person> getPeople();

    List<Person> getPeople(String name);
}
