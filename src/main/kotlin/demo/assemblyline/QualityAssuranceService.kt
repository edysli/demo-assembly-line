package demo.assemblyline

interface QualityAssuranceService {
  fun check(car: Car): Boolean
}

class AlwaysAcceptingQAService : QualityAssuranceService {
  override fun check(car: Car): Boolean {
    return true
  }
}
