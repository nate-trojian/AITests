name := "MonteCarlo"

version := "1.0"

organization := "com.ntrojian.montecarlo"

scalaVersion := "2.11.8"

resolvers += Resolver.bintrayRepo("underscoreio", "training")

libraryDependencies ++= Seq(
  "com.github.wookietreiber" %% "scala-chart" % "latest.integration",
  "underscoreio" %% "doodle" % "0.6.3"
)