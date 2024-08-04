package program.ahorcado;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.List;

/**
 * Juego del ahorcado
 **/

public class Ahorcado {
    private static Random rand = new Random(); // Instancia de random
    public static Scanner scan = new Scanner(System.in); // Instancia de scanner

    // Limpiar consola
    public static void clear() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Pausar
    public static void pause() {
        System.out.print("Presiona enter para continuar...");
        scan.nextLine();
        scan.nextLine();
    }

    // Genera un numero aleatorio en un rango dado
    public static int genNumAleatorio(int ri, int rf) {
        return rand.nextInt(rf - ri + 1) + ri;
    }

    // Genera una palabra aleatoria de un arreglo de strings
    public static String genWord() {
        String[] palabras = { "computadora", "programacion", "java", "algoritmo", "openai",
                "python", "manzana", "lenguaje", "django", "spring" };
        return palabras[genNumAleatorio(0, palabras.length - 1)];
    }

    public static void main(String[] args) {
        boolean jugarDeNuevo = true;

        /*------ Bucle principal ------*/
        while (jugarDeNuevo) {
            clear();
            String palabraSecreta = genWord();
            int longitudPalabra = palabraSecreta.length(); // Longitud para usarla mas adelante

            char[] letrasAcertadas = new char[longitudPalabra]; // Almacena los subguiones / letras adivinadas
            List<Character> letrasUsadas = new ArrayList<>(); // Almacena las letras ya usadas, para no repetir

            // Banderas
            boolean adivinoPalabra = false;
            boolean letraCorrecta;

            // Contadores
            int intentos = 6;

            // Se llena el arreglo con subguiones
            for (int i = 0; i < longitudPalabra; i++) {
                letrasAcertadas[i] = '_';
            }

            /*------ Bucle de la partida ------*/
            while (intentos > 0 && !adivinoPalabra) {
                letraCorrecta = false; // Reinicio en cada intento

                // Se imprime el estado actual de la palabra
                System.out.print("* Palabra Secreta " + "(" + longitudPalabra + " Letras): ");
                System.out.println(String.valueOf(letrasAcertadas));

                // Entrada del usuario
                System.out.print("> Introduce una letra: ");
                char letra = scan.next().charAt(0);
                System.out.println();

                // Compara y busca ocurrencia de la letra ingresada, en la palabra secreta
                for (int i = 0; i < longitudPalabra; i++) {

                    if (palabraSecreta.charAt(i) == letra) {
                        // Si la letra no se a usado, la toma
                        if (!(letrasUsadas.contains(letra))) {
                            letrasAcertadas[i] = letra;
                            letraCorrecta = true;
                        }
                    }
                }

                if (letraCorrecta) {
                    letrasUsadas.add(letra);
                } else {
                    intentos--;

                    if (intentos > 0) {
                        System.out.println("* Has fallado, te quedan : " + intentos + " intentos *");
                        System.out.println();
                        pause();
                    }
                }

                if (String.valueOf(letrasAcertadas).equals(palabraSecreta)) {
                    adivinoPalabra = true;
                }

                clear();
            }

            // Evaluacion de resultados
            if (adivinoPalabra) {
                System.out.println("> Has ganado !, has adivinado la palabra, con " + intentos + " intentos restantes");
            } else {
                System.out.println("* Has perdido, te has quedado sin intentos *");
                System.out.println("* La palabra secreta era: '" + palabraSecreta + "' *");
            }

            // Entrada volver a jugar
            char volverAjugar = ' ';
            do {
                System.out.print("\n> Deseas jugar de nuevo? (s/n): ");
                volverAjugar = Character.toLowerCase(scan.next().charAt(0));
            } while (volverAjugar != 's' || volverAjugar != 'n');

            jugarDeNuevo = volverAjugar == 's';
            clear();
        }
        scan.close();
    }
}
