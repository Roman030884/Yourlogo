package tests;

import org.testng.annotations.DataProvider;

public class EmailData {
    @DataProvider(name = "CreateAccountDataProvider")
    public Object [][] getDataEmail()  {
        return new Object[][]{{"barabulka@gmail.com"},{"ussr@mail.ar"},{"swift@gmail.com"}};
    }
}