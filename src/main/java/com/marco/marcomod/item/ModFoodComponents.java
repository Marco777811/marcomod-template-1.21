package com.marco.marcomod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent DARKNESS_CAKE = new FoodComponent.Builder().nutrition(-2).saturationModifier(-1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS,2400,0),1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.WITHER,300,1),1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE,1,7),0.2F)//20%扣除大量血量
            .alwaysEdible()
            .build();
}
