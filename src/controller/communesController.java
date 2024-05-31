package controller;

import view.communesView;

public class communesController {

    private communesView view;

    public communesController(communesView view) {
        this.view = view;
    }

    public void onReady() {
        view.getMenuButton().setOnAction(e -> {
            view.getMenu().setVisible(!view.getMenu().isVisible());
            if (!view.getMenu().isVisible()) {
                view.getRoot().getChildren().remove(view.getMenu());
            } else {
                view.getRoot().setLeft(view.getMenu());
            }
        });
        view.getExitButton().setOnAction(e -> {
            view.exit();
        });
    }
    
}
