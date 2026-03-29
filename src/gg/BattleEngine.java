package gg;

import java.util.Scanner;
import java.util.Random;

public class BattleEngine {

    private Scanner sc = new Scanner(System.in);
    private Random rand = new Random();
    private Trainer player, opponent;
    private Pokemon pActive, oActive;

    public BattleEngine(Trainer player, Trainer opponent) {
        this.player = player;
        this.opponent = opponent;
        if (!player.party.isEmpty()) {
            this.pActive = player.party.get(0);
        }
        if (!opponent.party.isEmpty()) {
            this.oActive = opponent.party.get(0);
        }
    }

    //======================================
    // INPUT VALIDATION
    //======================================
    private int getValidBattleInput(int min, int max) {
        while (true) {
            try {
                System.out.print("> ");
                String inputStr = sc.next();
                int input = Integer.parseInt(inputStr);

                if (input >= min && input <= max) {
                    return input;
                }
                System.out.println("Invalid choice! Please choose between " + min + " and " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("That is not a number! Please try again.");
            }
        }
    }

    //======================================
    // BATTLE OPTIONS
    //======================================
    public void start() {
        if (pActive == null || oActive == null) {
            return;
        }

        System.out.println("\n" + opponent.name + " wants to battle!");

        while (!pActive.isFainted() && !oActive.isFainted()) {
            displayStatus();
            System.out.println("\n1. Fight  \n2. Pokemon  \n3. Bag  \n4. Run");

            int choice = getValidBattleInput(1, 4);

            switch (choice) {
                case 1:
                    handleFightTurn();
                    break;
                case 2:
                    switchPokemon();
                    break;
                case 3:
                    System.out.println("Feature coming soon!");
                    break;
                case 4:
                    System.out.println("Can't escape a trainer battle!");
                    break;

            }
        }

        //======================================
        // BATTLE CONCLUSION
        //======================================
        if (oActive.isFainted()) {
            System.out.println("\n" + oActive.pokeName + " fainted!");
            System.out.println(opponent.name + ": " + opponent.loseQuote);
        } else if (pActive.isFainted()) {
            System.out.println("\n" + pActive.pokeName + " fainted!");
            System.out.println(opponent.name + ": " + opponent.winQuote);
        }
    }

    //======================================
    // HP DISPLAY
    //======================================
    private void displayStatus() {
        System.out.println("\n========================");
        System.out.println(oActive.pokeName + " HP: " + oActive.hp + "/" + oActive.maxHp);
        System.out.println(pActive.pokeName + " HP: " + pActive.hp + "/" + pActive.maxHp);
        System.out.println("========================");
    }

    //======================================
    // FIGHT OPTION
    //======================================
    private void handleFightTurn() {
        System.out.println("Choose a move:");
        int availableMoves = 0;
        for (int i = 0; i < pActive.moves.length; i++) {
            if (pActive.moves[i] != null) {
                System.out.println((i + 1) + ". " + pActive.moves[i].MoveName);
                availableMoves++;
            }
        }

        int mIndex = getValidBattleInput(1, availableMoves) - 1;
        Move pMove = pActive.moves[mIndex];
        Move oMove = getRandomMove(oActive);

        //======================================
        // WHO GOES FIRST?
        //======================================
        if (pActive.speed >= oActive.speed) {
            applyDamage(pActive, oActive, pMove);
            if (!oActive.isFainted() && oMove != null) {
                applyDamage(oActive, pActive, oMove);
            }
        } else {
            if (oMove != null) {
                applyDamage(oActive, pActive, oMove);
            }
            if (!pActive.isFainted()) {
                applyDamage(pActive, oActive, pMove);
            }
        }
    }

    //======================================
    // DAMAGE APPLICATION
    //======================================
    private void applyDamage(Pokemon attacker, Pokemon defender, Move move) {
        int atkStat = move.MoveCategory.equals("Physical") ? attacker.atk : attacker.spAtk;
        int defStat = move.MoveCategory.equals("Physical") ? defender.def : defender.spDef;

        double critMultiplier = 1.0;
        if (rand.nextInt(16) == 0) {
            critMultiplier = 1.5;
            System.out.print("A critical hit! ");
        }

        //======================================
        // DAMAGE CALCULATION
        //======================================
        int damage = (int) (((((2 * attacker.level / 5 + 2) * move.power * atkStat / defStat) / 50) + 2) * critMultiplier);
        defender.takeDamage(damage);

        System.out.println(attacker.pokeName + " used " + move.MoveName + "! (Dealt " + damage + " damage)");
    }

    //======================================
    // RANDOM OPPONENT MOVE
    //======================================
    private Move getRandomMove(Pokemon p) {
        int count = 0;
        for (Move m : p.moves) {
            if (m != null) {
                count++;
            }
        }
        if (count == 0) {
            return null;
        }
        return p.moves[rand.nextInt(count)];
    }

    
    //======================================
    // SWITCH ACTIVE POKEMON
    //======================================
    private void switchPokemon() {
        System.out.println("Choose a Pokemon:");
        for (int i = 0; i < player.party.size(); i++) {
            Pokemon p = player.party.get(i);
            System.out.println((i + 1) + ". " + p.pokeName + " (HP: " + p.hp + "/" + p.maxHp + ")");
        }

        int pick = getValidBattleInput(1, player.party.size()) - 1;
        pActive = player.party.get(pick);
        System.out.println("Go! " + pActive.pokeName + "!");
    }
}
