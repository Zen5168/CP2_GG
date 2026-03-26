package gg;
import java.util.*;

class Pokemon {
    String PokeName;
    String PokeType;
    int level;
    int maxHp, hp, atk, spAtk, def, spDef,  speed;
    Move [] moves = new Move[4];
    int moveCount = 0;
    // ArrayList<Move> moves = new ArrayList<>();
    
    public Pokemon(String PokeName, String PokeType, int level, int bHP, int bAtk, int bSp_Atk, int bDef, int bSp_def, int bSpd){
        this.PokeName = PokeName;
        this.PokeType = PokeType;
        this.level = level;
        
        // STAT FORMULA PART LOL ;)
        this.maxHp = ((bHP * 2 * level)/ 100) + level + 10;
        this.hp = maxHp;
        this.atk = ((bAtk * 2 * level)/ 100)+ 5;
        this.spAtk = ((bSp_Atk * 2 * level)/ 100)+ 5;
        this.def = ((bDef * 2 * level)/ 100)+ 5;
        this.spDef = ((bSp_def * 2 * level)/ 100)+ 5;
        this.speed = ((bSpd * 2 * level)/ 100)+ 5;
        
    }
}
