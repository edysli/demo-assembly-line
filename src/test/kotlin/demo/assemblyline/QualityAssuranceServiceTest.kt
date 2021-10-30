package demo.assemblyline

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class QualityAssuranceServiceTest {
  @Test
  fun alwaysAcceptingQAService() {
    val accepting: QualityAssuranceService = AlwaysAcceptingQAService()
    assertTrue(accepting.check(Car()))
    assertTrue(accepting.check(Car()))
  }

  @Test
  fun rejectingOnceQAService() {
    val rejectOnce: QualityAssuranceService = RejectingOnceQAService()
    assertFalse(rejectOnce.check(Car()))
    assertTrue(rejectOnce.check(Car()))
    assertTrue(rejectOnce.check(Car()))
  }

  @Test
  fun rateBasedQAService() {
    val expectedAcceptanceRate = 0.8
    val rateBased: QualityAssuranceService = RateBasedQAService(expectedAcceptanceRate)
    val car = Car()
    var acceptedCars = 0
    val iterations = 1000
    for (i in 1..iterations) {
      if (rateBased.check(car)) acceptedCars++
    }
    assertEquals(expectedAcceptanceRate, acceptedCars / iterations.toDouble(), 0.05)
  }
}
