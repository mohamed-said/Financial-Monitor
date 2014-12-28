package gui

import swing._
import event._
import Swing._
import ListView._
import java.io._
import scala.collection.mutable.ListBuffer
import BorderPanel.Position._
import scala.io.Source
import scala.collection.mutable.ListBuffer
import java.nio.file.{ Paths, Files }
import java.nio.charset.StandardCharsets

case class Company(val name: String, val symbol: String, val required: Boolean) {
  var _required = required
  val _box = new CheckBox(name)

  def changeState {
    _required = true
  }
}

case class Function(val name: String, val number: String, val required: Boolean) {
  var _required = required
  val _box = new CheckBox(name)
  def changeState {
    _required = true
  }
}

object FinancialMonitorGUI extends SimpleSwingApplication {

  def top = new MainFrame {
    title = "Financial Monitor"
    
    var allCompanies = ListBuffer[Company]()
    var allFunctions = ListBuffer[Function]()

    contents = new BorderPanel {
      val tabs = new TabbedPane {
        import TabbedPane._
        val companies = new FlowPanel {
          border = Swing.EmptyBorder(20, 20, 20, 20)

          contents += new BoxPanel(Orientation.Vertical) {
            border = CompoundBorder(TitledBorder(EtchedBorder, "Check Boxes"), EmptyBorder(20, 20, 20, 20))

            for (line <- Source.fromFile("small.in").getLines()) {
              val words: Array[String] = line.split(",")
              allCompanies += (Company(words(1), words(0), false))
            }

            val companyList = allCompanies.toList
            for (ob <- companyList) {
              contents.append(ob._box)
              listenTo(ob._box)
            }

            for (ob <- companyList) {
              reactions += {
                case ButtonClicked(ob._box) => {
                  val fw = new FileWriter("final.out", true);
                  fw.write(ob.symbol + '|');
                  fw.close();
                  println(ob.symbol)
                }
              }
            }
          }
        } // Flow Panel

        val functions = new FlowPanel {
          border = Swing.EmptyBorder(20, 20, 20, 20)

          contents += new BoxPanel(Orientation.Vertical) {
            border = CompoundBorder(TitledBorder(EtchedBorder, "Select Functions"), EmptyBorder(100, 100, 100, 100))

            for (line <- Source.fromFile("functions.in").getLines()) {
              val words: Array[String] = line.split(",")
              allFunctions += (Function(words(0), words(1), false))
            }

            val functionList = allFunctions.toList
            for (ob <- functionList) {
              contents.append(ob._box)
              listenTo(ob._box)
            }

            for (ob <- functionList) {
              reactions += {
                case ButtonClicked(ob._box) => {
                  val fw = new FileWriter("final_funs.out", true);
                  fw.write(ob.number + '|');
                  fw.close();
                  println(ob.number)
                }
              }
            }
          }
        }

        pages += new Page("Companies", companies)
        pages += new Page("Functions", functions)

      }

      val list = new ListView(tabs.pages) {
        selectIndices(0)
        selection.intervalMode = ListView.IntervalMode.Single
        renderer = ListView.Renderer(_.title)
      }
      val center = new SplitPane(Orientation.Vertical, new ScrollPane(list), tabs) {
        oneTouchExpandable = true
        continuousLayout = true
      }
      layout(center) = Center
      object slider extends Slider {
        min = 0
        value = tabs.selection.index
        max = tabs.pages.size - 1
        majorTickSpacing = 1
      }
      layout(slider) = South
      /*
       * Establish connection between the tab pane, slider, and list view.
       */
      listenTo(slider)
      listenTo(tabs.selection)
      listenTo(list.selection)
      reactions += {
        case ValueChanged(`slider`) =>
          if (!slider.adjusting) tabs.selection.index = slider.value
        case SelectionChanged(`tabs`) =>
          slider.value = tabs.selection.index
          list.selectIndices(tabs.selection.index)
        case SelectionChanged(`list`) =>
          if (list.selection.items.length == 1)
            tabs.selection.page = list.selection.items(0)

      }
      listenTo(tabs.selection)
      listenTo(list.selection)
    }
  }
}