package SquareGame;
import java.util.Random;

public class Spawn {
    private Handler handler;
    private HUD hud;
    private int scoreKeeper=0;
    private int limit=300;
    private Random r=new Random();


    public Spawn (Handler handler, HUD hud){
        this.handler=handler;
        this.hud=hud;
    }


    public void tick(){
        scoreKeeper++;
        System.out.println(limit);
        if(scoreKeeper>=limit){
            scoreKeeper=0;
            hud.setLvl(hud.getLvl()+1);
           if(hud.getLvl()==1){
                handler.addObject(new BigEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BigEnemy, handler));
            }else if(hud.getLvl()==2){
                handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.SmartEnemy, handler));
            }else if(hud.getLvl()==3){
                handler.addObject(new LifeBooster(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.LifeBooster, handler));
                handler.addObject(new BigEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BigEnemy, handler));
            }else if(hud.getLvl()==4){
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
            }else if(hud.getLvl()==5){
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
            }else if(hud.getLvl()==6){
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
            }else if(hud.getLvl()==7){
                handler.addObject(new LifeBooster(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.LifeBooster, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.FastEnemy, handler));
            }else if(hud.getLvl()==8){
                handler.addObject(new BigEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BigEnemy, handler)); 
            }else if(hud.getLvl()==9){
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));           
            }else if(hud.getLvl()==10){
                handler.clearEnemies(1);
                handler.addObject(new Boss1Enemy((Game.WIDTH/2)-48, -64, ID.Boss1Enemy, handler));
                limit=1000;
            }else if(hud.getLvl()==11){
                limit=400;
                handler.clearEnemies(1);
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.FastEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.FastEnemy, handler));
            }else if(hud.getLvl()==12){
                handler.addObject(new SmartFastEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.SmartFastEnemy, handler));
            }else if(hud.getLvl()==13){
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
            }else if(hud.getLvl()==14){
                handler.addObject(new BigEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BigEnemy, handler));
            }else if(hud.getLvl()==15){
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
                handler.addObject(new LifeBooster(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.LifeBooster, handler));
            }else if(hud.getLvl()==16){
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.FastEnemy, handler));
            }else if(hud.getLvl()==17){
                handler.addObject(new BigEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BigEnemy, handler));
            }else if(hud.getLvl()==18){
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
            }else if(hud.getLvl()==19){
                handler.addObject(new LifeBooster(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.LifeBooster, handler));
                handler.addObject(new LifeBooster(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.LifeBooster, handler));
            }else if(hud.getLvl()==400){
                handler.clearEnemies(1);
                handler.addObject(new Boss2Enemy((Game.WIDTH/2)-48, -64, ID.Boss1Enemy, handler));
                limit=100000;
            }
        }

        
    }
    
}
