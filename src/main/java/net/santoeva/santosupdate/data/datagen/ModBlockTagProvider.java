package net.santoeva.santosupdate.data.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.santoeva.santosupdate.SantosUpdate;
import net.santoeva.santosupdate.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {


    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, SantosUpdate.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.SILVER_ORE.get())
                .add(ModBlocks.SILVER_BLOCK.get())

                .add(ModBlocks.SMOLDERING_ORE.get())
        ;
        this.tag(Tags.Blocks.NEEDS_WOOD_TOOL)

        ;
        this.tag(Tags.Blocks.NEEDS_GOLD_TOOL)

        ;
        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.SILVER_ORE.get())
                .add(ModBlocks.SILVER_BLOCK.get())
        ;
        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SMOLDERING_ORE.get())

        ;
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)

        ;
        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)

        ;


    }
}
