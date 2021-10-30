package demo.assemblyline

import kotlin.test.Test
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
}
