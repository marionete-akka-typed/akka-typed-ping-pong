package uk.co.marionete.ping_pong

import akka.actor.typed.{ActorRef, Behavior}
import akka.testkit.typed.scaladsl.{ActorTestKit, BehaviorTestKit, TestProbe}
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpec}

class PlayerSpec
  extends WordSpec
    with ActorTestKit
    with Matchers
    with BeforeAndAfterAll {

  "A player" must {
    "be alive" in {
      val testKit: BehaviorTestKit[PCommand] = BehaviorTestKit(new Player().rest)
      testKit.run(StartGame(0))
      assert(testKit.isAlive)
    }
  }

  "A player" must {
    "send message" in {
      val probe: TestProbe[PCommand] = TestProbe[PCommand]()
      val play: Behavior[PCommand] = new Player().playing(10)
      val pinger: ActorRef[PCommand] = spawn(play)

      pinger ! Ping(probe.ref)

      probe.expectMessage(Ping(pinger))
    }
  }

  "A player" must {
    "send a end game message" in {
      val probe: TestProbe[PCommand] = TestProbe[PCommand]()
      val play: Behavior[PCommand] = new Player().playing(0)
      val pinger: ActorRef[PCommand] = spawn(play)

      pinger ! Ping(probe.ref)

      probe.expectMessage(EndGame(pinger))
    }
  }

  override def afterAll(): Unit = shutdownTestKit()
}



