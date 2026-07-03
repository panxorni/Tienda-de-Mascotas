package tiendamascotas.interfaz;

import tiendamascotas.logica.modelo.ClienteVirtual;
import javax.swing.*;
import java.awt.*;

public class ClientePanel extends JPanel {
    private JLabel lblNombre;
    private JLabel lblBusca;
    private  JLabel lblPresupuesto;
    private JLabel lblResultado;

    public ClientePanel(){
        setLayout(new GridLayout(4,1,5,5));
        setBorder(BorderFactory.createTitledBorder("Cliente virtual"));
        setPreferredSize(new Dimension(230, 0));

        lblNombre= new JLabel("Cliente: -");
        lblBusca= new JLabel("Busca: -");
        lblPresupuesto= new JLabel("presupuesto: -");
        lblResultado= new JLabel("Estado: esperando clientes");

        add(lblNombre);
        add(lblBusca);
        add(lblPresupuesto);
        add(lblResultado);
    }

    public void mostrarCliente(ClienteVirtual clienteVirtual){
        lblNombre.setText("Cliente: "+ clienteVirtual.getNombre());
        lblBusca.setText("Busca: "+ clienteVirtual.getTipoMascotaNecesitada());
        lblPresupuesto.setText("Presupuesto: $"+ clienteVirtual.getPresupuesto());
        lblResultado.setText("Resultado: procesando");
    }

    public void actualizarResultados(String resultado){
        lblResultado.setText("Resultado: "+ resultado);
    }
}
