package utils;

import java.util.ArrayList;

import model.data.Commune;

public class ExportCommData {
    
    public void export(ArrayList<Commune> communes) {
        String filename = "../export/communes.csv";
        String values = "idCommune;Nom commune;idDepatrement de la commune;id des garres;id 2d gare;idcommune voisine;id 2d commune voisine";
        for (Commune commune : communes) {
            values += "\n" + commune.getIdCommune() + ";" + commune.getNomCommune() + ";" + commune.getLeDepartement().getIdDepartement() + ";";

            for (int i = 0; i < commune.getLesGares().size(); i++) {
                values += commune.getLesGares().get(i).getCodeGare();
                if (i < commune.getLesGares().size() - 1) {
                    values += ";";
                }
            }

            for (int i = 0; i < commune.getCommunesVoisines().size(); i++) {
                values += commune.getCommunesVoisines().get(i).getIdCommune();
                if (i < commune.getCommunesVoisines().size() - 1) {
                    values += ";";
                }
            }
        }
        CsvExportUtil.exportCsv(filename, values);
    }
}
