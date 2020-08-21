package video_game_db.test_scenarios

import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef._
import video_game_db.baseConfig.BaseSimulation
import video_game_db.requests.CommonRequests

class MyFirstTest extends BaseSimulation {
  val scn = scenario("My First Test")
    .exec(CommonRequests.getAllVideoGames())

  setUp(scn.inject(atOnceUsers(1)))
    .protocols(httpConfig)
}
