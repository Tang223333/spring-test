package websx.spring.test.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.Type;
import websx.spring.test.springtest.service.impl.TypeService;
import websx.spring.test.springtest.utils.JsonUtils;

import java.util.List;
import java.util.Map;

@RequestMapping("/type")
@RestController
public class TypeController {

    @Autowired
    private TypeService typeService;

    @RequestMapping("/findAll")
    public Map<String,Object> findAllType(){
        List<Type> allType = typeService.findAllType();
        return JsonUtils.getJson(allType,allType!=null?0:1);
    }
}
