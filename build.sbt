ThisBuild / scalaVersion     := "3.2.0"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "io.chrisdavenport"
ThisBuild / organizationName := "Christopher Davenport"

enablePlugins(ScalaNativePlugin)

name := "Scala Native Ember Example"

resolvers ++= Resolver.sonatypeOssRepos("snapshots")
libraryDependencies ++= Seq(
  "com.armanbilge" %%% "epollcat" % "0.1.1", // vesitigial
  "com.armanbilge" %%% "fs2-io_uring" % "0.0-dbbb6e6-SNAPSHOT", // Runtime
  "org.http4s" %%% "http4s-ember-client" % "0.23.16",
  "org.http4s" %%% "http4s-ember-server" % "0.23.16",
  "org.http4s" %%% "http4s-dsl" % "0.23.16",
  "org.http4s" %%% "http4s-circe" % "0.23.16",
)


nativeConfig ~= { c =>
  c.withCompileOptions(c.compileOptions :+ "-I/home/linuxbrew/.linuxbrew/include")
    .withLinkingOptions(c.linkingOptions ++ List("-L/home/linuxbrew/.linuxbrew/lib"))
}
envVars ++= {
  Map(
    "S2N_DONT_MLOCK" -> "1",
    "LD_LIBRARY_PATH" -> "/home/linuxbrew/.linuxbrew/lib:/usr/local/opt/openssl@1.1/lib"
  )
}
