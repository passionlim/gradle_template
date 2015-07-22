package cj.oshopping.tomcat;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
public class CipherUtilsTest {

	@Test
	public void encrypt_테스트() {
		String encryptData = CipherUtils.encrypt("password");
		System.out.println("EncryptData:"+encryptData);
		assertTrue(encryptData.length() > 0);
	}

	@Test
	public void decrypt_테스트() {
		String plainText = CipherUtils.decrypt("VtouejR8xDOLTayx/Aqp3g==");
		System.out.println("DecryptData:"+plainText);
		assertThat(plainText, is("password"));
	}
}
