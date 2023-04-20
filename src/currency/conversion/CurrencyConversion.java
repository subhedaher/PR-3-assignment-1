package currency.conversion;

import javafx.application.Application;
import javafx.stage.Stage;
import view.ViewManager;

public class CurrencyConversion extends Application {

    @Override
    public void start(Stage primaryStage) {
        ViewManager.openLoginPage();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
