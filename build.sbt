//import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "uk.co.marionete",
      scalaVersion := "2.12.5",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "Akka1",
    libraryDependencies ++= Seq(
      // https://mvnrepository.com/artifact/com.typesafe.akka/akka-actor-typed
      "com.typesafe.akka" %% "akka-actor-typed" % "2.5.12",
      // https://mvnrepository.com/artifact/org.scalatest/scalatest
      "org.scalatest" %% "scalatest" % "3.0.5" % Test,
      // https://mvnrepository.com/artifact/com.typesafe.akka/akka-testkit-typed
      "com.typesafe.akka" %% "akka-testkit-typed" % "2.5.12" % Test
    )
  )
