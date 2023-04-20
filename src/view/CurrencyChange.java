package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CurrencyChange extends Stage {

    final Label label;
    final Button btnLogOut;
    final Label lUsd;
    final TextField tUsd;
    final Label to;
    final Label lNis;
    final TextField tNis;
    final Button btnConvert;
    final Label alert;

    public CurrencyChange() {
        label = new Label("Currency Conversion System");
        btnLogOut = new Button("Logout");
        btnLogOut.getStyleClass().add("btnLogOut");
        btnLogOut.setOnAction(e -> {
            ViewManager.closecurrencyChangePage();
            ViewManager.openLoginPage();
        });
        HBox hBox1 = new HBox(150, label, btnLogOut);

        hBox1.setAlignment(Pos.CENTER);

        lUsd = new Label("USD");
        tUsd = new TextField();

        lNis = new Label("NIS");
        tNis = new TextField();

        VBox vBox1 = new VBox(20, lUsd, tUsd);
        vBox1.setAlignment(Pos.CENTER);
        to = new Label("To");
        VBox vBox2 = new VBox(20, lNis, tNis);
        vBox2.setAlignment(Pos.CENTER);
        HBox hBox2 = new HBox(20, vBox1, to, vBox2);
        hBox2.setAlignment(Pos.CENTER);

        alert = new Label();
        alert.getStyleClass().add("alert");

        btnConvert = new Button("Convert");
        btnConvert.getStyleClass().add("btnConvert");
        btnConvert.setOnAction(e -> {
            if (tNis.getText().isEmpty() && tUsd.getText().isEmpty()) {
                alert.setText("Please Fill Field");
            } else if (tUsd.getText().isEmpty() && !(tNis.getText().isEmpty())) {
                float nis = (float) (Float.parseFloat(tNis.getText()) / 3.62);
                tUsd.setText(nis + "");
                alert.setText("");
            } else if (tNis.getText().isEmpty() && !(tUsd.getText().isEmpty())) {
                float usd = (float) (Float.parseFloat(tUsd.getText()) * 3.64);
                tNis.setText(usd + "");
                alert.setText("");
            }
        });

        VBox vBox3 = new VBox(40, hBox1, hBox2, alert, btnConvert);
        vBox3.setAlignment(Pos.CENTER);
        StackPane root = new StackPane();
        root.getChildren().add(vBox3);
        root.setPadding(new Insets(40));
        Scene scene = new Scene(root, 550, 350);
        scene.getStylesheets().add("/css/stylecurrency.css");
        this.setScene(scene);
        setTitle("Currency Change System");
        show();
    }
}
