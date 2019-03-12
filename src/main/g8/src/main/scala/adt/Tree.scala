package adt

sealed trait ???

object List {

  val coucou = "coucou"

  def sum(ints: List[Int]): Int = ???

  def product(ds: List[Double]): Double = ???

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) {
      Nil
    } else {
      Cons(as.head, apply(as.tail: _*))
    }

}
