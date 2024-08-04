package Utils;

import java.io.IOException;
import java.util.Scanner;

public class Lib {

    private static Scanner scan = new Scanner(System.in);

    public static void startUTF() {
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            // Windows
            try {
                ProcessBuilder builder = new ProcessBuilder("powershell.exe", "[Console]::OutputEncoding = [System.Text.Encoding]::UTF8");
                builder.inheritIO().start().waitFor();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            // Linux y macOS
            try {
                ProcessBuilder builder = new ProcessBuilder("bash", "-c", "export LANG=en_US.UTF-8");
                builder.inheritIO().start().waitFor();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Lee y valida entrada de un numero entero
    public static int getInt(String msg) {
        int num;
        do {
            System.out.print(msg);
            try {
                num = Integer.parseInt(scan.nextLine());
                return num;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        } while (true);
    }

    // Lee y valida entrada de un numero double
    public static double getDouble(String msg) {
        double num;
        do {
            System.out.print(msg);
            try {
                num = Double.parseDouble(scan.nextLine());
                return num;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        } while (true);
    }

    // Imprime mensaje y pide string
    public static String getString(String msg) {
        System.out.print(msg);
        return scan.nextLine();
    }

    // Pausa ejecucion hasta que se presione enter
    public static void pause() {
        System.out.print("Presione enter para continuar...");
        scan.nextLine();
    }

    // Limpia consola
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Cerrar scanner
    public static void closeScan() {
        if (scan != null) {
            scan.close();
        }
    }
}
