package uk.co.marionete.ping_pong

import akka.actor.typed.scaladsl.Behaviors.Receive
import akka.testkit.typed.scaladsl.Effects.Spawned
import akka.testkit.typed.scaladsl.{ActorTestKit, BehaviorTestKit}
import org.scalatest.{BeforeAndAfterAll, GivenWhenThen, Matchers, WordSpec}

class GameSpec
  extends WordSpec
    with ActorTestKit
    with Matchers
    with BeforeAndAfterAll
    with GivenWhenThen {

  "A game" when {
    "created" should {
      "create players" that {
        "are two in number" in {
          Given("An empty game")
          When("it is created")
          val given = BehaviorTestKit(Game.root)

          Then("two players should exist")
          val expected = 2
          val result = given
            .retrieveAllEffects
            .filter(_.isInstanceOf[Spawned[Receive[Player]]])
            .size

          result shouldEqual expected
        }

//        "are named Ping and Pong" in {
//          Given("An empty game")
//          When("it is created")
//          val given = BehaviorTestKit(Game.root)

//          Then("two players should exist")
//          val allPlayers = given
//            .retrieveAllEffects.map()


//          assert(false)
//        }
      }
    }


  }


}
