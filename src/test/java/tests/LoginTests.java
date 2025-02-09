package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        //if SignOut present --->logout
        if (app.getHelperUser().isLogged())
            app.getHelperUser().logout();
    }


    @Test
    public void loginSuccess() {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("karinmc9@mail.ru", "Rfhbyrf29$");
        app.getHelperUser().sumitLogin();
        //Assert

        Assert.assertTrue(app.getHelperUser().isLogged());
    }

    @Test
    public void loginSuccessModel() {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("karinmc9@mail.ru", "Rfhbyrf29$");
        app.getHelperUser().sumitLogin();
        Assert.assertTrue(app.getHelperUser().isLogged());
    }
}