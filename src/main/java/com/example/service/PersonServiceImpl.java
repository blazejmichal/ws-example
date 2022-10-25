package com.example.service;

import com.example.model.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonServiceImpl
    implements
    PersonService {

  @Override
  public Person getPerson(
      String pesel
  ) {
    // TODO: calling dataSource to be implemented
    return new Person(
        "Jan",
        "Kowalski",
        pesel
    );
  }

}