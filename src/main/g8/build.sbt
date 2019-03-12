organization := "$organization$"

name := "$name$"

description := "$app_description$"

version := "1.0-SNAPSHOT"

lazy val root = project in file(".")

scalaVersion := "2.12.6"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % Test

scalacOptions ++= Seq(
    "-unchecked"
  , "-deprecation"
  , "-feature"
  , "-language:postfixOps"
  , "-language:reflectiveCalls"
)



