package io.biuteifo.web.utils;

import java.io.IOException;
import java.io.StringWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 文本（String）工具类
 * 
 * @author <a href="mailto:632635114@qq.com">luojun</a>
 * @date 2019年1月11日
 * @version 0.0.1
 */
public final class TextUtils {

	private static Logger logger = LoggerFactory.getLogger(TextUtils.class);

	public static final String EMPTY_JSON = "{}";

	public static boolean isEmpty(Object obj) {
		if (obj == null || obj.toString().isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * 对象转JsonString
	 * 
	 * @param obj 需要转换的对象
	 * @return Json字符串
	 */
	public static String object2JsonString(Object obj) {
		try {
			StringWriter stringWriter = new StringWriter();
			JsonGenerator jsonGenerator = new JsonFactory().createGenerator(stringWriter);
			objectMapper.writeValue(jsonGenerator, obj);
			jsonGenerator.close();
			return stringWriter.toString();
		} catch (IOException e) {
			logger.error(String.format("对象{%s}转换JsonString异常！", obj), e);
			return EMPTY_JSON;
		}
	}

	/**
	 * Json字符串转对象
	 * 
	 * @param jsonString Json字符串
	 * @param clazz 需要转换出对象的类型
	 * @return <T> t 目标对象
	 */
	public static <T> T jsonStringToObject(String jsonString, Class<T> clazz) {
		try {
			return objectMapper.readValue(jsonString, clazz);
		} catch (Exception e) {
			logger.error(String.format("JsonString{%s}转换对象{%s}异常！", jsonString, clazz.getName()), e);
			return null;
		}
	}

	private static ObjectMapper objectMapper = new ObjectMapper();
}
