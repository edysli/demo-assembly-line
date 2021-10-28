package demo.assemblyline

import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals

class AssemblyLineTest {
  @Test
  fun needsAtLeastTwoStations() {
    val ise = assertThrows<IllegalStateException> { AssemblyLine(listOf(PaintingStation())) }
    assertEquals("At least two stations are required", ise.message)
  }

  @Test
  fun lastStationMustBeQualityAssuranceAndBuild() {
    val ise = assertThrows<IllegalStateException> { AssemblyLine(listOf(PaintingStation(), MechanicAssemblyStation())) }
    assertEquals("The last station must be a quality assurance and build station", ise.message)
  }

  @Test
  fun produceCallsAllStations() {
    val al: AssemblyLine = AssemblyLine(
      listOf(
        PaintingStation(),
        MechanicAssemblyStation(),
        InteriorAssemblyStation(),
        QualityAssuranceAndBuildStation()
      )
    )
    val assemblyCar = AssemblyCarSpy()
    al.produce(assemblyCar)
    assertEquals(1, assemblyCar.paintCalls)
    assertEquals(1, assemblyCar.assemblyMechanicsCalls)
    assertEquals(1, assemblyCar.assemblyInteriorCalls)
    assertEquals(1, assemblyCar.buildCalls)
  }
}
