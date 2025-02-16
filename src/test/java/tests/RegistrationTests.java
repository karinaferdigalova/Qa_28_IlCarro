package tests;

import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase {
    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogged())
            app.getHelperUser().logout();

    }
    @Test
    public void registrationSuccess(){
        Random random = new Random();
        int i = random.nextInt(1000) +1000;
        System.out.println(i);

        System.out.println(System.currentTimeMillis());
        int z =(int) ((System.currentTimeMillis()/1000)%3600);

        User user = new User()
                .setFirsName("Mila")
                .setLastName("Milova")
                .setEmail("mills" + i + "@gmail.com")
                .setPassword("Mila123456$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(),"You are logged in success");
    }
}
