import com.typesafe.sbteclipse.core.EclipsePlugin.EclipseKeys

name := "subprojects"

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.6"

scalacOptions ++= Seq(
  "-feature",                   // Shows warnings in detail in the stdout
  "-language:reflectiveCalls"   // Address the warning generated on the primary route files after introducing subprojects; see https://groups.google.com/d/msg/play-framework/nNr2NdBtWuw/JfbPLaX35XcJ
)

libraryDependencies ++= Seq(
)

lazy val root = (project in file(".")).enablePlugins(PlayJava).dependsOn(admin, website).aggregate(website, admin)

lazy val common = (project in file("modules/common")).enablePlugins(PlayJava)

lazy val admin = (project in file("modules/admin")).enablePlugins(PlayJava).dependsOn(common)

lazy val website = (project in file("modules/website")).enablePlugins(PlayJava).dependsOn(common)

EclipseKeys.preTasks := Seq(compile in Compile)
EclipseKeys.skipParents in ThisBuild := false

routesGenerator := InjectedRoutesGenerator
