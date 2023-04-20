package view;

import java.io.IOException;

public class ViewManager {

    public static Login login = null;
    public static CurrencyChange currencyChange = null;

    private ViewManager() {
    }

    public static void openLoginPage() {
        if (login == null) {
            login = new Login();
            login.show();
        } else {
            login.show();
        }
    }

    public static void closeloginPage() {
        if (login != null) {
            login.close();
        }
    }

    public static void opencurrencyChangePage() throws IOException {
        if (currencyChange == null) {
            currencyChange = new CurrencyChange();
            currencyChange.show();
        } else {
            currencyChange.show();
        }
    }

    public static void closecurrencyChangePage() {
        if (currencyChange != null) {
            currencyChange.close();
        }
    }
}
