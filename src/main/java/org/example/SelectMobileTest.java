package org.example;

import com.beust.jcommander.Parameter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.*;

public class SelectMobileTest extends BasicTest
{
    //initializing variables
    private String itemName;
    private String itemQuantity;
    private String itemPrice;

    //Launch the Web Browser
    @Test(priority = 1)
    @Parameters({"url"})
    public void launchURLTest2(String url)
    {
        driver.get(url);
    }

    //Verifying the URL and checkwhether the correct page is opened
    @Test(priority = 2)
    @Parameters({"url"})
    public void verifyURLTest3(String url)
    {
        Assert.assertEquals(driver.getCurrentUrl(),url);
        System.out.println("The URL was verified ....");
        System.out.println("Correct page opened ....");
    }

    //Select "Cell Phones & Accessories" from the dropdown list
    @Test(priority = 3)
    public void selectDropDownTest4()
    {
        WebElement selectDropDown = driver.findElement(By.id("gh-cat"));
        Select select = new Select(selectDropDown);
        select.selectByVisibleText("Cell Phones & Accessories");
    }

    //Type "Mobile Phones" in the search box and click on the search button
    @Test(priority = 4)
    public void searchMobilePhoneTest5()
    {
        driver.findElement(By.id("gh-ac")).sendKeys("Mobile phone");
        driver.findElement(By.xpath("//*[@id=\"gh-btn\"]")).click();
    }

    //Check the "Apple" check box
    @Test(priority = 5)
    public void selectCheckBoxTest6()
    {
        driver.findElement(By.xpath("//*[@id=\"x-refine__group_1__0\"]/ul/li[1]/div/a/div/span/input")).click();

    }

    //Select the first item of the page
    @Test(priority = 6)
    public void selectFirstElementTest7()
    {
        WebElement firstItem = driver.findElement(By.xpath("//*[@id=\"srp-river-results\"]/ul/li[2]/div/div[2]/a/div/span"));
        firstItem.click();

        for (String winHandle : driver.getWindowHandles())
        {
            driver.switchTo().window(winHandle);
        }

    }

    //Select the first element from the dropdown list that belongs to Model type
    //If it is not exists Model type , then it will give "Model selection is  not found ...."
    @Test(priority = 7)
    public void selectModelTest8() throws Exception
    {
        try
        {
           WebElement selectBox = driver.findElement(By.xpath("//*[@id=\"x-msku__select-box-1000\"]"));
           Select selectBoxLabel = new Select(selectBox);
           selectBoxLabel.selectByIndex(1);
        }
        catch(Exception e)
        {
            System.out.println("Model selection does not found ....");
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    //Select the first element from the dropdown list that belongs to Carrier type
    //If it is not exists Carrier type , then it will give "Carrier selection is  not found ...."
    @Test(priority = 8)
    public void selectCarrierTest9() throws Exception
    {
        try
        {
            WebElement selectBox = driver.findElement(By.xpath("//*[@id=\"x-msku__select-box-1002\"]"));
            Select selectBoxLabel = new Select(selectBox);
            selectBoxLabel.selectByIndex(1);
        }
        catch(Exception e)
        {
            System.out.println("Carrier selection does not found ....");
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    //Select the first element from the dropdown list that belongs to Storage
    //If it is not exists Storage , then it will give "Storage selection does not found ...."
    @Test(priority = 9)
    public void selectStorageTest10() throws Exception
    {
        try
        {
            WebElement selectBox = driver.findElement(By.xpath("//*[@id=\"x-msku__select-box-1004\"]"));
            Select selectBoxLabel = new Select(selectBox);
            selectBoxLabel.selectByIndex(1);
        }
        catch(Exception e)
        {
            System.out.println("Storage Capacity selection is  not found ....");
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    //Select the first element from the dropdown list that belongs to select the Color
    //If it is not exists color element , then it will give "color selection does not found ...."
    @Test(priority = 10)
    public void selectColorTest11() throws Exception
    {
        try
        {
            WebElement selectBox = driver.findElement(By.xpath("//*[@id=\"x-msku__select-box-1003\"]"));
            Select selectBoxLabel = new Select(selectBox);
            selectBoxLabel.selectByIndex(1);
        }
        catch(Exception e)
        {
            System.out.println("Color selection is  not found ....");
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    //Select the first element from the dropdown list that belongs to select the Cosmetic
    //If it is not exists Cosmetic , then it will give "Cosmetic selection does not found ...."
    @Test(priority = 11)
    public void selectCosmeticTest12() throws Exception
    {
        try
        {
            WebElement selectBox = driver.findElement(By.xpath("//*[@id=\"x-msku__select-box-1001\"]"));
            Select selectBoxLabel = new Select(selectBox);
            selectBoxLabel.selectByIndex(1);
        }
        catch(Exception e)
        {
            System.out.println("Cosmetic selection does not found ....");
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    /*@Test(priority = 12)
    public void addQuantityTest13()
    {
            WebElement qtyBox = driver.findElement(By.xpath("//*[@id=\"qtyTextBox\"]"));
            //String n = Keys.chord(Keys.CONTROL, "A");
            qtyBox.clear();
            qtyBox.sendKeys(String.valueOf(4));

    }*/

    @Test(priority = 13)
    public void printAttributesTest14()
    {
            //print Item Name on the console
            itemName = driver.findElement(By.xpath("//*[@id=\"LeftSummaryPanel\"]/div[1]/div[1]/div/h1/span")).getText();
            System.out.println("Item name is : "+ itemName);

            //print Item Price on the console
            itemPrice = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/form/div[2]/div/div[1]/div[1]/div/div[2]/div/span[1]/span")).getText();
            System.out.println("Item price is : "+itemPrice);

            //print Condition on the console
            System.out.println("Item condition is : "+ driver.findElement(By.xpath("//*[@id=\"mainContent\"]/form/div[1]/div[1]/div/div[2]/div[1]/div/span")).getText());

            //print Item Quantity on the console
            itemQuantity = driver.findElement(By.id("qtyTextBox")).getAttribute("value");
            System.out.println("Item quantity is : "+itemQuantity);

    }


    //Click on the Add to cart button
    @Test(priority = 14)
    public void selectAddToCart()
    {
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/form/div[2]/div/div[1]/div[2]/ul/li[2]/div/a")).click();
    }

   //Verify the Selected details and the cart page details are correct
    @Test(priority = 15)
    public void verifyDetails()
    {
        SoftAssert softAssert = new SoftAssert();
        WebElement actuald1 = driver.findElement(By.xpath("//span[@class=\"BOLD\"]/label"));
        String actualName = actuald1.getText();
        softAssert.assertEquals(actualName,itemName,"Incorrect Item Name");

        WebElement actuald2 = driver.findElement(By.xpath("//div[@class=\"price-details\"]/div/span/span/span"));
        String actualPrice = actuald2.getText();
        softAssert.assertEquals(actualPrice,itemPrice,"Incorrect Item Price");

    }

    //verify the quantity of the item and print it on console
     @Test(priority = 16)
    public void verifyQuantity()
     {
         Assert.assertNotNull(itemQuantity);
         System.out.println("The quantity field is Not Null");
         System.out.println("Item Quantity is : "+itemQuantity);

     }

    //Verify shopping cart checkout subtotal is equals to the item price
     @Test(priority = 17)
    public void verifySubTotal()
    {
        WebElement actual = driver.findElement(By.className("text-display-span"));
        String actualSubTotal = actual.getText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualSubTotal,itemPrice," ERROR : Sub Total does not match . ");

    }


    //Print the Shipping Fee on the console
    @Test(priority = 17)
    public void printShippingFee()
    {
        WebElement fee = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[4]/div/div[2]/div[2]/div[2]/span/span/span"));
        System.out.println("Shipping Fee : "+fee.getText());

    }

}
