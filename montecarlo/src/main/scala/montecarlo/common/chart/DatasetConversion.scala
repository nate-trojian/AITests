package montecarlo.common.chart

import org.jfree.data.xy.IntervalXYDataset

import scala.reflect.runtime.universe._

import scalax.chart._
import scalax.chart.module.{RichChartingCollections, DatasetConversions}
import scalax.chart.module.XYDatasetConversions.ToXYDataset

/**
  * Author: Nate
  * Created on: 9/28/16
  * Description: 
  */
object DatasetConversion {
  def convertToXY[CHART_TYPE <: Chart, DATA_TYPE](data: Array[DATA_TYPE])
                                           (implicit chartTag: TypeTag[CHART_TYPE], dataTag: TypeTag[DATA_TYPE]): ToXYDataset = {
    chartTag.tpe match {
      case _: XYChart => {
        dataTag.tpe match {
          case _:(AnyVal, AnyVal) => {
          }
        }
      }
      case _ => {
      }
    }
  }
}
