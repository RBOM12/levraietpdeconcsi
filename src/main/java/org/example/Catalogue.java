package org.example;

import java.util.ArrayList;

public class Catalogue {
    ArrayList<Marchand> marchands;

    public Catalogue() {
        this.marchands = new ArrayList<Marchand>();
    }

    public void addMarchand(Marchand marchand) {
        marchands.add(marchand);
    }

    public void removeMarchand(Marchand marchand) {
        marchands.remove(marchand);
    }

    public void getMarchands() {
        int i = 0;
        for (Marchand marchand : marchands) {
            System.out.println(i+" - "+marchand.getNom());
        }
    }




}
