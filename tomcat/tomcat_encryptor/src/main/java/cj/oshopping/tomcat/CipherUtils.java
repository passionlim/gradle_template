package cj.oshopping.tomcat;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public abstract class CipherUtils {

	static String DEFAULT_SECRET_KEY = "cojds_dssec!2#%%";

	public static String ENV_VARIABLE_NAME = "TOMCAT_PROP_SEC_KEY";
	public static String SYSTEM_PROPERTY_NAME = "tomcat.property.secretKey";

	private static Cipher encryptCipher;
	private static Cipher decryptCipher;

	static {
		initCipher();
	}

	public static void initCipher() {
		String encryptKey = System.getenv(ENV_VARIABLE_NAME);

		if (StringUtils.isNotBlank(System.getProperty(SYSTEM_PROPERTY_NAME))) {
			encryptKey = System.getenv(SYSTEM_PROPERTY_NAME);
		}

		if (StringUtils.isBlank(encryptKey)) {
			encryptKey = DEFAULT_SECRET_KEY;
		}

		try {
			SecretKeySpec secretKey = new SecretKeySpec(encryptKey.getBytes("UTF-8"), "AES");
			encryptCipher = Cipher.getInstance("AES");
			encryptCipher.init(Cipher.ENCRYPT_MODE, secretKey);

			decryptCipher = Cipher.getInstance("AES");
			decryptCipher.init(Cipher.DECRYPT_MODE, secretKey);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public static String encrypt(String plainText) {
		try {
			return DatatypeConverter.printBase64Binary(encryptCipher.doFinal(plainText.getBytes("UTF-8")));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String decrypt(String encryptedHexString) {
		try {
			return new String(decryptCipher.doFinal(DatatypeConverter.parseBase64Binary(encryptedHexString)), "UTF-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
