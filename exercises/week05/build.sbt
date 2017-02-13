name := """exercises week05"""

version := "1.0"

scalaVersion := "2.12.1"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

// Change this to another test framework if you prefer
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

// Exclude some folders associated with IntelliJ
ideaExcludeFolders += ".idea"

ideaExcludeFolders += ".idea_modules"