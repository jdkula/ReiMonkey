/*
 * ReiMonkey by TekkifyLife
 * Original mod by minecraftmonkey
 */

package net.minecraft.src;

import net.minecraft.client.Minecraft;

import com.tekkifylife.reimonkey.Reference;
import com.tekkifylife.reimonkey.ReiMonkey;
import com.tekkifylife.reimonkey.Strings;

public class mod_ReiMonkey extends BaseMod {

	/* Variable for storing Rei's Minimap's function class */
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

			/* Obtain fields and set them to the variable declared above */
			rm = Class.forName("reifnsk.minimap.ReiMinimap").getDeclaredField("instance").get(null);

		} catch (Exception e) {

			/* Send the player a message since Rei's Minimap is corrupted or missing. */
			mc.thePlayer.addChatMessage(Strings.REIS_MINIMAP_MISSING);
			
			/* Stop this function */
			return false;
		}

		/* Set everything to allow, may consider a toggle later. */
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