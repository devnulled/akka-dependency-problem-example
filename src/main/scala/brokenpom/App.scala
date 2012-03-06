package brokenpom

import play.api.mvc.{Action, AsyncResult}
import play.api.mvc.Results._
import play.api.libs.concurrent._

import scala.util.Random
import annotation.tailrec

import akka.actor.{Props, ActorSystem, Actor}
import akka.pattern.ask
import akka.pattern.pipe
import akka.util.Timeout
import akka.util.duration._
import akka.dispatch.{Await, Future}
import play.api.data.Form
import play.api.data.Forms._
import com.typesafe.play.mini._

object App extends Application {

    def route = Routes(
          Through("/search/term/") {groups: List[String] =>
            Action {
              val term :: Nil = groups
              Ok(<h1>Your search term was: {term}</h1>).as("text/html")
            }
          },
          {
            case GET(Path("/ping")) => Action { Ok("Pong @ %s\n".format(System.currentTimeMillis))}
          }
      )

}
