package model.data;

import java.util.ArrayList;
import exception.*;
import java.lang.Comparable;

/**
 * La classe Departement représente un département avec ses aéroports, communes, et informations liées.
 */
public class Departement implements Comparable<Departement> {

    /**
     * List des aéroport du département.
     */
    private ArrayList<Aeroport> lesAeroports;

    /**
     * List des communes du département.
     */
    private ArrayList<Commune> lesCommunes;

    /**
     * Code INSEE du déparement.
     */
    private int idDepartement;

    /**
     * Nom du département.
     */
    private String nomDepartement;

    /**
     * Investissement culturelle de 2019 du dépatement.
     */
    private double investissementCulturel2019;

    /**
     * Constructeur par défaut de la classe Departement.
     */
    public Departement() {
        this.lesAeroports = new ArrayList<Aeroport>();
        this.lesCommunes = new ArrayList<Commune>();
        this.idDepartement = 0;
        this.nomDepartement = "";
        this.investissementCulturel2019 = 0;
    }

    /**
     * Constructeur avec paramètres de la classe Departement.
     * @param lesAeroports les aéroports du département
     * @param lesCommunes les communes du département
     * @param idDepartement le code INSEE du département
     * @param nomDepartement le nom du département
     * @param investissementCulturel2019 l'investissement culturel de 2019 du département
     * @throws InvalidAttributException si un attribut est invalide (null ou négatif)
     */
    public Departement(ArrayList<Aeroport> lesAeroports, ArrayList<Commune> lesCommunes, int idDepartement, String nomDepartement, double investissementCulturel2019) throws InvalidAttributException {
        if (lesAeroports == null || lesCommunes == null || idDepartement <= 0 || nomDepartement == null || investissementCulturel2019 <= 0) 
            throw new InvalidAttributException("Les attributs sont invalides");
        this.lesAeroports = lesAeroports;
        this.lesCommunes = lesCommunes;
        this.idDepartement = idDepartement;
        this.nomDepartement = nomDepartement;
        this.investissementCulturel2019 = investissementCulturel2019;
    }

    /**
     * Obtient les aéroports du département.
     * @return la liste des aéroports du département
     */
    public ArrayList<Aeroport> getLesAeroports() {
        return this.lesAeroports;
    }

    /**
     * Définit les aéroports du département.
     * @param lesAeroports la nouvelle liste des aéroports
     * @throws InvalidAttributException si les aéroports sont nuls
     */
    public void setLesAeroports(ArrayList<Aeroport> lesAeroports) throws InvalidAttributException {
        if (lesAeroports == null) 
            throw new InvalidAttributException("L'attribut ne peut pas être nul");
        this.lesAeroports = lesAeroports;
    }

    /**
     * Obtient les communes du département.
     * @return la liste des communes du département
     */
    public ArrayList<Commune> getLesCommunes() {
        return this.lesCommunes;
    }

    /**
     * Définit les communes du département.
     * @param lesCommunes la nouvelle liste des communes
     * @throws InvalidAttributException si les communes sont nulles
     */
    public void setLesCommunes(ArrayList<Commune> lesCommunes) throws InvalidAttributException {
        if (lesCommunes == null) 
            throw new InvalidAttributException("L'attribut ne peut pas être nul");
        this.lesCommunes = lesCommunes;
    }

    /**
     * Obtient le code INSEE du département.
     * @return le code INSEE du département
     */
    public int getIdDepartement() {
        return this.idDepartement;
    }

    /**
     * Définit le code INSEE du département.
     * @param idDepartement le nouveau code INSEE
     * @throws InvalidAttributException si le code INSEE est inférieur ou égal à zéro
     */
    public void setIdDepartement(int idDepartement) throws InvalidAttributException {
        if (idDepartement <= 0) 
            throw new InvalidAttributException("L'attribut ne peut pas être inférieur ou égal à zéro");
        this.idDepartement = idDepartement;
    }

    /**
     * Obtient le nom du département.
     * @return le nom du département
     */
    public String getNomDepartement() {
        return this.nomDepartement;
    }

    /**
     * Définit le nom du département.
     * @param nomDepartement le nouveau nom du département
     * @throws InvalidAttributException si le nom du département est nul
     */
    public void setNomDepartement(String nomDepartement) throws InvalidAttributException {
        if (nomDepartement == null) 
            throw new InvalidAttributException("L'attribut ne peut pas être nul");
        this.nomDepartement = nomDepartement;
    }

    /**
     * Obtient l'investissement culturel de 2019 du département.
     * @return l'investissement culturel de 2019 du département
     */
    public double getInvestissementCulturel2019() {
        return this.investissementCulturel2019;
    }

    /**
     * Définit l'investissement culturel de 2019 du département.
     * @param investissementCulturel2019 le nouvel investissement culturel de 2019
     * @throws InvalidAttributException si l'investissement culturel est inférieur ou égal à zéro
     */
    public void setInvestissementCulturel2019(double investissementCulturel2019) throws InvalidAttributException {
        if (investissementCulturel2019 <= 0) 
            throw new InvalidAttributException("L'attribut ne peut pas être inférieur ou égal à zéro");
        this.investissementCulturel2019 = investissementCulturel2019;
    }

    /**
     * Obtient le nombre de gares de fret dans le département.
     * @return le nombre de gares de fret
     */
    public int getNbGareFret() {
        int ret = 0;
        for (Commune e : this.lesCommunes) {
            for (Gare g : e.getLesGares()) {
                if (g.getEstFret()) 
                    ret++;
            }
        }
        return ret;
    }

    /**
     * Obtient le nombre de gares de voyageurs dans le département.
     * @return le nombre de gares de voyageurs
     */
    public int getNbGareVoyageur() {
        int ret = 0;
        for (Commune e : this.lesCommunes) {
            for (Gare g : e.getLesGares()) {
                if (g.getEstVoyageur()) 
                    ret++;
            }
        }
        return ret;
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères du département.
     * @return une chaîne de caractères représentant le département
     */
    public String toString() {
        String ret = "Code Insee : " + this.idDepartement + "\nNom : " + this.nomDepartement + 
                     "\nInvestissement Culturel 2019 : " + this.investissementCulturel2019 + "\nCommunes : ";

        for (Commune c : this.lesCommunes) {
            ret += "\n\t" + c.getNomCommune();
        }

        ret += "\nAéroports : ";

        for (Aeroport a : this.lesAeroports) {
            ret += "\n\t" + a.getNom();
        }
        return ret;
    }

    /**
     * Compare ce département à un autre département en fonction du nombre de communes.
     * @param dep le département à comparer
     * @return 1 si ce département a plus de communes, -1 s'il en a moins, 0 s'ils en ont autant
     * @throws NullPointerException si le département à comparer est nul
     */
    public int compareTo(Departement dep) throws NullPointerException {
        if (dep == null) 
            throw new NullPointerException("Le département à comparer ne peut pas être nul");

        int ret;
        if (this.lesCommunes.size() > dep.getLesCommunes().size()) {
            ret = 1;
        } else if (this.lesCommunes.size() < dep.getLesCommunes().size()) {
            ret = -1;
        } else {
            ret = 0;
        }
        return ret;
    }
    
}
