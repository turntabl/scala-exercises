import munit.FunSuite

class IntListSuite extends FunSuite{

  val integerList:List[Int] = List(1,2,3,4,5,6,7,8,9,10)  

  test("Less than 5 should return only the values in the list that are less than 5") {
    assertEquals(IntListFunctions.lessThanFive(integerList), List(1,2,3,4))
  }

  test("Removing duplicates should return the same list if there are no duplicates in the list") {
    assertEquals(IntListFunctions.removeDuplicates(integerList), integerList)
  }

  test("Removing duplicates should return the with duplicates removed list if there are duplicates in the list") {
      val duplicateList = List(1,1,1,2,2,2,3,3,3,4,4,4,5)
      assertEquals(IntListFunctions.removeDuplicates(duplicateList), List(1,2,3,4,5))
  }

  test("Combining two lists should give one list containing all the elements of both lists") {
    val list1 = List(1,2)
    val list2 = List(3,4)
    assertEquals(IntListFunctions.combineLists(list1, list2), List(1,2,3,4))
  }

  test("Combining multiple lists should give one list containing all the elements of both lists") {
    val list1 = List(1,2)
    val list2 = List(3,4)
    val list3 = List(5,6)
    assertEquals(IntListFunctions.combineNLists(list1, list2, list3), List(1,2,3,4,5,6))
  }

  test("Getting the penultimate element of a list should return the second to last element") {
    val list = List(1,2,3,4,5,6,7,8,9,10)

    assertEquals(IntListFunctions.penultimateElement(list), 9)
  }

  test("isPalindrome returns true for lists that are palindromes and false otherwise") {
    val list1 = List(1,2,3,4,5,6,7,8,9,10)
    val list2 = List(1,2,3,4,5,4,3,2,1)

    assertEquals(IntListFunctions.isPalindrome(list1), false)
    assertEquals(IntListFunctions.isPalindrome(list2), true)
  }

  test("Consecutive duplicates in a list should be removed correctly") {
    val list1 = List(1,1,2,1,3,3,2,4)

    assertEquals(IntListFunctions.removeConsecutiveDuplicates(list1), List(1,2,1,3,2,4))

  }
}
