package tests;

import models.Car;
import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTests extends TestBase {
    @BeforeMethod
    public void preCondition(){
        if(!app.getHelperUser().isLogged()){
        app.getHelperUser().login(new User().setEmail("karinmc9@mail.ru").setPassword("Rfhbyrf29$"));
        }

    }
    @Test
    public void addNewCarSuccess() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        Car car = Car.builder()
                .location("Tel Aviv, Israel")
                .manufacture("Mazda")
                .model("M3")
                .year("2022")
                .fuel("Petrol")
                .seats(4)
                .carClass("C")
                .carRegNum("678-900-" + i)
                .price(50)
                .about("My car")
                .build();

        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().submitCarForm();
    }
}
