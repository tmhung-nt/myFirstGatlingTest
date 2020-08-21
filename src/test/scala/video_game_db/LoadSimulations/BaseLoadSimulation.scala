package video_game_db.LoadSimulations

import io.gatling.core.Predef._
import video_game_db.baseConfig.BaseSimulation
import video_game_db.requests.CommonRequests

import scala.concurrent.duration.DurationInt

class BaseLoadSimulation extends BaseSimulation {
  val scn = scenario("Basic Load Simulation")
    .exec(CommonRequests.getAllVideoGames())
    .pause(5)
    .exec(CommonRequests.getSpecificVideoGame())
    .pause(5)
    .exec(CommonRequests.getAllVideoGames())

  setUp(scn.inject(
    nothingFor(5 seconds),
    atOnceUsers(5),
    rampUsers(10) during (10 seconds)
  )).protocols(httpConfig.inferHtmlResources())
}
