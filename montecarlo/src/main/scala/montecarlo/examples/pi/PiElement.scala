package montecarlo.examples.pi

import montecarlo.common.Element

/**
  * Author: Nate
  * Created on: 9/28/16
  * Description: Pi Element
  */
class PiElement(state: PiState) extends Element[(Double, Double), PiState](state) {
  override def display(curState: PiState): (Double, Double) = {
    (curState.getX, curState.getY)
  }

  override def update(state: PiState): PiState = {
    state
  }
}
