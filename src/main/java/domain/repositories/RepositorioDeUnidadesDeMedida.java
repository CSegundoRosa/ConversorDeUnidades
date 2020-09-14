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

        milimetro.agregarEquivalencia(milimetro, 1.00);
        milimetro.agregarEquivalencia(centimetro,0.10);
        milimetro.agregarEquivalencia(metro, 0.001);
        milimetro.agregarEquivalencia(kilometro,0.000001);

        centimetro.agregarEquivalencia(metro,0.01);
        centimetro.agregarEquivalencia(centimetro, 1.00);
        centimetro.agregarEquivalencia(milimetro, 10.00);
        centimetro.agregarEquivalencia(kilometro, 0.00001);

        metro.agregarEquivalencia(metro, 1.00);
        metro.agregarEquivalencia(centimetro, 100.00);
        metro.agregarEquivalencia(milimetro, 1000.00);
        metro.agregarEquivalencia(kilometro, 0.001);

        kilometro.agregarEquivalencia(kilometro,1.00);
        kilometro.agregarEquivalencia(metro, 1000.00);
        kilometro.agregarEquivalencia(centimetro, 100000.00);
        kilometro.agregarEquivalencia(milimetro, 1000000.00);
        //agregar el resto (son esas?)

        this.unidadDeMedidas.add(centimetro);
        this.unidadDeMedidas.add(milimetro);
        this.unidadDeMedidas.add(metro);
        this.unidadDeMedidas.add(kilometro);
    }

    public List<UnidadDeMedida> buscarTodas(){
        return this.unidadDeMedidas;
    }
}
