import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class LoadImage implements Runnable {

	
static BufferedImage yellow, doge = null;	

	
public static void initialize() {
	
	try {
	    yellow = ImageIO.read(new File("Images//yellow.png"));
	    doge = ImageIO.read(new File("Images//doge.png")); 
		} catch (IOException e) {
		}	
		
}


	public void run() {
	
		
	}	
	
}
