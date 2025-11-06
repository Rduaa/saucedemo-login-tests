package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginBtn = By.id("login-button");
    private final By errorMsg = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(8));
    }

    public LoginPage open(String baseUrl) {
        driver.get(baseUrl);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtn));
        return this;
    }

    public LoginPage typeUsername(String value) {
        driver.findElement(username).sendKeys(value);
        return this;
    }

    public LoginPage typePassword(String value) {
        driver.findElement(password).sendKeys(value);
        return this;
    }

    private void hardClear(By locator) {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(locator));
        el.click();
        el.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        el.sendKeys(Keys.DELETE);
        wait.until(d -> el.getAttribute("value").isEmpty());
    }

    public LoginPage clearUsername() {
        hardClear(username);
        return this;
    }

    public LoginPage clearPassword() {
        hardClear(password);
        return this;
    }

    public LoginPage clickLogin() {
        driver.findElement(loginBtn).click();
        return this;
    }

    public String getError() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg)).getText();
    }
}
