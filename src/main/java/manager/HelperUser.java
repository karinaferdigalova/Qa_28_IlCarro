package manager;

import models.User;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static jdk.nashorn.internal.objects.NativeJava.type;

public class HelperUser extends HelperBase {


    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        click(By.xpath("//*[text()=' Log in ']"));
    }


    public void fillLoginForm(String email, String password) {
        type(By.id("email"), email);
        type(By.id("password"), password);
    }

    public void fillLoginForm(User user) {
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(5));
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
        emailField.click();
        type(By.id("email"), user.getEmail());

        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
        emailField.click();
        type(By.id("password"), user.getPassword());
    }

    public void submit() {
        click(By.xpath("//button[@type='submit']"));
    }


    public void clickOkButton() {
        if (isElementPresent(By.xpath("//button[text()='Ok']")))
            click(By.xpath("//button[text()='Ok']"));
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//*[text()= ' Logout ']"));
    }


    public void logout() {
        click(By.xpath("//*[text()= ' Logout ']"));
    }

    public String getErrorText() {

        return wd.findElement(By.cssSelector("div.error")).getText();
    }


    //*********************************Regstration********************

    public void openRegistrationForm() {
        click(By.xpath("//*[text()=' Sign up ']"));
    }

    public void fillRegistrationForm(User user) {
        type(By.id("name"), user.getFirsName());
        type(By.id("lastName"), user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());

    }

    public void checkPolicy() {

        if (!wd.findElement(By.id("terms-of-use")).isSelected()) {
            //  click(By.id("terms-of-use"));
            //click(By.cssSelector("label[for='terms-of-use']"));

            //variant 2

            JavascriptExecutor js = (JavascriptExecutor) wd;
            js.executeScript("document.querySelector('#terms-of-use').click();");
        }

    }

    public void checkPolicyXY(){
        WebElement label = wd.findElement(By.cssSelector("label[for='terms-of-use']"));
        Rectangle rectangle = label.getRect();
        int w =  rectangle.getWidth();
        int xOffset = -w/2;

        //Dimension size = wd.manage().window().getSize();

        Actions actions = new Actions(wd);
        actions.moveToElement(label,xOffset,0).click().release().perform();
    }

    public void login(User user) {
        openLoginForm();
        fillLoginForm(user);
        submit();
        clickOkButton();
    }



}