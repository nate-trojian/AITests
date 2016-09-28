package montecarlo.common

import montecarlo.common.random.Randomizer
import montecarlo.common.reflect.ReflectUtil
import scala.reflect.ClassTag
import scala.reflect.runtime.universe._

/**
*  Author: Nate
*  Created on: 5/29/16
*  Description: Base Round Simulation class
*/
abstract class RoundSimulation[R <: Randomizer](n: Int, rounds: Int, randomizer: R) extends AbstractSimulation[R] {
  override type CODOMAIN_TYPE <: RoundCodomain[STATE_TYPE, R]
  override implicit def tagC: TypeTag[CODOMAIN_TYPE]
  val codomain: CODOMAIN_TYPE = ReflectUtil.newInstance(tagC, 0, Some(Seq(randomizer)))

  private[common] def cTagS = ReflectUtil.typeTagToClassTag(tagS)

  val elements: Array[Array[ELEMENT_TYPE]] = cTagE.wrap.newArray(rounds+1)

  final override def initialize() = {
    elements(0) = cTagE.newArray(n)
    for(i <- 0 until n) elements(0) update(i, newE(codomain.fromDomain(i)))
  }

  override def show = {

  }

  private def runRounds()(implicit classTag: ClassTag[ELEMENT_TYPE]) = {
    for(i <- 1 to rounds) {
      elements(i) = codomain.inTupleDomainPriv(elements(i-1)
        .map[STATE_TYPE, Array[STATE_TYPE]](s => s.updateState())(Array.canBuildFrom(cTagS)))
        .map(s => newE(s))
    }
  }

  override def run() = {
    initialize()
    runRounds()(cTagE)
  }
}
