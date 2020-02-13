package org.epam.pkg

import scala.io.Source

object Employee extends App {

    val file = Source.fromFile("src/main/resources/Downloads/emp.txt").getLines
    println(file)
    val header = file.take(1).next()
    val data = file.filter(h => h != header)
    val empSortedRecords = data.map(rec => rec.split(",")).map(rec => (rec(0).toInt, rec(1), rec(2), rec(3).toInt)).toList.sortBy(_._1).take(5)
    empSortedRecords.foreach(println)
    val avgSal = data.map(rec => rec.split(",")).map(rec => (rec(0).toInt, rec(1), rec(2), rec(3).toInt)).toList.groupBy(_._3).map({ case (k, v) => (k, v.map(x => x._4)) }).map({ case (k, v) => (k, v.sum / v.length) })
    avgSal.foreach(println)
}
