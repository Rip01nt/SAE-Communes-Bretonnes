package model.data;

import java.util.ArrayList;

import exception.*;

public class DonneesAnnuelles {

    private Annee lAnnee;
    private Commune laCommune;
    private int nbMaison;
    private int nbAppart;
    private double prixMoyen;
    private double prixM2Moyen;
    private double surfaceMoy;
    private double depensesCultutrellesTotales;
    private double budgetTotal;
    private int population;


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

    public Annee getLAnnee() {
        return this.lAnnee;
    }

    public void setLAnnee(Annee lAnnee) throws InvalidAttributException {
        if (lAnnee == null) throw new InvalidAttributException("Attribut cannot be null");
        this.lAnnee = lAnnee;
    }

    public Commune getLaCommune() {
        return this.laCommune;
    }

    public void setLaCommune(Commune laCommune) throws InvalidAttributException{
        if (laCommune == null) throw new InvalidAttributException("Attribut cannto be null");
        this.laCommune = laCommune;
    }

    public int getNbMaison() {
        return this.nbMaison;
    }

    public void setNbMaison(int nbMaison) throws InvalidAttributException {
        if (nbMaison <= 0) throw new InvalidAttributException("Attribut cannot be lesser than 0");
        this.nbMaison = nbMaison;
    }

    public int getNbAppart() {
        return this.nbAppart;
    }

    public void setNbAppart(int nbAppart) throws InvalidAttributException {
        if (nbAppart <= 0) throw new InvalidAttributException("Attribut cannot be lesser than 0");
        this.nbAppart = nbAppart;
    }

    public double getPrixMoyen() {
        return this.prixMoyen;
    }

    public void setPrixMoyen(double prixMoyen) throws InvalidAttributException {
        if (prixMoyen <= 0) throw new InvalidAttributException("Attribut cannot be lesser than 0");
        this.prixMoyen = prixMoyen;
    }

    public double getPrixM2Moyen() {
        return this.prixM2Moyen;
    }

    public void setPrixM2Moyen(double prixM2Moyen) throws InvalidAttributException{
        if (prixM2Moyen <= 0) throw new InvalidAttributException("Attribut cannot be lesser than 0");
        this.prixM2Moyen = prixM2Moyen;
    }

    public double getSurfaceMoy() {
        return this.surfaceMoy;
    }

    public void setSurfaceMoy(double surfaceMoy) throws InvalidAttributException {
        if (surfaceMoy <= 0) throw new InvalidAttributException("Attribut cannot be lesser than 0");
        this.surfaceMoy = surfaceMoy;
    }

    public double getDepensesCultutrellesTotales() {
        return this.depensesCultutrellesTotales;
    }

    public void setDepensesCultutrellesTotales(double depensesCultutrellesTotales) throws InvalidAttributException {
        if (depensesCultutrellesTotales <= 0) throw new InvalidAttributException("Attribut cannot be lesser than 0");
        this.depensesCultutrellesTotales = depensesCultutrellesTotales;
    }

    public double getBudgetTotal() {
        return this.budgetTotal;
    }

    public void setBudgetTotal(double budgetTotal) throws InvalidAttributException {
        if (budgetTotal <= 0) throw new InvalidAttributException("Attribut cannot be lesser than 0");
        this.budgetTotal = budgetTotal;
    }

    public int getPopulation() {
        return this.population;
    }

    public void setPopulation(int population) throws InvalidAttributException {
        if (population <= 0) throw new InvalidAttributException("Attribut cannot be lesser than 0");
        this.population = population;
    }

    public static double moyennePrixLogements(ArrayList<DonneesAnnuelles> donneeAnnulles) throws NullPointerException{
        if (donneeAnnulles == null) throw new NullPointerException("The parameter donneeAnnuelles is null");

        double ret = 0;
        for (DonneesAnnuelles d : donneeAnnulles){
            ret += d.getPrixMoyen();
        }
        ret = ret/donneeAnnulles.size();

        return ret;
        
    }

    public String toString(){
        return "l'Année : " + this.lAnnee.getANNEE() + "\tla Commune : " + this.laCommune.getNomCommune() + "\nNombre Maison vendu : " + this.nbMaison + "\nNombre Appartement vendu : " + this.nbAppart + "\nSurface Moyenne Logement : " + this.surfaceMoy + "\nPrix Moyen Logement : " + this.prixMoyen + "\nPrix Moyenne m² : " + this.prixM2Moyen + "\nDépenses Culturelles Total : " + this.depensesCultutrellesTotales + "\nBudjet Total : " + this.budgetTotal + "\nPopulation : " + this.population;  
    }



}
