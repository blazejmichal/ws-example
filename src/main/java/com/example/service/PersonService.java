package com.example.service;

import com.example.model.Person;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface PersonService {

  @WebMethod
  public abstract Person getPerson(
      @WebParam(name = "pesel") String pesel
  );

}