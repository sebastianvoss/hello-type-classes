package com.sebastianvoss

import com.sebastianvoss.Show.ops._
import org.scalatest.{FlatSpec, Matchers}

class ShowSpec extends FlatSpec with Matchers {

  "Show" should "be able to show integers" in {
    1.show should be("int 1")
  }

  it should "be able to show strings" in {
    "foo".show should be("string foo")
  }

  it should "allow to override" in {
    implicit val fancyString: Show[String] = s => s"fancy_string $s"
    "foo".show should be("fancy_string foo")
  }

  it should "allow to define custom" in {
    case class Foo(name: String)
    implicit val fooString: Show[Foo] = f => s"foo $f"
    Foo("test").show should be("foo Foo(test)")
  }

}
