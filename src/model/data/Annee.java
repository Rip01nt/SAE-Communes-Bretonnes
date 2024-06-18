package model.data;
import java.util.ArrayList;

/**
 * La classe Annee représente une année avec un taux d'inflation associé.
 */
public class Annee {

    /**
     * L'année.
     */
    private final int ANNEE;
    /**
     * Le taux d'inflation de cette Année.
     */
    private double tauxInflation;

    /**
     * Constructeur par défaut de la classe Annee.
     */
    public Annee() {
        this.ANNEE = 0;
        this.tauxInflation = 0;
    }

    /**
     * Constructeur avec paramètres de la classe Annee.
     * @param ANNEE l'année
     * @param tauxInflation le taux d'inflation pour l'année
     */
    public Annee(int ANNEE, double tauxInflation) {
        this.ANNEE = ANNEE;
        this.tauxInflation = tauxInflation;
    }

    /**
     * Obtient l'année.
     * @return l'année
     */
    public int getANNEE() {
        return this.ANNEE;
    }

    /**
     * Obtient le taux d'inflation de l'année.
     * @return le taux d'inflation de l'année
     */
    public double getTauxInflation() {
        return this.tauxInflation;
    }

    /**
     * Définit le taux d'inflation de l'année.
     * @param tauxInflation le nouveau taux d'inflation
     */
    public void setTauxInflation(double tauxInflation) {
        this.tauxInflation = tauxInflation;
    }

    /**
     * Calcule la moyenne des taux d'inflation d'une liste d'années.
     * @param annee la liste des années
     * @return la moyenne des taux d'inflation
     * @throws NullPointerException si la liste des années est nulle
     */
    public static double moyenneTauxInflation(ArrayList<Annee> annee) throws NullPointerException {
        if (annee == null) throw new NullPointerException("Le paramètre ne peut pas être nul");
        double ret = 0;
        for (Annee a : annee) {
            ret += a.getTauxInflation();
        }
        ret = ret / annee.size();
        return ret;
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères de l'année.
     * @return une chaîne de caractères représentant l'année
     */
    public String toString() {
        return "Année : " + this.ANNEE + "\nTaux inflation : " + this.tauxInflation;
    }
}
