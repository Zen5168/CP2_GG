package gg;
import java.util.*;

public class GG {
    
    public static String performWish(){
        int pityCounter = 0;
        pityCounter++;
        double chance = Math.random();
        
        if (pityCounter>=0){
            pityCounter = 0;
        }
        
        return "4 Star";
    }
    
    public static void main(String[] args) {
        performWish();
    }
    
}
