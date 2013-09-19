/*
 * ReiMonkey by TekkifyLife and JonaK
 * Original mod by minecraftmonkey
 * ReiMonkey is licensed under the LGPL 3 license.
 * http://www.gnu.org/licenses/lgpl.html
 */

package net.minecraft.src;

import net.minecraft.client.Minecraft;

import com.tekkifylife.reimonkey.ReiMonkey;

public class mod_ReiMonkey extends BaseMod {

	/* Variable for storing Rei's Minimap's function class */
	private Object rm;

	public String getName() {

		return "ReiMonkey";
	}

	@Override
	public String getVersion() {

		return "@VERSION@";
	}

	@Override
	public void load() {

		/* Register a tick hook */
		ModLoader.setInGameHook(this, true, false);
	}

	public boolean onTickInGame(float tick, Minecraft mc) {

		try {

			/* Obtain fields and set them to the variable declared above */
			rm = Class.forName("reifnsk.minimap.ReiMinimap").getDeclaredField("instance").get(null);

		} catch (Exception e) {
			
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