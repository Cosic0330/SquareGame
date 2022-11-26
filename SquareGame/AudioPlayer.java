package SquareGame;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Music;
import org.newdawn.slick.Sound;




public class AudioPlayer {

    public static Map<String, Sound> soundMap= new HashMap<>();
    public static Map<String, Music> musicMap=new HashMap<>();
    
    public static void load(){
        try {
            musicMap.put("Zelda", new Music("res/zelda.ogg"));
            soundMap.put("click", new Sound("res/clic.ogg"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Music getMusic(String key){
        return musicMap.get(key);
    }

    public static Sound getSound(String key){
        return soundMap.get(key);
    }
}
