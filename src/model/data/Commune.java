package model.data;

import java.util.ArrayList;


public class Commune {

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

    public Commune(Departement leDepartement, ArrayList<Gare> lesGares, ArrayList<Commune> communesVoisines, int idCommune, String nomCommune) {
        try{
            if (idCommune < 0) {
                throw new IllegalArgumentException("Erreur idCommune : valeur incorrecte");
            }
            if(nomCommune == null){
                throw new IllegalArgumentException("Erreur nomCommune : valeur incorrecte");
            }
            if(leDepartement == null){
                throw new IllegalArgumentException("Erreur leDepartement : valeur incorrecte");
            }
            if(lesGares == null){
                throw new IllegalArgumentException("Erreur lesGares : valeur incorrecte");
            }
            if(communesVoisines == null){
                throw new IllegalArgumentException("Erreur communesVoisines : valeur incorrecte");
            }
            this.leDepartement = leDepartement;
            this.lesGares = lesGares;
            this.communesVoisines = communesVoisines;
            this.idCommune = idCommune;
            this.nomCommune = nomCommune;



        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
    }


    public Departement getLeDepartement() {
        return this.leDepartement;
    }

    public void setLeDepartement(Departement leDepartement) {
        try{
            this.leDepartement = leDepartement;
        } catch (Exception e) {
            System.out.println("Erreur leDepartement : valeur incorrecte");
        }
    }

    public ArrayList<Gare> getLesGares() {
        return this.lesGares;
    }

    public void setLesGares(ArrayList<Gare> lesGares) {
        try{
            this.lesGares = lesGares;
        } catch (Exception e) {
            System.out.println("Erreur lesGares : valeur incorrecte");
        }
    }

    public ArrayList<Commune> getCommunesVoisines() {
        return this.communesVoisines;
    }

    public void setCommunesVoisines(ArrayList<Commune> communesVoisines) {
        try{
            this.communesVoisines = communesVoisines;
        } catch (Exception e) {
            System.out.println("Erreur communesVoisines : valeur incorrecte");
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
        try{
            this.nomCommune = nomCommune;
        } catch (Exception e) {
            System.out.println("Erreur nomCommune : valeur incorrecte");
        }
    }

}
