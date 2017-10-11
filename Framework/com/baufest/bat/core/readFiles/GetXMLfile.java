package com.baufest.bat.core.readFiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

/**
 * Read XML File
 * @author Miguel D'Alessio
 * */
public class GetXMLfile {

    /**
     * Read XML Config Properties
     * @author Miguel D'Alessio
     * */
    public String GetConfigProperties(String propertyConf) throws IOException{

        String property = null;
        java.util.Properties prop = new Properties();

        prop.loadFromXML(new FileInputStream(System.getProperty("user.dir")+"/conf/config-properties/config-properties.xml"));
        property = prop.getProperty(propertyConf);

        return property;
    }
}