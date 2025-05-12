package com.test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.lang.*;
import java.util.*;

public class FlipkartLogoTest {

    WebDriver driver;
    String currentPage;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com");
    }

    @Test
    public void verifyLogoIsDisplayed() {
        try {
            WebElement logoElement = driver.findElement(By.cssSelector("div._16ZfEv"));
            assert logoElement.isDisplayed() : "Logo is not displayed.";
            System.out.println("✅ Test Passed: Flipkart logo is displayed.");
        } catch (Exception e) {
            e.printStackTrace();
            assert false : "❌ Test Failed in verifyLogoIsDisplayed: " + e.getMessage();
        }
    }

    @Test(dependsOnMethods = "verifyLogoIsDisplayed")
    public void searchForProduct() {
        try {
            String item = "google pixel 8a 5g";
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys(item);
            searchBox.submit();
            System.out.println("✅ Test Passed: Search performed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            assert false : "❌ Test Failed in searchForProduct: " + e.getMessage();
        }
    }

    @Test(dependsOnMethods = "searchForProduct")
    public void clickSearchResult() {
        try {
            // Wait until the product appears and click
           // WebDriverWait wait = new WebDriverWait(driver, 10);
             currentPage = driver.getWindowHandle();
            System.out.println("mainpage = "+ currentPage);
            WebElement product = driver.findElement(
                    By.xpath("//div[normalize-space() = 'Google Pixel 8a (Aloe, 128 GB)']")
            );
            product.click();
            Set<String> allPages = driver.getWindowHandles();
            for(String page: allPages){
                if(!page.equals(currentPage)) {
                    currentPage=page;
                    driver.switchTo().window(currentPage);
                    break;
                }
            }
            System.out.println("nextPage"+driver.getCurrentUrl());
            System.out.println(currentPage);

            System.out.println("✅ Test Passed: Product clicked successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            assert false : "❌ Test Failed in clickSearchResult: " + e.getMessage();
        }
    }

    @Test(dependsOnMethods = "clickSearchResult")
    public void buyNow(){
        try{
            WebElement buyButton = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[2]/form/button"));
            //WebElement buyButton = driver.findElement(By.name("Buy Now"));
            buyButton.click();
            Thread.sleep(5000);

            System.out.println("✅ Test Passed: Buy now button clicked successfully.");

        }catch(Exception e){
            e.printStackTrace();
            assert false : "Test Failed in buyNow" + e.getMessage();
        }
    }

    @Test(dependsOnMethods = "buyNow")
    public void enterDetails(){
        try{
            String mobileNumber= "8100129139"; //put your mobile number
            String emailID = "arnabdhara2022@gmail.com"; //put your email address
            WebElement inputForm = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[1]/div/div/div/div/div[1]/div/form/div[1]/input"));
            inputForm.sendKeys(mobileNumber);  //use your mobile number
            WebElement ContinueButton = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[1]/div/div/div/div/div[1]/div/form/div[3]/button"));
            ContinueButton.click();
            //WebElement OtpForm = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[1]/div/div/div/div/div[1]/div/form/div[2]/input"));
            Thread.sleep(10000);  //I am intentionally putting a 10 second sleep here to enter the otp manually received in my mobile number
            //This portion can be automated using TWILIO SMS service but flipkart does not support US phone number
            WebElement loginButton = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[1]/div/div/div/div/div[1]/div/form/div[4]/button"));
            loginButton.click();
            //WebElement delivery = driver.findElement(By.xpath("//button[normalize-space(text())='Deliver Here']"));
            //delivery.click();
           // WebElement email = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[3]/div/div/div/div/div[5]/span[1]/form/input"));
            //email.sendKeys(emailID);
            //WebElement ContinueEmail = driver.findElement(By.xpath("//*[@id=\"to-payment\"]/button"));
            //*[@id="to-payment"]/button
            //ContinueEmail.click();
            driver.findElement(By.cssSelector(".QqFHMw.VuSC8m._7Pd1Fp")).click();
            WebElement AcceptButton = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/button"));
            AcceptButton.click();
            //*[@id="to-payment"]/button

            //Thread.sleep(5000);



            System.out.println("✅ Test Passed: Details Entered successfully.");


        }catch(Exception e){
            e.printStackTrace();
            assert false : "Test Failed in enterDetails" + e.getMessage();
        }
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
