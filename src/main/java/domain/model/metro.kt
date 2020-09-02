package domain.model

object metro : convertible {
    private var unidades = 1.0
    private var equivalencias = HashMap<convertible, Double>()

    init {
        equivalencias.put(milimetro, 1000.0)
        equivalencias.put(centimetro, 100.0)
        equivalencias.put(metro, 1.0)
        equivalencias.put(kilometro, 0.0001)
    }

    override fun convertirUnidadesA(convertible: convertible): Double? {
        return unidades * equivalenciaPara(convertible)!!
    }

    override fun equivalenciaPara(convertible: convertible): Double? {
        return equivalencias[convertible]
    }

    override fun cambiarUnidades(unidades: Double) {
        metro.unidades = unidades
    }

    override fun toString(): String {
        return "Metro"
    }

}