/**
 * Sample Skeleton for 'Login.fxml' Controller Class
 */

package org.client;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.email.SendMail;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class LoginController extends Controller {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="lognBtn"
    private Button loginBtn; // Value injected by FXMLLoader

    @FXML // fx:id="password"
    private PasswordField passwordText; // Value injected by FXMLLoader

    @FXML // fx:id="signUpText"
    private Text signUpText; // Value injected by FXMLLoader

    @FXML // fx:id="username"
    private TextField usernameText; // Value injected by FXMLLoader

    private int count = 0;

    /**
     * Sending the server to log into the site.
     * @param event
     */
    @FXML
    void login(ActionEvent event) {
        count++;
        if (count == 10) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Project not working?");
            alert.setHeaderText("Did you do a big change? \nDid you ask yourself what you need to do FIRST OF ALL??????");
            alert.setContentText("Maybe in another life you better be running later");
            alert.getButtonTypes().clear();
            ButtonType confirmBtn = new ButtonType("Clean Install");
            alert.getButtonTypes().setAll(confirmBtn);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == confirmBtn) {
                SendMail.openWebpage("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
                count = 0;
            }
        }
        if (usernameText.getText().isEmpty() || passwordText.getText().isEmpty()) {
            Controller.sendAlert("One or more fields are empty.", "Login Failed", Alert.AlertType.WARNING);
            return;
        }


        List<Object> msg = new LinkedList<Object>();
        msg.add("#LOGIN");
        msg.add(usernameText.getText());
        msg.add(passwordText.getText());
        try {
            App.client.sendToServer(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Changing the screen to signUp screen.
     * @param event
     */
    @FXML
    void goToSignup(MouseEvent event) {
        ObservableList<Node> buttons = ((VBox) this.getSkeleton().mainScreen.getLeft()).getChildren();

        signUpText.setFill(Color.web("#7825fa"));

        for (Node node : buttons) {
            if (node.getId().equals("loginBtn"))
                node.setStyle("-fx-background-color: #9bc98c");

            if (node.getId().equals("signUpBtn"))
                node.setStyle("-fx-background-color: #62a74d");
        }

        this.getSkeleton().changeCenter("SignUp");
    }


    /**
     * Calling login when pressed enter.
     * @param event
     */
    @FXML
    void enterLogin(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER)
            login(new ActionEvent());
    }


    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert loginBtn != null : "fx:id=\"lognBtn\" was not injected: check your FXML file 'Login.fxml'.";
        assert passwordText != null : "fx:id=\"passwordText\" was not injected: check your FXML file 'Login.fxml'.";
        assert signUpText != null : "fx:id=\"signUpText\" was not injected: check your FXML file 'Login.fxml'.";
        assert usernameText != null : "fx:id=\"username\" was not injected: check your FXML file 'Login.fxml'.";

    }

}

