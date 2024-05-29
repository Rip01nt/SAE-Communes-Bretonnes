package model.data;

import exception.*;

public class Gare {

    private Commune laCommune;
    private int codeGare;
    private String nomGare;
    private boolean estFret;
    private boolean estVoyageur;


    public Gare() {
        this.laCommune = new Commune();
        this.codeGare = 0;
        this.nomGare = "";
        this.estFret = false;
        this.estVoyageur = false;
    }

    public Gare(Commune laCommune, int codeGare, String nomGare, boolean estFret, boolean estVoyageur) throws InvalidAttributException {
        if (laCommune == null || codeGare <= 0 || nomGare == null) throw new InvalidAttributException("The Attributs are invalid ");
        this.laCommune = laCommune;
        this.codeGare = codeGare;
        this.nomGare = nomGare;
        this.estFret = estFret;
        this.estVoyageur = estVoyageur;
        
    }


    public Commune getLaCommune() {
        return this.laCommune;
    }

    public void setLaCommune(Commune laCommune) throws InvalidAttributException{
        if (laCommune == null)throw new InvalidAttributException("Attribut laCommune cannot be null");
        this.laCommune = laCommune;
    }

    public int getCodeGare() {
        return this.codeGare;
    }

    public void setCodeGare(int codeGare) throws InvalidAttributException{
        if (codeGare <= 0)throw new InvalidAttributException("Attribut codeGare cannot be lesser than 0");
        this.codeGare = codeGare;
    }

    public String getNomGare() {
        return this.nomGare;
    }

    public void setNomGare(String nomGare) throws InvalidAttributException{
        if (nomGare == null) throw new InvalidAttributException("Attribut nomGare cannot be null");
        this.nomGare = nomGare;
    }

    public boolean getEstFret() {
        return this.estFret;
    }

    public void setEstFret(boolean estFret) {
        this.estFret = estFret;
    }

    public boolean getEstVoyageur() {
        return this.estVoyageur;
    }

    public void setEstVoyageur(boolean estVoyageur) {
        this.estVoyageur = estVoyageur;
    }

    public boolean estFerroviaire() {
        return this.estFret && this.estVoyageur;
    }
}
