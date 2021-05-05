package tests;

import org.testng.annotations.DataProvider;

public class EmailData {
    @DataProvider(name = "CreateAccountDataProvider")
    public Object [][] getDataEmail()  {
        Object [][] emailData = {{"barabulka@gmail.com"},{"ussr@mail.ar"},{"swift@gmail.com"}};
        return emailData;
    }
}