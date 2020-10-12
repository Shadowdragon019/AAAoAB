
package net.mcreator.aaaoab.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.aaaoab.AaaoabModElements;

@AaaoabModElements.ModElement.Tag
public class HardRockCandyYellowItem extends AaaoabModElements.ModElement {
	@ObjectHolder("aaaoab:hard_rock_candy_yellow")
	public static final Item block = null;
	public HardRockCandyYellowItem(AaaoabModElements instance) {
		super(instance, 32);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64));
			setRegistryName("hard_rock_candy_yellow");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
