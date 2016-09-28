package montecarlo.common

/**
 * Author: Nate
 * Created on: 9/22/15
 * Description: Base class for Displayable entities
 */
trait Displayable {
  type I
  type R
  def display(item: I): R
}
