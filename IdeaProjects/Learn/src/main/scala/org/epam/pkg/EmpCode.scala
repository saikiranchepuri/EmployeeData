package org.epam.pkg

import scala.io.Source

object EmpCode extends App {

  val file = Source.fromFile("src/main/resources/Downloads/EmpCode").getLines
  val header = file.take(1).next()
  val data = file.filter(r => r!= header)
  val s = data.map(rec => rec.split(",")).map(e => (e(0),e(1)))
  s.toList.distinct.foreach(println)
//  s.toList.distinct.toMap.values.foreach(println)





//  println(data.mkString)
//  val sample = data.toList.mkString
//  println(sample)
//  println(sample.distinct)


}
