package qa.qamentor.commands;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import qa.qamentor.utils.Directory;

public class SikuliActions {
	
	public static void click(String image) throws FindFailed {
		System.out.println("Click Passed");
		String Path = Directory.uploadFilePath+"\\SikuliImages\\"+image;
		Screen screen = new Screen();
		Pattern pattern = new Pattern(Path);
		screen.wait(pattern, 3000);
		screen.click(pattern); 
	}

	public static void type(String image , String Value) throws FindFailed {
		System.out.println("Password Passed");
		String Path = Directory.uploadFilePath+"\\SikuliImages\\"+image;
		Screen screen = new Screen();		
		Pattern pattern = new Pattern(Path);
		screen.wait(pattern, 4000);
		screen.type(pattern, Value); 
		
	}
	
	

}
