package video_game_db

import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder
import video_game_db.LoadSimulations._

object GatlingRunner {

  def main(args: Array[String]): Unit = {

    // this is where you specify the class you want to run
    val simClass = classOf[FixDurationLoadSimulation].getName

    val props = new GatlingPropertiesBuilder
    props.simulationClass(simClass)

    Gatling.fromMap(props.build)

  }

}
