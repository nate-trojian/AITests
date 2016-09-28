package montecarlo.common

import montecarlo.common.random.Randomizer

/**
  * Author: Nate
  * Created on: 9/27/16
  * Description: Wrapper Thread to run Simulation
  */
class SimulationThread[R <: Randomizer, S <: AbstractSimulation[R]](simulation: S) extends Thread {

  override def run() = {
    simulation.run()
  }

  def getSimulation: S = {
    this.join()
    simulation
  }
}
