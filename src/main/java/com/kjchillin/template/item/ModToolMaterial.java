package com.kjchillin.template.item;

import com.kjchillin.template.util.ModTagsClass;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;

import java.util.function.Supplier;

public enum ModToolMaterial implements ToolMaterial {
    RUBY(10,1200000,23456f,500,26, () -> Ingredient.ofItems(ModItems.RUBY));

    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantibility;
    private final Supplier<Ingredient> repairIngredient;

    ModToolMaterial(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantibility, Supplier<Ingredient> repairIngredient) {
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantibility = enchantibility;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return ModTagsClass.Blocks.PICKAXE_NOT_BREAKABLE_BLOCK;
    }

    @Override
    public int getEnchantability() {
        return this.enchantibility;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
