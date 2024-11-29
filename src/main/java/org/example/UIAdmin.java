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
        System.out.println("5. Supprimer un client");
        System.out.println("6. Supprimer un marchand");
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
                    String nm2 = gUI.saisirString("Veuillez saisir le nom du client : ");
                    Client c = gC.recupunclient(nm2);
                    gC.modifcompte(c);


                    break;
                case 4:
                    System.out.println("Modif un marchand");
                    String nm3 = gUI.saisirString("Veuillez saisir le nom du marchand : ");
                    Marchand m = gC.recupunmarchand(nm3);
                    gC.modifcompte(m);
                    break;
                case 5:
                    String nm = gUI.saisirString("Veuillez saisir le nom du client : ");
                    supprimerClient(nm);
                    break;
                case 6:
                    String nm1 = gUI.saisirString("Veuillez saisir le nom du marchand : ");
                    supprimerMarchand(nm1);
                    break;
                case 7:
                    System.out.println("Deconnexion, à bientôt");
                    a.deconnexion();
                    break;
                default:
                    System.out.println("Choix invalide");
                    break;
            }
        }
    }
    public void supprimerMarchand(String m) {
            Marchand m1= gC.recupunmarchand(m);
            gC.supprimerCompte(m1);
    }
    public void supprimerClient(String m) {
            Client c = gC.recupunclient(m);
            gC.supprimerCompte(c);

    }
}
