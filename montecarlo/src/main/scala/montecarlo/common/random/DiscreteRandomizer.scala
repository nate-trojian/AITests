package montecarlo.common.random

import scala.util.Random

/**
 * Author: Nate
 * Created on: 5/29/16
 * Description: Randomizer from sequence of values
 */
class DiscreteRandomizer[U](seq: Seq[U], seed:Option[Long] = None) extends Randomizer {
  type T = U

  private val rand:Random = seed match {
    case Some(s:Long) => new Random(s)
    case None => new Random()
  }

  def generate: T = {
    seq(rand.nextInt(seq.length))
  }
}
