package gg;

public class Pokemon {
  
    protected String pokeName; 
    protected String type;
    protected int hp, maxHp, atk, def, spAtk, spDef, speed, level;
    protected Move[] moves = new Move[4];

    public Pokemon(String name, String type, int level, int hp, int atk, int spAtk, int def, int spDef, int speed) {
        this.pokeName = name;
        this.type = type;
        this.level = level;
        this.hp = hp;
        this.maxHp = hp;
        this.atk = atk;
        this.spAtk = spAtk;
        this.def = def;
        this.spDef = spDef;
        this.speed = speed;
    }

    public void takeDamage(int damage) {
        this.hp = Math.max(0, this.hp - damage);
    }

    public boolean isFainted() {
        return hp <= 0;
    }
}