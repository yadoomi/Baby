package net.yadoomi.glitch.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.yadoomi.glitch.Glitch;
import net.yadoomi.glitch.block.ModBlocks;

public class ModItemGroups {

    public static final ItemGroup BABY = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Glitch.MOD_ID, "baby"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.GLITCH))
                    .displayName(Text.translatable("itemgroup.glitch.glitch"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.GLITCH_STAR);
                        entries.add(ModItems.GLITCH);
                        entries.add(ModBlocks.GLITCH_BLOCK);
                        entries.add(ModItems.INFERNO_GLITCH);
                        entries.add(ModBlocks.INFERNO_GLITCH_BLOCK);
                        entries.add(ModBlocks.GLITCHED_LEAVES);
                        entries.add(ModBlocks.GLITCHED_PLANKS);
                    }).build());

    public static void registerItemGroups() {
        Glitch.LOGGER.info("Registering Item Groups for " + Glitch.MOD_ID);
    }

}
