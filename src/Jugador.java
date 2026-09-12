import java.util.Random;

import javax.swing.JPanel;

public class Jugador {

    private final int TOTAL_CARTAS = 10;
    private final int MARGEN = 10;
    private final int DISTANCIA = 40;

    private Carta[] cartas = new Carta[TOTAL_CARTAS];
    private Random r = new Random();
    private Carta[] cartasCombinadas = new Carta[10];
    private int posicionCombinadas = 0;

    public void repartir() {

        cartasCombinadas = new Carta[10];
        posicionCombinadas = 0;

        for (int i = 0; i < TOTAL_CARTAS; i++) {
            cartas[i] = new Carta(r);
        }
    }

    public void mostrar(JPanel pnl) {
        pnl.removeAll();
        pnl.setLayout(null);
        int posicion = MARGEN + TOTAL_CARTAS * DISTANCIA;
        for (Carta carta : cartas) {
            posicion -= DISTANCIA;
            carta.mostrar(pnl, posicion, MARGEN);
        }
        pnl.repaint();
    }

    public String getGrupos() {
        String resultado = "No se encontraron grupos";

        int[] contadores = new int[NombreCarta.values().length];
        boolean hayGrupos = false;
        for (Carta carta : cartas) {
            int posicion = carta.getNombre().ordinal();
            contadores[posicion]++;
            if (!hayGrupos && contadores[posicion] >= 2) {
                hayGrupos = true;
            }
        }

        if (hayGrupos) {
            resultado = "Se encontraron los siguientes grupos:\n";
            // for (int contador : contadores) {
            for (int i = 0; i < contadores.length; i++) {
                // if (contador >= 2) {
                if (contadores[i] >= 2) {
                    resultado += Grupo.values()[contadores[i]] + " de " + NombreCarta.values()[i] + "\n";
                    
                    for (Carta carta : cartas) {
                        if (carta.getNombre().ordinal() == i) {
                            cartasCombinadas[posicionCombinadas] = carta;
                            posicionCombinadas++;
                        }

                }   }
            }
        
        }
        return resultado;
    }
    

    public String getEscaleras() {
        boolean[][] matriz_cartas = new boolean[4][13];

        for (Carta carta : cartas) {
            int pinta = carta.getPinta().ordinal();
            int nombre = carta.getNombre().ordinal();

            matriz_cartas[pinta][nombre] = true;
        }

        String resultado = "";
        boolean hayEscaleras = false;

        for (int p = 0; p < matriz_cartas.length; p++) {

            int indice = 0;

            while (indice < 13 && matriz_cartas[p][indice]) {
                indice++;
            }

            int i = (indice + 1) % 13;

            while (i != indice) {

                if (matriz_cartas[p][i]) {

                    int cantidad = 1;
                    int siguiente = (i + 1) % 13;

                    while (cantidad < 13 && matriz_cartas[p][siguiente]) {
                        cantidad++;
                        siguiente = (siguiente + 1) % 13;
                    }

                    //revisar si es 2 o 3, no recuerdo bien
                    if (cantidad >= 2) {

                        if (!hayEscaleras) {
                            resultado = "Se encontraron las siguientes escaleras:\n";
                            hayEscaleras = true;
                        }

                        resultado += Grupo.values()[cantidad]
                                + " de "
                                + Pinta.values()[p]
                                + ": ";

                        for (int c = 0; c < cantidad; c++) {
                            int posicion = (i + c) % 13;

                            resultado += NombreCarta.values()[posicion] + "-";
                            for (Carta carta : cartas) {
                                if (carta.getPinta().ordinal() == p && carta.getNombre().ordinal() == posicion) {
                                            cartasCombinadas[posicionCombinadas] = carta;
                                            posicionCombinadas++;
                                    
                                }
                            }
                        }

                        resultado += "\n";

                        i = siguiente;

                    } else {
                        i = (i + 1) % 13;
                    }

                } else {
                    i = (i + 1) % 13;
                }
            }
        }

        if (!hayEscaleras) {
            resultado = "No se encontraron escaleras";
        }

        return resultado;
    }

    public int getPuntaje() {

        int puntaje = 0;

        for (Carta carta : cartas) {

            boolean combinada = false;

            for (Carta cartaCombinada : cartasCombinadas) {

                if (carta == cartaCombinada) {
                    combinada = true;
                }
            }

            if (!combinada) {

                if (carta.getNombre() == NombreCarta.AS
                    || carta.getNombre() == NombreCarta.JACK
                    || carta.getNombre() == NombreCarta.QUEEN
                    || carta.getNombre() == NombreCarta.KING) {

                    puntaje += 10;

                } else {
                    puntaje += carta.getNombre().ordinal() + 1;
                }
            }
        }

        return puntaje;
}


}


