package cj.oshopping.tomcat;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.tomcat.util.IntrospectionUtils;

public class EncryptPropertyDecoder implements IntrospectionUtils.PropertySource {
	
	/**
	 * 암호화 필드 표현 방법
	 */
	private static Pattern encryptValuePattern = Pattern.compile("^\\s*ENC\\(([A-Za-z0-9=/+]*)\\)\\s*$");

	Properties properties = new Properties();
	
	public EncryptPropertyDecoder() throws IOException {
		String targetPath = null;
		
		if( StringUtils.isNotBlank(System.getProperty("org.apache.tomcat.util.digester.PROPERTY_SOURCE"))) {
			targetPath = System.getProperty("org.apache.tomcat.util.digester.PROPERTY_SOURCE.targetPath");
		}
		
		if ( StringUtils.isNotBlank(targetPath)) {
			scan(targetPath, new PropertiesLoader() {
				public void load(Properties properties, File file) throws IOException {
					properties.load(new InputStreamReader(new FileInputStream(file), "UTF-8"));
				}
			});
		}
		
		decryptProperties();
	}
	
	
	private void decryptProperties() {
		for ( Entry<?,?> entry : this.properties.entrySet()) {
			String key = entry.getKey().toString();
			String value = entry.getValue().toString();
			
			Matcher matcher = encryptValuePattern.matcher(value);
			if ( matcher.matches() ) {
				properties.setProperty(key, CipherUtils.decrypt(matcher.group(1)));
			}
		}
	}

	/**
	 * targetPath 조회후 조회된 파일을 properteis loader 에 설정
	 * @param targetPath
	 * @param propertiesLoader
	 * @throws IOException 
	 */
	private void scan(String targetPath, PropertiesLoader propertiesLoader) throws IOException {
		String baseDir = targetPath.substring(0, targetPath.lastIndexOf(File.separator));
		String filePattern = targetPath.substring(targetPath.lastIndexOf(File.separator)+1);
				
		if ( filePattern.contains("*") ) {
			FileFinder finder = new FileFinder(filePattern);
			Files.walkFileTree(Paths.get(baseDir), finder);
			
			for ( Path path : finder.getMatchedPaths()) {
				propertiesLoader.load(this.properties, path.toFile());
			}
		} else {
			File file = new File(targetPath);
			if ( file.exists() && file.isFile() && file.canRead() ) {
				propertiesLoader.load(this.properties, file);
			}
		}
	}


	public String getProperty(String key) {
		return this.properties != null ? this.properties.getProperty(key) : null;
	}

}
