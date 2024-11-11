package com.Enfin.TestCases;

import java.io.IOException;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.Enfin.testBase.TestBase;

public class Testcase extends TestBase {

	@Test
	public void createTable() throws IOException, InterruptedException {

		log.debug("Todo CreateTable");
		WebElement platformLaunch = driver.findElement(By.xpath(ObjectRepository.getProperty("PlatformLaunch")));
		platformLaunch.click();

		log.debug("Platform Launched Clicked!!!!");
		CaptureScreenShot();

		WebElement createNewTask = driver.findElement(By.xpath(ObjectRepository.getProperty("CreateNewTask")));
		createNewTask.click();
		log.debug("Create New Task Clicked");

		WebElement Title = driver.findElement(By.name(ObjectRepository.getProperty("Title")));
		Title.sendKeys("Task1");
		log.debug("Create New Task Clicked");

		WebElement Description = driver.findElement(By.name(ObjectRepository.getProperty("Description")));
		Description.sendKeys("This is a Sample Task for Dialog Box handling");
		log.debug("Description Entered!!!");

		WebElement toDo = driver.findElement(By.xpath(ObjectRepository.getProperty("toDo")));
		toDo.sendKeys("Checklist");
		log.debug("Checklist Entered!!!");

		WebElement addList = driver.findElement(By.xpath(ObjectRepository.getProperty("addList")));
		addList.click();
		log.debug("CheckList Added!!!");

		WebElement Newtodo = driver.findElement(By.xpath(ObjectRepository.getProperty("Newtodo")));
		Newtodo.sendKeys("Checklist2");
		log.debug("New Checklist Created!!!");

		WebElement newTodoAdd = driver.findElement(By.xpath(ObjectRepository.getProperty("newTodoAdd")));
		newTodoAdd.click();
		log.debug("New Task Added!!!");

		WebElement deleteChecklist2 = driver.findElement(By.xpath(ObjectRepository.getProperty("deleteCheckList2")));
		deleteChecklist2.click();
		log.debug("CheckList2 Deleted!!!");
		
		WebElement selectDropDown = driver.findElement(By.xpath(ObjectRepository.getProperty("selectColumn")));
		selectDropDown.click();
		log.debug("DropDown Clicked!!!");
		
		WebElement dropdownlist = driver.findElement(By.xpath(ObjectRepository.getProperty("dropdownlist")));
		CaptureScreenShot();
		
		List<WebElement> options = driver.findElements(By.xpath("//ul[@id=':r6:']"));
		for (int i = 0; i < options.size(); i++) {

			System.out.println(options.get(i).getText());

			if (options.get(i).getText().contains("Doing")) {
				options.get(i).click();
				break;
			}
		}
		log.debug("Dropdown Selected!!!");
		CaptureScreenShot();
		
		WebElement SubmitButton= driver.findElement(By.xpath(ObjectRepository.getProperty("CreateSubmit")));
		SubmitButton.click();
		log.debug("New Task Created");
		CaptureScreenShot();
		
		WebElement draggble= driver.findElement(By.xpath(ObjectRepository.getProperty("drag")));
		WebElement drop=driver.findElement(By.xpath(ObjectRepository.getProperty("drop")));
		Actions action= new Actions(driver);
		action.dragAndDrop(draggble, drop);
		
		
		
		WebElement Toggle= driver.findElement(By.xpath(ObjectRepository.getProperty("toggle")));
		Toggle.click();
		log.debug("Background Changed to white!!!");
		CaptureScreenShot();

	}
}
