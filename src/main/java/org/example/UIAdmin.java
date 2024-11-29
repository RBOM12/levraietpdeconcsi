package org.example;

public class UIAdmin {
    GestionUI gUI = new GestionUI();
    GestionCompte gC;
    public UIAdmin(GestionCompte gC) {
        this.gC = gC;
    }

    public void start(Administrateur a) throws Exception {
        System.out.println("Bienvenue " + a.getPseudo());
        System.out.println("------------------------------------------");
        System.out.println("1. Voir les marchands");
        System.out.println("2. Voir les clients");
        System.out.println("3. Modif un client");
        System.out.println("4. Modif un marchand");
        System.out.println("5. Se déconnecter");
        System.out.println("------------------------------------------");

        int choix = 0;
        while (choix != 5) {
            choix = gUI.saisirChoix();
            switch (choix) {
                case 1:
                    System.out.println("Voir les marchands");
                    gC.getmarchand();
                    break;
                case 2:
                    System.out.println("Voir les clients");
                    gC.getclients();
                    break;
                case 3:
                    System.out.println("Modif un client");
                    break;
                case 4:
                    System.out.println("Modif un marchand");
                    break;
                case 5:
                    System.out.println("Se déconnecter");
                    a.deconnexion();
                    break;
                default:
                    System.out.println("Choix invalide");
                    break;
            }
        }
    }
}
