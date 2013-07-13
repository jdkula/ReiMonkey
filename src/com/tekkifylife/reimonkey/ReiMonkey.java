package com.tekkifylife.reimonkey;

import java.lang.reflect.Field;

public class ReiMonkey {

	/* Function to access class fields and modify them */
	public static void setTrue(Object par1Object, String par2String) {

		try {

			Field var1Field = par1Object.getClass().getDeclaredField(par2String);
			var1Field.setAccessible(true);
			var1Field.set(par1Object, Boolean.valueOf(true));

		} catch (Exception e) {

		}
	}
}