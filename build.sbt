ThisBuild / scalaVersion     := "3.2.1"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "io.chrisdavenport"
ThisBuild / organizationName := "Christopher Davenport"

enablePlugins(ScalaNativePlugin)

name := "Scala Native Ember Example"

resolvers ++= Resolver.sonatypeOssRepos("snapshots")

libraryDependencies ++= Seq(
  "com.armanbilge" %%% "epollcat" % "0.1.1-66-4d931d3-SNAPSHOT", // Runtime
  "org.http4s" %%% "http4s-ember-client" % "0.23.16",
  "org.http4s" %%% "http4s-ember-server" % "0.23.16",
  "org.http4s" %%% "http4s-dsl" % "0.23.16",
  "org.http4s" %%% "http4s-circe" % "0.23.16",
  "io.github.cquiroz" %%% "scala-java-locales" % "1.4.1+60-f23c22ec-SNAPSHOT",
)

val isLinux = {
  val osName = Option(System.getProperty("os.name"))
  osName.exists(_.toLowerCase().contains("linux"))
}
val isMacOs = {
  val osName = Option(System.getProperty("os.name"))
  osName.exists(_.toLowerCase().contains("mac"))
}

nativeMode := "release-fast"
nativeLTO := "thin"
nativeLinkingOptions += "-lprofiler"
envVars ++= {
  Map("S2N_DONT_MLOCK" -> "1")
}
