package net.yadoomi.baby;

import net.fabricmc.api.ModInitializer;

import net.yadoomi.baby.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Baby implements ModInitializer {
	public static final String MOD_ID = "baby";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItems.registerModItems();
	}
}