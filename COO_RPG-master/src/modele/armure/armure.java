package modele.armure;

import modele.objet;

public class armure extends objet {

    private int valeurDefense;

    private String type;

    public armure(String nom, int valeurDefense, String type) {
        super(nom);
        this.valeurDefense = valeurDefense;
        this.type = type;
    }

    public int getValeurDefense() {
        return valeurDefense;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
