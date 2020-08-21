package video_game_db.requests

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object CommonRequests {
  def getAllVideoGames() = {
    repeat(1) {
      exec(http("Get all video games - 1st call")
        .get("videogames")
        .check(status.is(200))
      )
    }
  }

  def getSpecificVideoGame() = {
    exec(http("Get specific game")
      .get("videogames/1")
      .check(status.in(200 to 210))
    )
  }

  def postNewGame(customFeeder: Iterator[Map[String, Any]]) = {
    repeat(5) {
      feed(customFeeder)
        .exec(http("Post New Game")
          .post("videogames/")
          .body(ElFileBody("bodies/NewGameTemplate.json")).asJson
          .check(status.is(200)))
        .pause(1)
    }
  }
}
