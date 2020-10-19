package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks {
//@Before TestNG deki gibi calisir
    //Her scenariodan once calisir
    //GLOBAL Hooks annotation
    @Before(order = 1)
    public void setUp(){
        System.out.println("Hooks class - Setup Method");
    }
    //Her spesific senaryodan once calisir.
    //TAGGED Hooks annotations
    @Before(value = " @iphone",order = 2)
    public void searchIphone(){
        System.out.println("Hooks class-Iphone Methods");
    }
    //@After Methodu her senaryodan sonra calisir
    @After
    public void teardown(Scenario scenario){
        System.out.println("Hooks class-tearDown Method");
        //ScreenShot almak icin
        final byte[] screenshot=((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        //scenario fail olursa image eklyelim
        if (scenario.isFailed()){
            scenario.embed(screenshot,"image/png");
        }
        //Driver.closeDriver();
    }
}
