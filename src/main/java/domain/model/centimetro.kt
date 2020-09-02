package domain.model

object centimetro : convertible {
    private var unidades = 1.0
    private var equivalencias = HashMap<convertible, Double>()

    init {
        equivalencias.put(milimetro, 10.0)
        equivalencias.put(centimetro, 1.0)
        equivalencias.put(metro, 0.01)
        equivalencias.put(kilometro, 0.00001)
    }

    override fun convertirUnidadesA(convertible: convertible): Double? {
        return unidades * equivalenciaPara(convertible)!!
    }

    override fun equivalenciaPara(convertible: convertible): Double? {
        return equivalencias[convertible]
    }

    override fun cambiarUnidades(unidades: Double) {
        centimetro.unidades = unidades
    }

    override fun toString(): String {
        return "Centimetro"
    }
}