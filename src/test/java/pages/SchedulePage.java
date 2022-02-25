package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class SchedulePage extends BasePage{
    public SchedulePage(WebDriver driver) {
        super(driver);
    }

    public void insertName(String name){
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div[2]/div[2]/input")).sendKeys(name);
    }
    public void insertNumberPhone(String numberPhone){
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div[2]/div[3]/input")).sendKeys(numberPhone);
    }
    public void add(){
        driver.findElement(By.xpath("//*[@id=\"app\"]/button")).click();

    }

    public void deleteRecord(String recordName){
        int i = 2;
        String valueTr;

        if (driver.findElement(By.xpath("//*[@id=\"app\"]/table/tbody")).getText().contains(recordName)){
            while (i < 5){
                valueTr = Integer.toString(i);
                if(driver.findElement(By.xpath("//*[@id=\"app\"]/table/tbody/tr["+valueTr+"]/td[1]")).getText().equals(recordName)){
                    driver.findElement(By.xpath("//*[@id=\"app\"]/table/tbody/tr["+valueTr+"]/td[3]")).click();
                    i = 6;
                }else{
                    i++;
                }
            }
        }
    }
    public void addRegister(){
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div[3]/button[1]")).click();
    }
    public boolean confirmation(String name){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement confirmationElement = driver.findElement(By.xpath("//*[@id=\"app\"]/table/tbody"));
        return confirmationElement.getText().contains(name);

    }

    public Boolean verify(){

        WebElement verifyElement = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div[2]/span"));

        return !verifyElement.getText().isEmpty();
    }

    public boolean confirmationDelete(String name){

        WebElement confirmationElement = driver.findElement(By.xpath("//*[@id=\"app\"]/table/tbody"));
        return !confirmationElement.getText().contains(name);

    }


}
