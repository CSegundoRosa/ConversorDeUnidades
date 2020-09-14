package views;

//import domain.model.convertible;

import domain.model.UnidadDeMedida;
import domain.repositories.RepositorioDeUnidadesDeMedida;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;


public class Principal extends JFrame{
    private JPanel mainPanel;
    private JLabel titulo;
    private JPanel panelCentral;
    private JLabel medidaSeleccionada;
    private JTextField unidadesFuente;
    private JTextField unidadesDestino;
    private JComboBox selectorMedidaFuente;
    private JComboBox selectorMedidaDestino;


    public Principal(String title){
        super(title);
        this.rellenarSelectores();
        this.agregarListenersParaInputs();
        this.agregarListenersParaSelectores();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
    }


    private void rellenarSelectores(){
        RepositorioDeUnidadesDeMedida unRepositorio = new RepositorioDeUnidadesDeMedida();
        List<UnidadDeMedida> items = unRepositorio.buscarTodas();

        for(Object item : items){
            this.selectorMedidaFuente.addItem(item);
            this.selectorMedidaDestino.addItem(item);
        }

    }

    private void  agregarListenersParaInputs(){
        unidadesFuente.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                mostrarMedidasEquivalentes();
            }
        });

        unidadesDestino.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                mostrarMedidasEquivalentes();
            }
        });
    }

    private void mostrarMedidasEquivalentes(){
        UnidadDeMedida unidadDeMedidaFuente = (UnidadDeMedida) selectorMedidaFuente.getSelectedItem();
        UnidadDeMedida unidadDeMedidaDestino = (UnidadDeMedida) selectorMedidaDestino.getSelectedItem();
        String valorUnidadesFuente = unidadesFuente.getText();
        if(!valorUnidadesFuente.isEmpty()){
            Double unidades = new Double(valorUnidadesFuente);
            Double unidadesConvertidas = convertirUnidades(unidades, unidadDeMedidaFuente, unidadDeMedidaDestino);
            String detalleUnidadesConvertidas = String.format("%.2f", unidadesConvertidas);
            unidadesDestino.setText(detalleUnidadesConvertidas);
        }
    }

    private Double convertirUnidades(Double unidades, UnidadDeMedida unidadDeMedidafuente, UnidadDeMedida unidadDeMedidaDestino) {
        unidadDeMedidafuente.cambiarUnidades(unidades);
        Double unidadesConvertidas = unidadDeMedidafuente.convertirUnidadesA(unidadDeMedidaDestino);
        return unidadesConvertidas;
    }

    private void agregarListenersParaSelectores(){
        selectorMedidaFuente.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    mostrarMedidasEquivalentes();
                }
            }
        });

        selectorMedidaDestino.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    mostrarMedidasEquivalentes();
                }
            }
        });
    }

}
