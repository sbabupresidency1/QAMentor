package qa.qamentor.CommonMethods;

import java.io.File;

import org.sikuli.script.*;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

//import com.sun.jna.platform.unix.X11.Screen;
public class Auto {
	public static void main(String[] args) throws IOException, InterruptedException, FindFailed {
		// File firebug_path = new File("D:\\xpipath\\Etihad_Guest_Reward_Card_4.0_glc.xpi");
		File firebug_path = new File("C:\\workspace\\QAmentor\\qamentor\\lib\\etihad_guest_reward_card-2.2-fx.xpi");  
		FirefoxProfile firefoxprofile = new FirefoxProfile();
		firefoxprofile.addExtension(firebug_path);

		WebDriver driver = new FirefoxDriver(firefoxprofile);

		driver.get("http://www.google.com");

		

		String Path = "";
		Screen screen = new Screen();		
		Pattern logo = new Pattern("C:\\workspace\\QAmentor\\QA\\testcases\\UploadFiles\\Download\\QA.png");
		screen.wait(logo, 2000);
		screen.click(logo); 
		
		Pattern x = new Pattern("C:\\workspace\\QAmentor\\QA\\testcases\\UploadFiles\\Download\\X.png");
		screen.wait(x, 2000);
		screen.click(x);
	 
		
		
		
		/*
		Pattern title = new Pattern("C:\\workspace\\QAmentor\\QA\\testcases\\UploadFiles\\Download\\Title.png");
		screen.wait(title, 2000);
		screen.find(screen.userCapture().getFile()).highlight(2);
		String one = screen.toString();
		System.out.println("Value : "+one);*/
		
		
		
		
	
		Pattern username = new Pattern("C:\\workspace\\QAmentor\\QA\\testcases\\UploadFiles\\Download\\Username.png");
		screen.wait(username, 2000);
		screen.type(username, "100013783866");
 
		
		
		
		Pattern password = new Pattern("C:\\workspace\\QAmentor\\QA\\testcases\\UploadFiles\\Download\\Password.png");
		screen.wait(password, 2000);
		screen.type(password, "awPTCesx");
 
		
		
		Pattern captcha = new Pattern("C:\\workspace\\QAmentor\\QA\\testcases\\UploadFiles\\Download\\Captcha.png");
		screen.wait(captcha, 2000);
		screen.click(captcha);
		 
		

		Pattern login = new Pattern("C:\\workspace\\QAmentor\\QA\\testcases\\UploadFiles\\Download\\LoginButton.png");
		screen.wait(login, 4000);
		screen.click(login);
	 
		
		
		
		
		
		




	}
}
