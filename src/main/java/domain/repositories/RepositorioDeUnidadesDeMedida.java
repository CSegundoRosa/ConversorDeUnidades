package domain.repositories;

import domain.model.UnidadDeMedida;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDeUnidadesDeMedida {
    private List<UnidadDeMedida> unidadDeMedidas;

    public RepositorioDeUnidadesDeMedida(){
        this.unidadDeMedidas = new ArrayList<UnidadDeMedida>();
        UnidadDeMedida centimetro = new UnidadDeMedida("Centimetro");
        UnidadDeMedida milimetro = new UnidadDeMedida("Milimetro");
        UnidadDeMedida metro = new UnidadDeMedida("Metro");
        UnidadDeMedida kilometro = new UnidadDeMedida("Kilometro");

        centimetro.agregarEquivalencia(metro,0.01);
        //agregar el resto

        this.unidadDeMedidas.add(centimetro);
        this.unidadDeMedidas.add(milimetro);
        this.unidadDeMedidas.add(metro);
        this.unidadDeMedidas.add(kilometro);
    }

    public List<UnidadDeMedida> buscarTodas(){
        return this.unidadDeMedidas;
    }
}
