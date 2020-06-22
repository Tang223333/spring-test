package websx.spring.test.springtest.utils;

import java.util.HashMap;
import java.util.Map;

public class JsonUtils2 {

    public static Map<String, Object> getJson(Object strings, Integer error_code,String reason){
        Map<String,Object> maps=new HashMap<>();
        if (error_code == 0) {
            maps.put("data",strings);
        }else {
            maps.put("data","[]");
        }
        maps.put("reason",reason);
        maps.put("error_code",error_code);
        return maps;
    }

    public static Map<String,Object> getJson2(Object object1,Object object2,Integer error_code,String reason){
        Map<String,Object> maps=new HashMap<>();
        if (error_code==0) {
            maps.put("data1",object1);
            maps.put("data2",object2);
        }else {
            maps.put("data","[]");
        }
        maps.put("reason",reason);
        maps.put("error_code",error_code);
        return maps;
    }

    public static Map<String,Object> getJson3(Object object1,Object object2,Object object3,Integer error_code,String reason){
        Map<String,Object> maps=new HashMap<>();
        if (error_code==0) {
            maps.put("data1",object1);
            maps.put("data2",object2);
            maps.put("data3",object3);
        }else {
            maps.put("data","[]");
        }
        maps.put("reason",reason);
        maps.put("error_code",error_code);
        return maps;
    }

    public static Map<String,Object> getJson4(Object object1,Object object2,Object object3,Object object4,Integer error_code,String reason){
        Map<String,Object> maps=new HashMap<>();
        if (error_code==0) {
            maps.put("data1",object1);
            maps.put("data2",object2);
            maps.put("data3",object3);
            maps.put("data4",object4);
        }else {
            maps.put("data","[]");
        }
        maps.put("reason",reason);
        maps.put("error_code",error_code);
        return maps;
    }
}
