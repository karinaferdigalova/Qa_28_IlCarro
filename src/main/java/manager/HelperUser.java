package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperUser extends HelperBase {


    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm(){
        WebElement loginTab = wd.findElement(By.cssSelector("a[href='/login?url=%2Fsearch']"));
//    //xPath--> //a[text()='LOGIN']
//    loginTab.click();
        click(By.cssSelector("a[href='/login?url=%2Fsearch']"));

    }
    public void fillLoginRegistrationForm(String email, String password) {

        type(By.xpath("//input[@id='email']"), email);

        type(By.xpath("//input[@id='password']"), password);
    }
    public void sumitLogin(){
        click(By.xpath("//button[text()='Y’alla!']"));
    }
    public boolean isLogged() {
        return   isElementPresent(By.xpath("//button[text() = 'Sign Out']"));
    }
    public void logout() {
        click(By.xpath("//button[text() = 'Sign Out']"));
    }

}
