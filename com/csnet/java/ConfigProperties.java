/**
 * 
 */
package com.csnet.java;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Richard Hiley
 *
 */
public class ConfigProperties {

    public static Properties getProperties() {
    	final Properties properties = new Properties();

        try (InputStream input = new FileInputStream("properties/config.properties")) {

            // load a properties file
        	properties.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    	return properties;
    }
    

}
