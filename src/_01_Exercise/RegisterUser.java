package _01_Exercise;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import utility.BaseDriver;
import utility.MyFunc;

public class RegisterUser extends BaseDriver {

    @Test
    public void Test1()
    {
        driver.get("http://automationexercise.com");

        String url =driver.getCurrentUrl();
        System.out.println("url = " + url);

        Assert.assertEquals(url, "https://automationexercise.com/");

        WebElement signUpButton= driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
        signUpButton.click();

        WebElement confirmationNewUser= driver.findElement(By.xpath("//h2[text()='New User Signup!']"));

        Assert.assertEquals(confirmationNewUser.getText(), "New User Signup!");

        WebElement name= driver.findElement(By.xpath("//input[@name='name']"));
        name.sendKeys("Cihan");

        WebElement email= driver.findElement(By.xpath("(//input[@name='email'])[2]"));
        email.sendKeys("cihan@gmail.com");

        WebElement signUpButton2= driver.findElement(By.xpath("//button[text()='Signup']"));
        signUpButton2.click();

        WebElement confirmationEnterAccount= driver.findElement(By.xpath("//b[text()='Enter Account Information']"));

        Assert.assertEquals(confirmationEnterAccount.getText(),"ENTER ACCOUNT INFORMATION");

        WebElement gender= driver.findElement(By.id("id_gender1"));
        gender.click();

        WebElement passwordEnter= driver.findElement(By.id("password"));
        passwordEnter.sendKeys("123456");

        WebElement day= driver.findElement(By.id("days"));
        Select daySelect=new Select(day);
        daySelect.selectByValue("23");

        WebElement month= driver.findElement(By.id("months"));
        Select monthSelect=new Select(day);
        monthSelect.selectByValue("5");

        WebElement year= driver.findElement(By.id("years"));
        Select yearSelect=new Select(day);
        yearSelect.selectByIndex(22);

        WebElement checkNewsletter= driver.findElement(By.id("newsletter"));
        checkNewsletter.click();

        WebElement checkOffer= driver.findElement(By.id("optin"));
        checkOffer.click();

        WebElement firstName= driver.findElement(By.id("first_name"));
        firstName.sendKeys("Cihan");

        Actions actions=new Actions(driver);
        Action action=actions.moveToElement(firstName)
                        .click()
                                .keyDown(Keys.TAB)
                                        .keyUp(Keys.TAB)
                                                .sendKeys("kabak")
                                                             .build();
        MyFunc.wait(2);
        action.perform();













       waitAndClose();


    }

}
