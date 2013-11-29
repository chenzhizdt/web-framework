package org.instorm.utils;

public class DataCheck {
	public static boolean isNullOrBlank(final String value){
		if(value == null || value.equals("")){
			return true;
		}
		return false;
	}
}
