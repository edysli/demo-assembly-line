package demo.assemblyline

class AssemblyLine(private val stations: List<Station>, private val qaService: QualityAssuranceService) {
  init {
    if (stations.isEmpty()) throw IllegalStateException("At least one station is required")
  }

  fun produce(assemblyCar: AssemblyCar): Car {
    for (s in stations) s.execute(assemblyCar)
    return qaPassOrProduceAgain(assemblyCar)
  }

  private fun qaPassOrProduceAgain(assemblyCar: AssemblyCar): Car {
    val car = assemblyCar.build()
    return if (qaService.check(car)) {
      car
    } else {
      produce(assemblyCar)
    }
  }
}
