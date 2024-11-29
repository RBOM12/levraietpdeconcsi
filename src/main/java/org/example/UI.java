package org.example;

import java.util.Scanner;

public class UI {
    Compte c;
    GestionUI gUI = new GestionUI();
    GestionCompte gC = new GestionCompte();
    UIAdmin uia = new UIAdmin(gC);
    UIClient uic = new UIClient(gC);
    UIMarchand uim = new UIMarchand();

    public UI() throws Exception {
        System.out.println("Bienvenue sur notre site de vente en ligne");
        System.out.println("------------------------------------------");
        System.out.println("1. Se connecter");
        System.out.println("2. S'inscrire");
        System.out.println("3. Voir catalogue");
        System.out.println("4. Quitter");
        System.out.println("------------------------------------------");
        gC.initialise();
        int choix ;
            choix = gUI.saisirChoix();
        String pseudo ;
        String mdp;
            switch (choix) {
                case 1:
                    pseudo = gUI.saisirString("Veuillez saisir votre pseudo : ");
                    mdp = gUI.saisirString("Veuillez saisir votre mot de passe : ");

                    this.c = gC.getCompte(pseudo, mdp);
                    if (this.c instanceof Marchand) {
                        uim.start((Marchand) this.c);
                    } else if (this.c instanceof Administrateur) {
                        uia.start((Administrateur) this.c);
                    }else {
                        uic.start((Client) this.c);
                    }

                    break;
                case 2:
                    String nom = gUI.saisirString("Veuillez saisir votre nom : ");
                    String prenom = gUI.saisirString("Veuillez saisir votre prénom : ");
                    String adresse = gUI.saisirString("Veuillez saisir votre adresse : ");
                    pseudo = gUI.saisirString("Veuillez saisir votre pseudo : ");

                    mdp = gUI.saisirString("Veuillez saisir votre mot de passe : ");
                    this.c=new Utilisateur().inscription( nom, prenom, adresse, pseudo, mdp, gUI.estMarchand());
                    this.c = gC.getCompte(pseudo, mdp);
                    if (this.c instanceof Marchand) {
                        uim.start((Marchand) this.c);
                    } else if (this.c instanceof Administrateur) {
                        uia.start((Administrateur) this.c);
                    }else {
                        uic.start((Client) this.c);
                    }
                case 3:
                    System.out.println("Afficher Marchands");

                    break;
                case 4:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide");
                    break;
            }
    }








}
