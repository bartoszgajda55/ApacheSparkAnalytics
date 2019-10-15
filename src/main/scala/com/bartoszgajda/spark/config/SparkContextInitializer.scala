package com.bartoszgajda.spark.config

import org.apache.spark.{SparkConf, SparkContext}

object SparkContextInitializer {
  def createSparkContext(name: String, additionalOptions: List[(String, String)]) = {
    val sc: SparkConf = basicSparkConf(name, additionalOptions)
    SparkContext.getOrCreate(sc)
  }

  def basicSparkConf(name: String, additionalOptions: List[(String, String)]): SparkConf = {
    val sparkConf = new SparkConf()
      .setAppName(name)
      .setMaster("local[4]")
    additionalOptions.foreach(option => sparkConf.set(option._1, option._2))
    sparkConf
  }
}

case class SparkApplicationConfig(appName: String) extends Serializable