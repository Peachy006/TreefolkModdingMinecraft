package sean.modding;

import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

import java.util.function.Supplier;

public enum TreefolkMaterial implements ToolMaterial {
    // This defines the "Treefolk" Tier
    TREEFOLK(455, 7.0f, 2.5f, BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 15, () -> Ingredient.ofItems(ModItems.TREEFOLK_DROP));

    private final int durability;
    private final float miningSpeed;
    private final float attackDamage;
    private final TagKey<Block> inverseTag;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    TreefolkMaterial(int durability, float miningSpeed, float attackDamage, TagKey<Block> inverseTag, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.durability = durability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.inverseTag = inverseTag;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    @Override public int getDurability() { return this.durability; }
    @Override public float getMiningSpeedMultiplier() { return this.miningSpeed; }
    @Override public float getAttackDamage() { return this.attackDamage; }
    @Override public TagKey<Block> getInverseTag() { return this.inverseTag; }
    @Override public int getEnchantability() { return this.enchantability; }
    @Override public Ingredient getRepairIngredient() { return this.repairIngredient.get(); }
}