package games_skeletons;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject {

		Random r = new Random();
		Handler handler;
		
		public Player(int x, int y, ID id, Handler handler){
			super(x, y, id);
			this.handler = handler;
		
		}

		public Rectangle getBounds(){
			return new Rectangle((int)x, (int)y, 32, 32);
		}
		public void tick(){
			x += velX;
			y += velY;
			
			x = game.clamp((int)x,  0, game.WIDTH - 46);
			y = game.clamp((int)y,  0, game.HEIGHT - 68);
			
			handler.addObject(new Trail(x, y, ID.Trail, Color.white, 32, 32, .1f, handler));
			
			collision();
		}
		
		private void collision(){
			for(int i = 0; i <handler.object.size(); i++){
				GameObject tempObject = handler.object.get(i);
				
				if (tempObject.getID()== ID.BasicEnemy || tempObject.getID() == ID.FastEnemy || tempObject.getID() == ID.SmartEnemy){
					if(getBounds().intersects(tempObject.getBounds())){
						HUD.HEALTH -= 2;
					}
				}
			}
		}
		
		public void render(Graphics g){
		
			g.setColor(Color.white);
			g.fillRect((int)x, (int)y, 32, 32);
		}
		
		
}
 