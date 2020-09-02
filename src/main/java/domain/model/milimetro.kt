package domain.model

object milimetro : convertible {
    private var unidades = 1.0
    private var equivalencias = HashMap<convertible, Double>()

    init {
        equivalencias.put(milimetro, 1.0)
        equivalencias.put(centimetro, 0.1)
        equivalencias.put(metro, 0.001)
        equivalencias.put(kilometro, 0.000001)
    }

    override fun convertirUnidadesA(convertible: convertible): Double? {
        return unidades * equivalenciaPara(convertible)!!
    }

    override fun equivalenciaPara(convertible: convertible): Double? {
        return equivalencias[convertible]
    }

    override fun cambiarUnidades(unidades: Double) {
        milimetro.unidades = unidades
    }

    override fun toString(): String {
        return "Milimetro"
    }
}