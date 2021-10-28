package demo.assemblyline

class AssemblyLine(private val stations: List<Station>) {
  init {
    if (stations.isEmpty()) throw IllegalStateException("At least one station is required")
  }

  fun produce(assemblyCar: AssemblyCar): Car {
    for (s in stations) s.execute(assemblyCar)
    return assemblyCar.build()
  }
}
