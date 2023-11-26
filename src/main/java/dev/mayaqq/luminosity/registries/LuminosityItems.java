package dev.mayaqq.luminosity.registries;

import de.dafuqs.spectrum.registries.SpectrumItems;
import dev.mayaqq.luminosity.Luminosity;
import dev.mayaqq.luminosity.registries.items.CrystalHoverpackItem;
import dev.mayaqq.luminosity.registries.materials.HoverpackMaterial;
import net.fabricmc.fabric.api.item.v1.EquipmentSlotProvider;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class LuminosityItems {

    public static final Item CRYSTAL_HOVERPACK = register("crystal_hoverpack", new CrystalHoverpackItem(new FabricItemSettings().maxCount(1).fireproof(), Luminosity.id("hidden/unlock_hoverpack"), new HoverpackMaterial(), 1000));

    public static void register() {}

    public static Item register(String id, Item item) {
        return Registry.register(Registries.ITEM, Luminosity.id(id), item);
    }
}
