package demo.assemblyline

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

internal class StationTest {
  private val assemblyCar = AssemblyCarSpy()

  @Test
  fun paintingStationIsAStation() {
    assertIs<Station>(PaintingStation())
  }

  @Test
  fun executingPaintingStationCallsPaint() {
    val painting = PaintingStation()
    painting.execute(assemblyCar)
    assertEquals(1, assemblyCar.paintCalls)
  }

  @Test
  fun mechanicAssemblyStationIsAStation() {
    assertIs<Station>(MechanicAssemblyStation())
  }

  @Test
  fun executingMechanicAssemblyStationCallsAssemblyMechanics() {
    val mechanic = MechanicAssemblyStation()
    mechanic.execute(assemblyCar)
    assertEquals(1, assemblyCar.assemblyMechanicsCalls)
  }

  @Test
  fun interiorAssemblyStationIsAStation() {
    assertIs<Station>(InteriorAssemblyStation())
  }

  @Test
  fun executingInteriorAssemblyStationCallsAssemblyInterior() {
    val interior = InteriorAssemblyStation()
    interior.execute(assemblyCar)
    assertEquals(1, assemblyCar.assemblyInteriorCalls)
  }

  @Test
  fun polishStationIsAStation() {
    assertIs<Station>(PolishStation())
  }

  @Test
  fun executingPolishStationCallsPolish() {
    val polish = PolishStation()
    polish.execute(assemblyCar)
    assertEquals(1, assemblyCar.polishCalls)
  }
}

internal class AssemblyCarSpy() : AssemblyCar {
  var paintCalls = 0
  var assemblyMechanicsCalls = 0
  var assemblyInteriorCalls = 0
  var buildCalls = 0
  var polishCalls = 0

  override fun paint() {
    paintCalls++
  }

  override fun assemblyMechanics() {
    assemblyMechanicsCalls++
  }

  override fun assemblyInterior() {
    assemblyInteriorCalls++
  }

  override fun polish() {
    polishCalls++
  }

  override fun build(): Car {
    buildCalls++
    return Car()
  }
}
