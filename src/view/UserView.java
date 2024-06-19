package view;

import controller.communesController;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class UserView {

    private GridPane userPane;
    private Label labelUsername;
    private Label labelPassword;
    private Label InfoCHG;
    private TextField textUsername;
    private TextField textOldPassword;
    private TextField textNewPassword;
    private Button buttonChange;

    public UserView(communesController controller) {
        userPane = new GridPane();
        GridPane innerPane = new GridPane();

        labelUsername = new Label("Username");
        labelUsername.setFont(controller.getFONT());
        GridPane.setMargin(labelUsername, controller.getINSETS());
        GridPane.setHalignment(labelUsername, HPos.CENTER);

        labelPassword = new Label("Password");
        labelPassword.setFont(controller.getFONT());
        GridPane.setMargin(labelPassword, controller.getINSETS());
        GridPane.setHalignment(labelPassword, HPos.CENTER);

        InfoCHG = new Label("Change your username or password");
        InfoCHG.setFont(controller.getFONT());
        GridPane.setMargin(InfoCHG, controller.getINSETS());
        GridPane.setHalignment(InfoCHG, HPos.CENTER);

        textUsername = new TextField();
        textUsername.setFont(controller.getFONT());
        GridPane.setMargin(textUsername, controller.getINSETS());
        GridPane.setHalignment(textUsername, HPos.CENTER);
        textUsername.setPromptText("New Username");

        textNewPassword = new TextField();
        textNewPassword.setFont(controller.getFONT());
        GridPane.setMargin(textNewPassword, controller.getINSETS());
        GridPane.setHalignment(textNewPassword, HPos.CENTER);
        textNewPassword.setPromptText("New Password");

        textOldPassword = new TextField();
        textOldPassword.setFont(controller.getFONT());
        GridPane.setMargin(textOldPassword, controller.getINSETS());
        GridPane.setHalignment(textOldPassword, HPos.CENTER);
        textOldPassword.setPromptText("Old Password");
        
        buttonChange = new Button("Change");
        buttonChange.setFont(controller.getFONT());
        GridPane.setMargin(buttonChange, controller.getINSETS());
        GridPane.setHalignment(buttonChange, HPos.CENTER);

        userPane.add(InfoCHG, 0, 0);
        userPane.add(innerPane, 0, 1);
        innerPane.add(labelUsername, 0, 1);
        innerPane.add(labelPassword, 0, 2);
        innerPane.add(textUsername, 1, 1);
        innerPane.add(textNewPassword, 1, 2);
        innerPane.add(textOldPassword, 1, 3);
        innerPane.add(buttonChange, 1, 4);


    }

    public GridPane getPane() {
        return userPane;
    }

    public Label getLabelUsername() {
        return labelUsername;
    }

    public Label getLabelPassword() {
        return labelPassword;
    }

    public TextField getTextUsername() {
        return textUsername;
    }

    public TextField getTextNewPassword() {
        return textNewPassword;
    }

    public TextField getTextOldPassword() {
        return textOldPassword;
    }


    public Button getButtonChange() {
        return buttonChange;
    }

}
