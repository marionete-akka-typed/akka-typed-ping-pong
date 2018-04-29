package uk.co.marionete.pingPong

import akka.NotUsed
import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.{ActorRef, Behavior, Terminated}

object Game {
  val root: Behavior[NotUsed] =
    Behaviors.setup { ctx =>
      val ping: ActorRef[PCommand] = ctx.spawn(new Player().rest, "Ping")
      val pong: ActorRef[PCommand] = ctx.spawn(new Player().rest, "Pong")
      ctx.watch(ping)
      ctx.watch(pong)

      import scala.util.Random
      ping ! StartGame(Random.nextInt(30) + 10)
      pong ! StartGame(Random.nextInt(30) + 10)

      ping ! Ping(pong)

      Behaviors.receiveSignal {
        case (_, Terminated(ref)) => Behaviors.stopped
      }
    }
}
