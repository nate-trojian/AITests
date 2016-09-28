package montecarlo.common.random

import scala.reflect.runtime.universe._

/**
 * Author: Nate
 * Created on: 5/29/16
 * Description: Base randomizer
 */
abstract class Randomizer {
  type T
  implicit private[common] def tagT: TypeTag[T] = typeTag[T]
  def generate: T
}
