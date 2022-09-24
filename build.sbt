ThisBuild / scalaVersion     := "3.2.0"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "io.chrisdavenport"
ThisBuild / organizationName := "Christopher Davenport"

name := "Scala Native Ember Example"

libraryDependencies ++= Seq(
  "org.http4s" %%% "http4s-ember-client" % "0.23.16",
  "org.http4s" %%% "http4s-ember-server" % "0.23.16",
  "org.http4s" %%% "http4s-dsl" % "0.23.16",
  "org.http4s" %%% "http4s-circe" % "0.23.16",
)

fork := true
