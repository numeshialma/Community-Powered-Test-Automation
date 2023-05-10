package pages;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginSteps {
    WebDriver driver=null;
    LoginPage login;
    @Given("browser is opening")
    public void browserIsOpening() {
        System.out.println("Inside Step-browser is open");
        String projectPath=System.getProperty("user.dir");
        System.out.println("Project path is: "+projectPath);
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @And("user is on the login page")
    public void userIsOnTheLoginPage() {
        driver.navigate().to("https://example.testproject.io/web/");
    }

    @When("^user enter (.*) and (.*)$")
    public void userEnterUsernameAndPassword (String username,String password) throws InterruptedException {
        login=new LoginPage(driver);
        login.enterUsername(username);
        login.enterPassword(password);


        driver.findElement(By.id("name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(3000);
    }

    @And("user clicks on login")
    public void userClicksOnLogin() {
        login.clickLogin();
    }

    @Then("user is navigate")
    public void userIsNavigate() throws InterruptedException {
        login.checkLogOutIsDisplayed();
        //driver.findElement(By.id("logout")).isDisplayed();
        Thread.sleep(3000);
        driver.close();
    }
}
