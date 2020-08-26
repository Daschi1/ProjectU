package de.daschi.projectu.blockentities;

import de.daschi.projectu.ProjectU;
import de.daschi.projectu.guidescriptions.TransmutationEngineGuiDescription;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

public class TransmutationEngineBlockEntity extends BlockEntity implements NamedScreenHandlerFactory {
    public TransmutationEngineBlockEntity() {
        super(ProjectU.transmutationEngineBlockEntity);
    }


    @Override
    public Text getDisplayName() {
        return Text.of("Transmutation Tablet"); // TODO: 26.08.2020 language
    }

    @Override
    public @Nullable ScreenHandler createMenu(final int syncId, final PlayerInventory inv, final PlayerEntity player) {
        return new TransmutationEngineGuiDescription(syncId, inv, ScreenHandlerContext.create(this.world, this.pos));
    }

}
