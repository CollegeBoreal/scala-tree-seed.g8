package adt

import org.scalatest.{FlatSpec, Matchers}
import scala.language.postfixOps

class TreeSpec extends FlatSpec with Matchers {

  "Tree ADT" should "answer some uses cases with size" in {
    Tree.size(Leaf("a")) shouldBe 1
    Tree.size(Branch(Leaf("a"), Leaf("b"))) shouldBe 3
    Tree.size(Branch(Leaf("a"), Branch(Leaf("a"), Leaf("b")))) shouldBe 5
  }

  "Tree ADT" should "answer some uses cases with max" in {
    Tree.maximum(Branch(Leaf(4), Branch(Leaf(10), Leaf(3)))) shouldBe 10
    Tree.maximum(Branch(Branch(Leaf(24), Leaf(5)), Branch(Leaf(10), Leaf(3)))) shouldBe 24
  }

  "Tree ADT" should "answer some uses cases with depth" in {
    Tree.depth(Branch(Branch(Leaf(24), Leaf(5)), Branch(Leaf(10), Leaf(3)))) shouldBe 2
    Tree.depth(Leaf("a")) shouldBe 0
  }

  "Tree ADT" should "answer some uses cases with map" in {
    Tree.map(Branch(Leaf(1), Leaf(2)))(_ + 1) shouldBe Branch(Leaf(2), Leaf(3))
    Tree.map(Branch(Leaf("a"), Leaf("b")))(_ + "-") shouldBe Branch(Leaf("a-"), Leaf("b-"))
    Tree.map(Branch(Branch(Leaf(24), Leaf(5)), Branch(Leaf(10), Leaf(3))))(-1 *) shouldBe Branch(Branch(Leaf(-24), Leaf(-5)), Branch(Leaf(-10), Leaf(-3)))
    Tree.map(Branch(Branch(Leaf(24), Leaf(6)), Branch(Leaf(10), Leaf(4))))(_ / 2) shouldBe Branch(Branch(Leaf(12), Leaf(3)), Branch(Leaf(5), Leaf(2)))
    Tree.map(Branch(Leaf(24), Branch(Leaf(10), Leaf(4))))(_ / 2) shouldBe Branch(Leaf(12), Branch(Leaf(5), Leaf(2)))
  }

}
