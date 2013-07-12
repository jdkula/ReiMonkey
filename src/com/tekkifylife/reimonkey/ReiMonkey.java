package com.tekkifylife.reimonkey;

import java.lang.reflect.Field;

public class ReiMonkey {

	public static void setTrue(Object par1Object, String par2String) {

		try {

			Field field = par1Object.getClass().getDeclaredField(par2String);
			field.setAccessible(true);
			field.set(par1Object, Boolean.valueOf(true));

		} catch (Exception e) {

		}
	}
}