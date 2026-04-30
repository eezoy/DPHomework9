package com.narxoz.rpg.vault;

import com.narxoz.rpg.artifact.*;
import com.narxoz.rpg.combatant.*;
import com.narxoz.rpg.memento.Caretaker;
import com.narxoz.rpg.visitor.*;
import java.util.*;

public class ChronomancerEngine {

    public VaultRunResult runVault(List<Hero> party) {
        System.out.println("\n=== Entering the Chronomancer's Vault ===\n");

        Inventory vaultInventory = new Inventory();
        vaultInventory.addArtifact(new Weapon("Shadow Blade",   120, 8, 12));
        vaultInventory.addArtifact(new Potion("Elixir of Life",  50, 1, 80));
        vaultInventory.addArtifact(new Scroll("Scroll of Doom",  90, 1, "Doom"));
        vaultInventory.addArtifact(new Ring("Ring of Eternity", 200, 1, 10));
        vaultInventory.addArtifact(new Armor("Dragonscale Mail",150, 15,  6));

        int artifactsAppraised = vaultInventory.size();

        System.out.println("--- Appraisal: Gold Value ---");
        GoldAppraiser goldAppraiser = new GoldAppraiser();
        vaultInventory.accept(goldAppraiser);
        System.out.println("  Total vault value: " + goldAppraiser.getTotalValue() + "g\n");

        System.out.println("--- Appraisal: Enchantment Scan ---");
        EnchantmentScanner enchantmentScanner = new EnchantmentScanner();
        vaultInventory.accept(enchantmentScanner);
        System.out.println("  Enchanted items found: " + enchantmentScanner.getEnchantedCount() + "\n");

        System.out.println("--- Appraisal: Curse Detection ---");
        CurseDetector curseDetector = new CurseDetector();
        vaultInventory.accept(curseDetector);
        System.out.println("  Cursed items found: " + curseDetector.getCursedCount() + "\n");

        System.out.println("--- Appraisal: Weight Calculation (open/closed proof) ---");
        WeightCalculator weightCalculator = new WeightCalculator();
        vaultInventory.accept(weightCalculator);
        System.out.println("  Total carry weight: " + weightCalculator.getTotalWeight() + " kg\n");

        Caretaker caretaker = new Caretaker();
        for (Hero hero : party) {
            System.out.println("[Memento] Saving snapshot for " + hero.getName() + " -> HP=" + hero.getHp() + ", Mana=" + hero.getMana() + ", Gold=" + hero.getGold());
            caretaker.save(hero.createMemento());
        }

        int mementosCreated = caretaker.size();
        System.out.println();

        System.out.println("--- Vault Event: Ancient Curse Activated! ---");
        for (Hero hero : party) {
            hero.takeDamage(40);
            hero.spendMana(30);
            System.out.println("  " + hero.getName() + " after trap -> HP=" + hero.getHp() + ", Mana=" + hero.getMana() + ", Gold=" + hero.getGold());
        }
        System.out.println();

        System.out.println("--- Chronomancer activates Time Crystal: Rewinding! ---");
        int restoredCount = 0;
        for (int i = party.size() - 1; i >= 0; i--) {
            HeroMemento memento = caretaker.undo();
            if (memento != null) {
                party.get(i).restoreFromMemento(memento);
                restoredCount++;
                System.out.println("[Rewind] " + party.get(i).getName() + " restored -> HP=" + party.get(i).getHp() + ", Mana=" + party.get(i).getMana() + ", Gold=" + party.get(i).getGold());
            }
        }
        System.out.println();

        return new VaultRunResult(artifactsAppraised, mementosCreated, restoredCount);
    }
}
