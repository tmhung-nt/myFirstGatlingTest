package video_game_db.baseConfig

import com.typesafe.config.ConfigFactory
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class BaseSimulation extends Simulation {
  val conf = ConfigFactory.load()
  val httpConfig = http.baseUrl(conf.getString("baseUrl"))
    .header("Accept", "application/json")

}
