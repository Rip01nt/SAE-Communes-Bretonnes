package model.data;

import java.util.ArrayList;
import exception.*;
import java.lang.Comparable;

/**
 * La classe Commune représente une commune avec des attributs tels que le département,
 * les gares, les communes voisines, un identifiant et un nom.
 */
public class Commune implements Comparable<Commune> {

    /**
     * Le Département de la Commune.
     */
    private Departement leDepartement;

    /**
     * List de Gares de la Commune.
     */
    private ArrayList<Gare> lesGares;

    /**
     * List des Communes voisines.
     */
    private ArrayList<Commune> communesVoisines;

    /**
     * Code INSEE de la Commune.
     */
    private int idCommune;

    /**
     * Nom de la Commune.
     */
    private String nomCommune;


    /**
     * Constructeur par défaut de la classe Commune.
     */
    public Commune() {
        this.leDepartement = new Departement();
        this.lesGares = new ArrayList<Gare>();
        this.communesVoisines = new ArrayList<Commune>();
        this.idCommune = 0;
        this.nomCommune = "";
    }

    /**
     * Constructeur avec paramètres de la classe Commune.
     * @param leDepartement le département de la commune
     * @param lesGares les gares de la commune
     * @param communesVoisines les communes voisines
     * @param idCommune le code INSEE de la commune
     * @param nomCommune le nom de la commune
     * @throws InvalidAttributException si un attribut est invalide (null)
     */
    public Commune(Departement leDepartement, ArrayList<Gare> lesGares, ArrayList<Commune> communesVoisines, int idCommune, String nomCommune) throws InvalidAttributException {
        if (leDepartement == null || lesGares == null || communesVoisines == null || nomCommune == null || idCommune <= 0) 
            throw new InvalidAttributException("Les attributs sont invalides");
        this.leDepartement = leDepartement;
        this.lesGares = lesGares;
        this.communesVoisines = communesVoisines;
        this.idCommune = idCommune;
        this.nomCommune = nomCommune;
    }

    /**
     * Obtient le département de la commune.
     * @return le département de la commune
     */
    public Departement getLeDepartement() {
        return this.leDepartement;
    }

    /**
     * Définit le département de la commune.
     * @param leDepartement le nouveau département
     * @throws InvalidAttributException si le département est null
     */
    public void setLeDepartement(Departement leDepartement) throws InvalidAttributException {
        if (leDepartement == null) 
            throw new InvalidAttributException("L'attribut ne peut pas être nul");
        this.leDepartement = leDepartement;
    }

    /**
     * Obtient les gares de la commune.
     * @return la liste des gares de la commune
     */
    public ArrayList<Gare> getLesGares() {
        return this.lesGares;
    }

    /**
     * Définit les gares de la commune.
     * @param lesGares la nouvelle liste de gares
     * @throws InvalidAttributException si lesGares sont null
     */
    public void setLesGares(ArrayList<Gare> lesGares) throws InvalidAttributException {
        if (lesGares == null) 
            throw new InvalidAttributException("L'attribut ne peut pas être nul");
        this.lesGares = lesGares;
    }

    /**
     * Obtient les communes voisines.
     * @return la liste des communes voisines
     */
    public ArrayList<Commune> getCommunesVoisines() {
        return this.communesVoisines;
    }

    /**
     * Définit les communes voisines.
     * @param communesVoisines la nouvelle liste des communes voisines
     * @throws InvalidAttributException si les communes voisines sont nulles
     */
    public void setCommunesVoisines(ArrayList<Commune> communesVoisines) throws InvalidAttributException {
        if (communesVoisines == null) 
            throw new InvalidAttributException("L'attribut ne peut pas être nul");
        this.communesVoisines = communesVoisines;
    }

    /**
     * Obtient l'identifiant de la commune.
     * @return l'identifiant de la commune
     */
    public int getIdCommune() {
        return this.idCommune;
    }

    /**
     * Définit l'identifiant de la commune.
     * @param idCommune le nouvel identifiant
     * @throws InvalidAttributException si le code INSEE est inférieur ou égal à zéro
     */
    public void setIdCommune(int idCommune) throws InvalidAttributException {
        if (idCommune <= 0) 
            throw new InvalidAttributException("L'attribut ne peut pas être inférieur ou égal à zéro");
        this.idCommune = idCommune;
    }

    /**
     * Obtient le nom de la commune.
     * @return le nom de la commune
     */
    public String getNomCommune() {
        return this.nomCommune;
    }

    /**
     * Définit le nom de la commune.
     * @param nomCommune le nouveau nom
     * @throws InvalidAttributException si le nom de la commune est nul
     */
    public void setNomCommune(String nomCommune) throws InvalidAttributException {
        if (nomCommune == null) 
            throw new InvalidAttributException("L'attribut ne peut pas être nul");
        this.nomCommune = nomCommune;
    }

    /**
     * Obtient le nombre de communes voisines.
     * @return le nombre de communes voisines
     */
    public int getNbVoisin() {
        return this.communesVoisines.size();
    }

    /**
     * Vérifie si la commune possède des gares.
     * @return vrai si la commune possède des gares, faux sinon
     */
    public boolean aGare() {
        return this.lesGares.size() != 0;
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères de la commune.
     * @return une chaîne de caractères représentant la commune
     */
    public String toString() {
        String ret = "Code Insee : " + this.idCommune + "\nNom : " + this.nomCommune + 
                     "\nDépartement : " + this.leDepartement.getNomDepartement() + "\nGares : ";
        for (Gare g : this.lesGares) {
            ret += "\n\t" + g.getNomGare();
        }

        ret += "\nCommunes Voisines : ";
        for (Commune c : this.communesVoisines) {
            ret += "\n\t" + c.getNomCommune();
        }

        return ret;
    }

    /**
     * Compare cette commune à une autre commune en fonction du nombre de communes voisines.
     * @param comm la commune à comparer
     * @return 1 si cette commune a plus de communes voisines, -1 si elle en a moins, 0 si elles en ont autant
     * @throws NullPointerException si la commune à comparer est nulle
     */
    public int compareTo(Commune comm) throws NullPointerException {
        if (comm == null) 
            throw new NullPointerException("La commune à comparer ne peut pas être nulle");

        int ret;
        if (this.communesVoisines.size() > comm.getCommunesVoisines().size()) { 
            ret = 1;
        } else if (this.communesVoisines.size() < comm.getCommunesVoisines().size()) {
            ret = -1;
        } else {
            ret = 0;
        }
        return ret;
    }
}
