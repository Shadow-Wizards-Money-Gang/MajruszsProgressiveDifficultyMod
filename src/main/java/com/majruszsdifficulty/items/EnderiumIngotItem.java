package com.majruszsdifficulty.items;

import com.majruszsdifficulty.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class EnderiumIngotItem extends Item {
	public EnderiumIngotItem() {
		super( new Properties().tab( Registries.ITEM_GROUP ).rarity( Rarity.UNCOMMON ) );
	}
}