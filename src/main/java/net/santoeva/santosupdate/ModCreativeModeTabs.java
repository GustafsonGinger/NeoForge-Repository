package net.santoeva.santosupdate;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.santoeva.santosupdate.block.ModBlocks;
import net.santoeva.santosupdate.item.ModItems;

import java.util.function.Supplier;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SantosUpdate.MOD_ID);


    public static final Supplier<CreativeModeTab> UTIL_TAB =
            CREATIVE_MODE_TABS.register("util_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.santosupdate.util_tab"))
                    .icon(() -> new ItemStack(Items.ANDESITE))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.SILVER_RAW);
                        output.accept(ModItems.SILVER_INGOT);

                        output.accept(ModBlocks.SILVER_ORE);

                        output.accept(ModItems.SMOLDERING_SLAG);
                        output.accept(ModBlocks.SMOLDERING_ORE);
                    })
                    .build());


    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }


}
