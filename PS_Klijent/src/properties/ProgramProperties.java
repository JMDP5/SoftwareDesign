/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Singleton class to manage program properties(like location of saved images).
 *
 * @author aleksandar
 */
public class ProgramProperties {

    private static ProgramProperties instance;
    private String propertiesFile;
    private InputStream input;
    OutputStream output;
    private Properties properties;

    private ProgramProperties() {
        this.propertiesFile = "config.properties";
        properties = new Properties();
        loadDefaultProperties();
    }

    public static ProgramProperties getInstance() {
        if (instance == null) {
            instance = new ProgramProperties();
        }
        return instance;
    }

    private void loadDefaultProperties() {
        try {
            input = new FileInputStream(propertiesFile);
            properties.load(input);
            input.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getLocation() {
        return properties.getProperty("location");
    }

    public void setLocation(String loc) {
        try {
            output = new FileOutputStream(propertiesFile);
            properties.setProperty("location", loc);
            properties.store(output, "---No Comment---");
            output.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
