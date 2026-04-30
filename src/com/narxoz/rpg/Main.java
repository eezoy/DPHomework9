package com.narxoz.rpg;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.vault.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Homework 9 Demo: Visitor + Memento ===");

        Hero warrior = new Hero("Arthur", 150, 30, 20, 15, 100, null);
        Hero mage = new Hero("Dumbledore", 80, 120, 10,  5, 200, null);

        List<Hero> party = Arrays.asList(warrior, mage);

        System.out.println("--- Party entering the vault ---");
        for (Hero hero : party) System.out.println("  " + hero);
        
        ChronomancerEngine engine = new ChronomancerEngine();
        VaultRunResult result = engine.runVault(party);

        System.out.println("--- Party after rewind ---");
        for (Hero hero : party) System.out.println("  " + hero);
        
        System.out.println("=== Vault Run Complete ===");
        System.out.println(result);
    }
}
