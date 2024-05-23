package model;

public class Annee {

    private final int ANNEE;
    private double tauxInflation;

    public Annee() {
    }

    public Annee(int ANNEE, double tauxInflation) {
        this.ANNEE = ANNEE;
        this.tauxInflation = tauxInflation;
    }

    public int getANNEE() {
        return this.ANNEE;
    }

    public double getTauxInflation() {
        return this.tauxInflation;
    }

    public void setTauxInflation(double tauxInflation) {
        this.tauxInflation = tauxInflation;
    }

}
