package elitecareer.framework.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
	//WebDriver driver;
	
	public String getPageTitle(WebDriver driver){
		String title = driver.getTitle();
		return title;
	}
	
	public String getElementByName(WebDriver driver, String folderName){
		String elementName = null;
		List <WebElement> allFolders = driver.findElements(By.id("facebook_header"));
		for(int i=0; i<allFolders.size(); i++){
			if(allFolders.get(i).getText().equalsIgnoreCase(folderName)){
				elementName = allFolders.get(i).getText();
			}
		}
		return elementName;
	}
	
	public String getErrorMessageByValue(WebDriver driver, String errorMessage){
		String elementName = null;
		List <WebElement> allFolders = driver.findElements(By.id("error"));
		for(int i=0; i<allFolders.size(); i++){
			if(allFolders.get(i).getText().equalsIgnoreCase(errorMessage)){
				elementName = allFolders.get(i).getText();
			}
		}
		return elementName;
	}
	
	public boolean verifyCurrentUrlSuffix(WebDriver driver, String suffix){
		return driver.getCurrentUrl().endsWith(suffix);
	}
	
	public void selectFromDropdownList(WebElement element, String value){
		new Select(element).selectByVisibleText(value);
	}
	
	public void goToPreviousPage(WebDriver driver){
		driver.navigate().back();
	}
	
	public void mouseOver(WebDriver driver, WebElement element){
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}
	
	public void pageRefresh(WebDriver driver){
		driver.navigate().refresh();
	}
	
	public Integer convertStringToInteger(String stringData){
		int integerValue = Integer.parseInt(stringData);
		return integerValue;
	}

	public String convertIntegerToString(Integer integerValue){
		String newString = String.valueOf(integerValue);
		return newString;
	}
	
	public static String getExcelCellData(String excelFilePath, String excelSheetName, int row, int column, String dataType) throws InvalidFormatException, IOException{
		FileInputStream fis = new FileInputStream(excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(excelSheetName);
		String value = null;
		if(dataType.equalsIgnoreCase("s")){
			value = sh.getRow(row).getCell(column).getStringCellValue();
		}else if(dataType.equalsIgnoreCase("i")){
			value = String.valueOf((int) sh.getRow(row).getCell(column).getNumericCellValue());
		}
		return value;
	}
}
