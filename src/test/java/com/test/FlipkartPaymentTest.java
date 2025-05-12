package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FlipkartPaymentTest {
    WebDriver driver;
    String currentPage;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/payments?isRevampedDesktopView=true&token=PN2505122155204c1964981c1e11562f0e1edc6fc481edc182832403b6fb930f165c84aed3367b1_v3_1");
    }

        @Test
        public void verifyUpi() {
            try {
               // WebElement logoElement = driver.findElement(By.cssSelector("h5[data-testid='page-title']")); // or .getText()
               // assert logoElement.isDisplayed() : "Logo is not displayed.";
                WebElement upi = driver.findElement(By.xpath("/html/body/div/div[2]/div/section[1]/div/div/div/section/div/div[1]/div[2]/div/div/div/section/div/label/div[2]/div/div/input"));
                upi.sendKeys("arnabdhara35");
                System.out.println("✅ Test Passed: Flipkart logo is displayed.");
            } catch (Exception e) {
                e.printStackTrace();
                assert false : "❌ Test Failed in verifyLogoIsDisplayed: " + e.getMessage();
            }
        }

}
