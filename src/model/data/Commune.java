package model.data;

import java.util.ArrayList;
import exception.*;
import java.lang.Comparable;


public class Commune implements Comparable {

    private Departement leDepartement;
    private ArrayList<Gare> lesGares;
    private ArrayList<Commune> communesVoisines;
    private int idCommune;
    private String nomCommune;


    public Commune() {
        this.leDepartement = new Departement();
        this.lesGares = new ArrayList<Gare>();
        this.communesVoisines = new ArrayList<Commune>();
        this.idCommune = 0;
        this.nomCommune = "";
    }

    public Commune(Departement leDepartement, ArrayList<Gare> lesGares, ArrayList<Commune> communesVoisines, int idCommune, String nomCommune) throws InvalidAttributException {
        if (leDepartement == null || lesGares == null || communesVoisines == null || nomCommune == null) throw new InvalidAttributException("The attributs are invalid");
        this.leDepartement = leDepartement;
        this.lesGares = lesGares;
        this.communesVoisines = communesVoisines;
        this.idCommune = idCommune;
        this.nomCommune = nomCommune;
    }


    public Departement getLeDepartement() {
        return this.leDepartement;
    }

    public void setLeDepartement(Departement leDepartement) throws InvalidAttributException {
        if(leDepartement == null) throw new InvalidAttributException("Attribut cannot be null");
        this.leDepartement = leDepartement;
    }

    public ArrayList<Gare> getLesGares() {
        return this.lesGares;
    }

    public void setLesGares(ArrayList<Gare> lesGares) throws InvalidAttributException {
        if(lesGares == null) throw new InvalidAttributException("Attribut cannot be null");
        this.lesGares = lesGares;
    }

    public ArrayList<Commune> getCommunesVoisines() {
        return this.communesVoisines;
    }

    public void setCommunesVoisines(ArrayList<Commune> communesVoisines) throws InvalidAttributException{
        if (communesVoisines == null) throw new InvalidAttributException("Attribut cannot be null");
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

    public void setNomCommune(String nomCommune) throws InvalidAttributException{
        if(nomCommune == null)throw new InvalidAttributException("Attribut cannto be null");
        this.nomCommune = nomCommune;
    }

    public int getNbVoisin(){
        return this.communesVoisines.size();
    }

    public boolean aGare(){
        return this.lesGares.size() != 0;
    }

    public String toString(){
        String ret = "Code Insee : " + this.idCommune + "\nNom : " + this.nomCommune + "\nDepatement : " + this.leDepartement.toString() + "\nGarres : ";
        for (Gare g : this.lesGares) {
            ret += "\n" + g.getNomGare();
        }

        ret += "\nCommunes Voisines : ";
        for (Commune c : this.communesVoisines) {
            ret += "\n" + c.getNomCommune();
        }

        return ret;
    }

    public int compareTo(Commune comm) throws NullPointerException{
        if (comm == null) throw new NullPointerException("The Commune to comapre cannot be null");

        int ret;
        if (this.communesVoisines.size() > comm.getCommunesVoisines().size()){ 
            ret = 1;
        }else if (this.communesVoisines.size() < comm.getCommunesVoisines().size()){
            ret = -1;
        }else {
            ret = 0;
        }
        return ret;
    }
}
