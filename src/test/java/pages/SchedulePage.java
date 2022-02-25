package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SchedulePage extends BasePage{
    public SchedulePage(WebDriver driver) {
        super(driver);
    }

    public SchedulePage insertName(String name){
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div[2]/div[2]/input")).sendKeys(name);
        return this;
    }
    public SchedulePage insertNumberPhone(String numberPhone){
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div[2]/div[3]/input")).sendKeys(numberPhone);
        return this;
    }
    public SchedulePage add(){
        driver.findElement(By.xpath("//*[@id=\"app\"]/button")).click();
        return this;

    }

    public SchedulePage deleteRecord(String recordName){
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
        return this;
    }
    public SchedulePage addRegister(){
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div[3]/button[1]")).click();
        return this;
    }
    public boolean confirmation(String name){

        WebElement confirmationElement = driver.findElement(By.xpath("//*[@id=\"app\"]/table/tbody"));
        if(confirmationElement.getText().contains(name)){
            return true;
        }else {
            return false;
        }

    }

    public Boolean verify(){

        WebElement verifyElement = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div[2]/span"));

        if(verifyElement.getText().isEmpty()){
            return false;
        }else {
            return true;
        }
    }

    public boolean confirmationDelete(String name){

        WebElement confirmationElement = driver.findElement(By.xpath("//*[@id=\"app\"]/table/tbody"));
        return !confirmationElement.getText().contains(name);

    }


}
