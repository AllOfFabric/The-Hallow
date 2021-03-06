package io.github.alloffabric.thehallow.client;

import io.github.alloffabric.thehallow.registry.HallowedNetworking;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;
import net.minecraft.util.registry.Registry;

@Environment(EnvType.CLIENT)
public class HallowedClientNetworking {
	private HallowedClientNetworking() {
		// NO-OP
	}

	public static void init() {
		ClientSidePacketRegistry.INSTANCE.register(HallowedNetworking.SHOW_FLOATING_ITEM_S2C, (context, buf) -> {
			int rawId = buf.readVarInt();
			ItemStack stack = Registry.ITEM.get(rawId).getStackForRender();
			MinecraftClient.getInstance().gameRenderer.showFloatingItem(stack);
		});
	}
}
