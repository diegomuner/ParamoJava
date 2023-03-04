package com.casino.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.casino.helpers.BaseTest;
import com.casino.webpages.CasinoHomePage;
import com.github.javafaker.Faker;

public class casinoTests extends BaseTest {
// Using Java Faker to generate random data
Faker faker = new Faker();

// Because faker.fullname() returns a String with spaces we remove spaces to use that as an email
String email = ((faker.name().fullName()).replaceAll("\\s+", "").replaceAll("[^a-zA-Z0-9]", "").toLowerCase())+"@something";
String password = "SuperSecret123!!";
	
	
	@Test
	public void signUp() throws InterruptedException {
	

		CasinoHomePage home = new CasinoHomePage(driver);
		//Check if the welcome modal is present
		if(home.welcomeText.isDisplayed()) {System.out.println("Welcome modal was displayed");} else {System.out.println("Welcome modal was not displayed" + "\n");}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
		home.emailField.sendKeys(email);
		home.passwordField.sendKeys(password);
		home.passwordField2.sendKeys(password);
		home.checkboxOlder.click();
		Thread.sleep(3000);
		home.checkboxNoBonus.click();
		home.createAccount.click();
		
		Thread.sleep(10000);
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
