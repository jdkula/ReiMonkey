package net.minecraft.src;

import net.minecraft.client.Minecraft;

import com.tekkifylife.reimonkey.Reference;
import com.tekkifylife.reimonkey.ReiMonkey;
import com.tekkifylife.reimonkey.Strings;

public class mod_ReiMonkey extends BaseMod {

	private Object rm;

	public String getName() {

		return Reference.MOD_NAME;
	}

	@Override
	public String getVersion() {

		return Reference.MOD_VERSION;
	}

	@Override
	public void load() {

		ModLoader.setInGameHook(this, true, false);
	}

	public boolean onTickInGame(float tick, Minecraft mc) {

		try {

			rm = Class.forName("reifnsk.minimap.ReiMinimap").getDeclaredField("instance").get(null);

		} catch (Exception e) {

			mc.thePlayer.addChatMessage(Strings.REIS_MINIMAP_MISSING);
			return false;
		}
			
		ReiMonkey.setTrue(rm, "allowCavemap");
		ReiMonkey.setTrue(rm, "allowEntitiesRadar");
		ReiMonkey.setTrue(rm, "allowEntityPlayer");
		ReiMonkey.setTrue(rm, "allowEntityAnimal");
		ReiMonkey.setTrue(rm, "allowEntityMob");
		ReiMonkey.setTrue(rm, "allowEntitySlime");
		ReiMonkey.setTrue(rm, "allowEntitySquid");
		ReiMonkey.setTrue(rm, "allowEntityLiving");
		
		return true;
	}
}