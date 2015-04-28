class Person(name : String, age: Int)

object Person{
  def apply(name: String, age: Int) = new Person(name, age)
}
val p = Person("krati", 20)