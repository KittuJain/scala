

case object MyNil extends List[Nothing]
case class Cons[T](head:T, tail:List[T]) extends List[T]
trait List[+T]{
  def ::[U >: T](element:U): Cons[U] = Cons(element, this)
}

1 :: MyNil
trait Animal
class Tiger extends Animal
class Lion extends Animal
new Tiger :: MyNil
new Tiger :: new Tiger :: MyNil
new Lion :: new Tiger :: MyNil
List(1,2,3,4)
