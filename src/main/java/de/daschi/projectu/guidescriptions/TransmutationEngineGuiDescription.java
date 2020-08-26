package de.daschi.projectu.guidescriptions;

import de.daschi.projectu.ProjectU;
import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WItemSlot;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandlerContext;

public class TransmutationEngineGuiDescription extends SyncedGuiDescription {
    private static final int INVENTORY_SIZE = 1;

    public TransmutationEngineGuiDescription(final int syncId, final PlayerInventory playerInventory, final ScreenHandlerContext context) {
        super(ProjectU.transmutationEngineInventoryScreen, syncId, playerInventory, SyncedGuiDescription.getBlockInventory(context, INVENTORY_SIZE), SyncedGuiDescription.getBlockPropertyDelegate(context));

        final WGridPanel root = new WGridPanel();
        this.setRootPanel(root);
        root.setSize(300, 200);

        final WItemSlot itemSlot = WItemSlot.of(this.blockInventory, 0);
        root.add(itemSlot, 4, 1);

        root.add(this.createPlayerInventoryPanel(), 0, 3);

        root.validate(this);
    }
}
