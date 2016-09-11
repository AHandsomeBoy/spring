package com.spring;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.core.io.FileSystemResource;

import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * Created by andy.wu
 */


public class PropertyUtil {
    private static Map<String, String> propertiesMap = new HashMap<>();
    // Default as in PropertyPlaceholderConfigurer


    public static void processProperties( Properties props) throws BeansException {

        propertiesMap = new HashMap<String, String>();
        for (Object key : props.keySet()) {
            String keyStr = key.toString();

            try {
                //PropertiesLoaderUtils的默认编码是ISO-8859-1,在这里转码一下
                propertiesMap.put(keyStr, new String(props.getProperty(keyStr).getBytes("ISO-8859-1"),"utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }catch (java.lang.Exception e){
                e.printStackTrace();
            };
        }
        System.out.println(propertiesMap);
    }
    public static void loadAllProperties(String filename){
        try {
            Properties properties = PropertiesLoaderUtils.loadProperties(new FileSystemResource(new File(filename)));
            processProperties(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String name) {
        return propertiesMap.get(name).toString();
    }
}