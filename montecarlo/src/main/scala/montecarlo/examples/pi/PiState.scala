package montecarlo.examples.pi

import montecarlo.common.State

/**
  * Author: Nate
  * Created on: 9/28/16
  * Description: 
  */
class PiState(x: Double, y: Double) extends State {
  def getX = x
  def getY = y
}
