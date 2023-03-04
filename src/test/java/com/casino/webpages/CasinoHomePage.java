package com.casino.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CasinoHomePage {
	private WebDriver driver;
	private WebDriverWait wait;

	//@FindBy(css = "a[href='/about/index.htm']")
	//@FindBy(linkText = "Agree")
	//@FindBy(xpath="(//*[@id=\"mainContent\"]/pre/span[16])")
	//@FindBy(id="submitRegister")
	
	
	
	//LOCATORS//
	//WELCOME MODAL
	@FindBy(css = "div.modal__content h3")
	public WebElement welcomeText;
	@FindBy(css = "button.mfp-close")
	public WebElement xClose;
	// SIGN UP BUTTON
	@FindBy(css = "a[data-test='nav-reg-head']")
	 public WebElement signUpButton;
	// SIGN UP MODAL
	@FindBy(css = "input[data-test='input-email']")
	 public WebElement emailField;
	@FindBy(css = "input[data-test='input-password']")
	 public WebElement passwordField;
	@FindBy(css = "input[data-test='input-password_confirmation']")
	 public WebElement passwordField2;
	//checkbox with agree terms and conditions
	@FindBy(css = "label[for='core__protected_modules_user_yiiForm_RegistrationForm_terms_and_conditions']")
	 public WebElement checkboxOlder;
	@FindBy(css = "label[for='bonus-0']")
	 public WebElement checkboxNoBonus;
	@FindBy(css = "button[data-test='control-submit']")
	 public WebElement createAccount;
	
	
	
	
	
	//CLASS CONSTRUCTOR
	public CasinoHomePage(WebDriver driver) {
		
		this.setDriver(driver);
		this.setWebdriverWait(wait);
		// Initialize Elements
		PageFactory.initElements(driver, this);
	 
	}
	
	
	public void completeSignUp() {
		
		emailField.sendKeys("123");
		passwordField.sendKeys("12313");
		checkboxOlder.click();
		checkboxNoBonus.click();
		createAccount.click();
		
	}
	
	
	
	
		
	public WebDriver getDriver() {
		return driver;
			}
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
			}
	public void setWebdriverWait(WebDriverWait wait) {
		this.wait = wait;
			}
	
	
	
	
	
	
	
}
