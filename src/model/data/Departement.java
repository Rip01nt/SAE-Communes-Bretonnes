package model.data;

import java.util.ArrayList;


public class Departement {

    private ArrayList<Aeroport> lesAeroports;
    private ArrayList<Commune> lesCommunes;
    private int idDepartement;
    private String nomDepartement;
    private double investissementCulturel2019;

    public Departement() {
    }

    public Departement(ArrayList<Aeroport> lesAeroports, ArrayList<Commune> lesCommunes, int idDepartement, String nomDepartement, double investissementCulturel2019) {
        this.lesAeroports = lesAeroports;
        this.lesCommunes = lesCommunes;
        this.idDepartement = idDepartement;
        this.nomDepartement = nomDepartement;
        this.investissementCulturel2019 = investissementCulturel2019;
    }

    public ArrayList<Aeroport> getLesAeroports() {
        return this.lesAeroports;
    }

    public void setLesAeroports(ArrayList<Aeroport> lesAeroports) {
        this.lesAeroports = lesAeroports;
    }

    public ArrayList<Commune> getLesCommunes() {
        return this.lesCommunes;
    }

    public void setLesCommunes(ArrayList<Commune> lesCommunes) {
        this.lesCommunes = lesCommunes;
    }

    public int getIdDepartement() {
        return this.idDepartement;
    }

    public void setIdDepartement(int idDepartement) {
        this.idDepartement = idDepartement;
    }

    public String getNomDepartement() {
        return this.nomDepartement;
    }

    public void setNomDepartement(String nomDepartement) {
        this.nomDepartement = nomDepartement;
    }

    public double getInvestissementCulturel2019() {
        return this.investissementCulturel2019;
    }

    public void setInvestissementCulturel2019(double investissementCulturel2019) {
        this.investissementCulturel2019 = investissementCulturel2019;
    }
    
}
