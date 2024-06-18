package model.data;

import exception.*;

/**
 * Représente une gare avec sa commune, son code, son nom, et ce qu'elle fait.
 */
public class Gare {

    /**
     * La commune de la gare.
     */
    private Commune laCommune;

    /**
     * Le code de la gare.
     */
    private int codeGare;

    /**
     * Le nom de la gare.
     */
    private String nomGare;

    /**
     * Indique si la gare prend en charge le transport de fret.
     */
    private boolean estFret;

    /**
     * Indique si la gare prend en charge le transport de voyageurs.
     */
    private boolean estVoyageur;

    /**
     * Constructeur par défaut de la classe Gare.
     */
    public Gare() {
        this.laCommune = new Commune();
        this.codeGare = 0;
        this.nomGare = "";
        this.estFret = false;
        this.estVoyageur = false;
    }

    /**
     * Constructeur avec paramètres de la classe Gare.
     * @param laCommune la commune où est située la gare
     * @param codeGare le code unique attribué à la gare
     * @param nomGare le nom de la gare
     * @param estFret indique si la gare prend en charge le transport de fret
     * @param estVoyageur indique si la gare prend en charge le transport de voyageurs
     * @throws InvalidAttributException si les attributs passés en paramètres sont invalides
     */
    public Gare(Commune laCommune, int codeGare, String nomGare, boolean estFret, boolean estVoyageur) throws InvalidAttributException {
        if (laCommune == null || codeGare <= 0 || nomGare == null) throw new InvalidAttributException("The Attributs are invalid ");
        this.laCommune = laCommune;
        this.codeGare = codeGare;
        this.nomGare = nomGare;
        this.estFret = estFret;
        this.estVoyageur = estVoyageur;
        
    }

    /**
     * Obtient la commune où est située la gare.
     * @return la commune de la gare
     */
    public Commune getLaCommune() {
        return this.laCommune;
    }

    /**
     * Définit la commune où est située la gare.
     * @param laCommune la commune de la gare
     * @throws InvalidAttributException si la commune est nulle
     */
    public void setLaCommune(Commune laCommune) throws InvalidAttributException{
        if (laCommune == null)throw new InvalidAttributException("Attribut laCommune cannot be null");
        this.laCommune = laCommune;
    }

    /**
     * Obtient le code unique attribué à la gare.
     * @return le code de la gare
     */
    public int getCodeGare() {
        return this.codeGare;
    }

    /**
     * Définit le code unique attribué à la gare.
     * @param codeGare le code de la gare
     * @throws InvalidAttributException si le code de la gare est inférieur ou égal à zéro
     */
    public void setCodeGare(int codeGare) throws InvalidAttributException{
        if (codeGare <= 0)throw new InvalidAttributException("Attribut codeGare cannot be lesser than 0");
        this.codeGare = codeGare;
    }

    /**
     * Obtient le nom de la gare.
     * @return le nom de la gare
     */
    public String getNomGare() {
        return this.nomGare;
    }

    /**
     * Définit le nom de la gare.
     * @param nomGare le nom de la gare
     * @throws InvalidAttributException si le nom de la gare est nul
     */
    public void setNomGare(String nomGare) throws InvalidAttributException{
        if (nomGare == null) throw new InvalidAttributException("Attribut nomGare cannot be null");
        this.nomGare = nomGare;
    }

    /**
     * Indique si la gare prend en charge le transport de fret.
     * @return true si la gare est dédiée au fret, sinon false
     */
    public boolean getEstFret() {
        return this.estFret;
    }

    /**
     * Définit si la gare prend en charge le transport de fret.
     * @param estFret true si la gare est dédiée au fret, sinon false
     */
    public void setEstFret(boolean estFret) {
        this.estFret = estFret;
    }

    /**
     * Indique si la gare prend en charge le transport de voyageurs.
     * @return true si la gare est dédiée aux voyageurs, sinon false
     */
    public boolean getEstVoyageur() {
        return this.estVoyageur;
    }

    /**
     * Définit si la gare prend en charge le transport de voyageurs.
     * @param estVoyageur true si la gare est dédiée aux voyageurs, sinon false
     */
    public void setEstVoyageur(boolean estVoyageur) {
        this.estVoyageur = estVoyageur;
    }

    /**
     * Vérifie si la gare est à la fois pour le fret et pour les voyageurs.
     * @return true si la gare est à la fois pour le fret et pour les voyageurs, sinon false
     */
    public boolean estFerroviaire() {
        return this.estFret && this.estVoyageur;
    }

    /**
     * Retourne une représentation textuelle de la gare.
     * @return une chaîne de caractères représentant la gare
     */
    public String toString(){
        return "Nom : " + this.nomGare + "\nCode Gare : " + this.codeGare + "\nCommune : " + this.laCommune.getNomCommune() + "\nFret : " + this.estFret + "\nVoyageur : " + this.estVoyageur;
    }
}
