package model.data;
import exception.*;
import java.util.ArrayList;

/**
 * La classe Aeroport représente un aéroport avec des attributs tels que le département,
 * le nom, l'adresse et la commune associée.
 */
public class Aeroport {

    /**
     * Le Département de l'Aéroport.
     */
    private Departement leDepartement;

    /**
     * Le nom de l'Aéroport.
     */
    private String nom;

    /**
     * L'adresse de l'Aéroport.
     */
    private String adresse;

    /**
     * La commune de l'Aeroport.
     */
    private Commune laCommune;

    /**
     * Constructeur par défaut de la classe Aeroport.
     */
    public Aeroport() {
        this.leDepartement = new Departement();
        this.nom = "";
        this.adresse = "";
        this.laCommune = new Commune();
    }

    /**
     * Constructeur avec paramètres de la classe Aeroport.
     * @param leDepartement le département de l'aéroport
     * @param nom le nom de l'aéroport
     * @param adresse l'adresse de l'aéroport
     * @throws InvalidAttributException si un attribut est null
     * @throws CommuneNotFoundException si la commune n'est pas trouvée
     */
    public Aeroport(Departement leDepartement, String nom, String adresse) throws InvalidAttributException, CommuneNotFoundException{
        if (leDepartement == null || nom == null || adresse == null) throw new InvalidAttributException("The attribut cannot be null");
        this.leDepartement = leDepartement;
        this.nom = nom;
        this.adresse = adresse;
        this.updateCommune();
    }

    /**
     * Obtient le département de l'aéroport.
     * @return le département de l'aéroport
     */
    public Departement getLeDepartement() {
        return this.leDepartement;
    }

    /**
     * Définit le département de l'aéroport.
     * @param leDepartement le nouveau département
     * @throws InvalidAttributException si le département est nul
     */
    public void setLeDepartement(Departement leDepartement) throws InvalidAttributException{
        if (leDepartement == null) throw new InvalidAttributException("The attribut cannot be null");
        this.leDepartement = leDepartement;
    }

    /**
     * Obtient le nom de l'aéroport.
     * @return le nom de l'aéroport
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Définit le nom de l'aéroport.
     * @param nom le nouveau nom
     * @throws InvalidAttributException si le nom est nul
     */
    public void setNom(String nom) throws InvalidAttributException {
        if (nom == null) throw new InvalidAttributException("The attribut cannot be null");
        this.nom = nom;
    }

    /**
     * Obtient l'adresse de l'aéroport.
     * @return l'adresse de l'aéroport
     */
    public String getAdresse() {
        return this.adresse;
    }

    /**
     * Définit l'adresse de l'aéroport.
     * @param adresse la nouvelle adresse
     * @throws InvalidAttributException si l'adresse est nulle
     * @throws CommuneNotFoundException si la commune n'est pas trouvée
     */
    public void setAdresse(String adresse) throws InvalidAttributException {
        if (adresse == null) throw new InvalidAttributException("The attribut cannot be null");
        this.adresse = adresse;
    }

    /**
     * Obtient la commune associée à l'aéroport.
     * @return la commune associée à l'aéroport
     */
    public Commune getLaCommune() {
        return this.laCommune;
    }

    /**
     * Définit la commune associée à l'aéroport.
     * @param laCommune la nouvelle commune
     * @throws InvalidAttributException si la commune est nulle
     */
    public void setlaCommune(Commune laCommune) throws InvalidAttributException {
        if (laCommune == null) throw new InvalidAttributException("The attribut cannot be null");
        this.laCommune = laCommune;
    }

    /**
     * Met à jour la commune associée à l'aéroport en fonction de l'adresse.
     * @throws CommuneNotFoundException si la commune n'est pas trouvée dans les communes du département
     */
    private void updateCommune() throws CommuneNotFoundException{
        String[] tmp = this.adresse.split(" ");
        int idCommune = Integer.parseInt(tmp[tmp.length-1]);

        for(Commune c : this.leDepartement.getLesCommunes()){
            if (idCommune == c.getIdCommune()) this.laCommune = c;
        }
        if (this.laCommune == null) throw new CommuneNotFoundException("The Commune is not found");
    }

    /**
     * Obtient les gares voyageurs associées à l'aéroport.
     * @return une liste des gares voyageurs
     */
    public ArrayList<Gare> getGaresVoyageurs(){
        ArrayList<Gare> ret = new ArrayList<Gare>();
        
        ArrayList<Gare> tmp = laCommune.getLesGares();
        for(Gare g : tmp){
            if (g.getEstVoyageur()) ret.add(g);
        }
        return ret;
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères de l'aéroport.
     * @return une chaîne de caractères représentant l'aéroport
     */
    public String toString(){
        return "Departement : " + this.leDepartement.getNomDepartement() + "\nNom : " + this.nom + "\nAdresse : " + this.adresse;
    }


}
