import munit.FunSuite

class StringSuite extends FunSuite {

  test("Return string should just return the string itself") {
    assertEquals(StringFunctions.returnString("string"), "string")
  }

  test("Capitalise and reverse should return empty for the empty string") {
    assertEquals(StringFunctions.capitaliseAndReverse(""), "")
  }

  test(
    "A string that is already capitalised and a palindrome should return itself"
  ) {
    assertEquals(StringFunctions.capitaliseAndReverse("ANNA"), "ANNA")
  }

  test("A string that is lower case should become upper case") {
    assertEquals(StringFunctions.capitaliseAndReverse("anna"), "ANNA")
  }

  test(
    "A string that is lower case and not a palindrome should become upper case and reversed"
  ) {
    assertEquals(StringFunctions.capitaliseAndReverse("abcd"), "DCBA")
  }

  test(
    "A string that is mixed case and not a palindrome should become upper case and reversed"
  ) {
    assertEquals(StringFunctions.capitaliseAndReverse("aBCd"), "DCBA")
  }

  test("Appending a string to the empty string should return the string") {
    assertEquals(StringFunctions.appendString("", "hello"), "hello")
  }

  test(
    "Appending a string to the another string should concatenate and return the concatenated string"
  ) {
    assertEquals(StringFunctions.appendString("hello", "world"), "helloworld")
  }

  test("Prepending a string to the empty string should return the string") {
    assertEquals(StringFunctions.prependString("", "hello"), "hello")
  }

  test(
    "Prepending a string to the another string should concatenate and return the concatenated string"
  ) {
    assertEquals(StringFunctions.prependString("world", "hello"), "helloworld")
  }

  test(
    "When converting a string to alphabetical order on a string of length 1, the result is the string itself"
  ) {
    assertEquals(StringFunctions.convertToAlphabetical("a"), "a")
  }

  test(
    "When converting a string to alphabetical order on a string of length > 1 that is already in order, " +
      "the result should be the string itself"
  ) {
    assertEquals(StringFunctions.convertToAlphabetical("abcd"), "abcd")
  }

  test(
    "When converting a string to alphabetical order on a string of length > 1 that is not in order, " +
      "the result should be the string in order"
  ) {
    assertEquals(StringFunctions.convertToAlphabetical("agdecb"), "abcdeg")
  }

  test(
    "When converting a string to alphabetical order on a string of length > 1 that is not in order and contains capitals, " +
      "the result should be the string in order with capitals next to lower case letters"
  ) {
    assertEquals(StringFunctions.convertToAlphabetical("abCBAfF"), "aAbBCfF")
  }

test(
    "The string 'exercise' should return 'e' as the most common character"
  ) {
    assertEquals(StringFunctions.mostCommonCharacter("exercise"),'e')
  }

  test(
    "The string 'hippo' should return 'p' as the most common character"
  ) {
    assertEquals(StringFunctions.mostCommonCharacter("hippo"),'p')
  }

}
