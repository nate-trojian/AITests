package montecarlo.common

import montecarlo.common.chart.{DatasetConversion, XYDotChart}
import montecarlo.common.random.Randomizer
import montecarlo.common.reflect.ReflectUtil
import scala.reflect.runtime.universe._
import scalax.chart.{XYChart, Chart}

/**
 * Author: Nate
 * Created on: 5/28/16
 * Description: Base Simulation class
 */
abstract class Simulation[R <: Randomizer](n: Int, randomizer: R) extends AbstractSimulation[R] {
  val codomain: Codomain[STATE_TYPE, R] = ReflectUtil.newInstance(tagC, 0, Some(Seq(randomizer)))

  private[common] def cTagI = ReflectUtil.typeTagToClassTag(tagI)

  private val elements = cTagE.newArray(n)

   def initialize() = {
    for(i <- 0 until n) elements update(i, newE(codomain.fromDomain(i)))
  }

  def show = {
    //The asInstanceOf I does nothing, but it makes the compiler feel better
    XYDotChart(DatasetConversion[CHART_TYPE, I](elements
      .map[I, Array[I]](e => e.displayState().asInstanceOf[I]
    )(Array.canBuildFrom(cTagI))
    )(tagCh, tagI))
  }

  override def run() = {
    initialize() //Essentially a round 0, which is all a one-round simulation does
  }
}