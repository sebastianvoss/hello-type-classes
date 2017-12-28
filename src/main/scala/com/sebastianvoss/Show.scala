package com.sebastianvoss

trait Show[A] {
  def show(a: A): String
}

object Show {
  def apply[A](implicit sh: Show[A]) = sh

  object ops {
    def show[A: Show](a: A) = Show[A].show(a)

    implicit class ShowOps[A: Show](a: A) {
      def show = Show[A].show(a)
    }
  }

  implicit val intCanShow: Show[Int] = i => s"int $i"

  implicit val stringCanShow: Show[String] = s => s"string $s"
}
