package com.test.service;

import com.test.model.Person;

import java.util.List;

public interface SimpleService {

    String simpleServiceMethod(Integer foo);

    String getSurname(String name);

    List<String> getNames();

    List<Person> getPeople();

    List<Person> getPeople(String name);

    void simpleServiceRecovery();
}
