package net.yadoomi.glitch.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.yadoomi.glitch.Glitch;
import net.yadoomi.glitch.item.custom.GlitchStarItem;

public class ModItems {

    public static final Item GLITCH = registerItem("glitch", new Item(new Item.Settings()));
    public static final Item INFERNO_GLITCH = registerItem("inferno_glitch", new Item(new Item.Settings()));

    public static  final Item GLITCH_STAR = registerItem("glitch_star", new GlitchStarItem(new Item.Settings().maxCount(0)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Glitch.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Glitch.LOGGER.info("Registering Mod Items for " + Glitch.MOD_ID);
    }

}
