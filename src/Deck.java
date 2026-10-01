import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    ArrayList<Card> cartas;

    public Deck() {
        // Constructor que crea las 52 cartas

        cartas = new ArrayList<>();

        String[] palos = {"Tréboles", "Corazones", "Picas", "Diamantes"};
        String[] valores = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        for (String palo : palos) {
            String color;

            if (palo.equals("Corazones") || palo.equals("Diamantes")) {
                color = "Rojo";
            } else {
                color = "Negro";
            }

            for (String valor : valores) {
                cartas.add(new Card(palo, color, valor));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cartas);
        System.out.println("Se mezcló el Deck.");
    }
    public Card head() {
        Card carta = cartas.remove(0);

        System.out.println("Carta: " + carta.valor + " de " + carta.palo);
        System.out.println("Quedan " + cartas.size() + " cartas.");

        return carta;
    }
    public Card pick() {
        int posicion = (int) (Math.random() * cartas.size());

        Card carta = cartas.remove(posicion);

        System.out.println("Carta: " + carta.valor + " de " + carta.palo);
        System.out.println("Quedan " + cartas.size() + " cartas.");

        return carta;
    }
    public ArrayList<Card> hand() {
        ArrayList<Card> mano = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int posicion = (int) (Math.random() * cartas.size());
            Card carta = cartas.remove(posicion);

            mano.add(carta);

            System.out.println("Carta: " + carta.valor + " de " + carta.palo);
        }

        System.out.println("Quedan " + cartas.size() + " cartas.");

        return mano;
    }
} 