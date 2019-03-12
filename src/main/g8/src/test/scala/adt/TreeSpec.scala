package adt

import org.scalatest.{FlatSpec, Matchers}

class ListSpec extends FlatSpec with Matchers {

  "la liste" should "afficher coucou" in {
    List.coucou shouldEqual "coucou"
  }

  "la somme" should "afficher 6" in {
    List.sum(List(1, 2, 3)) shouldEqual 6
  }

  "le produit" should "afficher 6.0" in {
    List.product(List(1.0, 2.0, 3.0)) shouldEqual 6.0
  }

}
