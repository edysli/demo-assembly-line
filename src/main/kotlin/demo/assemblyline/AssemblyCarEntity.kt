package demo.assemblyline

interface AssemblyCar {
  fun paint()
  fun assemblyMechanics()
  fun assemblyInterior()
  fun polish()
  fun build(): Car
}

class AssemblyCarEntity : AssemblyCar {
  override fun paint() {}
  override fun assemblyMechanics() {}
  override fun assemblyInterior() {}
  override fun polish() {}
  override fun build(): Car {
    return Car()
  }
}

class Car
