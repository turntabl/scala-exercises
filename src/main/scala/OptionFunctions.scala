import java.time.LocalDate

// Address case class to store an address where only line1 and postcode are mandatory
case class Address(
    line1: String,
    line2: Option[String],
    line3: Option[String],
    line4: Option[String], // None, Some("Badger Farm").
    line5: Option[String],
    postcode: String)

// Person case class forename and address are optional, with address using the Address type from above
case class Person(forename: Option[String], surname: String, dateOfBirth: LocalDate, address: Option[Address])

object OptionFunctions {

  /** Return everyone from the list passed in who has a forename */
  def getPeopleWithForenames(listOfPeople: List[Person]): List[Person] = {
    ???
  }

  /** Return everyone from the list but default their forename to unknown if it doesn't exist */
  def getPeopleWithDefaultForename(listOfPeople: List[Person]): List[Person] = {
    ???
  }

  /** Get the first line and postcode of all the addresses from the list of People*/
  def getAddresses(listOfPeople: List[Person]): List[(String, String)] = {
    ???
  }

}


