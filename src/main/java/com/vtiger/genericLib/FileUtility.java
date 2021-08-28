package com.vtiger.genericLib;
import java.io.FileInputStream;
import java.util.Properties;
/**
 * 
 * @author karthi
 *
 */

public class FileUtility {
	/**
	 * this method is to get the data from common property based on key which we pass
	 * @author karth
	 * @param key
	 * @return
	 * @throws Throwable
	 */

	public String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream fis=new FileInputStream("D:\\eclipse\\seleniumproject\\Data\\testcases1.properties");
		Properties property=new Properties();
		property.load(fis);
		String value= property.getProperty(key);
		return value;
		
	}

}
