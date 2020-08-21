package video_game_db.test_scenarios

import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef._
import video_game_db.requests.CommonRequests

class MyFirstTest extends Simulation {
  val httpConf = http.baseUrl("http://video-game-db.eu-west-2.elasticbeanstalk.com/app/")
                  .header("Accept", "application/json")

  val scn = scenario("My First Test")
    .exec(CommonRequests.getAllVideoGames())

  setUp(scn.inject(atOnceUsers(1)))
    .protocols(httpConf)
}
