import java.util.Random;

/**
 * Representa un mazo de cartas para un juego.
 * La baraja se organiza como una matriz de copias disponibles por pinta y nombre
 * de carta. Cada combinación tiene un número de unidades restantes, y se reduce
 * cada vez que se reparte una carta.
 */
public class Baraja {

    /**
     * Número de copias de cada carta que contiene la baraja.
     */
    private final int cantidadBarajas;

    /**
     * Matriz que almacena cuántas copias quedan de cada carta.
     * El índice [pinta][nombre] representa la cantidad disponible de una carta
     * específica dentro del mazo.
     */
    private int[][] disponibles;

    private Random random;

    /**
     * Crea una nueva baraja con la cantidad indicada de copias por carta.
     * @param cantidadBarajas número de veces que se repite cada carta dentro del mazo
     */
    public Baraja(int cantidadBarajas) {
        this.cantidadBarajas = cantidadBarajas;
        this.random = new Random();
        this.disponibles = new int[Pinta.values().length][NombreCarta.values().length];
        barajar();
    }

    /**
     * Reinicia el mazo y deja disponibles todas las cartas.
     */
    public void barajar() {
        for (int pinta = 0; pinta < disponibles.length; pinta++) {
            for (int nombre = 0; nombre < disponibles[pinta].length; nombre++) {
                disponibles[pinta][nombre] = cantidadBarajas;
            }
        }
    }

    /**
     * Reparte una carta aleatoria que aún tenga copias disponibles.
     * No se cubre el caso si el mazo se agotó y no existe ninguna carta disponible
     */
    public Carta repartirCarta() {
        int indicePinta;
        int indiceNombre;

        // Sortea combinaciones hasta encontrar una que todavía tenga copias disponibles
        do {
            indicePinta = random.nextInt(Pinta.values().length);
            indiceNombre = random.nextInt(NombreCarta.values().length);
        } while (disponibles[indicePinta][indiceNombre] <= 0);

        disponibles[indicePinta][indiceNombre]--;

        Pinta pinta = Pinta.values()[indicePinta];
        NombreCarta nombre = NombreCarta.values()[indiceNombre];

        return new Carta(pinta, nombre);
    }
}