package demo.assemblyline

class AssemblyLine(private val stations: List<Station>) {
  init {
    if (stations.size < 2) throw IllegalStateException("At least two stations are required")
    if (stations.last() !is QualityAssuranceAndBuildStation) throw IllegalStateException("The last station must be a quality assurance and build station")
  }

  fun produce(assemblyCar: AssemblyCar) {
    for (s in stations) s.execute(assemblyCar)
  }
}
