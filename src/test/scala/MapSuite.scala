import munit.FunSuite

class MapSuite extends FunSuite {

  val m: Map[String,String]= Map("test" -> "result", "test2" -> "result2", "test3" -> "result34", "cats" -> "dogs")
  val emptyMap:Map[String,String] = Map()

  test("We should be able to filter a map based on a starting with substring") {
    assertEquals(MapFunctions.getElementsInMapStartingWith(m, "ca"), Map("cats" -> "dogs"))
  }

  test("We should get the longest with the longest value") {
    assertEquals(MapFunctions.getKeyOfLongest(m), Some("test3"))
  }

  test("We should get none when getting the longest key on an empty map") {
    assertEquals(MapFunctions.getKeyOfLongest(emptyMap), None)
  }

  test("Combining n maps should allow any number of maps to be concatenated together") {
    val m2: Map[String, String] = Map("a" -> "b", "c" -> "d")
    val m3: Map[String,String]= Map("e" -> "f", "g" -> "h")
    val m4: Map[String,String]= Map("i" -> "j", "k" -> "l")

    assertEquals(MapFunctions.combineNMaps[String, String](m2,m3,m4), Map("a" -> "b", "c" -> "d","e" -> "f", "g" -> "h","i" -> "j", "k" -> "l"))
  }
}
