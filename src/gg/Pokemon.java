package gg;
import java.util.*;

class Pokemon {
    String PokeName;
    String PokeType;
    int level;
    int maxHp, hp, attack, spAttack, defense, spDefense,  speed;
    ArrayList<Move> moves = new ArrayList<>();
    
    public Pokemon(String PokeName, String PokeType, int level, int bHP, int bAtk, int bSp_Atk, int bDef, int bSp_def,  int bSpd){
        this.PokeName = PokeName;
        this.PokeType = PokeType;
        this.level = level;
        
        //STAT FORMULA PART LOL ;)
        this.maxHp = ((bHP * 2 * level)/ 100) + 5;
        this.hp = maxHp;
        this.attack = ((bAtk * 2 * level)/ 100)+ 5;
        this.spAttack = ((bSp_Atk * 2 * level)/ 100)+ 5;
        this.defense = ((bDef * 2 * level)/ 100)+ 5;
        this.spDefense = ((bSp_def * 2 * level)/ 100)+ 5;
        this.speed = ((bSpd * 2 * level)/ 100)+ 5;
    }
    // PLANNING TO ADD DMG CALCULATION NEXT
    
}
