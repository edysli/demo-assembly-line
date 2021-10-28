package demo.assemblyline

import kotlin.test.assertIs
import kotlin.test.Test

internal class AssemblyCarEntityTest {
  @Test
  fun assemblyCarEntityIsAnAssemblyCar() {
    assertIs<AssemblyCar>(AssemblyCarEntity())
  }

  @Test
  fun buildReturnsACar() {
    assertIs<Car>(AssemblyCarEntity().build())
  }
}