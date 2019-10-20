trait Sink[T <: WithId] {
  def write(ssc: StreamingContext, result: DStream[T])

}
