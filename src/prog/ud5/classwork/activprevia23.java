/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud5.classwork;

/**
 *
 * @author batoi
 */
public class activprevia23 {
    
    public static String[] copiaArray(String[] original) {
        String[] copia = new String[original.length];
        for (int i = 0; i < original.length; i++) {
            copia[i] = original[i];
        }
        return copia;
    }

    public static void main(String[] args) {
        String[] diesDeLaSetmana = {"dilluns", "dimarts", "dimecres", "dijous", "divendres", "dissabte", "diumenge"};

        String[] diesDeLaSemana2 = copiaArray(diesDeLaSetmana);

        diesDeLaSemana2[0] = "Monday";
        
        System.out.println("diesDeLaSetmana[0]: " + diesDeLaSetmana[0]);
        System.out.println("diesDeLaSemana2[0]: " + diesDeLaSemana2[0] + "\n");


        String[] diesDeLaSemana3 = copiaArray(diesDeLaSemana2);

        diesDeLaSemana3[0] = "Dilluns";

        System.out.println("diesDeLaSetmana[0]: " + diesDeLaSetmana[0]);
        System.out.println("diesDeLaSemana2[0]: " + diesDeLaSemana2[0]);
        System.out.println("diesDeLaSemana3[0]: " + diesDeLaSemana3[0]);
    }
}
