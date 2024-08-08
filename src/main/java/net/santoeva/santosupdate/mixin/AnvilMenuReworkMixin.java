package net.santoeva.santosupdate.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.inventory.AnvilMenu;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AnvilMenu.class)
public class AnvilMenuReworkMixin {

    @ModifyConstant(method = "createResult", constant = @Constant(intValue = 40))
    private int mixinLimitInt(int i){
        return Integer.MAX_VALUE;
    }

    @ModifyConstant(method = "createResult", constant = @Constant(intValue = 39))
    private int mixinMaxInt(int i){
        return Integer.MAX_VALUE - 1;
    }

    @Inject(method = {"calculateIncreasedRepairCost"}, at = {@At("RETURN")}, cancellable = true)
    private static void mixinRepairCostCurve(int currentCost, CallbackInfoReturnable<Integer> callbackInfoReturnable){
        callbackInfoReturnable.setReturnValue((int)((double)currentCost * 2) + 1);
    }

    @ModifyArg(method = {"createResult"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/world/inventory/DataSlot;set(I)V"), index = 0)
    private int maxCost(int cost){
        return Math.min(cost, 100);
    }

    @ModifyVariable(method = {"createResult"}, at = @At("STORE"), name = {"i1"})
    private int mixinRepairEqualItemCost(int original, @Local(ordinal = 1) int j){
        return (int)Math.ceil((double)original / Math.max(2.0, (double)j));
    }

    @ModifyVariable(method = {"createResult"}, at = @At("STORE"), name = {"l2"})
    private int mixinRepairItemCost(int original, @Local(ordinal = 1) int j, @Local(ordinal = 1) ItemStack itemstack1){
        return Math.min(itemstack1.getDamageValue(), itemstack1.getMaxDamage() / Math.max(4, j * 2));
    }





}
