package model.data;
import java.lang.NullPointerException;
import java.util.ArrayList;

public class Aeroport {

    private Departement leDepartement;
    private String nom;
    private String adresse;
    private Commune laCommune;

    public Aeroport() {
    }

    public Aeroport(Departement leDepartement, String nom, String adresse) throws NullPointerException, CommuneNotFoundException{
        if (leDepartement == null || nom == null || adresse == null) throw new NullPointerException("The attribut cannot be null");
        this.leDepartement = leDepartement;
        this.nom = nom;
        this.adresse = adresse;
        String[] tmp = this.adresse.split(" ");
        int idCommune = Integer.parseInt(tmp[tmp.length-1]);

        for(Commune c : this.leDepartement.getLesCommunes()){
            if (idCommune == c.getIdCommune()) this.laCommune = c;
        }
        if (this.laCommune == null) throw new CommuneNotFoundException("The Commune is not found");
    }

    public Departement getLeDepartement() {
        return this.leDepartement;
    }

    public void setLeDepartement(Departement leDepartement) throws NullPointerException{
        if (leDepartement == null) throw new NullPointerException("The attribut cannot be null");
        this.leDepartement = leDepartement;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        if (nom == null) throw new NullPointerException("The attribut cannot be null");
        this.nom = nom;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        if (adresse == null) throw new NullPointerException("The attribut cannot be null");
        this.adresse = adresse;
    }

    public ArrayList<Gare> getGaresVoyageurs(){
        ArrayList<Gare> ret = new ArrayList<Gare>();
        
        ArrayList<Gare> tmp = laCommune.getLesGares();
        for(Garre g : tmp){
            if (g.getEstVoyageur) ret.add(g);
        }
        return ret;
    }


}
