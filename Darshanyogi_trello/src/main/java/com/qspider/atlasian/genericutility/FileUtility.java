package com.qspider.atlasian.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	public String readPropertyFileData(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/trellocommondata.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String keyValue = pobj.getProperty(key);
		return keyValue;

	}

}
