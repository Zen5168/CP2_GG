package gg;

class Move {

    String MoveName;
    String MoveCategory;
    String MoveType;
    int power;
    int accuracy;
    int pp; // PP is how many times you can use this move and can only be restored through items or pokemon health center

    public Move(String MoveName, String MoveCategory, String MoveType, int power, int accuracy, int pp) {
        this.MoveName = MoveName;
        this.MoveCategory = MoveCategory;
        this.MoveType = MoveType;
        this.power = power;
        this.accuracy = accuracy;
        this.pp = pp;
    }
    //===========================================
    // DAMAGE CALCULATION
    //===========================================
    public static int calculateDamage(Pokemon attacker, Pokemon defender, Move move) {
        double baseDamage;
        if (move.MoveCategory.equals("Physical")) {
            baseDamage = (attacker.atk * move.power) / (double) defender.def;
        } else {
            baseDamage = (attacker.spAtk * move.power) / (double) defender.spDef;
        }
        return (int) (baseDamage / 5) + 2;
    }
}
