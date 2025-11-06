package tests;

import driver.DriverManager;
import org.assertj.core.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    private static final Logger LOG = LoggerFactory.getLogger(LoginTests.class);
    private static final String VALID_PASSWORD = "secret_sauce";

    @DataProvider(name = "validUsers", parallel = true)
    public Object[][] validUsers() {
        return new Object[][]{
                {"standard_user"},
                {"problem_user"},
                {"performance_glitch_user"},
                {"visual_user"}
        };
    }

    @Test(description = "UC-1: Empty credentials shows 'Username is required'")
    public void uc1_emptyCredentials() {
        var login = new LoginPage(DriverManager.getDriver()).open(baseUrl())
                .typeUsername("any").typePassword("any")
                .clearUsername().clearPassword();
        login.clickLogin();
        var msg = login.getError().trim();
        LOG.info("UC1 actual error: '{}'", msg);
        Assertions.assertThat(msg)
                .matches("(?i).*username\\s+is\\s+required.*");
    }

    @Test(description = "UC-2: Missing password shows 'Password is required'")
    public void uc2_missingPassword() {
        var login = new LoginPage(DriverManager.getDriver()).open(baseUrl())
                .typeUsername("any").typePassword("any")
                .clearPassword();
        login.clickLogin();
        var msg = login.getError().trim();
        LOG.info("UC2 actual error: '{}'", msg);
        Assertions.assertThat(msg)
                .matches("(?i).*password\\s+is\\s+required.*");
    }

    @Test(dataProvider = "validUsers",
            description = "UC-3: Valid login shows 'Swag Labs' on dashboard")
    public void uc3_validLogin(String user) {
        new LoginPage(DriverManager.getDriver()).open(baseUrl())
                .typeUsername(user)
                .typePassword(VALID_PASSWORD)
                .clickLogin();
        String title = new InventoryPage(DriverManager.getDriver()).getBrowserTitle();
        LOG.info("UC3 title: {}", title);
        Assertions.assertThat(title).isEqualTo("Swag Labs");
    }
}
