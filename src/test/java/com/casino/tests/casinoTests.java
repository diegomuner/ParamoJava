package com.casino.tests;

import java.time.Duration;
import java.util.Properties;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.casino.helpers.BaseTest;
import com.casino.helpers.SecurePassword;
import com.casino.webpages.CasinoHomePage;
import com.github.javafaker.Faker;

public class CasinoTests extends BaseTest {
// Using Java Faker to generate random data
Faker faker = new Faker();

// Because faker.fullname() returns a String with spaces we remove spaces to use that as an email

// This is declared here so we can use it across multiple tests
// Can also be generated in the webpage class and using a setter and getter return it and store it a variable in this class as well 
String email = ((faker.name().fullName()).replaceAll("\\s+", "").replaceAll("[^a-zA-Z0-9]", "").toLowerCase())+"@gmail.com";
//String password = "SuperSecret123!!";
//String password = SecurePassword.decrypt("vrjEBN270b7efn7/ARHN1rZXQqdwl7LPe0pna/v+pSw=", "ThisTFdsf$testkey");

		@Test
	public void signUp() throws InterruptedException {
		 Properties props = getProps();
		 
		System.out.print("IN THE TEST "+props.getProperty("decryptKey"));
		 
    
		CasinoHomePage home = new CasinoHomePage(driver);
		//Check if the welcome modal is present
		if(home.welcomeText.isDisplayed()) {System.out.println("Welcome modal was displayed");} else {System.out.println("Welcome modal was not displayed" + "\n");}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal__content")));
		//Close modal
		Thread.sleep(2000);
		home.xClose.click();
		home.signUpButton.click();
		//verify signup modal is open
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-test='input-email']")));
		//Fill and submit signup modal
		
		 //home.completeSignUp();

		//Or we can just do it here in the test
	    // send keys to send the Strings declared at the top
		//We could also input wrong information like an email with no @ to validate error messages and that FE validations are in place.
		home.emailField.sendKeys(email);
		home.passwordField.sendKeys(SecurePassword.decrypt(props.getProperty("decryptStr"), props.getProperty("decryptKey")));
		home.passwordField2.sendKeys(SecurePassword.decrypt(props.getProperty("decryptStr"), props.getProperty("decryptKey")));
		//We could potentially also check the endpoint that the FE hits and build a request with bad data to the endpoint and check that there are also BE validations in place.
		home.checkboxOlder.click();
		Thread.sleep(3000);
		home.checkboxNoBonus.click();
		home.createAccount.click();
		Thread.sleep(10000);
		if(home.SuccessText.isDisplayed()) {
			System.out.print("Successfully signed up"+ "\n");
		} else {
			System.out.print("Captcha was displayed"+ "\n");
			// captchas can be resolved by automation as well, and there are many different approaches 
		
			
		}
		
		//Checks that we signed up successfully
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
