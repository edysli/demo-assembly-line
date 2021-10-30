package demo.assemblyline

import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class AssemblyLineTest {
  private val qaService: QualityAssuranceService = AlwaysAcceptingQAService()

  @Test
  fun requiresAtLeastOneStation() {
    val ise = assertThrows<IllegalStateException> { AssemblyLine(listOf(), qaService) }
    assertEquals("At least one station is required", ise.message)
  }

  @Test
  fun produceCallsAllStations() {
    val al: AssemblyLine = AssemblyLine(
      listOf(
        PaintingStation(),
        MechanicAssemblyStation(),
        InteriorAssemblyStation(),
        PolishStation()
      ),
      qaService
    )
    val assemblyCar = AssemblyCarSpy()
    al.produce(assemblyCar)
    assertEquals(1, assemblyCar.paintCalls)
    assertEquals(1, assemblyCar.assemblyMechanicsCalls)
    assertEquals(1, assemblyCar.assemblyInteriorCalls)
    assertEquals(1, assemblyCar.polishCalls)
    assertEquals(1, assemblyCar.buildCalls)
  }

  @Test
  fun produceReturnsACar() {
    val al: AssemblyLine = AssemblyLine(
      listOf(
        PaintingStation(),
        MechanicAssemblyStation(),
        InteriorAssemblyStation(),
        PolishStation()
      ),
      qaService
    )
    assertIs<Car>(al.produce(AssemblyCarEntity()))
  }

  @Test
  fun requiresQualityAssuranceService() {
    val al: AssemblyLine = AssemblyLine(
      listOf(
        PaintingStation(),
        MechanicAssemblyStation(),
        InteriorAssemblyStation(),
        PolishStation()
      ), qaService
    )
  }
}
