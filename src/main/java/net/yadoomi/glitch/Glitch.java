package net.yadoomi.glitch;

import net.fabricmc.api.ModInitializer;

import net.yadoomi.glitch.block.ModBlocks;
import net.yadoomi.glitch.item.ModItemGroups;
import net.yadoomi.glitch.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Glitch implements ModInitializer {
	public static final String MOD_ID = "glitch";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

        ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}