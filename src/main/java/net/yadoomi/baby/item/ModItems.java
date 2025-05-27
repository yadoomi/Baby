package net.yadoomi.baby.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.yadoomi.baby.Baby;

public class ModItems {

    public static final Item TESTLOL = registerItem("testlol", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Baby.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Baby.LOGGER.info("Registering Mod Items for " + Baby.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(TESTLOL);
        });
    }

}
