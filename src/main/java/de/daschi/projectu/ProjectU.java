package de.daschi.projectu;

import de.daschi.projectu.blockentities.TransmutationEngineBlockEntity;
import de.daschi.projectu.blocks.TransmutationEngineBlock;
import de.daschi.projectu.guidescriptions.TransmutationEngineGuiDescription;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ProjectU implements ModInitializer {

    public static final TransmutationEngineBlock TRANSMUTATION_ENGINE_BLOCK = new TransmutationEngineBlock(FabricBlockSettings.of(Material.STONE).hardness(4.0f)); // TODO: 24.08.2020 blast resistance
    public static BlockEntityType<TransmutationEngineBlockEntity> transmutationEngineBlockEntity;
    public static ScreenHandlerType<TransmutationEngineGuiDescription> transmutationEngineInventoryScreen;

    @Override
    public void onInitialize() {
        final Identifier transmutationTabletIdentifier = new Identifier("projectu", "transmutation_engine");

        Registry.register(Registry.BLOCK, transmutationTabletIdentifier, TRANSMUTATION_ENGINE_BLOCK);
        Registry.register(Registry.ITEM, transmutationTabletIdentifier, new BlockItem(TRANSMUTATION_ENGINE_BLOCK, new Item.Settings().group(ItemGroup.MISC)));
        transmutationEngineBlockEntity = Registry.register(Registry.BLOCK_ENTITY_TYPE, transmutationTabletIdentifier, BlockEntityType.Builder.create(TransmutationEngineBlockEntity::new, TRANSMUTATION_ENGINE_BLOCK).build(null));
        transmutationEngineInventoryScreen = ScreenHandlerRegistry.registerSimple(transmutationTabletIdentifier, (syncId, inventory) -> new TransmutationEngineGuiDescription(syncId, inventory, ScreenHandlerContext.EMPTY));

    }

    //LEGACY code (with advanced_runtime_resource_pack v 0.2.6)

    //public static final RuntimeResourcePack RUNTIME_RESOURCE_PACK = RuntimeResourcePack.create("projectu:test");

    //RUNTIME_RESOURCE_PACK.addBlockState(JState.state(JState.variant(JState.model(transmutationTabletIdentifier.getNamespace() + ":block/" + transmutationTabletIdentifier.getPath()))), transmutationTabletIdentifier);

//        RUNTIME_RESOURCE_PACK.addModel(JModel.model("block/cube_all").textures(JModel.textures().particle("#side")).element(JModel.element().from(0, 0, 0).to(16, 0.4f, 16).faces(JModel.faces().down(JModel.face("#bottom").cullface(Direction.DOWN)).up(JModel.face("#top")).north(JModel.face("#side").cullface(Direction.NORTH)).south(JModel.face("#side").cullface(Direction.SOUTH)).west(JModel.face("#side").cullface(Direction.WEST)).east(JModel.face("#side").cullface(Direction.EAST)))), quarterSlabBottomIdentifier);

//        RUNTIME_RESOURCE_PACK.addModel(JModel.model(quarterSlabBottomIdentifier.getNamespace() + ":block/" + quarterSlabBottomIdentifier.getPath()).textures(JModel.textures().var("bottom", transmutationTabletIdentifier.getNamespace() + ":block/" + transmutationTabletIdentifier.getPath()).var("top", transmutationTabletIdentifier.getNamespace() + ":block/" + transmutationTabletIdentifier.getPath()).var("side", transmutationTabletIdentifier.getNamespace() + ":block/" + transmutationTabletIdentifier.getPath())), transmutationTabletIdentifier);

//        RUNTIME_RESOURCE_PACK.addModel(JModel.model(transmutationTabletIdentifier.getNamespace() + ":block/" + transmutationTabletIdentifier.getPath()), transmutationTabletIdentifier);

        /*try {
            RUNTIME_RESOURCE_PACK.addTexture(transmutationTabletIdentifier, ImageIO.read(new File("transmutation_engine.png")));
        } catch (final IOException e) {
            e.printStackTrace();
        }*/

//        RUNTIME_RESOURCE_PACK.addLootTable(transmutationTabletIdentifier, JLootTable.loot("minecraft:block").pool(JLootTable.pool().rolls(1).entry(JLootTable.entry().type("minecraft:item").name(transmutationTabletIdentifier.getNamespace() + ":" + transmutationTabletIdentifier.getPath())).condition(JLootTable.condition("minecraft:survives_explosion"))));

    //RRPCallback.EVENT.register(list -> list.add(RUNTIME_RESOURCE_PACK));
}
