package org.epam.pkg

import scala.io.Source

object empDojDetails extends App {
  val file = Source.fromFile("src/main/resources/Downloads/empdoj").getLines
  val header = file.take(1).next()
  val data = file.filter(h => h != header)

  // find employee joins in which location based on the dates.
  val empdoj = data.map(rec=>rec.split(",")).map(e=>(e(0),e(1),e(2),e(3))).toList.sortBy(_._1).groupBy(_._4).map({case(k,v)=>(k,v.map(r=>r._3))})
  empdoj.foreach(println)
}
