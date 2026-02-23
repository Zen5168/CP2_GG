package gg;
import java.util.*;

public class GG {
      
    static Scanner sc = new Scanner (System.in);
    static boolean isMainMenuRunning = true;
    static boolean isChoosingPokemon = true;
    static int MainMenuChoice;
    static String mcName;
    
    // MAIN 
    public static void main(String[] args) {
        
        MainMenu();
        System.out.println("Thank you");
    }
    
    // MAIN MENU
    static void MainMenu() {
        
            while(isMainMenuRunning){
            System.out.println("1. Start");
            System.out.println("2. Close");
            System.out.print("Enter your choice: ");
            MainMenuChoice = sc.nextInt();
            sc.nextLine();
            
            switch (MainMenuChoice){
                case 1: mainStory(); 
                            isMainMenuRunning = false;
                break;
                case 2: isMainMenuRunning = false;
                break;
                default: System.out.println("Invalid choice! Please try again");
            }
        }
}
    // MAIN STORY
    static void mainStory(){
        
        
        
        System.out.println("???: Hi, I'm Professor Delamaine");
        System.out.println("Delamaine: What is your name?");
        System.out.print("Enter your Name: ");
        mcName = sc.nextLine();
        System.out.println("It's nice to meet you " + mcName);
        System.out.println("Delamaine: Let's not beat around the bush " + mcName + ", you may now finally own your first pokemon");
        System.out.println("Delamaine: Choose your pokemon");
        
        pokeChoice();
        
        
     
    }
    
    static void pokeChoice(){
        int pokeChoice;
        while(isChoosingPokemon){
                    System.out.println("""
                           1. Charmander
                           2. Squirtle
                           3? Bulbasaur
                           """);
        System.out.print("Choose a pokemon (1-3): ");
        pokeChoice = sc.nextInt();
        
        switch(pokeChoice){
            case 1: System.out.println("You chose Charmander!");
                        isChoosingPokemon = false;
            break;
            case 2: System.out.println("You chose Squirtle!");
                       isChoosingPokemon = false;
            break;
            case 3: System.out.println("You chose Bulbasaur!");
                        isChoosingPokemon = false;
            break;
            default: System.out.println("That's not a pokemon! Please choose again");
        }
        }
    }
}