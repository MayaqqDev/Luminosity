package dev.mayaqq.luminosity;

import dev.mayaqq.luminosity.registries.LuminosityItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Luminosity implements ModInitializer {

    public static final String MOD_ID = "luminosity";
    public static final String MOD_NAME = "Luminosity";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    @Override
    public void onInitialize() {
        LOGGER.info("Illuminating your modding experience!");
        LuminosityItems.register();
    }

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }
}
