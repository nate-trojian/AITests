package montecarlo.common.random

import scala.reflect.runtime.universe._

/**
  * Author: Nate
  * Created on: 9/28/16
  * Description: Randomizer that returns tuple of randomizers
  */
class Tuple2Randomizer[R1 <: Randomizer, R2 <: Randomizer](protected val r1: R1, protected val r2: R2) extends Randomizer {
  private type T1 = r1.T
  private type T2 = r2.T
  type T = (T1, T2)

  override def generate: T = {
    (r1.generate, r2.generate)
  }
}
