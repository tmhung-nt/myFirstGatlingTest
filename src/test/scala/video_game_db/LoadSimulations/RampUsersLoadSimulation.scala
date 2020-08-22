package video_game_db.LoadSimulations

import io.gatling.core.Predef._
import video_game_db.baseConfig.BaseSimulation
import video_game_db.requests.CommonRequests

import scala.concurrent.duration.DurationInt

class RampUsersLoadSimulation extends BaseSimulation {
  val scn = scenario("Ramp Users Load Simulation")
    .exec(CommonRequests.getAllVideoGames())
    .pause(5)
    .exec(CommonRequests.getSpecificVideoGame())
    .pause(5)
    .exec(CommonRequests.getAllVideoGames())

  setUp(
    scn.inject(
      nothingFor(5 seconds),
//      constantUsersPerSec(10) during (10 seconds)
      rampUsersPerSec(1) to (5) during (10 seconds)
    ).protocols(httpConfig.inferHtmlResources())
  )
  /*
  rampUsersPerSec(1) to (5) during (10 seconds) --> 5 ramp up levels, 2 seconds each
  --> 00s-02s: 1x2 = 2 users
      02s-04s: 2x2 = 4 users
      04s-06s: 3x2 = 6 users
      06s-08s: 4x2 = 8 users
      08s-10s: 5x2 = 10 users
 --> total users: 30 users

  rampUsersPerSec(1) to (5) during (10 seconds) --> 5 ramp up levels, 2 seconds each
  --> 00s-04s: 1x4 = 4 users
      04s-08s: 2x4 = 8 users
      08s-12s: 3x4 = 12 users
      12s-16s: 4x4 = 16 users
      16s-20s: 5x4 = 20 users
 --> total users: 60 users

  */
}
