package demo.assemblyline

import kotlin.random.Random

interface QualityAssuranceService {
  fun check(car: Car): Boolean
}

class AlwaysAcceptingQAService : QualityAssuranceService {
  override fun check(car: Car): Boolean {
    return true
  }
}

class RejectingOnceQAService : QualityAssuranceService {
  var calls = 0
  override fun check(car: Car): Boolean {
    return if (calls > 0) {
      calls++
      true
    } else {
      calls++
      false
    }
  }
}

class RateBasedQAService(private val acceptanceRate: Double) : QualityAssuranceService {
  override fun check(car: Car): Boolean {
    return Random.nextDouble() <= acceptanceRate
  }
}
