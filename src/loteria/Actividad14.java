/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loteria;

/**
 *
 * @author batoi
 */
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Actividad14 {

    public static void main(String[] args) {
        int[] combinacionGanadora = generarSorteo();
        int cantApuesta = pedirApuesta();
        calcularYMostrar(cantApuesta, combinacionGanadora);
    }

    public static int pedirApuesta() {
        Scanner teclado = new Scanner(System.in);
        int cantApuesta;
        do {
            System.out.print("¿Cuántas apuestas quieres realizar?: ");
            while (!teclado.hasNextInt()) {
                System.out.println("Apuestas incorrectas. Introdúcelas de nuevo.");
                teclado.next();
            }
            cantApuesta = teclado.nextInt();
            if (cantApuesta < 1 || cantApuesta > 8) {
                System.out.println("Número de apuestas incorrecto. Debe estar entre 1 y 8.");
            }
        } while (cantApuesta < 1 || cantApuesta > 8);
        return cantApuesta;
    }

public static void mostrarTotalAPagar(int numApuestas) {
    double totalPagar;
    if (numApuestas == 1) {
        totalPagar = 1.25;
    } else if (numApuestas <= 3) {
        totalPagar = numApuestas * 1.5;
    } else if (numApuestas <= 5) {
        totalPagar = numApuestas * 2;
    } else if (numApuestas <= 7) {
        totalPagar = 12;
    } else {
        totalPagar = 18;
    }

    String colorVerde = "\033[0;32m";
    String colorReset = "\033[0m";

    System.out.printf("\n---- Total a Pagar ----\n+----+----+----+----+----+\n| Apuestas: | %d | \n| A Pagar: |  %s%.2f€%s | \n+----+----+----+----+----+\n", numApuestas, colorVerde, totalPagar, colorReset);
}

    public static void calcularYMostrar(int cantApuesta, int[] sorteo) {
        int[] aciertos = new int[cantApuesta];
        for (int i = 0; i < cantApuesta; i++) {
            System.out.printf("\n----- Apuesta %d ----", i + 1);
            int[] apuesta = generarApuesta();
            aciertos[i] = obtenerNivelDeAcierto(sorteo, apuesta);
            mostrarCombinacion(apuesta);
        }
        mostrarTotalAPagar(cantApuesta);
        mostrarSorteo(sorteo);
        mostrarPremiosObtenidos(aciertos);
    }

    public static int[] generarApuesta() {
        int[] apuesta = new int[8];
        Random random = new Random();

        for (int i = 0; i < apuesta.length - 1; i++) {
            int numero;
            do {
                numero = random.nextInt(50) + 1;
            } while (Arrays.asList(apuesta).contains(numero));
            apuesta[i] = numero;
        }

        apuesta = ordenar(Arrays.copyOf(apuesta, apuesta.length - 1));

        apuesta[6] = random.nextInt(50) + 1;

        return apuesta;
    }

    public static void mostrarCombinacion(int[] combinacion) {
        System.out.println("\n+----+----+----+----+----+----+--C--+");
        for (int j = 0; j < combinacion.length; j++) {
            System.out.printf("| %d ", combinacion[j]);
        }
        System.out.print("|");
        System.out.println("\n+----+----+----+----+----+----+-----+");
    }

    public static int[] generarSorteo() {
        int[] sorteo = new int[8];
        Random random = new Random();

        for (int i = 0; i < sorteo.length - 1; i++) {
            int numero;
            do {
                numero = random.nextInt(50) + 1;
            } while (contieneNumero(sorteo, numero));
            sorteo[i] = numero;
        }

        sorteo = ordenar(Arrays.copyOf(sorteo, sorteo.length - 1));

        sorteo[6] = random.nextInt(50) + 1;

        return sorteo;
    }

    public static int[] ordenar(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int aux = array[i];
                    array[i] = array[j];
                    array[j] = aux;
                }
            }
        }
        return array;
    }
    public static void mostrarSorteo(int[] boleto) {
            System.out.println("\n--------- SIMULADOR DE SORTEO ---------");
            System.out.println("+----+----+----+----+----+----+--C--+");
            for (int i = 0; i < boleto.length; i++) {
            System.out.printf("| %d ", boleto[i]);
        }
        System.out.print("|");
        System.out.println("\n+----+----+----+----+----+----+-----+");
}

    public static boolean contieneNumero(int[] array, int numero) {
        for (int i : array) {
            if (i == numero) {
                return true;
            }
        }
        return false;
    }

    public static int obtenerNivelDeAcierto(int[] sorteo, int[] apuesta) {
        int aciertos = 0;

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (sorteo[i] == apuesta[j]) {
                    aciertos++;
                    break;
                }
            }
        }
        return aciertos;
    }

    public static boolean calcularComplementario(int[] sorteo, int complementario) {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (sorteo[i] == complementario) {
                    return true;
                }
            }
        }
        return false;
    }
    
public static int obtenerTotalPremio(int[] nivelesDeAcierto) {
    int totalPremio = 0;
    for (int i = 0; i < nivelesDeAcierto.length; i++) {
        switch (nivelesDeAcierto[i]) {
            case 7:
                totalPremio += 500000;
                break;
            case 6:
                totalPremio += 50000;
                break;
            case 5:
                totalPremio += 10000;
                break;
            case 4:
                totalPremio += 500;
                break;
            case 3:
                totalPremio += 50;
                break;
            default:
                System.out.println("Nivel no reconocido");
                break;
        }
    }
    return totalPremio;
}
    
public static int obtenerPremioIndividual(int nivelAcierto) {
    switch (nivelAcierto) {
        case 7:
            return 500000;
        case 6:
            return 50000;
        case 5:
            return 10000;
        case 4:
            return 500;
        case 3:
            return 50;
        default:
            return 0;
    }
}


public static void mostrarPremiosObtenidos(int[] nivelesDeAcierto) {
    System.out.println("\n---------- PREMIOS OBTENIDOS -----------");
    int premioTotal = 0;
    for (int i = 0; i < nivelesDeAcierto.length; i++) {
        int premio = obtenerPremioIndividual(nivelesDeAcierto[i]);
        premioTotal += premio;
        if (nivelesDeAcierto[i] == 1) {
            System.out.printf("Apuesta %d: %d acierto (%d €)\n", i + 1, nivelesDeAcierto[i], premio);
        } else {
            System.out.printf("Apuesta %d: %d aciertos (%d €)\n", i + 1, nivelesDeAcierto[i], premio);
        }
    }
    System.out.printf("\nTotal ganado: %d€\n", premioTotal);
}



}
