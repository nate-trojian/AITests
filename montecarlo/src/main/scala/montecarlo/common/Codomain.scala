package montecarlo.common

import montecarlo.common.random.Randomizer

/**
 * Author: Nate
 * Created on: 5/29/16
 * Description: Determine if legal state
 */

/**
  * Codomain for state
  * @param randomizer Randomizer to use
  * @tparam S State type
  * @tparam R Type of Randomizer to use
  */
abstract class Codomain[S <: State, R <: Randomizer](randomizer: R) {

  /**
    * Test is state is valid
 *
    * @param state State to test
    * @return True if state is in codomain
    */
  def inDomain(state: S): Boolean

  private[common] def fromDomain(i: Int): S = fromDomain(randomizer.generate, i)

  /**
    * Get random state
    * @param randVal Value from randomizer
    * @param i index
    * @return Valid state of type S
    */
  def fromDomain(randVal: randomizer.T, i: Int): S
}
