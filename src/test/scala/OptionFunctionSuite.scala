import munit.FunSuite

import java.time.LocalDate

class OptionFunctionSuite extends FunSuite{

  /** Simple dummy test data */
  val testAddress1 = Address("1 Test Street", None, None, None, None, "TT11 1TT")
  val testAddress2 = Address("2 Test Street", Some("Test Area"), Some("Test Bigger Area"), Some("Test City"), Some("Test County"), "TT11 1TT")

  val testPerson1 = Person(None, "Thomas", LocalDate.of(1982, 7, 26), Some(testAddress1))
  val testPerson2 = Person(Some("Thomas"), "Thomas", LocalDate.of(1980, 1, 1), Some(testAddress2))
  val testPerson3 = Person(Some("Mark"), "Markinson", LocalDate.of(2001, 3, 3), None)

  test("getPeopleWithForenames returns an empty list if there are no forenames for any people in the list") {
    val listOfPeople = testPerson1 :: Nil
    assertEquals(OptionFunctions.getPeopleWithForenames(listOfPeople), Nil)
  }

  test("getPeopleWithForenames returns a list with two people in when there are two forenames in the list") {
    val listOfPeople = testPerson1 :: testPerson2 :: testPerson3 :: Nil
    assertEquals(OptionFunctions.getPeopleWithForenames(listOfPeople).size, 2)
  }

  test("getPeopleWithDefaultForenames returns a list with all the people however the forename is set to Unknown if the person doesn't have a forename") {
    val listOfPeople = testPerson1 :: testPerson2 :: testPerson3 :: Nil
    val listOfPeopleWithDefaultForename = OptionFunctions.getPeopleWithDefaultForename(listOfPeople)

    assertEquals(listOfPeopleWithDefaultForename.size, 3)
    assertEquals(listOfPeopleWithDefaultForename.head.forename, Some("Unknown"))
    assertEquals(listOfPeopleWithDefaultForename.tail.head.forename, Some("Thomas"))
  }

  test("getFirstLineAndPostcodes should return a list of tuples containing each of the first lines and postcodes from the list") {
    val listOfPeople = testPerson1 :: testPerson2 :: testPerson3 :: Nil
    assertEquals(OptionFunctions.getAddresses(listOfPeople), List(("1 Test Street","TT11 1TT"), ("2 Test Street", "TT11 1TT")))
  }
}
