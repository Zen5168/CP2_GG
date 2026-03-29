package gg;

import java.util.*;

public class GG {

    //===========================================
    // STARTER POKEMONS
    //===========================================
    // Pokemon Stat Order pokeName, pokeType, level, bHp, bAtk, bSp_Atk, bDef, bSp_def, bSpd
    static Pokemon Bulbasaur = new Pokemon("Bulbasaur", "Grass", 5, 45, 49, 65, 49, 65, 45);
    static Pokemon Charmander = new Pokemon("Charmander", "Fire", 5, 39, 52, 60, 43, 50, 65);
    static Pokemon Squirtle = new Pokemon("Squirtle", "Water", 5, 44, 48, 50, 65, 64, 43);

    //===========================================
    // SPACE FOR FUTURE POKEMONS
    //===========================================
    // || PLACEHOLDER ||
    //===========================================
    // POKEMON MOVES
    //===========================================
    // Move Stat Order ( MoveName, MoveCategory, MoveType, power, accuracy, pp )
    static Move Tackle = new Move("Tackle", "Physical", "Normal", 40, 100, 35);
    static Move Scratch = new Move("Scratch", "Physical", "Normal", 40, 100, 35);
    static Move VineWhip = new Move("Vine Whip", "Physical", "Grass", 45, 100, 25);

    //===========================================
    // TRAINERS
    //===========================================
    //===========================================
    // SCANNER
    //===========================================
    static Scanner sc = new Scanner(System.in);

    //===========================================
    // VARIABLES
    //===========================================
    static boolean isMainMenuRunning = true;
    static boolean inBattle = true;
    static int MainMenuChoice;
    static String mcName;
    static int pokeChoice;
    static Pokemon wildPokemon;
    static Trainer player;
    static Trainer rival;
    static Pokemon playerActive;
    static Pokemon rivalActive;

    //===========================================
    // INPUT VALIDATION
    //===========================================
    public static int getIntInput() {
        while (true) {
            try {
                int input = sc.nextInt();
                sc.nextLine();
                return input;

            } catch (InputMismatchException e) {
                String badInput = sc.nextLine();
                System.out.println("-------------------------------------------------------");
                System.out.println(badInput + " is not a number!");
                System.out.println("Please Try Again!");
                System.out.print("> ");
            }
        }
    }

    //===========================================
    // EMPTY INPUT VALIDATION
    //===========================================
    static String getValidName() {
        while (true) {
            String input = sc.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("-------------------------------------------------------");
                System.out.println("You can't possibly be nameless!");
                System.out.print("Please enter a valid name: ");
            } else {
                return input;
            }
        }
    }

    //===========================================
    // GBA STYLE
    //===========================================
    static void gbaPrint(String text) {
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            try {

                Thread.sleep(0);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        sc.nextLine();
    }

    //===========================================
    // MAIN MENU
    //===========================================
    static void MainMenu() {

        while (isMainMenuRunning) {
            System.out.println("1. Start");
            System.out.println("2. Close");
            System.out.print("Enter your choice: ");
            MainMenuChoice = getIntInput();

            switch (MainMenuChoice) {
                case 1:
                    mainStory();
                    isMainMenuRunning = false;
                    break;
                case 2:
                    isMainMenuRunning = false;
                    break;

                default:
                    System.out.println("-------------------------------------------------------");
                    System.out.println("Invalid choice! Please try again");
            }
        }
    }

    //===========================================
    // MAIN STORY
    //===========================================
    static void mainStory() {

        System.out.println("");
        gbaPrint("Press ENTER to continue the dialogue.");
        System.out.println("");
        gbaPrint("???: Hi, I'm Professor Delamaine");
        gbaPrint("Delamaine: What is your name?");
        System.out.print("Enter your Name: ");
        mcName = getValidName();

        player = new Trainer(mcName, "I'm the best!", "I need to train more...");
        rival = new Trainer("Dwight", "Calculated victory.", "How did I lose?");

        gbaPrint("Delamaine: It's nice to meet you " + mcName);
        gbaPrint("Delamaine: Let's not beat around the bush " + mcName + ", you may now finally own your first pokemon");
        gbaPrint("Delamaine: Choose your pokemon");

        pokeChoice();
        playerActive = player.party.get(0);

        RenamePokemon();

        gbaPrint("Delamaine: Oh! Here comes your cousin");
        gbaPrint("Cousin???: My name's Dwight, although this is the first time we've met I'm actually your cousin!");
        gbaPrint("Delamaine: Dwight, you can now also choose your first pokemon!");

        // YOUR RIVAL AUTOMATICALLY CHOOSES A POKEMON
        // THAT COUNTERS YOUR  STARTER POKEMON'S TYPE
        switch (pokeChoice) {
            case 1:
                gbaPrint("Dwight chose " + Squirtle.pokeName + "!");
                rival.addPokemon(Squirtle);
                break;
            case 2:
                gbaPrint("Dwight chose " + Bulbasaur.pokeName + "!");
                rival.addPokemon(Bulbasaur);
                break;
            case 3:
                gbaPrint("Dwight chose " + Charmander.pokeName + "!");
                rival.addPokemon(Charmander);
                break;
        }

        rivalActive = rival.party.get(0);

        gbaPrint("Delamaine: my son seems like he wants to battle");
        BattleEngine engine = new BattleEngine(player, rival);
        engine.start();
    }

    //===========================================
    // CHOOSING STARTER POKEON
    //===========================================
    static void pokeChoice() {
        boolean isChoosingPokemon = true;
        while (isChoosingPokemon) {
            System.out.println("""
                           1. Charmander
                           2. Squirtle
                           3. Bulbasaur
                           """);
            System.out.print("Choose a pokemon (1-3): ");
            pokeChoice = getIntInput();

            switch (pokeChoice) {
                case 1:
                    gbaPrint("You chose " + Charmander.pokeName + "!");
                    player.addPokemon(Charmander);
                    isChoosingPokemon = false;
                    break;
                case 2:
                    gbaPrint("You chose " + Squirtle.pokeName + "!");
                    player.addPokemon(Squirtle);
                    isChoosingPokemon = false;
                    break;
                case 3:
                    gbaPrint("You chose " + Bulbasaur.pokeName + "!");
                    player.addPokemon(Bulbasaur);
                    isChoosingPokemon = false;
                    break;
                default:
                    System.out.println("-------------------------------------------------------");
                    System.out.println("That's not a pokemon! Please choose again");
            }
        }
    }

    //===========================================
    // RENAME POKEMON
    //===========================================
    static void RenamePokemon() {
        int renameOption;
        String PokemonNewName;
        boolean renameRunning = true;

        System.out.println("Do you want to rename your pokemon?");
        System.out.println("1. Yes");
        System.out.println("2. No");

        do {
            System.out.print("> ");
            renameOption = getIntInput();
            switch (renameOption) {
                case 1:
                    System.out.print("Enter your pokemon's new name: ");
                    String newName = sc.nextLine();
                    player.party.get(0).pokeName = newName;
                    gbaPrint("You renamed your pokemon " + newName);
                    renameRunning = false;
                    break;
                case 2:
                    System.out.println("You decided not to rename your pokemon");
                    renameRunning = false;
                    break;
                default:
                    System.out.println("-------------------------------------------------------");
                    System.out.println(renameOption + " is not an option!");
            }

        } while (renameRunning);
    }

    //===========================================
    // INITIALIZE MOVES
    //===========================================
    static void initializeMoves() {

        // Bulbasaur
        Bulbasaur.moves[0] = Tackle;
        Bulbasaur.moves[1] = VineWhip;

        // Charmander
        Charmander.moves[0] = Scratch;

        // Squirtle
        Squirtle.moves[0] = Tackle;
    }

    //===========================================
    // MAIN 
    //===========================================
    public static void main(String[] args) {

        initializeMoves();
        MainMenu();
        System.out.println("Thank you");
    }
}
