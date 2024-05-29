package model.data;
import java.util.ArrayList;

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

    public double moyenneTauxInflation(ArrayList<Annee> annee) {
        double ret;
        try{
            ret = 0;
            for (Annee a : annee) {
                ret += a.getTauxInflation();
            }
            ret =  ret / annee.size();
        } catch (Exception e) {
            System.out.println("Erreur moyenneTauxInflation : valeur incorrecte");
            ret = 0;
        }
        return ret;
    }



}
