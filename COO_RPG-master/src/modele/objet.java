package modele;

public abstract class objet {

    private String nom;


    public objet(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    // Ajoutez d'autres méthodes ou propriétés communes à tous les objets
}

