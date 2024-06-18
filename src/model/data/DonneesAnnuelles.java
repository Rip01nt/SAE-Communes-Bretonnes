package model.data;

import java.util.ArrayList;
import java.lang.Comparable;
import exception.*;

public class DonneesAnnuelles implements Comparable<DonneesAnnuelles> {

    /**
     * L'année de la donnée 
     */
    private Annee lAnnee;
    /**
     * La commune de la donnée 
     */
    private Commune laCommune;
    /**
     * Le nombre de maison vendu pendant cette année dans cette commune 
     */
    private int nbMaison;
    /**
     * Le nombre d'appartement vendu pendant cette année dans cette commune 
     */
    private int nbAppart;
    /**
     * Le prix Moyen du logement de cette année pour cette commune 
     */
    private double prixMoyen;
    /**
     * le prix moyens du mettre carré pour cette donnée 
     */
    private double prixM2Moyen;
    /**
     * La surface moyenne des logement de cette donnée 
     */
    private double surfaceMoy;
    /**
     * Les dépenses culturelles total pour cette donnée
     */
    private double depensesCultutrellesTotales;
    /**
     * le budget total de la commune pour cette année 
     */
    private double budgetTotal;
    /**
     * La population de la commune a cette année 
     */
    private int population;

    /**
     * Constructeur par défaut de la classe DonneesAnnuelles.
     */
    public DonneesAnnuelles() {
        this.lAnnee = new Annee();
        this.laCommune = new Commune();
        this.nbMaison = 0;
        this.nbAppart = 0;
        this.prixMoyen = 0;
        this.prixM2Moyen = 0;
        this.surfaceMoy = 0;
        this.depensesCultutrellesTotales = 0;
        this.budgetTotal = 0;
        this.population = 0;
    }

    /**
     * Constructeur avec paramètres de la classe DonneesAnnuelles.
     * @param lAnnee l'année des données
     * @param laCommune la commune associée aux données
     * @param nbMaison le nombre de maisons vendues
     * @param nbAppart le nombre d'appartements vendus
     * @param prixMoyen le prix moyen des logements
     * @param prixM2Moyen le prix moyen par mètre carré
     * @param surfaceMoy la surface moyenne des logements
     * @param depensesCultutrellesTotales les dépenses culturelles totales
     * @param budgetTotal le budget total de la commune
     * @param population la population de la commune
     * @throws InvalidAttributException si un attribut est invalide (null ou négatif)
     */
    public DonneesAnnuelles(Annee lAnnee, Commune laCommune, int nbMaison, int nbAppart, double prixMoyen, double prixM2Moyen, double surfaceMoy, double depensesCultutrellesTotales, double budgetTotal, int population) throws InvalidAttributException{

        if (lAnnee == null || laCommune == null || nbMaison <= 0 || nbAppart <= 0 || prixMoyen <= 0 || prixM2Moyen <= 0 || surfaceMoy <= 0 || depensesCultutrellesTotales <= 0 || budgetTotal <= 0 || population <= 0) throw new InvalidAttributException("The Attributs are invalid");
        this.lAnnee = lAnnee;
        this.laCommune = laCommune;
        this.nbMaison = nbMaison;
        this.nbAppart = nbAppart;
        this.prixMoyen = prixMoyen;
        this.prixM2Moyen = prixM2Moyen;
        this.surfaceMoy = surfaceMoy;
        this.depensesCultutrellesTotales = depensesCultutrellesTotales;
        this.budgetTotal = budgetTotal;
        this.population = population;
    }

    /**
     * Obtient l'année de la donnée.
     * @return l'année de la donnée
     */
    public Annee getLAnnee() {
        return this.lAnnee;
    }

    /**
     * Définit l'année de la donnée.
     * @param lAnnee l'année de la donnée
     * @throws InvalidAttributException si l'année est null
     */
    public void setLAnnee(Annee lAnnee) throws InvalidAttributException {
        if (lAnnee == null) throw new InvalidAttributException("Attribut cannot be null");
        this.lAnnee = lAnnee;
    }

    /**
     * Obtient la commune de la donnée.
     * @return la commune de la donnée
     */
    public Commune getLaCommune() {
        return this.laCommune;
    }

    /**
     * Définit la commune de la donnée.
     * @param laCommune la commune de la donnée
     * @throws InvalidAttributException si la commune est null
     */
    public void setLaCommune(Commune laCommune) throws InvalidAttributException{
        if (laCommune == null) throw new InvalidAttributException("Attribut cannto be null");
        this.laCommune = laCommune;
    }

    /**
     * Obtient le nombre de maisons vendues pendant cette année dans cette commune.
     * @return le nombre de maisons vendues
     */
    public int getNbMaison() {
        return this.nbMaison;
    }

    /**
     * Définit le nombre de maisons vendues pendant cette année dans cette commune.
     * @param nbMaison le nombre de maisons vendues
     * @throws InvalidAttributException si le nombre de maisons est inférieur ou égal à zéro
     */
    public void setNbMaison(int nbMaison) throws InvalidAttributException {
        if (nbMaison <= 0) throw new InvalidAttributException("Attribut cannot be lesser than 0");
        this.nbMaison = nbMaison;
    }

    /**
     * Obtient le nombre d'appartements vendus pendant cette année dans cette commune.
     * @return le nombre d'appartements vendus
     */
    public int getNbAppart() {
        return this.nbAppart;
    }

    /**
     * Définit le nombre d'appartements vendus pendant cette année dans cette commune.
     * @param nbAppart le nombre d'appartements vendus
     * @throws InvalidAttributException si le nombre d'appartements est inférieur ou égal à zéro
     */
    public void setNbAppart(int nbAppart) throws InvalidAttributException {
        if (nbAppart <= 0) throw new InvalidAttributException("Attribut cannot be lesser than 0");
        this.nbAppart = nbAppart;
    }

    /**
     * Obtient le prix moyen des logements pour cette année dans cette commune.
     * @return le prix moyen des logements
     */
    public double getPrixMoyen() {
        return this.prixMoyen;
    }

    /**
     * Définit le prix moyen des logements pour cette année dans cette commune.
     * @param prixMoyen le prix moyen des logements
     * @throws InvalidAttributException si le prix moyen est inférieur ou égal à zéro
     */
    public void setPrixMoyen(double prixMoyen) throws InvalidAttributException {
        if (prixMoyen <= 0) throw new InvalidAttributException("Attribut cannot be lesser than 0");
        this.prixMoyen = prixMoyen;
    }

    /**
     * Obtient le prix moyen par mètre carré pour cette année dans cette commune.
     * @return le prix moyen par mètre carré
     */
    public double getPrixM2Moyen() {
        return this.prixM2Moyen;
    }

    /**
     * Définit le prix moyen par mètre carré pour cette année dans cette commune.
     * @param prixM2Moyen le prix moyen par mètre carré
     * @throws InvalidAttributException si le prix moyen par mètre carré est inférieur ou égal à zéro
     */
    public void setPrixM2Moyen(double prixM2Moyen) throws InvalidAttributException{
        if (prixM2Moyen <= 0) throw new InvalidAttributException("Attribut cannot be lesser than 0");
        this.prixM2Moyen = prixM2Moyen;
    }

    /**
     * Obtient la surface moyenne des logements pour cette année dans cette commune.
     * @return la surface moyenne des logements
     */
    public double getSurfaceMoy() {
        return this.surfaceMoy;
    }

    /**
     * Définit la surface moyenne des logements pour cette année dans cette commune.
     * @param surfaceMoy la surface moyenne des logements
     * @throws InvalidAttributException si la surface moyenne est inférieure ou égale à zéro
     */
    public void setSurfaceMoy(double surfaceMoy) throws InvalidAttributException {
        if (surfaceMoy <= 0) throw new InvalidAttributException("Attribut cannot be lesser than 0");
        this.surfaceMoy = surfaceMoy;
    }

    /**
     * Obtient les dépenses culturelles totales pour cette commune pendant l'année.
     * @return les dépenses culturelles totales
     */
    public double getDepensesCultutrellesTotales() {
        return this.depensesCultutrellesTotales;
    }

    /**
     * Définit les dépenses culturelles totales pour cette commune pendant l'année.
     * @param depensesCultutrellesTotales les dépenses culturelles totales
     * @throws InvalidAttributException si les dépenses culturelles totales sont inférieures ou égales à zéro
     */
    public void setDepensesCultutrellesTotales(double depensesCultutrellesTotales) throws InvalidAttributException {
        if (depensesCultutrellesTotales <= 0) throw new InvalidAttributException("Attribut cannot be lesser than 0");
        this.depensesCultutrellesTotales = depensesCultutrellesTotales;
    }

    /**
     * Obtient le budget total de la commune pour cette année.
     * @return le budget total de la commune
     */
    public double getBudgetTotal() {
        return this.budgetTotal;
    }

    /**
     * Définit le budget total de la commune pour cette année.
     * @param budgetTotal le budget total de la commune
     * @throws InvalidAttributException si le budget total est inférieur ou égal à zéro
     */
    public void setBudgetTotal(double budgetTotal) throws InvalidAttributException {
        if (budgetTotal <= 0) throw new InvalidAttributException("Attribut cannot be lesser than 0");
        this.budgetTotal = budgetTotal;
    }

    /**
     * Obtient la population de la commune pour cette année.
     * @return la population de la commune
     */
    public int getPopulation() {
        return this.population;
    }

    /**
     * Définit la population de la commune pour cette année.
     * @param population la population de la commune
     * @throws InvalidAttributException si la population est inférieure ou égale à zéro
     */
    public void setPopulation(int population) throws InvalidAttributException {
        if (population <= 0) throw new InvalidAttributException("Attribut cannot be lesser than 0");
        this.population = population;
    }

    /**
     * Calcule la moyenne du prix des logements pour une liste de données annuelles.
     * @param donneeAnnulles la liste de données annuelles
     * @return la moyenne du prix des logements
     * @throws NullPointerException si la liste de données est null
     */
    public static double moyennePrixLogements(ArrayList<DonneesAnnuelles> donneeAnnulles) throws NullPointerException{
        if (donneeAnnulles == null) throw new NullPointerException("The parameter donneeAnnuelles is null");

        double ret = 0;
        for (DonneesAnnuelles d : donneeAnnulles){
            ret += d.getPrixMoyen();
        }
        ret = ret/donneeAnnulles.size();

        return ret;
        
    }

    /**
     * Retourne une représentation textuelle des données annuelles.
     * @return une chaîne de caractères représentant les données annuelles
     */
    public String toString(){
        return "l'Année : " + this.lAnnee.getANNEE() + "\tla Commune : " + this.laCommune.getNomCommune() + "\nNombre Maison vendu : " + this.nbMaison + "\nNombre Appartement vendu : " + this.nbAppart + "\nSurface Moyenne Logement : " + this.surfaceMoy + "\nPrix Moyen Logement : " + this.prixMoyen + "\nPrix Moyenne m² : " + this.prixM2Moyen + "\nDépenses Culturelles Total : " + this.depensesCultutrellesTotales + "\nBudjet Total : " + this.budgetTotal + "\nPopulation : " + this.population;  
    }

    /**
     * Compare cette instance de DonneesAnnuelles avec une autre pour déterminer l'ordre en fonction de la population des données annuelles.
     * @param data les données annuelles à comparer
     * @return un entier négatif, zéro ou positif si cette instance est inférieure, égale ou supérieure à l'instance donnée
     * @throws NullPointerException si les données à comparer sont null
     */
    public int compareTo(DonneesAnnuelles data) throws NullPointerException {
        if (data == null) throw new NullPointerException("The DonneesAnnuelles to compare to cannot be null");

        int ret;
        if (this.population > data.getPopulation()){
            ret = 1;
        }else if (this.population < data.getPopulation()){
            ret = -1;
        }else {
            ret = 0;
        }
        return ret;
    }

}
