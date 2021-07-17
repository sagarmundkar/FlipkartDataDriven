package com.flipkart.test;

import org.testng.annotations.Test;
import pages.Login;
import pages.Logout;
import utility.ReadJsonFile;

import java.awt.*;

public class TestLogin extends BaseProgram{
    @Test(dataProvider = "Login", dataProviderClass = ReadJsonFile.class)

    public void LoginApplication(String data) throws InterruptedException, AWTException {
        Login login = new Login(driver);
        login.LoginApplication(data);

        Logout logout = new Logout(driver);
        logout.LogoutApplication();


    }
}
