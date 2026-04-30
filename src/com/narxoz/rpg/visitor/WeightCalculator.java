package com.narxoz.rpg.visitor;

import com.narxoz.rpg.artifact.*;

public class WeightCalculator implements ArtifactVisitor {

    private int totalWeight;

    public WeightCalculator() {
        this.totalWeight = 0;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    @Override
    public void visit(Weapon weapon) {
        totalWeight += weapon.getWeight();
        System.out.println("[WeightCalculator] Weapon  '" + weapon.getName() + "' -> " + weapon.getWeight() + " kg");
    }

    @Override
    public void visit(Potion potion) {
        totalWeight += potion.getWeight();
        System.out.println("[WeightCalculator] Potion  '" + potion.getName() + "' -> " + potion.getWeight() + " kg");
    }

    @Override
    public void visit(Scroll scroll) {
        totalWeight += scroll.getWeight();
        System.out.println("[WeightCalculator] Scroll  '" + scroll.getName() + "' -> " + scroll.getWeight() + " kg");
    }

    @Override
    public void visit(Ring ring) {
        totalWeight += ring.getWeight();
        System.out.println("[WeightCalculator] Ring    '" + ring.getName() + "' -> " + ring.getWeight() + " kg");
    }

    @Override
    public void visit(Armor armor) {
        totalWeight += armor.getWeight();
        System.out.println("[WeightCalculator] Armor   '" + armor.getName() + "' -> " + armor.getWeight() + " kg");
    }
}
