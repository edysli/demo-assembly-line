package demo.assemblyline

interface AssemblyCar {
  fun paint()
  fun assemblyMechanics()
  fun assemblyInterior()
  fun build(): Car
}

class AssemblyCarEntity : AssemblyCar {
  override fun paint() {}
  override fun assemblyMechanics() {}
  override fun assemblyInterior() {}
  override fun build(): Car {
    return Car()
  }
}

class Car
