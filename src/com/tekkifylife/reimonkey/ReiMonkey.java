package com.tekkifylife.reimonkey;

import java.lang.reflect.Field;

import net.minecraft.client.Minecraft;
import net.minecraft.src.ModLoader;

public class ReiMonkey {

	public static Minecraft mc = ModLoader.getMinecraftInstance();
	public static boolean rmExists;

	public static void setEnabled() {

		Object rm = null;

		try {

			rm = Class.forName("reifnsk.minimap.ReiMinimap").getDeclaredField("instance").get(null);
			rmExists = true;

		} catch (Exception e) {

			if (mc.theWorld.isRemote) {
				
				mc.thePlayer.addChatMessage(Strings.REIS_MINIMAP_MISSING);
				rmExists = false;
			}
		}

		if (rmExists) {

			setTrue(rm, "allowCavemap");
			setTrue(rm, "allowEntitiesRadar");
			setTrue(rm, "allowEntityPlayer");
			setTrue(rm, "allowEntityAnimal");
			setTrue(rm, "allowEntityMob");
			setTrue(rm, "allowEntitySlime");
			setTrue(rm, "allowEntitySquid");
			setTrue(rm, "allowEntityLiving");
		}
	}

	public static void setTrue(Object par1Object, String par2String) {

		try {

			Field field = par1Object.getClass().getDeclaredField(par2String);
			field.setAccessible(true);
			field.set(par1Object, Boolean.valueOf(true));

		} catch (Exception e) {

		}
	}
}