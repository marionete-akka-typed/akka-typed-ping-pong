package uk.co.marionete.pingPong

import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.{ActorRef, Behavior}

sealed trait PCommand
case class StartGame(moves: Int) extends PCommand
case class EndGame(who: ActorRef[EndGame]) extends PCommand
case class Ping(from: ActorRef[PCommand]) extends PCommand

class Player {
  val rest: Behavior[PCommand] = resting()

  private def resting(): Behavior[PCommand] =
    Behaviors.receive[PCommand] { (ctx, msg) =>
      msg match {
        case StartGame(moves) =>
          println(s"${ctx.self.path.toString} - Starting game")
          playing(move = moves)
        case _ =>
          Beh
          Behaviors.same
      }
    }

  private def playing(move: Int): Behavior[PCommand] =
    Behaviors.receive[PCommand] { (ctx, msg) =>
      msg match {
        case Ping(from) =>
          if (move <= 0) {
            println(s"${ctx.self.path.toString} - I am the champion")
            from ! EndGame(ctx.self)
            resting()
          } else {
            println(s"${ctx.self.path.toString} - move = ${move}")
            from ! Ping(ctx.self)
            playing(move - 1)
          }
        case EndGame(from) =>
          println(s"${ctx.self.path.toString} - I lost")
          Behaviors.stopped
        case _ =>
          Behaviors.same
      }
    }
}


