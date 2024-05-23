package model;

import java.util.ArrayList;

import model.Departement;

public class Commune {

    private Departement leDepartement;
    private ArrayList<Gare> lesGares;
    private ArrayList<Commune> communesVoisines;
    private int idCommune;
    private String nomCommune;


    public Commune() {
    }

    public Commune(Departement leDepartement, ArrayList<Gare> lesGares, ArrayList<Commune> communesVoisines, int idCommune, String nomCommune) {
        this.leDepartement = leDepartement;
        this.lesGares = lesGares;
        this.communesVoisines = communesVoisines;
        this.idCommune = idCommune;
        this.nomCommune = nomCommune;
    }


    public Departement getLeDepartement() {
        return this.leDepartement;
    }

    public void setLeDepartement(Departement leDepartement) {
        this.leDepartement = leDepartement;
    }

    public ArrayList<Gare> getLesGares() {
        return this.lesGares;
    }

    public void setLesGares(ArrayList<Gare> lesGares) {
        this.lesGares = lesGares;
    }

    public ArrayList<Commune> getCommunesVoisines() {
        return this.communesVoisines;
    }

    public void setCommunesVoisines(ArrayList<Commune> communesVoisines) {
        this.communesVoisines = communesVoisines;
    }

    public int getIdCommune() {
        return this.idCommune;
    }

    public void setIdCommune(int idCommune) {
        this.idCommune = idCommune;
    }

    public String getNomCommune() {
        return this.nomCommune;
    }

    public void setNomCommune(String nomCommune) {
        this.nomCommune = nomCommune;
    }

}
