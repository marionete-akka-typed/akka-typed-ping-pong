package uk.co.marionete.ping_pong

import akka.NotUsed
import akka.actor.typed.ActorSystem

object Main extends App {
  val system: ActorSystem[NotUsed] = ActorSystem(Game.root, "PingPong")
}
