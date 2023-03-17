package org.example;
import org.testng.annotations.Test;

public class AfterTest extends BasicTest
{
    //Close the browser
    @Test(priority = 16)
    public void exitBrowser()
    {
        driver.quit();
    }

}
