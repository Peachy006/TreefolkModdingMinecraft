package sean.modding;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems {
    public static Item register(Item item, String id) {
        Identifier itemID = Identifier.of(FirstMod.MOD_ID, id);

        Item registeredItem = Registry.register(Registries.ITEM, itemID, item);
        return registeredItem;
    }


    //ITEMS
    public static final Item TREEFOLK_AXE = register(
            new Item(new Item.Settings()),
            "treefolk_axe"
    );

    public static final Item TREEFOLK_HOE = register(
            new Item(new Item.Settings()),
            "treefolk_hoe"
    );

    public static final Item TREEFOLK_STAFF = register(
            new Item(new Item.Settings()),
            "treefolk_staff"
    );

    public static final Item TREEFOLK_DROP = register(
            new Item(new Item.Settings()),
            "treefolk_drop"
    );

    public static final Item TREEFOLK_PICKAXE = register(
            new Item(new Item.Settings()),
            "treefolk_pickaxe"
    );






    //creating an Item Group
    public static final RegistryKey<ItemGroup> TREEFOLK_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(FirstMod.MOD_ID, "treefolk_group"));

    public static final ItemGroup TREEFOLK_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.TREEFOLK_AXE))
            .displayName(Text.translatable("itemGroup.first-mod.treefolk_group"))
            .build();


    //calling a dummy method to initialize the mod, if a dummy method is called on a static class it will intialize the class
    public static void initialize() {
        Registry.register(Registries.ITEM_GROUP, TREEFOLK_GROUP_KEY, TREEFOLK_GROUP);

        ItemGroupEvents.modifyEntriesEvent(TREEFOLK_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(TREEFOLK_AXE);
            itemGroup.add(TREEFOLK_HOE);
            itemGroup.add(TREEFOLK_STAFF);
            itemGroup.add(TREEFOLK_DROP);
            itemGroup.add(TREEFOLK_PICKAXE);
        });
    }
}
