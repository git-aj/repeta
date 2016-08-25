package com.test.service;

import com.test.dao.PersonDao;
import com.test.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleServiceImpl implements SimpleService {

    @Autowired
    private PersonDao personDao;

    @Autowired
    private NotificationProvider notificationProvider;

    public String simpleServiceMethod(Integer foo) {
        notificationProvider.sendNotification("dummy", "message");

        return String.valueOf(foo);
    }

    @Override
    public String getSurname(String name) {
        return null;
    }

    @Override
    public List<String> getNames() {
        return null;
    }

    @Override
    public List<Person> getPeople() {
        // business stuff
        return personDao.getPeople();
    }

    @Override
    public List<Person> getPeople(String name) {
        // business stuff
        return personDao.getPeople(name);
    }

    public void simpleServiceRecovery() {
        notificationProvider.resendNotifications();
    }
}
