package test.model;


import model.data.Aeroport;
import model.data.Annee;
import model.data.Commune;
import model.data.Departement;
import model.data.Gare;
import model.data.DonneesAnnuelles;
import java.util.ArrayList;

import exception.CommuneNotFoundException;
import exception.InvalidAttributException;

public class ScenarioData {
    


    public static void main(String[] args){
        
        try {
            ArrayList<Commune> listComm1 = new ArrayList<Commune>();
            ArrayList<Aeroport> listAero1 = new ArrayList<Aeroport>();
            Departement dep1 = new Departement(listAero1, listComm1, 1, "Dep1", 1000);

            ArrayList<Commune> listComm2 = new ArrayList<Commune>();
            ArrayList<Aeroport> listAero2 = new ArrayList<Aeroport>();
            Departement dep2 = new Departement(listAero2, listComm2, 2, "Dep2", 2000);

            ArrayList<Gare> listGare1 = new ArrayList<Gare>();
            ArrayList<Commune> listCommVoi1 = new ArrayList<Commune>(); 
            Commune comm1 = new Commune(dep1, listGare1, listCommVoi1, 1, "Comm1");
            listComm1.add(comm1);

            ArrayList<Gare> listGare2 = new ArrayList<Gare>();
            ArrayList<Commune> listCommVoi2 = new ArrayList<Commune>(); 
            Commune comm2 = new Commune(dep2, listGare2, listCommVoi2, 2, "Comm2");
            listComm2.add(comm2);
            listCommVoi1.add(comm2);
            listCommVoi2.add(comm1);

            Aeroport aero1 = new Aeroport(dep1, "Aero1", "Adresse aéro 1");
            listAero1.add(aero1);

            Aeroport aero2 = new Aeroport(dep2, "Aero2", "Adresse aéro 2");
            listAero2.add(aero2);

            Gare gare1 = new Gare(comm1, 1, "Gare 1", true, true);
            listGare1.add(gare1);

            Gare gare2 = new Gare(comm2, 2, "Gare 2", false, false);
            listGare2.add(gare2);

            Annee annee1 = new Annee(1, 1.5);

            Annee annee2 = new Annee(2, 1);

            DonneesAnnuelles data1 = new DonneesAnnuelles(annee1, comm1, 1000, 1000, 50000, 600, 100, 100000, 1000000,50000);

            DonneesAnnuelles data2 = new DonneesAnnuelles(annee2, comm1, 1500, 1500, 75000, 550, 125, 1000000, 1500000, 55000);

            System.out.println("=========== Scenario POO ===========");

            System.out.print("\n\nVoici nos différents objet qui vont etre manupuler dans le Scenario :");
            System.out.println("\n\nLes Departement : \n\n" + dep1.toString() + "\n\n" + dep2.toString());
            System.out.println("\n\nLes Communes : \n\n" + comm1.toString() + "\n\n" + comm2.toString());
            System.out.println("\n\nLes Aeroports : \n\n" + aero1.toString() + "\n\n" + aero2.toString());
            System.out.println("\n\nLes Gares : \n\n" + gare1.toString() + "\n\n" + gare2.toString());
            System.out.println("\n\nLes Années : \n\n" + annee1.toString() + "\n\n" + annee2.toString());
            System.out.println("\n\nLes Données Annuelles : \n\n" + data1.toString() + "\n\n" + data2.toString());

            System.out.println("\n\nQuelle Commune a une gare ?");
            if (comm1.aGare()) System.out.println(comm1.getNomCommune());
            if (comm2.aGare()) System.out.println(comm2.getNomCommune());

            System.out.println("\n\nQuelle Commune des deux est la plus grande ?");
            int tmp = comm1.compareTo(comm2);
            if (tmp < 0){
                System.out.println(comm2.getNomCommune() + " est la plus grande.");
            }else if (tmp > 0){
                System.out.println(comm1.getNomCommune() + " est la plus grande.");
            }else {
                System.out.println("Aucune, elles sont équivalente.");
            }

            System.out.println("\n\nQuelles sont les nombre de gares fret et voyageurs dans les département ?");
            System.out.println(dep1.getNomDepartement() + " : \tFret : " + dep1.getNbGareFret() + "\tVoyageur : " + dep1.getNbGareVoyageur());
            System.out.println(dep2.getNomDepartement() + " : \tFret : " + dep2.getNbGareFret() + "\tVoyageur : " + dep2.getNbGareVoyageur());

            System.out.println("\n\nQuelle Depatement des deux est la plus grande ?");
            tmp = dep1.compareTo(dep2);
            if (tmp < 0){
                System.out.println(dep2.getNomDepartement() + " est la plus grande.");
            }else if (tmp > 0){
                System.out.println(dep1.getNomDepartement() + " est la plus grande.");
            }else {
                System.out.println("Aucune, elles sont équivalente.");
            }

            System.out.println("\n\n" + gare1.getNomGare() + " est-elle férroviaire ?");
            if(gare1.estFerroviaire()) {
                System.out.print("OUI");
            }else {
                System.out.println("NON");
            }

            System.out.println("\n\n" + gare2.getNomGare() + " est-elle férroviaire ?");
            if(gare2.estFerroviaire()) {
                System.out.print("OUI");
            }else {
                System.out.println("NON");
            }
            
            System.out.println("\n\nQuelles sont les gares Voyageurs de la Commune de " + aero1.getNom() + " ?");
            for(Gare g : aero1.getGaresVoyageurs()){
                System.out.println(g.getNomGare());
            }
            if (aero1.getGaresVoyageurs().size() == 0) System.out.println("Aucune");

            System.out.println("\n\nQuelles sont les gares Voyageurs de la Commune de " + aero2.getNom() + " ?");
            for(Gare g : aero2.getGaresVoyageurs()){
                System.out.println(g.getNomGare());
            }
            if (aero2.getGaresVoyageurs().size() == 0) System.out.println("Aucune");

            System.out.println("\n\nQuelle est la moyenne du taux d'inflation des deux années : ");
            ArrayList<Annee> listAnnees = new ArrayList<Annee>();
            listAnnees.add(annee1);
            listAnnees.add(annee2);
            System.out.println(Annee.moyenneTauxInflation(listAnnees));

            System.out.println("\n\nQuelle est la moyenne des prix des logement des année 1 et 2 de la commune " + comm1.getNomCommune() + " ?");
            ArrayList<DonneesAnnuelles> listData = new ArrayList<DonneesAnnuelles>();
            listData.add(data1);
            listData.add(data2);
            System.out.println(DonneesAnnuelles.moyennePrixLogements(listData));

        }catch (InvalidAttributException e){
            System.out.print(e.getMessage());
        }catch (CommuneNotFoundException e){
            System.out.println(e.getMessage());
        }

        






        
    }
}
