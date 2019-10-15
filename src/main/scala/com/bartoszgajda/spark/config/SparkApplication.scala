package com.bartoszgajda.spark.config

import org.apache.spark.{SparkConf, SparkContext}

trait SparkApplication {
  def sparkAppName: String

  def withSparkContext(conf: (SparkConf => SparkConf))(f: (SparkContext) => Unit): Unit = {
    val sparkConf = new SparkConf()
      .setAppName(sparkAppName)
    val sc = new SparkContext(conf(sparkConf))
    f(sc)
  }
}
