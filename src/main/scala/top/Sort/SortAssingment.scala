
package sortMonoid {

trait Ord[T] {
  def lessThan(a: T, b: T): Boolean
}

object Ord {
  implicit val IntOrd = new Ord[Int] {
    override def lessThan(a: Int, b: Int): Boolean = a < b
  }
}

}