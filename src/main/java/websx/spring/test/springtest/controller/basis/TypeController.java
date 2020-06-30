package websx.spring.test.springtest.controller.basis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.Game;
import websx.spring.test.springtest.entity.Img;
import websx.spring.test.springtest.entity.Type;
import websx.spring.test.springtest.entity.Type;
import websx.spring.test.springtest.service.impl.GameService;
import websx.spring.test.springtest.service.impl.ImgService;
import websx.spring.test.springtest.service.impl.TypeService;
import websx.spring.test.springtest.utils.JsonUtils;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/type")
@RestController
public class TypeController {

    @Autowired
    private TypeService typeService;
    @Autowired
    private GameService gameService;
    @Autowired
    private ImgService imgService;

    @RequestMapping(value = "/findById",method = RequestMethod.POST)
    public Map<String,Object> findByIdType(@PathParam("id") Long id){
        Type img = typeService.findByIdType(id);
        return JsonUtils.getJson(img,img!=null?0:1);
    }

    @RequestMapping("/findAll2")
    public Map<String,Object> findAll2Type(){
        List<Type> allType = typeService.findAllType();
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",allType.size());
        map.put("data",allType);
        return map;
    }

    @RequestMapping("/findAll")
    public Map<String,Object> findAllType(){
        List<Type> allType = typeService.findAllType();
        return JsonUtils.getJson(allType,allType!=null?0:1);
    }

    @RequestMapping(value = "/findByKey",method = RequestMethod.POST)
    public Map<String,Object> findByKeyType(@PathParam("tKeys") String tKeys){
        List<Type> imgs = typeService.findByKeyType(tKeys);
        return JsonUtils.getJson(imgs,imgs!=null?0:1);
    }

    @RequestMapping(value = "/findByValue")
    public Map<String,Object> findByValueType(@PathParam("value") String value,Integer page){
        List<Type> typesall=typeService.findByValueType(value);
        List<Type> types = typeService.findByValueType2(value,page);
        List<Game> games = new ArrayList<>();
        for (int i = 0; i < types.size(); i++) {
            games.add(gameService.findByTypeGame(types.get(i).getTKeys()));
            List<Img> imgs=imgService.findByKeyImg(games.get(i).getImgs()+"");
            if (imgs.size()>0&&imgs!=null) {
                games.get(i).setImgs(imgs.get(0).getValue());
            }else {
                games.get(i).setImgs("");
            }
        }
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",typesall.size());
        map.put("data",games);
        return map;
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
