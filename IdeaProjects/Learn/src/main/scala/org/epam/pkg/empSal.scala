package org.epam.pkg

import scala.io.Source

object empSal extends App {
  val file = Source.fromFile("src/main/resources/Downloads/emp.txt").getLines
  val header = file.take(1).next()
  val data = file.filter(h => h != header)
  // fetch highest salary on each dept.
  val empMaxSal = data.map(rec => rec.split(",")).map(r=>(r(0),r(1),r(2),r(3))).toList.groupBy(_._3).map({case(k,v)=>(k,v.map(x=>x._4).max)})
  empMaxSal.foreach(println)

  // fetch lowest salary on each dept.
  /*val empMinSal = data.map(rec => rec.split(",")).map(r=>(r(0),r(1),r(2),r(3))).toList.groupBy(_._3).map({case(k,v)=>(k,v.map(x=>x._4).min)})
  empMinSal.foreach(println)*/


}
