package stepDefinitions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MyStepdefs {
    private WebDriver driver;


    @Before
    public void beforeScenario() {

        System.setProperty("webdriver.chrome.driver",
                "/Users/guen/Documents/chrome-driver/chromedriver");

        // Launch Chrome
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1920, 1080));

        // Navigate to Celo
        driver.get("https://stagingapp.celohealth.com");

    }

    @After
    public void tearDown()
    {
        driver.quit();

    }


    @Given("^User logs in to page$")
    public void userLogsin() {

        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        driver.findElement(By.id("login")).click();

    }



    @When("^I login with credentials \"([^\"]*)\" and \"([^\"]*)\"$")
    public void whenILoginWithCredentialsAnd(String userID, String pass) throws Throwable {
        String windowHandle = driver.getWindowHandle();
        driver.switchTo().window(windowHandle);

        WebDriverWait wait = new WebDriverWait(driver,5);

        wait.until(ExpectedConditions.elementToBeClickable(By.id("Username")));
        WebElement element = driver.findElement(By.id("Username"));

        element.sendKeys(userID);
        driver.findElement(By.id("Password")).sendKeys(pass);
        driver.findElement(By.name("button")).click();
    }

    @And("^I enter passcode \"([^\"]*)\"$")
    public void iEnterPasscode(String passcode)  {
        WebDriverWait wait = new WebDriverWait(driver,5);

        String windowHandle = driver.getWindowHandle();
        driver.switchTo().window(windowHandle);
        wait.until(ExpectedConditions.elementToBeClickable(By.name("passcode")));

        WebElement element = driver.findElement(By.name("passcode"));
        element.sendKeys(passcode);
        element.sendKeys(Keys.TAB);
        driver.findElement(By.name("passcodeConfirm")).sendKeys(passcode);
        driver.findElement(By.xpath("//*[contains(text(),'NEXT')]")).click();
    }

    @Then("^I send a text \"([^\"]*)\" to \"([^\"]*)\"$")
    public void iSendATextTo(String message, String recipient) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver,5);
        String windowHandle = driver.getWindowHandle();
        driver.switchTo().window(windowHandle);
        String xpath = "//*[contains(@class, 'name celo-elipsis') and text()='" + recipient +"']";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        driver.findElement(By.xpath(xpath)).click();
        WebElement elemTextArea = driver.findElement(By.xpath("//*[@id=\"celo-send-message-textarea\"]"));
        elemTextArea.sendKeys(message);
        elemTextArea.sendKeys(Keys.ENTER);
    }

    @And("^I log out from the application$")
    public void userLogsOutToApplication() {
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement element = driver.findElement(By.xpath("//*[contains(@class, 'text ng-star-inserted')]"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class, 'text ng-star-inserted')]")));
        element.click();
        element = driver.findElement(By.xpath("//*[text() = 'Log out']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text() = 'Log out']")));
        element.click();

    }
}
