package org.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ObjectRepository {
	
	WebDriver driver;
	public ObjectRepository() {
		
		PageFactory.initElements(driver, this);
	}


	@FindAll({
		@FindBy(id="input-firstname"),
		@FindBy(name="firstname"),
		@FindBy(xpath="(//input[@id='input-firstname'])[1]")
	})
	private WebElement firstname;
	
	@FindAll({
		@FindBy(id="input-lastname"),
		@FindBy(name="lastname"),
		@FindBy(xpath="(//input[@id='input-lastname'])[1]")
	})
	private WebElement lastname;
		
	@FindAll({
		@FindBy(id="input-email"),
		@FindBy(name="email"),
		@FindBy(xpath="(//input[@id='input-email'])[1]")
	})
	private WebElement email;
	
	@FindAll({
		@FindBy(id="input-telephone"),
		@FindBy(name="telephone"),
		@FindBy(xpath="(//input[@id='input-telephone'])[1]")
	})
	private WebElement telephone;
	
	@FindAll({
		@FindBy(id="input-password"),
		@FindBy(name="password"),
		@FindBy(xpath="(//input[@id='input-password'])[1]")
	})
	private WebElement password;
	
	@FindAll({
		@FindBy(id="input-confirm"),
		@FindBy(name="confirm"),
		@FindBy(xpath="(//input[@id='input-confirm'])[1]")
	})
	private WebElement confirmpassword;
	
	@FindAll({
		@FindBy(name="agree"),
		@FindBy(xpath="(//input[@name='agree'])[1]")
	})
	private WebElement policycheckbok;
	
	@FindAll({
		@FindBy(className="btn btn-primary"),
		@FindBy(xpath="//input[@value='Continue']")
	})
	private WebElement continuebtn;
	
	// *****************************************************************************************************
	
	
	public WebElement Fname() {
		return firstname;
	}
	
	public WebElement Lname() {
		return lastname;
	}
	
	public WebElement Email() {
		return email;
	}
	
	public WebElement Telephone() {
		return telephone;
	}
	
	public WebElement Password() {
		return password;
	}
	
	public WebElement Confirmpassword() {
		return confirmpassword;
	}
	
	public WebElement Policycheckbok() {
		return policycheckbok;
	}
	
	public WebElement Continuebtn() {
		return continuebtn;
	}

	

}
