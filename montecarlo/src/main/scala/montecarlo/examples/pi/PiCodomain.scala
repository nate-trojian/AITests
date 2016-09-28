package montecarlo.examples.pi

import montecarlo.common.Codomain
import montecarlo.common.random.{DoubleRandomizer, Tuple2Randomizer, Randomizer}

/**
  * Author: Nate
  * Created on: 9/28/16
  * Description: Codomain for Pi
  */
class PiCodomain(randomizer: Tuple2Randomizer[DoubleRandomizer, DoubleRandomizer])
  extends Codomain[PiState, Tuple2Randomizer[DoubleRandomizer, DoubleRandomizer]](randomizer) {
  override def inDomain(state: PiState) = true

  /**
    * Get random state
    *
    * @param randVal Value from randomizer
    * @param i       index
    * @return Valid state of type S
    */
  override def fromDomain(randVal: (Double, Double), i: Int): PiState = {
    new PiState(randVal._1, randVal._2)
  }
}
