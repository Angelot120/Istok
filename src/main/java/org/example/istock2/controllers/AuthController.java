package org.example.istock2.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.istock2.HelloApplication;
import org.example.istock2.models.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class AuthController {
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;

    private String file = "";

    @FXML
    public void onSignin() throws IOException {
        this.file = "register.fxml";
        reDirect(file);

    }

    @FXML
    public void onLogin() throws IOException {
        this.file = "hello-view.fxml";
        reDirect(file);

    }

    @FXML
    public void onSubmit() throws IOException, SQLException {
        String userName = usernameTextField.getText().trim();
        String password = passwordTextField.getText().trim();
        System.out.println("Submition sucessfully");

        if (!userName.isEmpty() && !password.isEmpty()){

            User user  = new User();
            user.setUsername(userName);
            user.setPassword(password);
            user.regster(user);

            this.file = "hello-view.fxml";
            reDirect(file);


        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alert");
            alert.setContentText("Username or password null or empty");
            alert.showAndWait();
        }
    }

    public void reDirect(String file) throws IOException {

        /*Stage initialStage = (Stage) usernameTextField.getSene().getWindow();
        initialStage.close();*/

        Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource(file)));
        Stage stage = (Stage) usernameTextField.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    public void register(ActionEvent actionEvent) throws IOException {

        Stage stage = (Stage) usernameTextField.getScene().getWindow();

        Stage newStage = new Stage();
        Parent root  = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("home.fxml")));
        newStage.setTitle("Istock");
        newStage.setScene(new Scene(root));
        newStage.show();


        stage.close();
    }
}
