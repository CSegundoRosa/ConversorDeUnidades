package domain.model;

import java.util.HashMap;

public class UnidadDeMedida {
    private String nombre;
    private Double unidades;
    private HashMap<UnidadDeMedida, Double> equivalencias;

    //Constructor
    public UnidadDeMedida(String nombre){
        this.nombre = nombre;
        this.unidades = 1.0;
        this.equivalencias = new HashMap<UnidadDeMedida, Double>();
    }

    public void agregarEquivalencia(UnidadDeMedida unidadDeMedida, Double equivalencia){
        this.equivalencias.put(unidadDeMedida, equivalencia);
    }

    public Double equivalenciaPara(UnidadDeMedida unidadDeMedida){
        return this.equivalencias.get(unidadDeMedida);
    }

    public Double convertirUnidadesA(UnidadDeMedida unidadDeMedida){
        return this.unidades * this.equivalenciaPara(unidadDeMedida);
    }

    public void cambiarUnidades(Double unidades){
        this.unidades = unidades;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
