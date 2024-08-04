package program.ahorcado;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.SwingUtilities;

/**
 * @author frank
 */
public final class Ahorcado {

    private static final Random rand = new Random();
    private static final String[][] PALABRAS = {
        {"COMPUTADORA", "Tecnologia"}, {"PROGRAMACION", "Tecnologia"}, {"ALGORITMO", "Tecnologia"},
        {"CELULAR", "Tecnologia"}, {"MEXICO", "Pais"}, {"VENEZUELA", "Pais"}, {"ARGENTINA", "Pais"},
        {"PERU", "Pais"}, {"MANZANA", "Fruta"}, {"PERA", "Fruta"}, {"PLATANO", "Fruta"},
        {"MANGO", "Fruta"}, {"PERRO", "Animal"}, {"CABALLO", "Animal"}, {"SERPIENTE", "Animal"},
        {"PEZ", "Animal"}
    };

    private String[] palabraSecreta; // Palabra a adivinar
    private char[] letrasAcertadas; // Arreglo para las letras adivinadas
    private List<Character> letrasUsadas; // Lista con letras usadas
    private int intentos; // Contador de intentos
    private int MAX_INTENTOS = 6; // Maximos Intentos
    private boolean adivinoPalabra; // Bandera de victoria
    private int longitudPalabra; // Longitud de la palabra secreta

    // Constructor
    public Ahorcado() {
        iniciarJuego();
    }

    // Inicializa elementos del juego
    public void iniciarJuego() {
        palabraSecreta = genWord();
        longitudPalabra = palabraSecreta[0].length();

        letrasAcertadas = new char[longitudPalabra];

        for (int i = 0; i < longitudPalabra; i++) {
            letrasAcertadas[i] = '_';
        }
        letrasUsadas = new ArrayList<>();
        intentos = MAX_INTENTOS;
        adivinoPalabra = false;
    }

    // Genera una palabra aleatoria
    private String[] genWord() {
        return PALABRAS[rand.nextInt(PALABRAS.length)];
    }

    // Procesa la letra ingresada
    public void procesarLetra(char letra) {

        // Si la letra ingresada ya se utilizo, la ignora
        if (letrasUsadas.contains(letra)) {
            return;
        }

        boolean letraCorrecta = false;

        // Verifica si la letra ingresada, esta en la palabra secreta
        for (int i = 0; i < longitudPalabra; i++) {
            if (palabraSecreta[0].charAt(i) == letra) {
                letrasAcertadas[i] = letra;
                letraCorrecta = true;
            }
        }

        letrasUsadas.add(letra); // Agrega la letra ingresada a la lista de letras utilizadas

        if (!letraCorrecta) {
            intentos--;
        }

        // Compara la palabra secreta con la adivinada
        if (new String(letrasAcertadas).equals(palabraSecreta[0])) {
            adivinoPalabra = true;
        }

    }

    // Getters
    public boolean haGanado() {
        return adivinoPalabra;
    }

    public boolean haPerdido() {
        return intentos == 0;
    }

    public String getPalabraSecreta() {
        return palabraSecreta[0];
    }

    public String getPista() {
        return palabraSecreta[1];
    }

    public char[] getLetrasAcertadas() {
        return letrasAcertadas;
    }

    public int getIntentosRestantes() {
        return intentos;
    }

    public List<Character> getLetrasUsadas() {
        return letrasUsadas;
    }

    public int getMaxIntentos() {
        return MAX_INTENTOS;
    }

    // Main
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GuiAhorcado().setVisible(true);
            }
        });
    }
}
