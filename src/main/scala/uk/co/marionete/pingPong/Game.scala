package uk.co.marionete.pingPong

import akka.NotUsed
import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.{ActorRef, Behavior, Terminated}

object Game {
  //  sealed trait Command
  //  case class Start() extends Command

  val root: Behavior[NotUsed] =
    Behaviors.setup { ctx =>
      val ping: ActorRef[PCommand] = ctx.spawn(new Player().rest, "Ping")
      val pong: ActorRef[PCommand] = ctx.spawn(new Player().rest, "Pong")
      ctx.watch(ping)
      ctx.watch(pong)

      ping ! StartGame
      pong ! StartGame

      ping ! Ping(pong)

      Behaviors.receiveSignal {
        case (_, Terminated(ref)) => Behaviors.stopped
      }
    }
}
