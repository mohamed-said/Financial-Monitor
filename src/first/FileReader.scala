//package first
//
//  // TODO create a .txt file "functions"
//  // comma separated with the function name and it's indexing number
//  // load the file into a list of objects just like the companies
//  // will loop on the list after taking the checking from the user
//
//
//import scala.io.Source
//import scala.collection.mutable.ListBuffer
//import javafx.scene.control.CheckBox
//
//object FileReader {
//  
//  // class for the functions
//  case class Function(val name:String, val number:String, val required:Boolean) {
//    var _required = required
//    def changeState {
//      _required = true
//    }
//  }
//  
//  
//  // class for the companies
//  case class Company(val name:String, val symbol:String, val required:Boolean) {
//    var _required = required
//    def changeState {
//      _required = true
//    }
//  }  
//   
//  var allCompanies = ListBuffer[Company]()
//  var allFunctions = ListBuffer[Function]()
//  
//  
//  
//  def main(args:Array[String]) {
//  
//    // read companies from file
//    for (line <- Source.fromFile("small.txt").getLines()) {
//      val words:Array[String] = line.split(",")
//      allCompanies += (Company(words(1), words(0), false))
//    }
//    
//    // read all functions from a file
//    for (line <- Source.fromFile("functions.txt").getLines()) {
//      val words:Array[String] = line.split(",")
//      allFunctions += (Function(words(0), words(1), false))
//    }
//    
//    
//    val companyList = allCompanies.toList
//    val functionList = allFunctions.toList
//    
//    println("list size = " +  companyList.length)
//    for (ob <- companyList) {
//      ob.changeState
//      println(ob.name + " " + ob.symbol + " " + ob._required)
//      if (ob._required == true) {
//        println(" ==> This is a required company")
//      }
//    }
//    
//    println("---------------")
//    for (ob <- functionList) {
//      ob.changeState
//      println(ob.name + " " + ob.number + " " + ob._required)
//    }
//    
//  }
//}
//
