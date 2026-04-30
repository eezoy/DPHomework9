package com.narxoz.rpg.visitor;

import com.narxoz.rpg.artifact.Armor;
import com.narxoz.rpg.artifact.ArtifactVisitor;
import com.narxoz.rpg.artifact.Potion;
import com.narxoz.rpg.artifact.Ring;
import com.narxoz.rpg.artifact.Scroll;
import com.narxoz.rpg.artifact.Weapon;

/**
 * Visitor that scans artifacts for magical properties.
 *
 * Rings and scrolls are considered strongly enchanted.
 * Weapons with a high attack bonus show traces of magic.
 * Potions and armor without bonus stats are flagged as mundane.
 */
public class EnchantmentScanner implements ArtifactVisitor {

    private int enchantedCount;

    public EnchantmentScanner() {
        this.enchantedCount = 0;
    }

    public int getEnchantedCount() {
        return enchantedCount;
    }

    @Override
    public void visit(Weapon weapon) {
        if (weapon.getAttackBonus() >= 5) {
            enchantedCount++;
            System.out.println("  Enchant: Weapon  '" + weapon.getName() + "' -> ENCHANTED (attack bonus: " + weapon.getAttackBonus() + ")");
        } else {
            System.out.println("  Enchant: Weapon  '" + weapon.getName() + "' -> mundane");
        }
    }

    @Override
    public void visit(Potion potion) {
        System.out.println("  Enchant: Potion  '" + potion.getName() + "' -> alchemical, not enchanted");
    }

    @Override
    public void visit(Scroll scroll) {
        enchantedCount++;
        System.out.println("  Enchant: Scroll  '" + scroll.getName() + "' -> ENCHANTED (spell: " + scroll.getSpellName() + ")");
    }

    @Override
    public void visit(Ring ring) {
        enchantedCount++;
        System.out.println("  Enchant: Ring    '" + ring.getName() + "' -> ENCHANTED (magic bonus: " + ring.getMagicBonus() + ")");
    }

    @Override
    public void visit(Armor armor) {
        if (armor.getDefenseBonus() >= 5) {
            enchantedCount++;
            System.out.println("  Enchant: Armor   '" + armor.getName() + "' -> ENCHANTED (defense bonus: " + armor.getDefenseBonus() + ")");
        } else {
            System.out.println("  Enchant: Armor   '" + armor.getName() + "' -> mundane");
        }
    }
}
