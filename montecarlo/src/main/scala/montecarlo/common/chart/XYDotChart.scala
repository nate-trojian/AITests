package montecarlo.common.chart

import java.awt._
import java.awt.geom.{Ellipse2D, Rectangle2D}

import org.jfree.chart.axis._
import org.jfree.chart.plot.XYPlot
import org.jfree.chart.renderer.xy.XYShapeRenderer
import org.jfree.chart.{StandardChartTheme, ChartTheme}

import scala.swing.Orientation
import scalax.chart.XYChart
import scalax.chart.module.XYDatasetConversions.ToXYDataset

/**
  * Author: Nate
  * Created on: 9/28/16
  * Description: Factory for scatter plot
  */
object XYDotChart {
  def apply[A: ToXYDataset](data: A, title: String = "",
                              orientation: Orientation.Value = Orientation.Vertical, legend: Boolean = true)
                             (implicit theme: ChartTheme = StandardChartTheme.createJFreeTheme): XYChart = {
    val dataset = ToXYDataset[A].convert(data)
    val domainAxis = new NumberAxis()
    val rangeAxis = new NumberAxis()
    val renderer = new XYShapeRenderer() {
      override def getItemPaint(row: Int, column: Int): Paint = {
        Color.RED
      }

      override def getItemShape(row: Int, column: Int): Shape = {
        new Ellipse2D.Double(-1.0, -1.0, 2.0, 2.0)
      }
    }
    val plot = new XYPlot(dataset, domainAxis, rangeAxis, renderer)
    XYChart(plot, title = title, legend = legend, theme = theme)
  }
}
