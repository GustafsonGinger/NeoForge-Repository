package net.santoeva.santosupdate.data.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.santoeva.santosupdate.SantosUpdate;
import net.santoeva.santosupdate.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, SantosUpdate.MOD_ID, exFileHelper);
    }


    //Register BlockStates and models in here
    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.SILVER_ORE);
        blockWithItem(ModBlocks.SILVER_BLOCK);
    }

    private void blockWithItem(DeferredBlock<Block> deferredBlock){

        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));

    }
}
