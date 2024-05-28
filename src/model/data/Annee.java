package model.data;

public class Annee {

    private final int ANNEE;
    private double tauxInflation;

    public Annee() {
        this.ANNEE = 0;
        this.tauxInflation = 0;
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
