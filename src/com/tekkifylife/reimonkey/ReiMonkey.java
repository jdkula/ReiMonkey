/*
 * ReiMonkey by TekkifyLife and JonaK
 * Original mod by minecraftmonkey
 * ReiMonkey is licensed under the LGPL 3 license.
 * http://www.gnu.org/licenses/lgpl.html
 */

package com.tekkifylife.reimonkey;

import java.lang.reflect.Field;

public class ReiMonkey {

	/* Function to access class fields and modify them with reflection */
	public static void setTrue(Object par1Object, String par2String) {

		try {

			Field var1Field = par1Object.getClass().getDeclaredField(par2String);
			var1Field.setAccessible(true);
			var1Field.set(par1Object, Boolean.valueOf(true));

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}