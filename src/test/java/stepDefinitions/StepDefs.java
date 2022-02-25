package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.SchedulePage;

import static org.testng.AssertJUnit.fail;

public class StepDefs {
    private WebDriver driver;


    @Before
    public void initialize(){

        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        driver.get("http://localhost:8080/");

    }
    @After
    public void finish(){
        driver.quit();
    }

    @Given("that I click on add")
    public void add(){
        new SchedulePage(driver).add();
    }

    @Given("that I delete record {string}")
    public void deleteRecord(String recordName){
        new SchedulePage(driver).deleteRecord(recordName);

    }

    @And("that I enter the name {string}")
    public void insertName(String name){
        new SchedulePage(driver).insertName(name);
    }

    @And("fill in your phone as {string}")
    public void insertNumberPhone(String numberPhone){
        new SchedulePage(driver).insertNumberPhone(numberPhone);
    }

    @And("click add to add record")
    public void addRegister(){
        new SchedulePage(driver).addRegister();
        if(new SchedulePage(driver).verify()){
            fail("Registro já existente");
        }
    }

    @Then("registration must be registered {string}")
    public void confirmation(String registro){
        Assert.assertTrue(new SchedulePage(driver).confirmation(registro));


    }

    @Then("the agenda must not be registered with the name {string}")
    public void calendarWithNoRegistration(String name){
        driver.findElement(By.xpath("//*[@id=\"app\"]/table/tbody")).getText().contains(name);

    }
}
