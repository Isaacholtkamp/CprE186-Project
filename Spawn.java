package games_skeletons;

import java.util.Random;

public class Spawn {

	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	
	private int scoreKeep = 0;
	
	public Spawn(Handler handler, HUD hud){
		this.handler = handler;
		this.hud = hud;
		
	}

	public void tick(){
		scoreKeep++;
		
		if(scoreKeep >= 100){
			scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1);
			
		if(hud.getLevel() == 2)	
			{
				handler.addObject(new BasicEnemy(r.nextInt(game.WIDTH),r.nextInt(game.HEIGHT), ID.BasicEnemy, handler));
			}
		else if (hud.getLevel() == 3){
			handler.addObject(new BasicEnemy(r.nextInt(game.WIDTH),r.nextInt(game.HEIGHT), ID.BasicEnemy, handler));
			}
		else if (hud.getLevel()==4){
			handler.addObject(new FastEnemy(r.nextInt(game.WIDTH),r.nextInt(game.HEIGHT), ID.FastEnemy, handler));
		}
		else if (hud.getLevel()==5){
			handler.addObject(new SmartEnemy(r.nextInt(game.WIDTH),r.nextInt(game.HEIGHT), ID.SmartEnemy, handler));
		}
		}
	}
}
