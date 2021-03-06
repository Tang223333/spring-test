package websx.spring.test.springtest.utils;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.util.JSONPObject;

import java.util.HashMap;
import java.util.Map;

public class JsonUtils {

    public static Map<String, Object> getJson(Object strings,Integer error_code){
        Map<String,Object> maps=new HashMap<>();
        if (strings != null) {
            maps.put("reason","请求成功");
            maps.put("data",strings);
        }else {
            maps.put("reason","请求失败");
            maps.put("data","[]");
        }
        maps.put("error_code",error_code);
        return maps;
    }

    public static Map<String,Object> getJson2(Object object1,Object object2,Integer error_code){
        Map<String,Object> maps=new HashMap<>();
        if (object1 != null&&object2!=null) {
            maps.put("reason","请求成功");
            maps.put("data1",object1);
            maps.put("data2",object2);
        }else {
            maps.put("reason","请求失败");
            maps.put("data","[]");
        }
        maps.put("error_code",error_code);
        return maps;
    }

    public static Map<String,Object> getJson3(Object object1,Object object2,Object object3,Integer error_code){
        Map<String,Object> maps=new HashMap<>();
        if (object1 != null&&object2!=null) {
            maps.put("reason","请求成功");
            maps.put("data1",object1);
            maps.put("data2",object2);
            maps.put("data3",object3);
        }else {
            maps.put("reason","请求失败");
            maps.put("data","[]");
        }
        maps.put("error_code",error_code);
        return maps;
    }

    public static Map<String,Object> getJson4(Object object1,Object object2,Object object3,Object object4,Integer error_code){
        Map<String,Object> maps=new HashMap<>();
        if (object1 != null&&object2!=null) {
            maps.put("reason","请求成功");
            maps.put("data1",object1);
            maps.put("data2",object2);
            maps.put("data3",object3);
            maps.put("data4",object4);
        }else {
            maps.put("reason","请求失败");
            maps.put("data","[]");
        }
        maps.put("error_code",error_code);
        return maps;
    }
}
