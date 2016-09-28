package montecarlo.common

import montecarlo.common.random.Randomizer
import montecarlo.common.reflect.ReflectUtil

import scala.reflect.runtime.universe._
import scalax.chart.Chart

/**
  * Author: Nate
  * Created on: 9/28/16
  * Description: 
  */
abstract class AbstractSimulation[R <: Randomizer] extends Runnable {
  val name: String

  type I
  type STATE_TYPE <: State
  type ELEMENT_TYPE <: Element[this.I, STATE_TYPE]
  type CODOMAIN_TYPE <: Codomain[STATE_TYPE, R]
  type CHART_TYPE <: Chart

  implicit def tagI: TypeTag[I] = typeTag[I]
  implicit def tagS: TypeTag[STATE_TYPE] = typeTag[STATE_TYPE]
  implicit def tagE: TypeTag[ELEMENT_TYPE] = typeTag[ELEMENT_TYPE]
  implicit def tagC: TypeTag[CODOMAIN_TYPE] = typeTag[CODOMAIN_TYPE]
  implicit def tagCh: TypeTag[CHART_TYPE] = typeTag[CHART_TYPE]

  private[common] def cTagE = ReflectUtil.typeTagToClassTag(tagE)

  private[common] def newE(state:STATE_TYPE): ELEMENT_TYPE = ReflectUtil.newInstance(tagE, 0, Some(Seq(state)))

  private[common] def initialize()
  def show()
}
