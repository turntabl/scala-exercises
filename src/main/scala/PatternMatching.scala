/** All exercises in here should be completed using pattern matching even when
  * there are better solutions using higher order functions */

object PatternMatching {

  /* If number is < 0 return " <0 "
     0 to 18 raturn "0<=number<=18"
     19 to 35 return "19<=number<=35"
     36 to 65 return "36<=number<=54"
     Over 65 return " >65

     // Hint, pattern matching allows for guards
   */
  def numberInRange(number: Int):String = {
    number match {
      case n if n < 0 => n.toString + "<0"
      case n if 0 to 18 contains n => "0<=" + n.toString + "<=18"
      case n if 19 to 35 contains n => "19<=" + n.toString + "<=35"
      case n if 36 to 65 contains n => "36<=" + n.toString + "<=65"
      case n => n.toString + ">65"
    }
  }

  /* Take a List and if it is empty return 0, if it contains 3 elements return the third, otherwise return the first */
  def thirdOrFirst(l: List[Int]): Int = {
    l match {
      case Nil => 0
      case List(_, _, z) => z
      case head::tail => head
    }
  }

  /* If List starts with 0, 1 then return "Starts with 0,1"
     If list starts with 1,2 then return "starts with 1,2"
     If list starts with anything else return "Doesn't start with 0,1 or 1,2
   */
  def startsWithCheck(l:List[Int]): String = {
    l match {
      case 0::1::tail => "Starts with 0,1"
      case 1::2::tail => "Starts with 1,2"
      case _ => "Doesn't start with 0,1 or 1,2"
    }
  }

  /* Write a function that does the following:
  *  Gives the length of a list, Gives the size of a map, list or vector or gives -1 otherwise */
  def generalSize(x: Any):Int = {
    x match {
      case l : List[Any] => l.size
      case m : Map[Any, Any] => m.size
      case v : Vector[Any] => v.size
      case s : String => s.size
      case _ => -1
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

  sealed trait Expression
  case class Variable(name:String) extends Expression
  case class Number(number: Double) extends Expression
  case class UnaryOperation(operator: String, argument: Expression) extends Expression
  case class BinaryOperation(operator: String, left: Expression, right: Expression) extends Expression

  // Write a function that uses pattern matching to simplify double negation, adding 0 and multiplying by 1
  // e.g. UnOp("-", UnOp("-", e) == e (think --1 == 1)

  // Think carefully about what is actually happening here, this a powerful example of pattern matching
  // where the pattern matching is deep. It's matching not just the type of the Object, but the patterns within
  // the object too and then where there are constructors, the values within those too.

  // Hint - You only need one line for each case and a default case
  def simplify(expr: Expression): Expression = {
    expr match {
      case UnaryOperation("-", UnaryOperation("-", x)) => x
      case BinaryOperation("+", x, Number(0)) => x
      case BinaryOperation("*", x, Number(1)) => x
      case x => x
    }
  }
 }
