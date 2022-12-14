package com.example.model;

import java.util.Objects;

public class Person {

  private String imie;
  private String nazwisko;
  private String pesel;

  public Person(
  ) {
  }

  public Person(
      String imie,
      String nazwisko,
      String pesel
  ) {
    this.imie = imie;
    this.nazwisko = nazwisko;
    this.pesel = pesel;
  }

  public String getImie() {
    return imie;
  }

  public void setImie(String imie) {
    this.imie = imie;
  }

  public String getNazwisko() {
    return nazwisko;
  }

  public void setNazwisko(String nazwisko) {
    this.nazwisko = nazwisko;
  }

  public String getPesel() {
    return pesel;
  }

  public void setPesel(String pesel) {
    this.pesel = pesel;
  }

  @Override
  public boolean equals(
      Object o
  ) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Person person = (Person) o;
    return Objects.equals(imie, person.imie) && Objects.equals(nazwisko,
        person.nazwisko) && Objects.equals(pesel, person.pesel);
  }

  @Override
  public int hashCode(
  ) {
    return Objects.hash(imie, nazwisko, pesel);
  }

}