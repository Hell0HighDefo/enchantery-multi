package com.ordana.enchantery.mixins.enchantment_mixins;

import com.ordana.enchantery.EnchanteryLogic;
import com.ordana.enchantery.reg.ModTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.FireAspectEnchantment;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(FireAspectEnchantment.class)
public abstract class FireAspectEnchantmentMixin extends Enchantment {
    protected FireAspectEnchantmentMixin(Rarity rarity, EnchantmentCategory enchantmentCategory, EquipmentSlot[] equipmentSlots) {
        super(rarity, enchantmentCategory, equipmentSlots);
    }

    @Override
    public boolean isTreasureOnly() {
        return !EnchanteryLogic.getHolder(this).is(ModTags.BASIC);
    }

    @Override
    public boolean isTradeable() {
        return EnchanteryLogic.getHolder(this).is(ModTags.TRADEABLE);
    }

    @Override
    public boolean isDiscoverable() {
        return EnchanteryLogic.getHolder(this).is(ModTags.BASIC);
    }
}
