package video_game_db.LoadSimulations

import io.gatling.core.Predef._
import video_game_db.baseConfig.BaseSimulation
import video_game_db.requests.CommonRequests

import scala.concurrent.duration.DurationInt

class FixDurationLoadSimulation extends BaseSimulation {
  val scn = scenario("Fix Duration Load Simulation")
    .forever() {
      exec(CommonRequests.getAllVideoGames())
        .pause(5)
        .exec(CommonRequests.getSpecificVideoGame())
        .pause(5)
        .exec(CommonRequests.getAllVideoGames())
    }

  setUp(
    scn.inject(
      nothingFor(5),
      atOnceUsers(10),
      rampUsers(50) during (30 seconds)
    ).protocols(httpConfig.inferHtmlResources())
  ).maxDuration(1 minute)
}
