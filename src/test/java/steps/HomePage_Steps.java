package tests;

import driverInstance.DriverInstance;
import cucumber.api.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import java.io.*;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriverException;

public class HomePage_Steps {
    WebDriver driver;
    DriverInstance dInstance;

 // ############ Given steps ######################

    @Given("^User enters app Address$")
    public void user_enters_app_Address() throws Throwable {
        dInstance = new DriverInstance();
        driver = dInstance.generateDriverInstance();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.rms.com/how-we-serve");
        driver.navigate().back();
        driver.navigate().refresh();

    }
    @Given("^User enters \"([^\"]*)\"$")
    public void userEnters(String arg1) throws Throwable {
        //driver = new ChromeDriver();
        dInstance = new DriverInstance();
        driver = dInstance.generateDriverInstance();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(arg1);
        Thread.sleep(3000);
    }

 // ############### When steps ########################

    @When("^Click on the on \"([^\"]*)\" tab$")
    public void clickOnTheOnTab(String arg0) throws Throwable {
        driver.findElement(By.linkText(arg0)).click();
        Thread.sleep(3000);
    }

    @When("^User move cursor on the \"([^\"]*)\" tab$")
    public void userMoveCursorOnTheTab(String arg0) throws Throwable {
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(By.linkText(arg0))).perform();
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("C:/Users/User/Desktop/ud282-master/ud282-master/Java_Cucumber/screenshot.jpg"));
        Thread.sleep(3000);
    }

// ################## Then steps ##########################

    @Then("^User should be logged$")
    public void user_should_be_logged() throws Throwable {
        System.out.println("Hi");
        dInstance.closeDriverInstance(driver);
    }

    @Then("^User should be on the Home Page with title - \"([^\"]*)\"$")
    public void userShouldBeOnTheHomePageWithTitle(String arg1) throws Throwable {
        Assert.assertTrue(driver.getTitle().equals(arg1));
        System.out.println(driver.getTitle());
        dInstance.closeDriverInstance(driver);
    }



    @Then("^The \"([^\"]*)\" window should be open$")
    public void theWindowShouldBeOpen(String arg0) throws Throwable {
        Assert.assertTrue(driver.getTitle().contains(arg0));
        System.out.println(driver.getTitle());
        dInstance.closeDriverInstance(driver);
    }



    @Then("^User should see \"([^\"]*)\" sub_tab$")
    public void userShouldSeeSubtab(String arg0) throws Throwable {
        Assert.assertTrue(driver.getPageSource().contains(arg0));
        System.out.println("Element is presented");
        Thread.sleep(3000);
        dInstance.closeDriverInstance(driver);
    }

    @Then("^User should see \"([^\"]*)\" inner_tab$")
    public void userShouldSeeInner_tab(String arg1) throws Throwable {
        Assert.assertTrue(driver.getPageSource().contains(arg1));
        System.out.println("Element is presented");
        Thread.sleep(3000);
        dInstance.closeDriverInstance(driver);
    }
}
