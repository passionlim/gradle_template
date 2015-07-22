package cj.oshopping.tomcat;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class EncryptPropertyDecoderTest {

	private File testPropertiesDirectory;
	
	@Before
	public void init() {
		String testPropertiesPath = EncryptPropertyDecoder.class.getClassLoader().getResource("test1.properties").getFile();
		testPropertiesDirectory = new File(testPropertiesPath);
		
	}
	
	@Test
	public void property파일읽기() throws IOException {

		System.setProperty("org.apache.tomcat.util.digester.PROPERTY_SOURCE", EncryptPropertyDecoder.class.getCanonicalName());
		System.setProperty("org.apache.tomcat.util.digester.PROPERTY_SOURCE.targetPath", testPropertiesDirectory.getAbsolutePath());

		EncryptPropertyDecoder decoder = new EncryptPropertyDecoder();
		assertThat(decoder.getProperty("test1.key1"), is("value1"));
		assertThat(decoder.getProperty("test1.key2"), is("value2"));
		assertThat(decoder.getProperty("test1.password"), is("password"));
	}

	@Test
	public void wildcard_property파일읽기() throws IOException {
		System.setProperty("org.apache.tomcat.util.digester.PROPERTY_SOURCE", EncryptPropertyDecoder.class.getCanonicalName());
		System.setProperty("org.apache.tomcat.util.digester.PROPERTY_SOURCE.targetPath", testPropertiesDirectory.getParent() + File.separator + "test*.properties");

		EncryptPropertyDecoder decoder = new EncryptPropertyDecoder();
		assertThat(decoder.getProperty("test1.key1"), is("value1"));
		assertThat(decoder.getProperty("test1.key2"), is("value2"));
		assertThat(decoder.getProperty("test1.password"), is("password"));
		
		assertThat(decoder.getProperty("test2.key1"), is("value1"));
		assertThat(decoder.getProperty("test2.key2"), is("value2"));
		assertThat(decoder.getProperty("test2.password"), is("password"));
	}

}
