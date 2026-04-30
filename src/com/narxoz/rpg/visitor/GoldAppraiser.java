package com.narxoz.rpg.visitor;

import com.narxoz.rpg.artifact.*;

public class GoldAppraiser implements ArtifactVisitor {

    private int totalValue;

    public GoldAppraiser() {
        this.totalValue = 0;
    }

    public int getTotalValue() {
        return totalValue;
    }

    public void reset() {
        totalValue = 0;
    }

    @Override
    public void visit(Weapon weapon) {
        int appraisedValue = weapon.getValue() + weapon.getAttackBonus() * 3;
        totalValue += appraisedValue;
        System.out.println("[GoldAppraiser] Weapon  '" + weapon.getName() + "' -> " + appraisedValue + "g");
    }

    @Override
    public void visit(Potion potion) {
        int appraisedValue = potion.getValue();
        totalValue += appraisedValue;
        System.out.println("[GoldAppraiser] Potion  '" + potion.getName() + "' -> " + appraisedValue + "g");
    }

    @Override
    public void visit(Scroll scroll) {
        int appraisedValue = scroll.getValue() + 10;
        totalValue += appraisedValue;
        System.out.println("[GoldAppraiser] Scroll  '" + scroll.getName() + "' -> " + appraisedValue + "g");
    }

    @Override
    public void visit(Ring ring) {
        int appraisedValue = ring.getValue() + ring.getMagicBonus() * 5;
        totalValue += appraisedValue;
        System.out.println("[GoldAppraiser] Ring    '" + ring.getName() + "' -> " + appraisedValue + "g");
    }

    @Override
    public void visit(Armor armor) {
        int appraisedValue = armor.getValue() + armor.getDefenseBonus() * 2;
        totalValue += appraisedValue;
        System.out.println("[GoldAppraiser] Armor   '" + armor.getName() + "' -> " + appraisedValue + "g");
    }
}
