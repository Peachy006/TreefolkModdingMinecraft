package sean.modding;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems {



    //ITEMS
    public static final Item TREEFOLK_DROP = register("treefolk_drop", new Item(new Item.Settings()));

    public static final Item TREEFOLK_PICKAXE = register("treefolk_pickaxe",
            new PickaxeItem(TreefolkMaterial.TREEFOLK, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(TreefolkMaterial.TREEFOLK, 1.0f, -2.8f))));

    public static final Item TREEFOLK_AXE = register("treefolk_axe",
            new AxeItem(TreefolkMaterial.TREEFOLK, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(TreefolkMaterial.TREEFOLK, 6.0f, -3.2f))));

    public static final Item TREEFOLK_HOE = register("treefolk_hoe",
            new HoeItem(TreefolkMaterial.TREEFOLK, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(TreefolkMaterial.TREEFOLK, 0.0f, -3.0f))));

    public static final Item TREEFOLK_STAFF = register("treefolk_staff", new Item(new Item.Settings().maxCount(1)));

    public static final Item DIAMOND_STAFF = register("diamond_staff", new Item(new Item.Settings().maxCount(1)));

    public static final Item DIAMOND_STICK = register("diamond_stick", new Item(new Item.Settings()));





    //register helper method
    private static Item register(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(FirstMod.MOD_ID, name), item);
    }


    //GROUPS

    //GROUP1
    public static final RegistryKey<ItemGroup> TREEFOLK_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(),
            Identifier.of(FirstMod.MOD_ID, "treefolk_group"));

    public static final ItemGroup TREEFOLK_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.TREEFOLK_AXE))
            .displayName(Text.translatable("itemGroup.first-mod.treefolk_group"))
            .build();


    //GROUP2
    public static final RegistryKey<ItemGroup> TREEFOLK_GROUP_KEY_2 = RegistryKey.of(Registries.ITEM_GROUP.getKey(),
            Identifier.of(FirstMod.MOD_ID, "treefolk_group_2"));

    public static final ItemGroup TREEFOLK_GROUP_2 = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.DIAMOND_STICK))
            .displayName(Text.translatable("itemGroup.first-mod.treefolk_group_2"))
            .build();


    //Called from FirstMod onInitialize to register the groups and add items to them
    public static void initialize() {
        Registry.register(Registries.ITEM_GROUP, TREEFOLK_GROUP_KEY, TREEFOLK_GROUP);
        Registry.register(Registries.ITEM_GROUP, TREEFOLK_GROUP_KEY_2, TREEFOLK_GROUP_2);

        ItemGroupEvents.modifyEntriesEvent(TREEFOLK_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(TREEFOLK_DROP);
            itemGroup.add(TREEFOLK_PICKAXE);
            itemGroup.add(TREEFOLK_AXE);
            itemGroup.add(TREEFOLK_HOE);
            itemGroup.add(TREEFOLK_STAFF);
            itemGroup.add(DIAMOND_STAFF);
        });

        ItemGroupEvents.modifyEntriesEvent(TREEFOLK_GROUP_KEY_2).register(itemGroup -> {
            itemGroup.add(DIAMOND_STICK);
        });
    }
}