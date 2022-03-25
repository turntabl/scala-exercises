import PatternMatching.{BinaryOperation, Number, UnaryOperation, Variable, simplify}
import munit.{FunSuite, ScalaCheckSuite}
import org.scalacheck.Gen
import org.scalacheck.Prop.{forAll, propBoolean}

class PatternMatchingSuite extends FunSuite with ScalaCheckSuite {

  test("Number in range returns <0 for a negative number") {
    forAll(Gen.negNum[Int]) { n =>
      PatternMatching.numberInRange(n) == s"${n}<0"
    }
  }

  test("Number in range 0 to 18 returns as expected") {
    forAll(Gen.choose[Int](0,18)) { n =>
      PatternMatching.numberInRange(n) == s"0<=${n}<=18"
    }
  }

  test("Number in range 19 to 35 returns as expected") {
    forAll(Gen.choose[Int](19, 35)) { n =>
      PatternMatching.numberInRange(n) == s"19<=${n}<=35"
    }
  }

  test("Number in range 36 to 65 returns as expected") {
    forAll(Gen.choose[Int](36, 65)) { n =>
      PatternMatching.numberInRange(n) == s"36<=${n}<=65"
    }
  }

  test("Number > 65 returns as expected") {
    forAll(Gen.choose[Int](66, Int.MaxValue)) { n =>
      PatternMatching.numberInRange(n) == s"${n}>65"
    }
  }

  test("If list length is three then the third element is returned") {
    val l = List(1,2,3)
    PatternMatching.thirdOrFirst(l) == 3
  }

  test("If list size is empty then thirdOrFirst should return 0 ") {
    val l:List[Int] = Nil
    PatternMatching.thirdOrFirst(l) == 0
  }

  test("If list size is not three or empty then the head of the list should be returned") {
    forAll { (l:List[Int]) =>
      (l.size != 3 && l.nonEmpty) ==> {
        PatternMatching.thirdOrFirst(l) == l.head
      }
    }
  }

  test("List starting with 0,1 returns the correct string") {
    val l = List(0,1,2,3,4,5,6,7,8,9,10)
    assertEquals(PatternMatching.startsWithCheck(l), "Starts with 0,1")
    assertEquals(PatternMatching.startsWithCheck(l.take(2)), "Starts with 0,1")

  }

  test("List starting with 1,2 returns the correct string") {
    val l = List(1,2,3,4,5,6,7,8,9,10)
    assertEquals(PatternMatching.startsWithCheck(l), "Starts with 1,2")
    assertEquals(PatternMatching.startsWithCheck(l.take(2)), "Starts with 1,2")
  }

  test("List not starting with 0,1 or 1,2 returns the correct string") {
    val l = List(2,3,4,5)
    assertEquals(PatternMatching.startsWithCheck(l), "Doesn't start with 0,1 or 1,2")
  }

  test("General size returns the correct result for lists") {
    forAll { (l: List[Int]) =>
      PatternMatching.generalSize(l) == l.size
    }
  }

  test("General size returns the correct result for vectors") {
    forAll { (v: Vector[Int]) =>
      PatternMatching.generalSize(v) == v.size
    }
  }

  test("General size returns the correct result for lists") {
    forAll { (m: Map[Int, Int]) =>
      PatternMatching.generalSize(m) == m.size
    }
  }

  test("General size returns the correct result for lists") {
    forAll { (s: String) =>
      PatternMatching.generalSize(s) == s.length
    }
  }

  /*
    Here we define a series of case classes that extend the trait. Think of this like an enum
    that we can use to compose expressions together.

    As they're case classes they'll have:
      * Factory method (no need to use new)
      * Val prefixes, i.e. we can do v.name for a v Variable
      * Equals and hash code are implemented to compare sensibly
      * A copy method is available
   */

  test("Double negation simplification ensures that it is simplified to just the expression") {
    val numbers = for(n <- Gen.double) yield Number(n)

    forAll(numbers) { (n: Number) =>
      simplify(UnaryOperation("-", UnaryOperation("-", n))) == n
    }
  }

  test("Adding zero to a variable number simplifies to just the variable it is simplified to just the expression") {

    val numbers = for(n <- Gen.double) yield Number(n)

    forAll(numbers) { (n: Number) =>
      simplify(BinaryOperation("+", n, Number(0))) == n
    }
  }

  test("Multiplying by 1 to a variable number simplifies to just the variable it is simplified to just the expression") {

    val numbers = for(n <- Gen.double) yield Number(n)

    forAll(numbers) { (n: Number) =>
      simplify(BinaryOperation("*", n, Number(1))) == n
    }
  }

}


