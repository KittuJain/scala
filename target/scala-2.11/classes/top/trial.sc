val gujStrat = new Function1[Int, Boolean] {
  def apply(age : Int) = true
}
val gujStrat1 = new(Int => Boolean){
  def apply(age : Int) = false
}

val bangStrat = { age : Int => age > 50 }

class Person(age : Int, isFemale : Boolean){
  def isWise() =
    if(isFemale) age > 18 else age > 21
  def canMarry(canDrink : Int=> Boolean) =
    isWise && canDrink(age)
}

val p = new Person(23, false)
p.isWise()
p.canMarry(gujStrat)
p.canMarry(gujStrat1)
p.canMarry(bangStrat)
p.canMarry(_ > 20)
