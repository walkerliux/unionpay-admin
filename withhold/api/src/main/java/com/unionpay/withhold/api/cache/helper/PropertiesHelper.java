package com.unionpay.withhold.api.cache.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;

/**
 * 获取平台配置文件数据
 * 
 * @author Luke
 *
 */
public class PropertiesHelper {
	private static final Logger logger = Logger.getLogger(PropertiesHelper.class);
	
	 /** Singleton local property instance **/
    private static Properties SysLocalPropObject = null;

    /** Property file default **/
    private static String defaultpropfilename = "/application.properties";

    protected long lastModifiedData = -1;

    private static PropertiesHelper instance;

    private String baseDirectory = null;

    private boolean loadFromDatabase = false;

    public static PropertiesHelper getInstance() {
        if (instance == null) {
            instance = new PropertiesHelper();
        }
        return instance;
    }

    public static PropertiesHelper getInstance(ServletContext ctx) {
        instance = new PropertiesHelper(ctx);
        return instance;
    }

    /**
     * 
     * @param ctx
     */
    private PropertiesHelper(ServletContext ctx) {
        SysLocalPropObject = new Properties();
        final PropertiesHelper self = this;
        
        final String filePath = this.getClass().getResource(defaultpropfilename).getFile();
        logger.info("=============================");
        logger.info("Loading data: " + filePath);
        File propertyFile = new File(filePath);
        
        if(propertyFile.exists()) {
            reloadFile(propertyFile);
        }
        else {
        	try {
				reloadFile(this.getClass().getClassLoader().getResourceAsStream(defaultpropfilename));
			} catch (IOException e) {
				logger.error("加载配置文件异常", e);
			}
        }

        if (ctx != null) {
            baseDirectory = ctx.getRealPath("/");

            // Loop to detect file changes
            Thread t = new Thread() {
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                        }
                        try {
                            File propertyFile = new File(filePath);
                            if(propertyFile.exists()) {
                            	if (self.lastModifiedData != propertyFile.lastModified()) {
                                	logger.info("Property file is changed to reload!");
                                    self.reloadFile(propertyFile);
                                    self.lastModifiedData = propertyFile.lastModified();
                                }
                            }
                            else {
                            	try {
                    				reloadFile(this.getClass().getClassLoader().getResourceAsStream(defaultpropfilename));
                    			} catch (IOException e) {
                    				logger.error("加载配置文件异常", e);
                    			}
                            }
                            
                        } catch (Exception e) {

                        }
                    }
                }
            };
            t.start();
        }
    }

    /** Private Constructor for Singleton Instance */
    private PropertiesHelper() {
        this(null);
    }

    /** Get the base directory for this application */
    public String getBaseDirectory() {
        return baseDirectory == null ? "" : baseDirectory;
    }

    protected void reloadFile(File propertyFile) {
        FileInputStream inputStreamLocal = null;
        try {
            inputStreamLocal = new FileInputStream(propertyFile);
            reloadFile(inputStreamLocal);
        } catch (Exception e) {
            if (e instanceof FileNotFoundException) {
            	logger.info("No Local Properties File Found");
                SysLocalPropObject = null;
            } else {
                e.printStackTrace();
            }
        } finally {
            try {
                if (inputStreamLocal != null)
                    inputStreamLocal.close();
            } catch (IOException e) {
            	logger.info("Exception is happened when to close file stream");
            }
        }
    }
    
    /**
     * 
     * @param inputStreamLocal
     * @throws IOException
     */
    protected void reloadFile(InputStream inputStreamLocal) throws IOException {
        if (inputStreamLocal != null) {
            SysLocalPropObject.load(inputStreamLocal);
        }
        else {
        	logger.info("Loading input stream is null");
        }
        String enableString = SysLocalPropObject.getProperty("database.config.enable");

        if (enableString != null) {
            loadFromDatabase = enableString.trim().equalsIgnoreCase("true") || enableString.trim().equals("1");
        } else {
            loadFromDatabase = false;
        }
    }

    /**
     * Get a property from the Properties file (uppercase Get to avoid conflict)
     */
    public String getProperty(String property) {
        String val = null;

        if (loadFromDatabase) {
        	// From database to fetch configuration by forcing
            val = ConfigCacheHelper.get(property);
        }
        if (val == null && SysLocalPropObject != null)
            val = SysLocalPropObject.getProperty(property);

        return (val);

    }

    /** Get a property, allowing for a default value specification */
    public String getProperty(String property, String defaultValue) {
        String val = getProperty(property);

        if (val == null) {
            val = defaultValue;
        }

        return (val);
    }

    /**
     * Get a property from the Properties file (uppercase Get to avoid conflict)
     */
    public Integer getIntProperty(String property) {
        String val = getProperty(property);
        Integer nVal = null;
        try {
            nVal = Integer.parseInt(val);
        } catch (Exception e) {

        }
        return nVal;

    }

    /** Get a property, allowing for a default value specification */
    public Integer getIntProperty(String property, Integer defaultValue) {
        Integer val = getIntProperty(property);

        if (val == null) {
            val = defaultValue;
        }

        return (val);
    }

    /**
     * Get a property from the Properties file (uppercase Get to avoid conflict)
     */
    public Long getLongProperty(String property) {
        String val = getProperty(property);
        Long nVal = null;
        try {
            nVal = Long.parseLong(val);
        } catch (Exception e) {

        }
        return nVal;

    }

    /** Get a property, allowing for a default value specification */
    public Long getLongProperty(String property, Long defaultValue) {
        Long val = getLongProperty(property);

        if (val == null) {
            val = defaultValue;
        }

        return (val);
    }

    public boolean getBooleanProperty(String property, boolean defaultValue) {
        boolean retval = false;
        String val = getProperty(property);

        if (val == null || val.equals(""))
            retval = defaultValue;
        else if (val.trim().equalsIgnoreCase("true") || val.trim().equals("1"))
            retval = true;

        return (retval);
    }
}
