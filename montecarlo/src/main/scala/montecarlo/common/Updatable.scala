package montecarlo.common

/**
  * Author: Nate
  * Created on: 9/27/16
  * Description: Trait for updatable entities
  */
trait Updatable {
  type U
  def update(item: U): U
}
