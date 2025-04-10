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

    public static boolean validarDimensiones(int filas, int columnas) {
        if (filas <= 0 || columnas <= 0) {
            System.out.println("Las dimensiones deben ser mayores que cero");
            return false;
        }
        return true;
    }

    public static int[][] crearMatriz(int filas, int columnas) {
        return new int[filas][columnas];
    }

    public static void llenarMatriz(int[][] matriz) {
        Random rand = new Random();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = rand.nextInt(10);
            }
        }
        System.out.println("Matriz creada");
    }

    public static void mostrarFila(int[][] matriz, int fila) {
        if (fila < 0 || fila >= matriz.length) {
            System.out.println("Numero de fila no valido.");
            return;
        }

        System.out.print("Fila " + fila + ": ");
        for (int j = 0; j < matriz[fila].length; j++) {
            System.out.print(matriz[fila][j] + " ");
        }
        System.out.println();
    }

    public static boolean esMatrizCero(int[][] matriz) {
        int totalElementos = matriz.length * matriz[0].length;
        int contadorCeros = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == 0) {
                    contadorCeros++;
                }
            }
        }

        return contadorCeros > totalElementos / 2;
    }

    public static void menuPrincipal(int[][] matriz) {
        int opcion;
        do {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Mostrar una fila");
            System.out.println("2. Verificar si es matriz cero");
            System.out.println("3. Salir");
            System.out.print("Elija una opción (1-3): ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el numero de fila a mostrar (0 - " + (matriz.length-1) + "): ");
                    int fila = scanner.nextInt();
                    mostrarFila(matriz, fila);
                    break;
                case 2:
                    if (esMatrizCero(matriz)) {
                        System.out.println("La matriz ES de tipo cero");
                    } else {
                        System.out.println("La matriz NO ES de tipo cero");
                    }
                    break;
                case 3:
                    System.out.println("Saliendo del menu");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 3);
    }
}