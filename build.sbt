import Common._

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(Seq(
    name := "AITests",
    libraryDependencies ++= Seq(
      "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.7.3"
    )
  ))

lazy val montecarlo = project in file("montecarlo")

lazy val neuralnet = project in file("neuralnet")

ideaExcludeFolders += ".idea"

ideaExcludeFolders += ".settings"

ideaExcludeFolders += ".idea_modules"

ideaExcludeFolders += "bin"

ideaExcludeFolders += "project/*"

ideaExcludeFolders += "target"

ideaExcludeFolders += "**/scala-2.11"