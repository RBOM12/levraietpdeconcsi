package org.example;

import java.util.Scanner;

public class GestionUI {

    public int saisirChoix() {
        System.out.println("Veuillez saisir votre choix : ");
        int choix = 0;
        Scanner sc = new Scanner(System.in);
        try {
            choix = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Veuillez saisir un nombre");
        }
        return choix;
    }

    public String saisirString(String message) {
        System.out.println(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    Float saisirFloat(String message) {
        System.out.println(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextFloat();
    }

    int saisirInt(String message) {
        System.out.println(message);
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }


    public boolean estMarchand(){
        while (true){
            System.out.println("Etes-vous un marchand ? (O/N)");
            Scanner sc = new Scanner(System.in);
            String reponse = sc.nextLine();
            if (reponse.equals("O")){
                return true;
            } else if (reponse.equals("N")){
                return false;
            } else {
                System.out.println("Réponse invalide");
            }
        }
    }

}
