package com.harut.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CreerEtSupprimer {
	@Test 
	public void CreeCategorie() throws Exception {
		//Connexion
		System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Actions action = new Actions(driver);
		driver.manage().window().maximize();
		driver.get("http://localhost:7070/share/page/");
		driver.findElement(By.id("page_x002e_components_x002e_slingshot-login_x0023_default-username")).sendKeys("6156613");
		driver.findElement(By.id("page_x002e_components_x002e_slingshot-login_x0023_default-password")).sendKeys("alfresco");
		
		
		//Variable NomCategorier qui contien le nom de la catégorie
		String NomCategorier ="SaisirNom";
		driver.findElement(By.id("page_x002e_components_x002e_slingshot-login_x0023_default-submit-button")).click();
		// Click sur le bouton Outils admin
		driver.findElement(By.xpath("//a[contains(text(),'Outils admin')]")).click();
		Thread.sleep(1000);
		// Click sur le bouton Gestionnaire de catégories
		driver.findElement(By.xpath("//a[contains(text(),'Gestionnaire de catégories')]")).click();
		Thread.sleep(1000);
		// Placer le curseur sur le lien Catégorie racine
		action.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Catégorie racine')]"))).build().perform();
		Thread.sleep(1000);
		// Click sur le bouton en forme (+) Ajouter une catégorie
		driver.findElement(By.xpath("//span[@class='insitu-add-root-category']")).click();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		// S'assurer que la fenêtre avec le nom Ajouter une catégorie est chargéé 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userInput_h")));
		// Saisir le nom de la catégorie dans le champ Nom de la catégorie 
		driver.findElement(By.xpath(
				"//body[contains(@class,'claro js aikau-reveal masked')]/div[contains(@class,'yui-panel-container yui-dialog yui-simple-dialog shadow')]/div[contains(@class,'yui-module yui-overlay yui-panel')]/div[contains(@class,'bd')]/input[1]"))
				.sendKeys(NomCategorier);
		//Click sur le bouton OK
		driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
		Thread.sleep(2000);
		
		
		//Logout
		driver.findElement(By.id("HEADER_USER_MENU_POPUP")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[contains(text(),'Déconnexion')]")).click();
		Thread.sleep(2000);
		driver.quit();

	}

	@Test
	public void SupprimerCategorie() throws Exception {
		//Connexion
		System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Actions action = new Actions(driver);
		driver.manage().window().maximize();
		driver.get("http://localhost:7070/share/page/");
		driver.findElement(By.id("page_x002e_components_x002e_slingshot-login_x0023_default-username")).sendKeys("6156613");
		driver.findElement(By.id("page_x002e_components_x002e_slingshot-login_x0023_default-password")).sendKeys("alfresco");
		driver.findElement(By.id("page_x002e_components_x002e_slingshot-login_x0023_default-submit-button")).click();
		
		
		//Variable NomCategorier qui contien le nom de la catégorie
		String NomCategorier ="SaisirNom";
		// Click sur le bouton Outils admin
		driver.findElement(By.xpath("//a[contains(text(),'Outils admin')]")).click();
		Thread.sleep(1000);
		// Click sur le bouton Gestionnaire de catégories
		driver.findElement(By.xpath("//a[contains(text(),'Gestionnaire de catégories')]")).click();
		Thread.sleep(1000);
		// Placer le curseur sur le bouton avec le nom de la catégorie à supprimer
		action.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'"+NomCategorier+"')]"))).build()
				.perform();
		Thread.sleep(1000);
		// Click sur le bouton en forme (X) Supprimer la catégorie
		driver.findElement(
				By.xpath("//span[contains(text(),'"+NomCategorier+"')]//span[contains(@class,'insitu-delete-category')]"))
				.click();
		// S'assurer que la fenêtre avec le nom Supprimer la catégorie est chargéé 
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("prompt_h")));
		//Click sur le bouton Supprimer
		driver.findElement(By.xpath("//span[@class='first-child']//button[contains(text(),'Supprimer')]")).click();
		Thread.sleep(2000);
		
		
		//Logout
		driver.findElement(By.id("HEADER_USER_MENU_POPUP")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[contains(text(),'Déconnexion')]")).click();
		Thread.sleep(2000);
		driver.quit();

	}

}
