package com.test.service;

import com.test.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SimpleRestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleRestController.class);

    @Autowired
    private SimpleService simpleService;

    @RequestMapping("/names")
    public List<String> names() {
        return simpleService.getNames();
    }

    @RequestMapping("/surname")
    public String surname(@RequestParam("name") String name) {
        return simpleService.getSurname(name);
    }

    @RequestMapping("/people")
    public List<Person> people() {
        return simpleService.getPeople();
    }

    @RequestMapping(value = "/people", params = {"name"})
    public List<Person> people(@RequestParam("name") String name) {
        return simpleService.getPeople(name);
    }

    @RequestMapping("/user")
    public Map<String, String> user() {
        LOGGER.info("user|User: ");
        return new HashMap<>();
    }

}
