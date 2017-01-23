package pages;

import entities.LoginDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage {
    private WebDriver driver;

    @FindBy(id = "j_username")
    private WebElement userNameTextBox;

    @FindBy(id = "j_password")
    private WebElement passwordTextBox;

    @FindBy(id = "signin-action")
    private WebElement signInButton;

    @FindBy(id = "locationId")
    private WebElement locationSelection;

    @FindBy(css = ".form-control.style-form.valid")
    private WebElement zoneSelect;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void loginAs(LoginDetails loginDetails) {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        userNameTextBox.sendKeys(loginDetails.getLoginId());
        passwordTextBox.sendKeys(loginDetails.getPassword());

        if(loginDetails.getHasZone()){
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        WebElement signForm = driver.findElement(By.id("signform"));
        waitForElementToBeClickable(signForm, driver);
        signForm.submit();
    }

    public void visitWebsite() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
