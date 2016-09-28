package montecarlo.common

import montecarlo.common.random.Randomizer
import montecarlo.common.reflect.ReflectUtil

import scala.reflect.runtime.universe._

/**
 * Author: Nate
 * Created on: 5/29/16
 * Description: Monte Carlo Runner
 */
object MonteCarlo {
  private val MINUTE = 60 * 1000

  def runSimulation[R <: Randomizer, S <: Simulation[R]](n: Int, randomizer: R)
                                                        (implicit simClassTag: TypeTag[S]) = {
    val simulation = ReflectUtil.newInstance(simClassTag, 0, Some(Seq(n, randomizer)))
    val simulationThread = new SimulationThread[R, S](simulation)
    simulationThread.start()
    simulationThread
  }

  def runRoundSimulation[R <: Randomizer, S <: RoundSimulation[R]](n: Int, rounds: Int, randomizer: R)
                                                                  (implicit simClassTag: TypeTag[S]) = {
    val roundSimulation = ReflectUtil.newInstance(simClassTag, 0, Some(Seq(n, rounds, randomizer)))
    val simulationThread = new SimulationThread[R, S](roundSimulation)
    simulationThread.start()
    simulationThread
  }
}
