package service;

import com.example.model.Person;
import com.example.service.PersonServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class PersonServiceTest {

  @ParameterizedTest
  @ValueSource(
      strings = {
          "test",
          "",
          " "
      }
  )
  @NullSource
  public void getPerson_whenTestPesel_thenReturnTestPesel(
      String pesel
  ) {
    //Given:
    Person expectedPerson = new Person(
        "Jan",
        "Kowalski",
        pesel
    );
    PersonServiceImpl personService = new PersonServiceImpl();
    //When:
    Person result = personService.getPerson(pesel);
    //Then:
    Assertions.assertEquals(
        expectedPerson,
        result
    );
  }

}
