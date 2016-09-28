package montecarlo.common

/**
 * Author: Nate
 * Created on: 9/22/15
 * Description: Base Element class
 */
private[common] abstract class AbstractElement[S <: State](var state: S) extends Displayable with Updatable {
  type I = S
  def display(curState: S): R
  private[montecarlo] def displayState(): R = display(state)

  type U = S
  def update(state:S): S
  private[montecarlo] def updateState(): S = update(state)
}
