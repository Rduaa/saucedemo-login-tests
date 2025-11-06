package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/** Thread-safe WebDriver factory */
public class DriverManager {

    private static final ThreadLocal<WebDriver> TL_DRIVER = new ThreadLocal<>();
    private static final ThreadLocal<String> TL_BROWSER = new ThreadLocal<>();

    /** Set browser name from TestNG parameter (or default) */
    public static void setBrowser(String browser) {
        TL_BROWSER.set(browser == null ? "chrome" : browser.toLowerCase());
    }

    /** Get current driver instance (create if null) */
    public static WebDriver getDriver() {
        if (TL_DRIVER.get() == null) {
            var browser = TL_BROWSER.get() == null ? "chrome" : TL_BROWSER.get();
            // use ONE style of switch (classic with ':')
            switch (browser) {
                case "firefox":
                    FirefoxOptions fo = new FirefoxOptions();
                    TL_DRIVER.set(new FirefoxDriver(fo));
                    break;
                case "chrome":
                default:
                    ChromeOptions co = new ChromeOptions();
                    // keep it minimal and stable
                    co.addArguments("--disable-gpu");
                    TL_DRIVER.set(new ChromeDriver(co));
                    break;
            }
        }
        return TL_DRIVER.get();
    }

    /** Quit and cleanup */
    public static void quitDriver() {
        if (TL_DRIVER.get() != null) {
            TL_DRIVER.get().quit();
            TL_DRIVER.remove();
            TL_BROWSER.remove();
        }
    }
}