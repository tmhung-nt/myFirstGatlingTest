package video_game_db.test_scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class csvFeeder extends Simulation {

  val httpConf = http.baseUrl("http://video-game-db.eu-west-2.elasticbeanstalk.com/app/")
    .header("Accept", "application/json")

  val csvFeeder = csv("data/gameCsvFile.csv").circular

  def getAllVideoGames() = {
    repeat(1) {
      exec(http("Get all video games - 1st call")
        .get("videogames")
        .check(status.is(200))
      )
    }
  }

  def getSpecificVideoGame() = {
    repeat(10) {
      feed(csvFeeder)
        .exec(http("Get specific game")
          .get("videogames/${gameId}")
          .check(jsonPath("$.name").is("${gameName}"))
          .check(status.in(200 to 210))
        )
        .pause(1)
    }
  }

  val scn = scenario("Csv Feeder test")
      .exec(getSpecificVideoGame())

  setUp(
    scn.inject(atOnceUsers(1))
  ).protocols(httpConf)

}
