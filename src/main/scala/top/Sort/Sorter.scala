
package sorter {

import sortMonoid.Ord

object sorter {
    def sort[T](xs: List[T])(implicit ord: Ord[T]): List[T] = {
      xs match {
        case Nil => Nil
        case head :: tail => insert(sort(tail), head)
      }

    }


    def insert[T](xs: List[T], x: T)(implicit ord: Ord[T]): List[T] = xs match {
      case head :: tail if ord.lessThan(head, x) => x :: xs
      case Nil => List(x)
      case head :: tail => List(head) ::: insert(tail, x)

    }
  }
}