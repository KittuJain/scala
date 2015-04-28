//import sortMonoid.Ord

def sort(xs:List[Int]):List[Int] = {
 xs match{
   case Nil => Nil
   case head::tail =>insert(sort(tail),head)
 }
}


def insert1( xs:List[Int],x:Int):List[Int]= {
  xs.takeWhile(_ < x) ::: (x :: xs.dropWhile(_ < x))
}


def insert( xs:List[Int],x:Int):List[Int]= xs match {
  case head::tail if head > x => x::xs
  case Nil => List(x)
  case head::tail =>List(head):::insert(tail,x)

}
//def sort[T](xs: List[T])(implicit ord: Ord[T]): List[T] = {
//  xs match {
//    case Nil => Nil
//    case head :: tail => insert(sort(tail), head)
//  }
//
//}
//
//
//def insert[T](xs: List[T], x: T)(implicit ord: Ord[T]): List[T] = xs match {
//  case head :: tail if ord.lessThan(x, head) => x :: xs
//  case Nil => List(x)
//  case head :: tail => List(head) ::: insert(tail, x)
//
//}
//insert(List(2,3,6,7),1)
//
//insert(List(2,3,6,7),5)
//
//insert(List(2,3,6,7),8)
//
sort(List(2,5,3,1,6))