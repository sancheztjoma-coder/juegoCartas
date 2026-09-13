import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Carta {

    private int indice;
    private Pinta pinta;
    private NombreCarta nombre;

    // método constructor
    public Carta(Random r) {
        // generar un numero al azar entre 1 y 52
        indice = r.nextInt(52) + 1;
    }

    public Carta(Pinta pinta, NombreCarta nombre) {
        this.pinta = pinta;
        this.nombre = nombre;
        this.indice = pinta.ordinal() * 13 + nombre.ordinal() + 1;
    }

    public void mostrar(JPanel pnl, int x, int y) {
        // cargar imagen
        String rutaImagen = "imagenes/CARTA" + indice + ".JPG";
        ImageIcon imgCarta = new ImageIcon(getClass().getResource(rutaImagen));

        // mostrar en un JLABEL
        JLabel lblCarta = new JLabel(imgCarta);
        lblCarta.setBounds(x, y, imgCarta.getIconWidth(), imgCarta.getIconHeight());
        pnl.add(lblCarta);

        // evento CLICK de la CARTA
        lblCarta.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evento) {
                JOptionPane.showMessageDialog(null, getNombre() + " de " + getPinta());
            }
        });

    }

    // Getters
    public Pinta getPinta() {
        return pinta;
    }

    public NombreCarta getNombre() {
        return nombre;
    }

}
