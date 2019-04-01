package com.example.demo.common;

import com.mysql.jdbc.StringUtils;
import flexjson.*;
import flexjson.transformer.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JSON {
	public static String Encode(Object obj) {
		if(obj == null || obj.toString().equals("null")) return "";
		if(obj != null && obj.getClass() == String.class){
			return obj.toString();
		}
		JSONSerializer serializer = new JSONSerializer();
		serializer.transform(new DateTransformer("yyyy-MM-dd' 'HH:mm:ss"), Date.class);
		serializer.transform(new DateTransformer("yyyy-MM-dd' 'HH:mm:ss"), Timestamp.class);
		//serializer.transform(null, "");
		return serializer.deepSerialize(obj);
	}
	@SuppressWarnings("rawtypes")
	public static Object Decode(String json) {
		if (StringUtils.isNullOrEmpty(json)) return "";
		JSONDeserializer deserializer = new JSONDeserializer();
		deserializer.use(String.class, new DateTransformer("yyyy-MM-dd' 'HH:mm:ss"));		
		Object obj = deserializer.deserialize(json);
		if(obj != null && obj.getClass() == String.class){
			return Decode(obj.toString());
		}		
		return obj;
	}
	
	/*public static void main(String[] args) {
		System.out.println(JSON.Encode(new Date()));
	}*/
	
	/**
     * 将Javabean转换为Map
     * 
     * @param javaBean
     *            javaBean
     * @return Map对象
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map toMap(Object javaBean) {
        Map result = new HashMap();
        Method[] methods = javaBean.getClass().getDeclaredMethods();
        for (Method method : methods) {
            try {
                if (method.getName().startsWith("get")) {
                    String field = method.getName();
                    field = field.substring(field.indexOf("get") + 3);
                    field = field.toLowerCase().charAt(0) + field.substring(1);
                    Object value = method.invoke(javaBean, (Object[]) null);
                    result.put(field, null == value ? "" : value.toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 将Json对象转换成Map
     * 
     * @param jsonObject
     *            json对象
     * @return Map对象
     * @throws JSONException
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map toMap(String jsonString) throws JSONException {

        JSONObject jsonObject = new JSONObject(jsonString);
        
        Map result = new HashMap();
        Iterator iterator = jsonObject.keys();
        String key = null;
        String value = null;
        
        while (iterator.hasNext()) {

            key = (String) iterator.next();
            value = jsonObject.getString(key);
            result.put(key, value);

        }
        return result;

    }

    /**
     * 将JavaBean转换成JSONObject（通过Map中转）
     * 
     * @param bean
     *            javaBean
     * @return json对象
     */
    public static JSONObject toJSON(Object bean) {

        return new JSONObject(toMap(bean));

    }

    /**
     * 将Map转换成Javabean
     * 
     * @param javabean
     *            javaBean
     * @param data
     *            Map数据
     */
    @SuppressWarnings("rawtypes")
	public static Object toJavaBean(Object javabean, Map data) {

        Method[] methods = javabean.getClass().getDeclaredMethods();
        for (Method method : methods) {

            try {
                if (method.getName().startsWith("set")) {

                    String field = method.getName();
                    field = field.substring(field.indexOf("set") + 3);
                    field = field.toLowerCase().charAt(0) + field.substring(1);
                    method.invoke(javabean, new Object[] {

                    data.get(field)

                    });

                }
            } catch (Exception e) {
            }

        }

        return javabean;

    }

    /**
     * JSONObject到JavaBean
     * 
     * @param bean
     *            javaBean
     * @return json对象
     * @throws ParseException
     *             json解析异常
     * @throws JSONException
     */
    @SuppressWarnings("rawtypes")
	public static void toJavaBean(Object javabean, String jsonString)
            throws ParseException, JSONException {

        JSONObject jsonObject = new JSONObject(jsonString);
    
        Map map = toMap(jsonObject.toString());
        
        toJavaBean(javabean, map);

    }
}

