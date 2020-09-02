package domain.model

object kilometro : convertible {
    private var unidades = 1.0
    private var equivalencias = HashMap<convertible, Double>()

    init {
        equivalencias.put(milimetro, 1000000.0)
        equivalencias.put(centimetro, 100000.0)
        equivalencias.put(metro, 1000.0)
        equivalencias.put(kilometro, 1.0)
    }

    override fun convertirUnidadesA(convertible: convertible): Double? {
        return unidades * equivalenciaPara(convertible)!!
    }

    override fun equivalenciaPara(convertible: convertible): Double? {
        return equivalencias[convertible]
    }

    override fun cambiarUnidades(unidades: Double) {
        kilometro.unidades = unidades
    }


    override fun toString(): String {
        return "Kilometro"
    }
}