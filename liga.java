package com.fer.liga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class liga {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la etapa (octavos, cuartos, semifinales, final): ");
        String etapa = scanner.nextLine().toLowerCase();

        if (!etapa.equals("octavos") && !etapa.equals("cuartos") && !etapa.equals("semifinales") && !etapa.equals("final")) {
            System.out.println("Etapa no válida. Por favor, ingrese una etapa válida.");
            scanner.close();
            return;
        }

        List<String> equipos = new ArrayList<>();


        switch (etapa) {
            case "octavos":
                System.out.println("Ingrese los 16 equipos para octavos de final:");
                for (int i = 0; i < 16; i++) {
                    System.out.print("Equipo " + (i + 1) + ": ");
                    equipos.add(scanner.nextLine());
                }
                break;
            case "cuartos":
                System.out.println("Ingrese los 8 equipos para cuartos de final:");
                for (int i = 0; i < 8; i++) {
                    System.out.print("Equipo " + (i + 1) + ": ");
                    equipos.add(scanner.nextLine());
                }
                break;
            case "semifinales":
                System.out.println("Ingrese los 4 equipos para semifinales:");
                for (int i = 0; i < 4; i++) {
                    System.out.print("Equipo " + (i + 1) + ": ");
                    equipos.add(scanner.nextLine());
                }
                break;
            case "final":
                System.out.println("Ingrese los 2 equipos para la final:");
                for (int i = 0; i < 2; i++) {
                    System.out.print("Equipo " + (i + 1) + ": ");
                    equipos.add(scanner.nextLine());
                }
                break;
        }

        sorteo(equipos, etapa);
        scanner.close();
    }


    public static void sorteo(List<String> equipos, String etapa) {
        if (equipos.size() == 2) {
            System.out.println("Final: " + equipos.get(0) + " vs " + equipos.get(1));
            return;
        }

        System.out.println("Partidos de " + etapa + ":");

        Collections.shuffle(equipos);

        for (int i = 0; i < equipos.size(); i += 2) {
            System.out.println(equipos.get(i) + " vs " + equipos.get(i + 1));
        }

        List<String> equiposGanadores = new ArrayList<>();
        for (int i = 0; i < equipos.size(); i += 2)
        {
            equiposGanadores.add(equipos.get(i));
        }

        String siguienteEtapa = obtenerSiguienteEtapa(etapa);

        if (siguienteEtapa != null) {
            sorteo(equiposGanadores, siguienteEtapa);
        }
    }


    public static String obtenerSiguienteEtapa(String etapa) {
        switch (etapa) {
            case "octavos":
                return "cuartos";
            case "cuartos":
                return "semifinales";
            case "semifinales":
                return "final";
            default:
                return null;
        }
    }
}
