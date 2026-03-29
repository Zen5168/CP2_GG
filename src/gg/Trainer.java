package gg;

import java.util.*;

class Trainer {
    String name;
    ArrayList<Pokemon> party = new ArrayList<>();
    String winQuote;
    String loseQuote;

    public Trainer(String name, String winQuote, String loseQuote) {
        this.name = name;
        this.winQuote = winQuote;
        this.loseQuote = loseQuote;
    }

    public void addPokemon(Pokemon p) {
        if (party.size() < 6) {
            party.add(p);
        } else {
            System.out.println("Party is full!");
        }
    }
}