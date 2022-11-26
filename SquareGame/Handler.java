package SquareGame;
import java.util.*;
import java.awt.Graphics;

public class Handler {

    LinkedList<GameObject> object = new LinkedList<>();
    
    public void tick(){
        for(int i = 0 ; i<object.size(); i++){
            GameObject temp = object.get(i);
            temp.tick();
        }
    }

    public synchronized void render(Graphics g){
        for(int i = 0; i<object.size(); i++) {
            GameObject temp = object.get(i);
            temp.render(g);
        }
    }

    public void addObject(GameObject object){
        this.object.add(object);
    }

    public void removeObject(GameObject object){
        this.object.remove(object);
    }

    public synchronized void clearEnemies(int val){
        if(val==0){
            object.clear();
        }else{
            while(object.size()>1){
                object.removeLast();
            }
        }
    }
}
