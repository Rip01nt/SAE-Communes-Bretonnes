package model.data;

public class Gare {

    private Commune laCommune;
    private int codeGare;
    private String nomGare;
    private boolean estFret;
    private boolean estVoyageur;


    public Gare() {
    }

    public Gare(Commune laCommune, int codeGare, String nomGare, boolean estFret, boolean estVoyageur) {
        try{
            if(laCommune == null || codeGare == 0 || nomGare == null){
                throw new Exception("Erreur : paramètre null ou vide");
            }
            else{
                this.laCommune = laCommune;
                this.codeGare = codeGare;
                this.nomGare = nomGare;
                this.estFret = estFret;
                this.estVoyageur = estVoyageur;
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }


    public Commune getLaCommune() {
        return this.laCommune;
    }

    public void setLaCommune(Commune laCommune) {
        this.laCommune = laCommune;
    }

    public int getCodeGare() {
        return this.codeGare;
    }

    public void setCodeGare(int codeGare) {
        this.codeGare = codeGare;
    }

    public String getNomGare() {
        return this.nomGare;
    }

    public void setNomGare(String nomGare) {
        this.nomGare = nomGare;
    }

    public boolean isEstFret() {
        return this.estFret;
    }

    public boolean getEstFret() {
        return this.estFret;
    }

    public void setEstFret(boolean estFret) {
        this.estFret = estFret;
    }

    public boolean isEstVoyageur() {
        return this.estVoyageur;
    }

    public boolean getEstVoyageur() {
        return this.estVoyageur;
    }

    public void setEstVoyageur(boolean estVoyageur) {
        this.estVoyageur = estVoyageur;
    }

    public boolean estFerroviaire() {
        try{
            if (this.estFret || this.estVoyageur) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        
        }

    }
}
