case class Game(){
  var strategies = List.empty[Strategy]
  def put(strategy : Strategy){
    strategies = strategies :+ strategy
  }
  def play(input : Int) : String = {
    val result = strategies.foldLeft("")(_ + _.apply(input))
    result match{
      case "" => input.toString()
      case _ => result
    }
  }
}

trait Strategy {
  def apply(input:Int) :String
}

case class DivisionStrategy(divisor: Int, gameTerm: String) extends Strategy {
  def apply(input: Int) : String = {
    if(input % divisor == 0)
      gameTerm
    else
      ""
  }
}
val game = Game()
 game.put(DivisionStrategy(3,"Fizz"))
 game.put(DivisionStrategy(5,"Buzz"))
 game.play(1)
 game.play(2)
 game.play(3)
 game.play(4)
 game.play(5)
 game.play(6)
 game.play(7)
 game.play(15)