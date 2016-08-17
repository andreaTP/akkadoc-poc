
lazy val root = (project in file(".")).
  enablePlugins(ParadoxPlugin).
  settings(
    name := "Akka Docs POC",
    paradoxTheme := Some(builtinParadoxTheme("generic")),
    scalaVersion := "2.11.8",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor" % "2.4.9-RC2",
      "com.typesafe.akka" %% "akka-stream" % "2.4.9-RC2"
    )
)
