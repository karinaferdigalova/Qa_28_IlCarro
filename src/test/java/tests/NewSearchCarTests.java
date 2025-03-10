package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class NewSearchCarTests extends TestBase{

    @Test
    public void searchCurrentMonthSuccess(){
        app.getHelperCar().searchCurrentMonth("Tel Aviv, Israel", "3/10/2025", "3/27/2025");
        app.getHelperCar().getScreen("src/test/screenshots/currentMonth.png");
        app.getHelperCar().submit();
//        app.getHelperCar().yallaSearch();
        Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());
    }

    @Test
    public void searchCurrentYearSuccess(){
        app.getHelperCar().searchCurrentYear("Tel Aviv, Israel", "4/27/2025", "6/28/2025");
        app.getHelperCar().getScreen("src/test/screenshots/currentYear.png");
        app.getHelperCar().submit();
//        app.getHelperCar().yallaSearch();
        Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());
    }

    @Test
    public void searchAnyPeriodSuccess(){
        app.getHelperCar().searchAnyPeriod("Tel Aviv, Israel", "11/15/2025", "2/10/2026");
        app.getHelperCar().getScreen("src/test/screenshots/any.png");
        app.getHelperCar().submit();
//        app.getHelperCar().yallaSearch();
        Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());
    }
    @Test
    public void negativeSearch(){
        app.getHelperCar().searchNotValidPeriod("Tel Aviv, Israel", "2/15/2025", "2/10/2026");
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        app.getHelperUser().pause(5);
        Assert.assertTrue(app.getHelperUser().getErrorText().contains("You can't pick date before today"));
    }




    @AfterMethod
    public void postCondition(){
        app.getHelperCar().navigateByLogo();
    }



}