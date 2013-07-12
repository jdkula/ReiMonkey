package net.minecraft.src;

import net.minecraft.client.Minecraft;

import com.tekkifylife.reimonkey.Reference;
import com.tekkifylife.reimonkey.ReiMonkey;

public class mod_ReiMonkey extends BaseMod {

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

		ReiMonkey.setEnabled();

		if (ReiMonkey.rmExists == false) {
			
			return false;
		}
		
		return true;
	}
}