package gg;
import java.util.*;

public class GG {
    
    // Pokemon Stat Order PokeName, PokeType, level, bHp, bAtk, bSp_Atk, bDef, bSp_def, bSpd
    
    // STARTER POKEMONS
    static Pokemon Bulbasaur = new Pokemon("Bulbasaur", "Grass", 5, 45, 49, 65, 49, 65, 45);
    static Pokemon Charmander = new Pokemon("Charmander", "Fire", 5, 39, 52, 60, 43, 50, 65);
    static Pokemon Squirtle = new Pokemon("Squirtle", "Water", 5, 44, 48, 50, 65, 64, 43);
    
    // SPACE FOR FUTURE POKEMONS
    //--------------------------------------------
    
    
    //--------------------------------------------
    
    
    // Move Stat Order ( MoveName, MoveCategory, MoveType, power, accuracy, pp )
    static Move Tackle = new Move("Tackle", "Physical", "Normal", 40, 100, 35);
    static Move Scratch = new Move("Scratch", "Physical", "Normal", 40, 100, 35);
    static Move VineWhip = new Move("Vine Whip", "Physical", "Grass", 45, 100, 25);
    
   
    //--------------------------------------------
    static Scanner sc = new Scanner (System.in);
    
    //Static Variables
    static boolean isMainMenuRunning = true;
    static boolean inBattle = true;
    static int MainMenuChoice;
    static String mcName;
    static int pokeChoice;
    static Pokemon playerPokemon;
    static Pokemon rivalPokemon;
    static Pokemon wildPokemon;
    
    // Input Validation
    static int getIntInput(){
        while(true){
            try{
            int input = sc.nextInt();
            sc.nextLine();
            return input;
            
            }
            catch (InputMismatchException e) {
            String badInput = sc.nextLine();
            System.out.println("-------------------------------------------------------");
            System.out.println(badInput + " is not a number!");
            System.out.println("Please Try Again!");
            System.out.print("> "); 
        }   
    }
  }
    
    // Empty Name Input Validation
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
    
    // GBA Style
    static void gbaPrint(String text) {
    for (int i = 0; i < text.length(); i++) {
        System.out.print(text.charAt(i));
        try {
            
            Thread.sleep(30); 
        } 
        
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    sc.nextLine(); 
}
    
    // MAIN MENU
    static void MainMenu() {
        
            while(isMainMenuRunning){
            System.out.println("1. Start");
            System.out.println("2. Close");
            System.out.print("Enter your choice: ");
            MainMenuChoice = getIntInput();
            
            switch (MainMenuChoice){
                case 1: mainStory(); 
                            isMainMenuRunning = false;
                break;
                case 2: isMainMenuRunning = false;
                break;
                
                default: 
                    System.out.println("-------------------------------------------------------");
                    System.out.println("Invalid choice! Please try again");
            }
        }
}
    // MAIN STORY
    static void mainStory(){
        
        gbaPrint("Press ENTER to continue the dialogue.");
        gbaPrint("???: Hi, I'm Professor Delamaine");
        gbaPrint("Delamaine: What is your name?");
        System.out.print("Enter your Name: ");
        mcName = getValidName();
        gbaPrint("It's nice to meet you " + mcName);
        
        gbaPrint("Delamaine: Let's not beat around the bush " + mcName + ", you may now finally own your first pokemon");
        gbaPrint("Delamaine: Choose your pokemon");
        
        pokeChoice();
        RenamePokemon();
        
        gbaPrint("Delamaine: Oh! Here comes your cousin");
        gbaPrint("Cousin???: My name's Dwight, although this is the first time we've met I'm actually your cousin!");
        gbaPrint("Delamaine: Dwight, you can now also choose your first pokemon!");
        
        // YOUR RIVAL AUTOMATICALLY CHOOSES A POKEMON THAT COUNTERS YOUR POKEMON
        switch(pokeChoice){
            case 1: System.out.println("Dwight chose " + Squirtle.PokeName + "!");
                        rivalPokemon = Squirtle;
                         break;
            case 2: System.out.println("Dwight chose " + Bulbasaur.PokeName + "!");
                         rivalPokemon = Bulbasaur;
                         break;
            case 3: System.out.println("Dwight chose " + Charmander.PokeName + "!");
                         rivalPokemon = Charmander;
                         break;
        }
        
        System.out.println("Delamaine: my son seems like he wants to battle");
        battle();
    }
    
    static void pokeChoice(){
        boolean isChoosingPokemon = true;
        while(isChoosingPokemon){
                    System.out.println("""
                           1. Charmander
                           2. Squirtle
                           3. Bulbasaur
                           """);
        System.out.print("Choose a pokemon (1-3): ");
        pokeChoice = getIntInput();
        
        switch(pokeChoice){
            case 1: System.out.println("You chose " + Charmander.PokeName + "!");
                        playerPokemon = Charmander;
                        isChoosingPokemon = false;
            break;
            case 2: System.out.println("You chose " + Squirtle.PokeName + "!");
                       playerPokemon = Squirtle;
                       isChoosingPokemon = false;
            break;
            case 3: System.out.println("You chose " + Bulbasaur.PokeName + "!");
                        playerPokemon = Bulbasaur;
                        isChoosingPokemon = false;
            break;
            default: 
                System.out.println("-------------------------------------------------------");
                System.out.println("That's not a pokemon! Please choose again");
          }
        }
    }
    
    static void RenamePokemon(){
        int renameOption;
        String PokemonNewName;
        boolean renameRunning = true;
        
        System.out.println("Do you want to rename your pokemon?");
        System.out.println("1. Yes");
        System.out.println("2. No");
       
        do{
        System.out.print("> ");
        renameOption = getIntInput();
            switch(renameOption){
            case 1:System.out.print("Enter your pokemon's new name: ");
                        PokemonNewName = sc.nextLine();
                        System.out.println("You renamed your pokemon " + PokemonNewName);
                        renameRunning = false;
                        break;
            case 2: System.out.println("You decided not to rename your pokemon" );
                        renameRunning = false;
                        break;
            default: 
                System.out.println("-------------------------------------------------------");
                System.out.println(renameOption +" is not an option!");
          }
        }
        
        while(renameRunning);
        }
    
            static void battle(){
                int battleChoice;
                
                while (inBattle){
                    System.out.println("""
                                       1. Fight
                                       2. Pokemon
                                       3. Bag
                                       4. Run
                                       """);
                    System.out.println("What will you do (1-4)?");
                    System.out.print("> ");
                    battleChoice = getIntInput();
                    
                    switch (battleChoice){
                        case 1: fight();
                                    break;
                        case 2: //SwitchPokemon();
                                    break;
                        case 3: // bag ();
                                    break;
                        case 4: System.out.println("You ran away");
                                    inBattle = false;
                                    break;
                        default: System.out.println("Invalid choice!");   
                    }
                }
            }
            
            static void initializeMoves() {
                
                // Bulbasaur
                Bulbasaur.moves[0] = Tackle;
                Bulbasaur.moves[1] = VineWhip;
                
                // Charmander
                Charmander.moves[0] = Scratch;
                
                // Squirtle
                Squirtle.moves[0] = Tackle;            
            }
            
    static void battle(Pokemon player, Pokemon rival) {
        
        System.out.println("Battle: " + player.PokeName + " vs " + rival.PokeName);    
        
        while(playerPokemon.hp == 0 || rivalPokemon.hp == 0) {
            battle();
        }
      }
    
    static void fight() {
    System.out.println("Choose a move:");
    
    for (int i = 0; i < playerPokemon.moves.length; i++) {
        if (playerPokemon.moves[i] != null) {
            System.out.println((i + 1) + ". " + playerPokemon.moves[i].MoveName);
        }
    }
    
    System.out.print("> ");
    int moveChoice = getIntInput();

    Move selectedMove = playerPokemon.moves[moveChoice - 1];

    System.out.println(playerPokemon.PokeName + " used " + selectedMove.MoveName + "!");
   }
    
        // MAIN 
    public static void main(String[] args) {
        
        initializeMoves();
        MainMenu();
        System.out.println("Thank you");
    }
      }
