package model.data;

import java.util.ArrayList;
import exception.*;


public class Departement {

    private ArrayList<Aeroport> lesAeroports;
    private ArrayList<Commune> lesCommunes;
    private int idDepartement;
    private String nomDepartement;
    private double investissementCulturel2019;

    public Departement() {
        this.lesAeroports = new ArrayList<Aeroport>();
        this.lesCommunes = new ArrayList<Commune>();
        this.idDepartement = 0;
        this.nomDepartement = "";
        this.investissementCulturel2019 = 0;
    }

    public Departement(ArrayList<Aeroport> lesAeroports, ArrayList<Commune> lesCommunes, int idDepartement, String nomDepartement, double investissementCulturel2019) throws InvalidAttributException{
        if (lesAeroports == null || lesCommunes == null || idDepartement <= 0 || nomDepartement == null || investissementCulturel2019 <= 0) throw new InvalidAttributException("The attributs are invalid");
        this.lesAeroports = lesAeroports;
        this.lesCommunes = lesCommunes;
        this.idDepartement = idDepartement;
        this.nomDepartement = nomDepartement;
        this.investissementCulturel2019 = investissementCulturel2019;
    }

    public ArrayList<Aeroport> getLesAeroports() {
        return this.lesAeroports;
    }

    public void setLesAeroports(ArrayList<Aeroport> lesAeroports) throws InvalidAttributException{
        if (lesAeroports == null) throw new InvalidAttributException("Attribut cannot be null");
        this.lesAeroports = lesAeroports;
    }

    public ArrayList<Commune> getLesCommunes() {
        return this.lesCommunes;
    }

    public void setLesCommunes(ArrayList<Commune> lesCommunes) throws InvalidAttributException{
        if (lesCommunes == null) throw new InvalidAttributException("Attribut cannot be null");
        this.lesCommunes = lesCommunes;
    }

    public int getIdDepartement() {
        return this.idDepartement;
    }

    public void setIdDepartement(int idDepartement) throws InvalidAttributException {
        if (idDepartement <= 0) throw new InvalidAttributException("Attribut cannot be lesser than 0");
        this.idDepartement = idDepartement;
    }

    public String getNomDepartement() {
        return this.nomDepartement;
    }

    public void setNomDepartement(String nomDepartement) throws InvalidAttributException {
        if (nomDepartement == null) throw new InvalidAttributException("Attribut cannot be null");
        this.nomDepartement = nomDepartement;
    }

    public double getInvestissementCulturel2019() {
        return this.investissementCulturel2019;
    }

    public void setInvestissementCulturel2019(double investissementCulturel2019) throws InvalidAttributException {
        if (investissementCulturel2019 <= 0) throw new InvalidAttributException("Attribut cannot be lesser than 0");
        this.investissementCulturel2019 = investissementCulturel2019;
    }

    public int getNbGareFret(){
        int ret = 0;
        for (Commune e : this.lesCommunes){
            for (Gare g : e.getLesGares()){
                if (g.getEstFret()) ret++;
            }
        }
        return ret;
    }

    public int getNbGareVoyageur(){
        int ret = 0;
        for (Commune e : this.lesCommunes){
            for (Gare g : e.getLesGares()){
                if (g.getEstVoyageur()) ret++;
            }
        }
        return ret;
    }
    
}
