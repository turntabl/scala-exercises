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
    ???
  }

  /* Take a List and if it is empty return 0, if it contains 3 elements return the third, otherwise return the first */
  def thirdOrFirst(l: List[Int]): Int = {
    ???
  }

  /* If List starts with 0, 1 then return "Starts with 0,1"
     If list starts with 1,2 then return "starts with 1,2"
     If list starts with anything else return "Doesn't start with 0,1 or 1,2
   */
  def startsWithCheck(l:List[Int]): String = {
    ???
  }

  /* Write a function that does the following:
  *  Gives the length of a list, Gives the size of a map, list or vector or gives -1 otherwise */
  def generalSize(x: Any):Int = {
    ???
  }

  sealed trait Expression
  case class Variable(name:String) extends Expression
  case class Number(number: Double) extends Expression
  case class UnaryOperation(operator: String, argument: Expression) extends Expression
  case class BinaryOperation(operator: String, left: Expression, right: Expression) extends Expression

  // Write a function that uses pattern matching to simplify double negation, adding and multiplying by 1
  // e.g. UnOp("-", UnOp("-", e) == e (think --1 == 1)

  // Think carefully about what is actually happening here, this a powerful example of pattern matching
  // where the pattern matching is deep. It's matching not just the type of the Object, but the patterns within
  // the object too and then where there are constructors, the values within those too.

  // Hint - You only need one line for each case and a default case
  def simplify(expr: Expression): Expression = {
    ???
  }
 }
