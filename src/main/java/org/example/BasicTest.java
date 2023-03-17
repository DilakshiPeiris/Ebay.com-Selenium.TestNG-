package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;



public class BasicTest {
    protected static  WebDriver driver;

    //Launch the web browser
    @BeforeTest
    public void launchBrowserTest1()
    {
            System.setProperty("webdriver.Edge.driver","src/main/resources/msedgedriver.exe");
            driver = new EdgeDriver();
            driver.manage().window().maximize();


    }



}