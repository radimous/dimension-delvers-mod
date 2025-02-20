package com.dimensiondelvers.dimensiondelverstestmod;

import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.common.NeoForge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.MixinEnvironment;

import net.minecraft.client.Minecraft;


@Mod("dimensiondelvers_testmod")
public class DimensionDelversTestMod {
	public static final String NAME = "Dimension Delvers Test Mod";
	private static final Logger LOGGER = LoggerFactory.getLogger(NAME);

	public DimensionDelversTestMod() {
		LOGGER.info("Starting {} on Dist: {}", NAME, FMLLoader.getDist());

		NeoForge.EVENT_BUS.addListener((ClientTickEvent.Post e) -> {
			LOGGER.info("Running mixin audit");
			MixinEnvironment.getCurrentEnvironment().audit();

			LOGGER.info("Stopping client");
			Minecraft.getInstance().stop();
		});
	}
}