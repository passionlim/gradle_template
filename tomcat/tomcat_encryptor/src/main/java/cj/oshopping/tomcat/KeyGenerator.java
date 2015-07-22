package cj.oshopping.tomcat;

public class KeyGenerator {

	public static void main(String[] args) {
		System.out.println(CipherUtils.encrypt(args[0]));
	}

}
