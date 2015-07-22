package cj.oshopping.tomcat;

public abstract class StringUtils {

	public static boolean isBlank(String string) {
		return string == null || string.trim().length() == 0;
	}
	
	public static boolean isNotBlank(String string) {
		return !isBlank(string);
	}
}