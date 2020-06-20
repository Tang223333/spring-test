package websx.spring.test.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.Type;
import websx.spring.test.springtest.entity.Type;
import websx.spring.test.springtest.service.impl.TypeService;
import websx.spring.test.springtest.utils.JsonUtils;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

@RequestMapping("/type")
@RestController
public class TypeController {

    @Autowired
    private TypeService typeService;

    @RequestMapping(value = "/findById",method = RequestMethod.POST)
    public Map<String,Object> findByIdType(@PathParam("id") Long id){
        Type img = typeService.findByIdType(id);
        return JsonUtils.getJson(img,img!=null?0:1);
    }

    @RequestMapping("/findAll")
    public Map<String,Object> findAllType(){
        List<Type> allType = typeService.findAllType();
        return JsonUtils.getJson(allType,allType!=null?0:1);
    }

    @RequestMapping(value = "/findByKey",method = RequestMethod.POST)
    public Map<String,Object> findByKeyType(@PathParam("tKeys") String tKeys){
        System.out.println(tKeys);
        List<Type> imgs = typeService.findByKeyType(tKeys);
        return JsonUtils.getJson(imgs,imgs!=null?0:1);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Map<String,Object> saveType(@PathParam("tKeys") String tKeys,
                                      @PathParam("value") String value){
        Type img=Type.builder().tKeys(tKeys).value(value).build();
        img=typeService.saveType(img);
        return JsonUtils.getJson(img,img!=null?0:1);
    }

    @RequestMapping(value = "/deleteById",method = RequestMethod.POST)
    public Map<String,Object> deleteByIdType(@PathParam("id") Long id){
        Type img = typeService.deleteByIdType(id);
        return JsonUtils.getJson(img,img!=null?0:1);
    }

    @RequestMapping(value = "/deleteByKey",method = RequestMethod.POST)
    public Map<String,Object> deleteType(@PathParam("tKeys")String tKeys){
        List<Type> imgs = typeService.deleteByKeyType(tKeys);
        return JsonUtils.getJson(imgs,imgs!=null?0:1);
    }
}
