package montecarlo.common

/**
  * Author: Nate
  * Created on: 9/27/16
  * Description: Element with R parameter, one to extend
  */
abstract class Element[D, S <: State](initialState: S) extends AbstractElement[S](initialState) {
  type R = D
}
