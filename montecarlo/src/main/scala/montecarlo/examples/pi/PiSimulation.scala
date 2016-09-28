package montecarlo.examples.pi

import montecarlo.common.random.{DoubleRandomizer, Tuple2Randomizer}
import montecarlo.common.{MonteCarlo, Simulation}

import scalax.chart.XYChart

/**
  * Author: Nate
  * Created on: 9/28/16
  * Description: Pi Simulation
  */
class PiSimulation(n: Int, randomizer: Tuple2Randomizer[DoubleRandomizer, DoubleRandomizer])
  extends Simulation[Tuple2Randomizer[DoubleRandomizer, DoubleRandomizer]](n, randomizer) {
  override val name: String = "Pi Simulation"

  override type STATE_TYPE = PiState
  override type I = (Double, Double)
  override type CODOMAIN_TYPE = PiCodomain
  override type CHART_TYPE = XYChart
  override type ELEMENT_TYPE = PiElement
}

object PiSimulation {
  def main(args: Array[String]) {
    MonteCarlo.runSimulation[Tuple2Randomizer[DoubleRandomizer, DoubleRandomizer], PiSimulation](
      1000, new Tuple2Randomizer[DoubleRandomizer, DoubleRandomizer](
      new DoubleRandomizer(-1, 1), new DoubleRandomizer(-1, 1))
    )
  }
}
