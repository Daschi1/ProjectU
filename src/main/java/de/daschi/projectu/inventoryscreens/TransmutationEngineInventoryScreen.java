package de.daschi.projectu.inventoryscreens;

import de.daschi.projectu.guidescriptions.TransmutationEngineGuiDescription;
import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class TransmutationEngineInventoryScreen extends CottonInventoryScreen<TransmutationEngineGuiDescription> {
    public TransmutationEngineInventoryScreen(final TransmutationEngineGuiDescription description, final PlayerEntity player, final Text title) {
        super(description, player, title);
    }
}
