package demo.assemblyline

interface Station {
  fun execute(assemblyCar: AssemblyCar)
}

class PaintingStation : Station {
  override fun execute(assemblyCar: AssemblyCar) {
    assemblyCar.paint()
  }
}

class MechanicAssemblyStation : Station {
  override fun execute(assemblyCar: AssemblyCar) {
    assemblyCar.assemblyMechanics()
  }
}

class InteriorAssemblyStation : Station {
  override fun execute(assemblyCar: AssemblyCar) {
    assemblyCar.assemblyInterior()
  }
}
