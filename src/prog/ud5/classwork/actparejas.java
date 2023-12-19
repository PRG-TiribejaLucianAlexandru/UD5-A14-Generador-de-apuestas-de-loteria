/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud5.classwork;

/**
 *
 * @author batoi
 */
public class actparejas {
    public static void main(String[] args) {
        int[] arrayA = {10, 20, 30, 40, 50};
        int[] arrayB = {60, 70, 80, 90, 100};
        
        int suma = arrayA[3] + arrayB[4];
        
        int[] arrayC = new int[5];
        arrayC[1] = suma + arrayA[0];
        
        int multiplicacion = 1;
        for (int i = 0; i < arrayA.length; i++) {
            multiplicacion *= arrayA[i];
            arrayC[2] += arrayA[i];
        }
        arrayC[0] = multiplicacion;
        
        arrayC[3] = arrayB[0] / arrayC[0];
        arrayC[4] = Math.max(arrayB[0], arrayA[arrayA.length - 1]);

        System.out.println("Array A: ");
        visualizarArrayFor(arrayA);
        System.out.println("Array B: ");
        visualizarArrayFor(arrayB);
        System.out.println("Array C: ");
        visualizarArrayFor(arrayC);
        
        if (arrayA.length >= 6) {
            System.out.println("Sexto valor de arrayA: " + arrayA[5]);
        } else {
            System.out.println("La longitud del arrayA no es suficiente para acceder al sexto valor.");
        }

        arrayA = new int[]{10, 20, 30, 40, 50, 60};
        System.out.println("Sexto valor de arrayA: " + arrayA[5]);

        System.out.println("\nActividades adicionales:");
        System.out.println("Visualizar arrayA con for:");
        visualizarArrayFor(arrayA);
        System.out.println("Visualizar arrayB con foreach:");
        visualizarArrayForEach(arrayB);
        System.out.println("Visualizar extremos de arrayC:");
        visualizarExtremos(arrayC);
        System.out.println("Obtener copia de arrayA:");
        int[] copiaArrayA = obtenerCopia(arrayA);
        visualizarArrayFor(copiaArrayA);
        System.out.println("Visualizar múltiplos de 3 en arrayC:");
        visualizarMultiplos(arrayC, 3);
        System.out.println("Visualizar máximo de arrayA:");
        visualizarMaximo(arrayA);
        System.out.println("Visualizar mínimo de arrayB:");
        visualizarMinimo(arrayB);
    }

    public static void visualizarArrayFor(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void visualizarArrayForEach(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void visualizarExtremos(int[] array) {
        System.out.println("Primer elemento: " + array[0]);
        System.out.println("Último elemento: " + array[array.length - 1]);
    }

    public static int[] obtenerCopia(int[] array) {
        int[] copia = new int[array.length];
        System.arraycopy(array, 0, copia, 0, array.length);
        return copia;
    }

    public static void visualizarMultiplos(int[] array, int divisor) {
        System.out.print("Múltiplos de " + divisor + ": ");
        for (int value : array) {
            if (value % divisor == 0) {
                System.out.print(value + " ");
            }
        }
        System.out.println();
    }

    public static void visualizarMaximo(int[] array) {
        int maximo = array[0];
        for (int value : array) {
            if (value > maximo) {
                maximo = value;
            }
        }
        System.out.println("Máximo: " + maximo);
    }

    public static void visualizarMinimo(int[] array) {
        int minimo = array[0];
        for (int value : array) {
            if (value < minimo) {
                minimo = value;
            }
        }
        System.out.println("Mínimo: " + minimo);
    }
}
