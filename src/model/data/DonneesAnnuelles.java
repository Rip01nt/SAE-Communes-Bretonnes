package model.data;

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
    }

    public DonneesAnnuelles(Annee lAnnee, Commune laCommune, int nbMaison, int nbAppart, double prixMoyen, double prixM2Moyen, double surfaceMoy, double depensesCultutrellesTotales, double budgetTotal, int population) throws NullPointerException{

        if (lAnnee == null || laCommune == null || nbMaison <= 0 || nbAppart <= 0 || prixMoyen <= 0 || prixM2Moyen <= 0 || surfaceMoy <= 0 || depensesCultutrellesTotales <= 0 || budgetTotal <= 0 || population <= 0) throw
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

    public void setLAnnee(Annee lAnnee) {
        this.lAnnee = lAnnee;
    }

    public Commune getLaCommune() {
        return this.laCommune;
    }

    public void setLaCommune(Commune laCommune) {
        this.laCommune = laCommune;
    }

    public int getNbMaison() {
        return this.nbMaison;
    }

    public void setNbMaison(int nbMaison) {
        this.nbMaison = nbMaison;
    }

    public int getNbAppart() {
        return this.nbAppart;
    }

    public void setNbAppart(int nbAppart) {
        this.nbAppart = nbAppart;
    }

    public double getPrixMoyen() {
        return this.prixMoyen;
    }

    public void setPrixMoyen(double prixMoyen) {
        this.prixMoyen = prixMoyen;
    }

    public double getPrixM2Moyen() {
        return this.prixM2Moyen;
    }

    public void setPrixM2Moyen(double prixM2Moyen) {
        this.prixM2Moyen = prixM2Moyen;
    }

    public double getSurfaceMoy() {
        return this.surfaceMoy;
    }

    public void setSurfaceMoy(double surfaceMoy) {
        this.surfaceMoy = surfaceMoy;
    }

    public double getDepensesCultutrellesTotales() {
        return this.depensesCultutrellesTotales;
    }

    public void setDepensesCultutrellesTotales(double depensesCultutrellesTotales) {
        this.depensesCultutrellesTotales = depensesCultutrellesTotales;
    }

    public double getBudgetTotal() {
        return this.budgetTotal;
    }

    public void setBudgetTotal(double budgetTotal) {
        this.budgetTotal = budgetTotal;
    }

    public int getPopulation() {
        return this.population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }


}
