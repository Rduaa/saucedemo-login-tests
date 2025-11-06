package pages;

import org.openqa.selenium.WebDriver;

public class InventoryPage {
    private final WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getBrowserTitle() {
        return driver.getTitle(); // "Swag Labs"
    }
}
