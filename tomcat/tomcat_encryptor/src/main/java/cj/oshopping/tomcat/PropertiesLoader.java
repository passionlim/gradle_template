package cj.oshopping.tomcat;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public interface PropertiesLoader {
	void load(Properties properties, File file) throws IOException;
}
