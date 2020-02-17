import org.epam.pkg.{EmpCode, Employee}
import org.scalatest.FunSuite
import org.scalatest.exceptions.TestFailedException

import scala.io.Source

class EmployeeTest extends FunSuite {

  test("mocking file"){
    val file1 = Source.fromFile("src/main/resources/Downloads/empMock.txt").mkString
    val l = List(1,"sai","CS",22)
    assert(file1 == l.mkString(","))
  }

  test("mocking object variables"){
    val data = Employee.file
    assert(data == null)
  }

  test("mocking file data"){
    val file = Source.fromFile("src/main/resources/Downloads/empMock1.txt").getLines
    val empSortedRecords = file.map(rec => rec.split(",")).map(rec => (rec(0).toInt, rec(1), rec(2), rec(3).toInt)).toList.sortBy(_._1)
    assert(empSortedRecords.length == 3)
  }

  test("sorted order of employee based on id"){
    val file = Source.fromFile("src/main/resources/Downloads/empMock1.txt").getLines
    val empSortedRecords = file.map(rec => rec.split(",")).map(rec => (rec(0).toInt, rec(1), rec(2), rec(3).toInt)).toList.sortBy(_._1)
    val ll = List((1,"sai","CS",22),(2,"kiran","IT",15),(3,"hyd","IT",54))
    assert(empSortedRecords == ll)
  }

  test("mocking average salary by dept"){
    val file = Source.fromFile("src/main/resources/Downloads/empMock1.txt").getLines
    val avgSalByDept = file.map(rec => rec.split(",")).map(rec => (rec(0).toInt, rec(1), rec(2), rec(3).toInt)).toList.groupBy(_._3).map({case (k,v)=>(k,v.map(x=>x._4))}).map({case (k,v)=>(k,v.sum/v.length)})
    val result = Map("IT" -> 34, "CS" -> 22)
    assert(avgSalByDept == result)
  }

  test("Test failure scenario"){
    val file = Source.fromFile("src/main/resources/Downloads/empMock1.txt").getLines
    val empSortedRecords = file.map(rec => rec.split(",")).map(rec => (rec(0).toInt, rec(1), rec(2), rec(3).toInt)).toList.sortBy(_._1)
    assertThrows[TestFailedException]{
      assert(empSortedRecords.length == 1)
    }
  }

  test("file code and description values in size"){
    val file = Source.fromFile("src/main/resources/Downloads/empCodeMock1.txt").getLines
    val header = file.take(1).next()
    val data = file.filter(r=>r!=header)
    val empCode = data.map(rec => rec.split(",")).map(rec=>(rec(0),rec(1)))
    val result = empCode.toList.distinct
    val l = List((1,"software engineer"),(2,"software test engineer"),(3,"sr. software engineer"))
    assert(result.length == l.length)
  }

  test("sorted file code and description values"){
    val file = Source.fromFile("src/main/resources/Downloads/empCodeMock1.txt").getLines
    val header = file.take(1).next()
    val data = file.filter(r=>r!=header)
    val empCode = data.map(rec => rec.split(",")).map(rec=>(rec(0),rec(1)))
    val result = empCode.toList.distinct
    val l = List((1,"software engineer"),(2,"software test engineer"),(3,"sr. software engineer"),(3,"sr. software engineer"))
    assert(result.length == l.distinct.length)
  }







  // file path mock
  // file reading contents
  // functions for splitting
  // function for sorting

}
