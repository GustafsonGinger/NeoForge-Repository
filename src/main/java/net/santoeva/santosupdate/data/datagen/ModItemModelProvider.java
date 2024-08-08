package net.santoeva.santosupdate.data.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.santoeva.santosupdate.SantosUpdate;
import net.santoeva.santosupdate.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output,  ExistingFileHelper existingFileHelper) {
        super(output, SantosUpdate.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.SILVER_INGOT.get());
        basicItem(ModItems.SILVER_RAW.get());

        basicItem(ModItems.SMOLDERING_SLAG.get());

    }
}
