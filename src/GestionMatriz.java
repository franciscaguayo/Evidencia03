import java.util.Scanner;
import java.util.Random;

public class GestionMatriz {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Programa de Gestion de Matrices");

        int filas, columnas;
        do {
            System.out.print("Ingrese numero de filas (mayor que 0): ");
            filas = scanner.nextInt();
            System.out.print("Ingrese numero de columnas (mayor que 0): ");
            columnas = scanner.nextInt();
        } while (!validarDimensiones(filas, columnas));
        int[][] matriz = crearMatriz(filas, columnas);

        llenarMatriz(matriz);

        menuPrincipal(matriz);

        System.out.println("Fin del programa");
    }
}