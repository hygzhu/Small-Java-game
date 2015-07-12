import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class YellowEnemy extends GameObject{

private Handler handler;
private HUD hud;
	
	public YellowEnemy(float x, float y, ID id, Handler handler,HUD hud) {
		super(x, y, id);
		this.handler = handler;
		this.hud = hud;

		velX = 3;
		velY = 3;
			
	}

	public Rectangle getBounds(){
		return new Rectangle((int)x,(int)y,16,16);
	}//Collision Boundary

	public void tick() {

		x+= velX;
		y+= velY;
		
		if(y <= 0 || y >= Game.HEIGHT -48) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH -16) velX *= -1;
		//prevents from exiting screen
		
		collision();
	}
	private void collision(){
		for (int i = 0; i< handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.Projectile){ //tempObject is now projectile
				if(getBounds().intersects(tempObject.getBounds())){

					hud.setScore(hud.getScore()+50);
					this.setID(ID.Removed);

				}
				//collision code for porjectiles
			}
			
		}
		
	}


	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.drawRect((int)x,(int) y,  16, 16);
		g.drawImage(LoadImage.yellow, (int)x -312 , (int)y -302, null);
		
	}

}
