package dev.mayaqq.luminosity.registries.items;

import de.dafuqs.revelationary.api.advancements.AdvancementHelper;
import de.dafuqs.spectrum.energy.InkStorage;
import de.dafuqs.spectrum.energy.InkStorageItem;
import de.dafuqs.spectrum.energy.color.InkColor;
import de.dafuqs.spectrum.energy.storage.FixedSingleInkStorage;
import de.dafuqs.spectrum.items.armor.BedrockArmorItem;
import de.dafuqs.spectrum.render.armor.BedrockArmorModel;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

public class CrystalHoverpackItem extends ArmorItem implements InkStorageItem<FixedSingleInkStorage> {

    private final int maxInk;
    private final Identifier unlockIdentifier;

    public CrystalHoverpackItem(Item.Settings settings, Identifier unlockIdentifier, ArmorMaterial material, int maxInk) {
        super(material, Type.CHESTPLATE, settings);
        this.maxInk = maxInk;
        this.unlockIdentifier = unlockIdentifier;
    }

    public Identifier getUnlockIdentifier() {
        return this.unlockIdentifier;
    }

    public boolean canUse(PlayerEntity entity) {
        return AdvancementHelper.hasAdvancement(entity, getUnlockIdentifier()) || entity.isCreative();
    }

    @Override
    public Drainability getDrainability() {
        return Drainability.PLAYER_ONLY;
    }

    @Override
    public FixedSingleInkStorage getEnergyStorage(ItemStack itemStack) {
        NbtCompound compound = itemStack.getNbt();
        if (compound != null && compound.contains("EnergyStore")) {
            return FixedSingleInkStorage.fromNbt(compound.getCompound("EnergyStore"));
        }
        return new FixedSingleInkStorage(maxInk, InkColor.of(DyeColor.PURPLE));
    }

    @Override
    public void setEnergyStorage(ItemStack itemStack, InkStorage storage) {
        if (storage instanceof FixedSingleInkStorage fixedSingleInkStorage) {
            NbtCompound compound = itemStack.getOrCreateNbt();
            compound.put("EnergyStore", fixedSingleInkStorage.toNbt());
        }
    }

    @Override
    public ItemStack getDefaultStack() {
        return super.getDefaultStack();
    }
}
