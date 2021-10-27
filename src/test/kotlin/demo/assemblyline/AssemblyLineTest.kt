package demo.assemblyline

import kotlin.test.Test

class AssemblyLineTest {
  @Test
  fun takesAListOfStations() {
    val stations: List<Station> = listOf()
    val al: AssemblyLine = AssemblyLine(stations)
  }

  @Test
  fun hasProduceMethod() {
    val stations: List<Station> = listOf()
    val al: AssemblyLine = AssemblyLine(stations)
    al.produce(AssemblyCarEntity())
  }
}
