val scala3Version = "3.0.0-M2"

resolvers += Resolver.sonatypeRepo("public")
resolvers += Resolver.sonatypeRepo("snapshots")

lazy val root = project
  .in(file("."))
  .settings(
    name := "tensorzoo",
    organization := "org.scaladl",
    version := "0.1.0",

    scalaVersion := scala3Version,

    libraryDependencies ++= Seq(
      "org.tensorflow" % "tensorflow-core-platform" % "0.3.0-SNAPSHOT",
      "com.novocode" % "junit-interface" % "0.11" % "test"
    )
  )
