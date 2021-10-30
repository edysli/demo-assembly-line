package demo.assemblyline

import kotlin.test.Test
import kotlin.test.assertTrue

internal class QualityAssuranceServiceTest {
  @Test
  fun alwaysAcceptingQAService() {
    val accepting: QualityAssuranceService = AlwaysAcceptingQAService()
    assertTrue(accepting.check(Car()))
    assertTrue(accepting.check(Car()))
  }
}
