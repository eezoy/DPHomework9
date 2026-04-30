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
            System.out.println("[CurseDetector] Weapon  '" + weapon.getName() + "' -> CURSED (suspiciously powerful)");
        } else {
            System.out.println("[CurseDetector] Weapon  '" + weapon.getName() + "' -> safe");
        }
    }

    @Override
    public void visit(Potion potion) {
        System.out.println("[CurseDetector] Potion  '" + potion.getName() + "' -> safe");
    }

    @Override
    public void visit(Scroll scroll) {
        String spell = scroll.getSpellName().toLowerCase();
        if (spell.contains("death") || spell.contains("curse") || spell.contains("doom") || spell.contains("void")) {
            cursedCount++;
            System.out.println("[CurseDetector] Scroll  '" + scroll.getName() + "' -> CURSED (dark spell: " + scroll.getSpellName() + ")");
        } else {
            System.out.println("[CurseDetector] Scroll  '" + scroll.getName() + "' -> safe");
        }
    }

    @Override
    public void visit(Ring ring) {
        if (ring.getMagicBonus() >= 8) {
            cursedCount++;
            System.out.println("[CurseDetector] Ring    '" + ring.getName() + "' -> CURSED (overwhelming magic: " + ring.getMagicBonus() + ")");
        } else {
            System.out.println("[CurseDetector] Ring    '" + ring.getName() + "' -> safe");
        }
    }

    @Override
    public void visit(Armor armor) {
        System.out.println("[CurseDetector] Armor   '" + armor.getName() + "' -> safe");
    }
}
