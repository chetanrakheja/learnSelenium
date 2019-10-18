package commonLibs.implementation;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import commonLibs.contracts.IScreenshot;

public class ScreenshotControl implements IScreenshot{
	
	private WebDriver driver;
	
	public ScreenshotControl(WebDriver driver){
		this.driver = driver;
	}
	
	@Override
	public void captureAndSaveScreenshot(String filename) throws Exception {
		filename = filename.trim();
		File imgFile,tmpFile;
		imgFile = new File(filename);
		
		if(imgFile.exists()) {
			throw new Exception("File Already Exists ...");
		}
		TakesScreenshot camera;
		camera =(TakesScreenshot) driver;
		
		tmpFile = camera.getScreenshotAs(OutputType.FILE);
		
		FileUtils.moveFile(tmpFile,imgFile);
			
	}

}
