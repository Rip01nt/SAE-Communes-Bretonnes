package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.data.Commune;

import java.util.ArrayList;
import java.util.List;

public class SearchModel {
    private ObservableList<Commune> data;

    public SearchModel() {
        // Initialisation avec des exemples de données
        data = FXCollections.observableArrayList(
            new Commune(/* paramètres de création d'une Commune */),
            new Commune(/* paramètres de création d'une Commune */),
            new Commune(/* paramètres de création d'une Commune */)
            // Ajouter plus d'instances de Commune si nécessaire
        );
    }

    public ObservableList<String> search(String query) {
        ObservableList<String> result = FXCollections.observableArrayList();
        if (query == null || query.isEmpty()) {
            return result;
        }

        for (Commune commune : data) {
            if (commune.getNomCommune().toLowerCase().contains(query.toLowerCase())) {
                result.add(commune.toString());
            }
        }
        return result;
    }
}
