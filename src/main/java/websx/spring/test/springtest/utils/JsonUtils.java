package websx.spring.test.springtest.utils;

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
}
