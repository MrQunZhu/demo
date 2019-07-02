package com.example.demo.mqtt;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ConfigUtil {

	public static Log log = LogFactory.getLog(ConfigUtil.class);
	private static Properties properties = null;
	private static Properties commProperties = null;

	// 加载关于测试或者真实环境的配置文件
	public static Properties getInstance() {
		if (properties == null) {
			properties = new Properties();
			loadProerties();
		}
		return properties;
	}

	private static void loadProerties() {
		InputStream in = ConfigUtil.class.getClassLoader().getResourceAsStream("config.properties");

		try {
			properties.load(in);
			in.close();
			log.info("加载配置文件" + properties);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 发送邮件配置文件加载
	public static Properties getCommonInstance() throws FileNotFoundException {
		if (commProperties == null) {
			commProperties = new Properties();
		}
		loadCommonPro();
		return commProperties;
	}
	 /**
	   * @author lixq
	   * @date 2019/3/4
	   * @description
	   * @param
	   * @return
	   */
	private static void loadCommonPro() throws FileNotFoundException {
		InputStream in = ConfigUtil.class.getClassLoader().getResourceAsStream("common.properties");
		try {
			commProperties.load(in);
			in.close();
			log.info("加载配置文件" + commProperties);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void updateCommonPro(String keyName, String keyValue) throws IOException {

		// 如果没有创建对象，先创建对象
		loadCommonPro();
		String filePath = ConfigUtil.class.getResource("/").getPath();
		try {
			OutputStream fos = new FileOutputStream(filePath + "common.properties");
			commProperties.setProperty(keyName, keyValue);
			commProperties.store(fos, "Update '" + keyName + "' value");
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}