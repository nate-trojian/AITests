package montecarlo.common

import montecarlo.common.random.Randomizer

/**
  * Author: Nate
  * Created on: 9/27/16
  * Description: Defines Codomain for tuple of state
  */
abstract class RoundCodomain[S <: State, R <: Randomizer](randomizer: R) extends Codomain[S, R](randomizer) {
  private[this] var markedStates: Array[Boolean] = Array.empty[Boolean]

  def inTupleDomain(states: Array[S]): Boolean

  private[common] def inTupleDomainPriv(states: Array[S]): Array[S] = {
    markedStates = new Array[Boolean](states.length)
    if(!inTupleDomain(states)) {
      val temp = (markedStates zip (states.view zipWithIndex)) filter(_._1) map(_._2)
      return correctState(temp, states)
    }
    markedStates = Array.empty[Boolean]
    states
  }

  final def mark(i: Int) = {
    if(markedStates.length != 0)
      markedStates(i) = true
  }

  final def markRange(start: Int, stop: Int) = {
    if(markedStates.length != 0) {
      for(i <- start until stop) markedStates(i) = true
    }
  }

  def correctState(markedStates: Array[(S, Int)], states:Array[S]): Array[S]
}
