package com.narxoz.rpg.visitor;

import com.narxoz.rpg.artifact.*;

public class CurseDetector implements ArtifactVisitor {

    private int cursedCount;

    public CurseDetector() {
        this.cursedCount = 0;
    }

    public int getCursedCount() {
        return cursedCount;
    }

    @Override
    public void visit(Weapon weapon) {
        if (weapon.getAttackBonus() >= 10) {
            cursedCount++;
            System.out.println("  Curse: Weapon  '" + weapon.getName() + "' -> CURSED (suspiciously powerful)");
        } else {
            System.out.println("  Curse: Weapon  '" + weapon.getName() + "' -> safe");
        }
    }

    @Override
    public void visit(Potion potion) {
        System.out.println("  Curse: Potion  '" + potion.getName() + "' -> safe");
    }

    @Override
    public void visit(Scroll scroll) {
        String spell = scroll.getSpellName().toLowerCase();
        if (spell.contains("death") || spell.contains("curse") || spell.contains("doom") || spell.contains("void")) {
            cursedCount++;
            System.out.println("  Curse: Scroll  '" + scroll.getName() + "' -> CURSED (dark spell: " + scroll.getSpellName() + ")");
        } else {
            System.out.println("  Curse: Scroll  '" + scroll.getName() + "' -> safe");
        }
    }

    @Override
    public void visit(Ring ring) {
        if (ring.getMagicBonus() >= 8) {
            cursedCount++;
            System.out.println("  Curse: Ring    '" + ring.getName() + "' -> CURSED (overwhelming magic: " + ring.getMagicBonus() + ")");
        } else {
            System.out.println("  Curse: Ring    '" + ring.getName() + "' -> safe");
        }
    }

    @Override
    public void visit(Armor armor) {
        System.out.println("  Curse: Armor   '" + armor.getName() + "' -> safe");
    }
}
