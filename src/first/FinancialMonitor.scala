//package first;
//
//import scala.swing._
//
//object FinancialMonitor extends SimpleSwingApplication {
//  val textArea = new TextArea
//  def openfile {
//    val chooser = new FileChooser
//    val source = scala.io.Source.fromFile("text.txt")
//    textArea.text = source.mkString
//  }
//  
//  def top = new MainFrame {
//    title = "Financial Monitor";
//    contents = textArea
//
//    menuBar = new MenuBar {
//      contents += new Menu("files") {
//        contents += new MenuItem(Action("show all company") {
//          openfile
//        })
//        contents += new MenuItem("add") {
//
//        }
//        contents += new MenuItem("view to check") {
//
//        }
//        contents += new Separator
//        contents += new MenuItem(Action("exit") {
//          sys.exit()
//        })
//      }
//    }
//    size = new Dimension(500, 500);
//    centerOnScreen
//  }
//}
//
