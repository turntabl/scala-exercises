scalaVersion := "2.13.8"

name := "scala-exercises"
organization := "io.turntabl"
version := "0.1"

libraryDependencies := Seq(
"org.scalameta" %% "munit" % "0.7.29" % Test,
"org.scalameta" %% "munit-scalacheck" % "0.7.29" % Test)
