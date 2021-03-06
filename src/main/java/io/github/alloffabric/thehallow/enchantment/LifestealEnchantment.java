package io.github.alloffabric.thehallow.enchantment;

import com.google.common.collect.ImmutableList;
import io.github.alloffabric.thehallow.registry.HallowedEnchantments;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;

public class LifestealEnchantment extends Enchantment {
	protected static final ImmutableList<Float> STEAL_MULTIPLIER = ImmutableList.of(0.1F, 0.12F, 0.15F, 0.17F, 0.2F);

	public LifestealEnchantment(Weight weight, EnchantmentTarget target, EquipmentSlot[] slots) {
		super(weight, target, slots);
	}

	public static boolean hasLifesteal(LivingEntity livingEntity) {
		return EnchantmentHelper.getEquipmentLevel(HallowedEnchantments.LIFESTEAL, livingEntity) > 0;
	}

	public static float getLifeWithSteal(DamageSource damageSource, float damage, LivingEntity attackedEntity) {
		if (damageSource.getSource() instanceof LivingEntity && hasLifesteal((LivingEntity) damageSource.getSource()) && attackedEntity.getHealth() <= 0) {
			LivingEntity attacker = (LivingEntity) damageSource.getSource();
			int enchantmentLevel = EnchantmentHelper.getEquipmentLevel(HallowedEnchantments.LIFESTEAL, attacker);
			float stolenHealth = damage * STEAL_MULTIPLIER.get(enchantmentLevel);
			return Math.min(attacker.getMaximumHealth(), attacker.getHealth() + stolenHealth);
		} else {
			return 0;
		}
	}

	@Override
	public int getMaximumLevel() {
		return 3;
	}
}
