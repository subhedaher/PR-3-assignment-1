package view;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Login extends Stage {

    final Image image;
    final ImageView imageView;
    final Label usernameLabel;
    final TextField usernameTF;

    final Label passwordLabel;
    final PasswordField passwordTF;

    final Button btnLogin;
    final Label alert;

    public Login() {
        image = new Image("/image/login.png");
        imageView = new ImageView(image);

        usernameLabel = new Label("User name ");
        usernameTF = new TextField();

        passwordLabel = new Label("Password");
        passwordTF = new PasswordField();

        btnLogin = new Button("Login");
        alert = new Label();
        alert.getStyleClass().add("alert");
        btnLogin.setOnAction(e -> {
            if (usernameTF.getText().equals("user") && passwordTF.getText().equals("userpass")) {
                try {
                    ViewManager.opencurrencyChangePage();
                } catch (IOException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                ViewManager.closeloginPage();
            } else if (usernameTF.getText().isEmpty() && passwordTF.getText().isEmpty()) {

                alert.setText("Please Fill Field");
            } else {
                alert.setText("Incorrect Username or Password");
            }
        });

        VBox vBox = new VBox(15, imageView, usernameLabel, usernameTF, passwordLabel, passwordTF, btnLogin, alert);
        vBox.setAlignment(Pos.CENTER);
        StackPane root = new StackPane();
        root.getChildren().add(vBox);
        root.setPadding(new Insets(60));
        Scene scene = new Scene(root, 350, 550);
        scene.getStylesheets().add("/css/stylelogin.css");
        this.setScene(scene);
        setTitle("Login");
        show();
    }
}
