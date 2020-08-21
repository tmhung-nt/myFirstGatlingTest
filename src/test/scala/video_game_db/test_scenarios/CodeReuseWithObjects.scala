package video_game_db.test_scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import video_game_db.baseConfig.BaseSimulation
import video_game_db.requests.CommonRequests

class CodeReuseWithObjects extends BaseSimulation {
  val scn = scenario("Code reuses")
      .exec(CommonRequests.getAllVideoGames())
      .pause(5)
      .exec(CommonRequests.getSpecificVideoGame())
      .pause(5)
      .exec(CommonRequests.getAllVideoGames())

  setUp(
    scn.inject(atOnceUsers(1))
  ).protocols(httpConfig)

}
