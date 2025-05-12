# Flipkart Automation Testing with Selenium & TestNG

This project contains automation tests written in Java using Selenium WebDriver and TestNG for testing various UI elements and flows on [Flipkart](https://www.flipkart.com/), including logo verification, product search, and navigation to the payments section.

---

## 📂 Project Structure

com:
  test:
    - FlipkartLogoTest.java



---

## 🛠 Prerequisites

- Java 8 or above installed
- Maven or any build tool (optional)
- Chrome browser installed
- ChromeDriver compatible with your Chrome version
- Internet connection

---

## 🔧 Setup Instructions

1. **Clone this repository** or place the `FlipkartLogoTest.java` file in your project directory.

2. **Add required dependencies** to your `pom.xml` (if using Maven):

   ```xml
   <dependencies>
       <dependency>
           <groupId>org.seleniumhq.selenium</groupId>
           <artifactId>selenium-java</artifactId>
           <version>4.17.0</version>
       </dependency>
       <dependency>
           <groupId>org.testng</groupId>
           <artifactId>testng</artifactId>
           <version>7.9.0</version>
           <scope>test</scope>
       </dependency>
   </dependencies>


   test_summary:
  actions_performed:
    - Opens Flipkart.com
    - Closes the login popup if present
    - Verifies that the Flipkart logo is displayed
    - Searches for a product (e.g., Google Pixel 8a)
    - Clicks on the product from the results
    - Attempts to reach the Payments section

challenges_faced:
  - title: Phone Number Lockout
    description: >
      During testing the full purchase flow, the OTP-based login mechanism caused 
      the phone number to get temporarily locked out due to excessive OTP requests.
  - title: Payments Flow Blocked
    description: >
      Unable to complete the automation flow to the Payments section, even though
      the navigation and cart flow were successful.

solutions_for_future_testing:
  - Use a sandboxed testing account or mock Flipkart clone for full automation.
  - Consider OTP bypass or test hooks if working with Flipkart internally.

improvements_planned:
  - Add Page Object Model (POM) structure
  - Handle iframes and dynamic popups more robustly
  - Expand test coverage to payment gateway and order confirmation



