package org.ali.maven.lab11.lab1111;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
	public static void main(String[] args)
	{
		
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");

			  WebDriver driver = new ChromeDriver();
			  try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  // Let the user actually see something!
			  String csvFile = "login.csv";
			  BufferedReader br = null;
		      String line = "";
		      String cvsSplitBy = ",";
			  try {

				  driver.get("http://localhost/lab11ap/index.php");
		            br = new BufferedReader(new FileReader(csvFile));
		            while ((line = br.readLine()) != null) {

		  		      WebElement username = driver.findElement(By.id("user"));
		  			  WebElement password = driver.findElement(By.id("pass"));
		  			  WebElement login = driver.findElement(By.id("login"));
		                // use comma as separator
		                String[] logindata = line.split(cvsSplitBy);
		                username.sendKeys(logindata[0]);
		                password.sendKeys(logindata[1]);
		                login.click();
		                WebElement result = driver.findElement(By.id("sucfail"));
		  			  	System.out.println(result.getText());
				      

		            }

		        } catch (FileNotFoundException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        } finally {
		            if (br != null) {
		                try {
		                    br.close();
		                } catch (IOException e) {
		                    e.printStackTrace();
		                }
		            }
		        }
			  
			  try {
				Thread.sleep(5000);
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  // Let the user actually see something!
			  driver.quit();
	}
}
